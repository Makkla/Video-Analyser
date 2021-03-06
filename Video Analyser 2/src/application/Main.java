package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import model.Clip;
import model.ClipInfo;
import model.CodecProperties;
import model.FormatResponse;
import model.Format;
import model.StreamResponse;
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

import com.fasterxml.jackson.databind.ObjectMapper;
public class Main extends Application {
	
	private String osSystem=System.getProperty("os.name");
	
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
			final ObjectMapper mapper = new ObjectMapper(); // create once, reuse
			final ObservableList<ClipInfo> data = FXCollections.observableArrayList(

		            );
			CodecProperties codecProperties = new CodecProperties();
			Clip einClip = new Clip();	
			einClip = mapper.readValue((Main.class.getResourceAsStream("/data/output.json")), Clip.class);
			System.out.println(einClip.getFormat().getFormat_long_name());
			System.out.println(einClip.getFormat().getFormat_name());
			System.out.println(einClip.getStreams().get(0).getCodec_tag_string());
			System.out.println(CodecProperties.getMaxBitrateVideo(einClip.getStreams().get(0).getCodec_tag_string()));
			

			Process p;
			
			p = Runtime.getRuntime().exec(getFfprobeVersion()+" -h");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) {
            System.out.println(line);
            
            

          }

			
			
//	        openButton.setOnAction(new EventHandler<ActionEvent>() {
//	        					
//				@Override
//				public void handle(ActionEvent event) {
//				
//					File file = fileChooser.showOpenDialog(primaryStage);
////					StreamResponse einClip = new StreamResponse();	
//					Map<String, Object> jsonMap =
//                    null;
////					ClipInfo clip = new ClipInfo(file.getPath(), file.getName());
//					String line;
//					Process p;
//					try
//                    {
//                        System.out.println(file.getPath());
//					    
//					 //   p = Runtime.getRuntime().exec("ffprobe -loglevel quiet -print_format json -show_entries format=filename,nb_streams,nb_programs,format_name,format_long_name,start_time,duration,size,bit_rate,probe_score -i " +file.getPath());
////					    p = Runtime.getRuntime().exec("ffprobe -loglevel quiet -print_format json -show_streams -i " +file.getPath());
//
//					   // BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//					      
//                        	
////					    einClip = mapper.readValue(FileUtils.readFileToByteArray(new File("C:\\Temp\\streamtest.json")), StreamResponse.class);
//					    
//					   // while ((line = input.readLine()) != null) {
////				            System.out.println(line);
////                        
//////                        einClip = mapper.readValue(p.getInputStream(), Probe_format.class);
////                        
////				          }
//                        
//                    }
//                    catch (IOException e)
//                    {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//										
//					
//					
////					System.out.println(einClip.getStreams().get(0).getTime_base());
//                    
//					
//					
////					
////					if (clip.getCorruptFrameCount()!= 0){
////
////						Stage dialogStage = new Stage();
////						dialogStage.initModality(Modality.WINDOW_MODAL);
////						dialogStage.setScene(new Scene(VBoxBuilder.create().
////						    children(new Text("Clip "+clip.getFileName()+" contains "+clip.getCorruptFrameCount()+ " corrupt frames")).
////						    alignment(Pos.CENTER).padding(new Insets(5)).build()));
////						dialogStage.show();
////					}
////						
////					
////					data.add(clip);
////					
//				}
//			});
	
	       
	        
	        
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
//	        bildformatCol.setCellValueFactory(new PropertyValueFactory("nenner")); //Ich wei� nicht was das bildformat ist
	        
	        
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
	
	
	private String getFfprobeVersion(){
		
		String ffprobe = null;
		
		if(osSystem.contains("Windows")) {
			
			ffprobe=getClass().getResource("/resources/fftools/windows/ffprobe.exe").getPath(); 
			ffprobe=ffprobe.substring(1, ffprobe.length());
			ffprobe=ffprobe.replaceAll("%20", " ");
			
		}
		else if(osSystem.contains("Linux")){
			
			
			
		}
			
		else if(osSystem.contains("Mac")) {
			
		}
		
		 return ffprobe;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
