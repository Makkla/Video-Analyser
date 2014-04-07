package application;
	
import java.io.File;

import model.ClipInfo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {
	@Override
	
	
	
	
	public void start(final Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Video Analyser");
			
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Clip");
			
			Button openButton = new Button("Open File or Directory");
			
			root.setBottom(openButton);
			
			root.setAlignment(openButton, Pos.BOTTOM_CENTER);
			root.setMargin(openButton, new Insets(12,12,12,12));
//			root.setCenter(openButton);
			
			final ObservableList<ClipInfo> data = FXCollections.observableArrayList(

		            );
			
			
	        openButton.setOnAction(new EventHandler<ActionEvent>() {
	        					
				@Override
				public void handle(ActionEvent event) {
				
					File file = fileChooser.showOpenDialog(primaryStage);
										
					ClipInfo clip = new ClipInfo(file.getPath(), file.getName());
					
					if (clip.getCorruptFrameCount()!= 0){

						Stage dialogStage = new Stage();
						dialogStage.initModality(Modality.WINDOW_MODAL);
						dialogStage.setScene(new Scene(VBoxBuilder.create().
						    children(new Text("Clip "+clip.getFileName()+" contains "+clip.getCorruptFrameCount()+ " corrupt frames")).
						    alignment(Pos.CENTER).padding(new Insets(5)).build()));
						dialogStage.show();
					}
						
					
					data.add(clip);
					
				}
			});
	
	       
	        
	        
	        TableColumn<ClipInfo, String>  clipNameCol = new TableColumn<ClipInfo, String>();
	        clipNameCol.setText("Clip Name");
	        clipNameCol.setMinWidth(100);
	        clipNameCol.setCellValueFactory(new PropertyValueFactory <ClipInfo, String> ("fileName"));

	        TableColumn<ClipInfo, Integer> corruptFrameCountCol = new TableColumn<ClipInfo, Integer>();
	        corruptFrameCountCol.setText("corruptFrameCount");
	        corruptFrameCountCol.setCellValueFactory(new PropertyValueFactory<ClipInfo, Integer>("corruptFrameCount"));
	        
	        TableColumn<ClipInfo, Integer> streamNumberCol = new TableColumn<ClipInfo, Integer>();
	        streamNumberCol.setText("Stream Number");
	        streamNumberCol.setCellValueFactory(new PropertyValueFactory<ClipInfo, Integer>("streamNumber"));

	        
	        TableColumn<ClipInfo, String> codecNamelCol = new TableColumn<ClipInfo, String>();
	        codecNamelCol.setText("Codec Name");
	        codecNamelCol.setMinWidth(100);
	        codecNamelCol.setCellValueFactory(new PropertyValueFactory<ClipInfo, String>("codecDetailname"));

	        	        
	        TableColumn codecTypCol = new TableColumn();
	        codecTypCol.setText("Codec typ");
	        codecTypCol.setCellValueFactory(new PropertyValueFactory("codecType"));
	        
	        
	        TableColumn framerateCol = new TableColumn();
	        framerateCol.setText("framerate");
	        framerateCol.setCellValueFactory(new PropertyValueFactory("nenner"));

	        
	        TableColumn bildformatCol = new TableColumn();
	        bildformatCol.setText("bildformat");
//	        bildformatCol.setCellValueFactory(new PropertyValueFactory("nenner")); //Ich weiﬂ nicht was das bildformat ist
	        
	        
	        TableColumn<ClipInfo, ?> datenrateCol = new TableColumn();
	        datenrateCol.setText("datenrate in Bit/s");
	        datenrateCol.setCellValueFactory(new PropertyValueFactory("dataRate"));
	        
	        
	        TableColumn<ClipInfo, Integer> framecountCol = new TableColumn<ClipInfo, Integer>();
	        framecountCol.setText("Anzahl der Frames");
	        framecountCol.setCellValueFactory(new PropertyValueFactory<ClipInfo, Integer>("frameCount"));
	        
	        TableView tableView = new TableView();

	        tableView.setItems(data);

	        tableView.getColumns().addAll(clipNameCol,streamNumberCol,corruptFrameCountCol, codecTypCol, codecNamelCol,framerateCol,bildformatCol,datenrateCol,framecountCol);
	        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	        
	       
	        
	        root.setCenter(tableView);


		 
		     
		     
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
