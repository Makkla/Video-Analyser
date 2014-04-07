package model;


import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.scene.layout.Pane;
import javafx.stage.Popup;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import com.sun.scenario.animation.shared.InfiniteClipEnvelope;

public class ClipInfo {
	
	//Stream,Codec Name, Codec typ,framerate,bildformat,datenrate in Bit/s,Anzahl der Frames
	
	private Integer streamNumber;
	private String codecName;
	private String codecType;
	private Double projectRate;
	private String codecFlavor;
	private Integer dataRate;
	private Integer frameCount;
	private Double meanDatarate;
	private Integer targetDatarate; 
	private Integer maxDatarate;
	private String codecDetailname;
	private Integer[] frameSizeList;
	private String[] frameTypeList;
	private String fileName;
	private Integer corruptFrameCount;
	
	public ClipInfo(String fileIn, String fileName) {
        super();

        //metadaten extrahieren
        this.extractClipInfo(fileIn);
        //datarate extrahieren in array
        this.extractFrameInfo(fileIn);
        
        this.showFramesizeGraph(fileIn, fileName);
        this.fileName = fileName;
        
        System.out.println("CorruptFrameCount= "+corruptFrameCount);
      }
	
	
	public void extractClipInfo(String fileIn){
		
		
		Process p;
    
    	String line;
   
    	try {//Stream,Codec Name, Codec typ,framerate,bildformat,datenrate in Bit/s,Anzahl der Frames
				p = Runtime.getRuntime().exec("ffprobe -loglevel quiet -select_streams v -show_entries stream=index,codec_type,codec_long_name,codec_time_base,codec_tag_string,bit_rate,nb_frames -print_format csv=print_section=0:nokey=1 -i " +fileIn);


    	  BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
  	  
    	  while ((line = input.readLine()) != null) {
    	    System.out.println(line);
    	
    	    String projectConvert;
    	    Double zaehler;
    	    Double nenner;
    	    
    	    
            StringTokenizer st = new StringTokenizer(line, ",");

            // The first token is the x value.
            streamNumber = Integer.parseInt(st.nextToken());
            codecName = st.nextToken();
            codecType = st.nextToken();
            projectConvert = st.nextToken();
            codecFlavor = st.nextToken();
            dataRate = Integer.parseInt(st.nextToken());
            frameCount = Integer.parseInt(st.nextToken());
            
            
            frameSizeList = new Integer[frameCount];
            frameTypeList = new String[frameCount];

            
            System.out.println(codecName);
            
        	StringTokenizer pc = new StringTokenizer(projectConvert, "/");
        	
        	zaehler = Double.parseDouble(pc.nextToken());
        	nenner = Double.parseDouble(pc.nextToken());
        	
        	System.out.println(zaehler);
        	System.out.println(nenner);
        	projectRate = zaehler / nenner;
        	System.out.println(projectRate);
       
        	
        	meanDatarate = dataRate * projectRate / 8;
        	System.out.println(dataRate);
        	System.out.println(meanDatarate);
        	
        	if (codecName.equals("ProRes")){
    		
        		switch (codecFlavor) {
        		
        		case "ap4h":
        			targetDatarate = 1376256;
        			maxDatarate = 1548288;
        			codecDetailname = "ProRes 4444";
        			System.out.println(targetDatarate);
        			System.out.println(maxDatarate);
    			break;
    		
        		case "apch":
        			targetDatarate = 917504;
        			maxDatarate = 1032192;
        			codecDetailname = "ProRes 422 HQ";
        			System.out.println(targetDatarate);
        			System.out.println(maxDatarate);
    			break;
    			
        		case "apcn":
        			targetDatarate = 611669;
        			maxDatarate = 688128;
        			codecDetailname = "ProRes 422";
        			System.out.println(targetDatarate);
        			System.out.println(maxDatarate);
    			break;
    			
        		case "apcs":
        			targetDatarate = 425984;
        			maxDatarate = 479232;
        			codecDetailname = "ProRes 422 LT"; 
        			System.out.println(targetDatarate);
        			System.out.println(maxDatarate);
    			break;
    			
    			
        		case "apco":
        			targetDatarate = 189326;
        			maxDatarate = 212992;
        			codecDetailname = "ProRes 422 Proxy";
        			System.out.println(targetDatarate);
        			System.out.println(maxDatarate);
    			break;
    			
    			
    		default:
    			System.out.println("No valid video format");
    		}
        	}
        	else{
        		System.out.println("Codec is not ProRes. Cannot analyse. Please contact Gregor.");
        		
        	};
        	
        	
    	  }
    	  
    	  input.close();
    	
          
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	} 
        
		
	public void extractFrameInfo (String fileIn){
		
		Process p;
	    
    	String line;
   
    	try {
				p = Runtime.getRuntime().exec("ffprobe -loglevel quiet -select_streams v -show_entries frame=best_effort_timestamp,pkt_size,pict_type, -print_format csv=print_section=0:nokey=1 -i " +fileIn);


    	  BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
  	  
    	  int x=0;
    	  corruptFrameCount = 0; //Counter to indicate the number of missing frames
    	  int frameCountDiff; //variable to store the difference between expected frame number and actual frame number
    	  
    	  while ((line = input.readLine()) != null) {
    	    
    		    
       	    StringTokenizer st = new StringTokenizer(line, ",");
       	    
       	    int frameCount = Integer.parseInt(st.nextToken());
       	    
       	    frameCountDiff = frameCount - x;   	    	
       	    
       	    if (frameCountDiff != corruptFrameCount) {
       	    	
       	    	System.out.println("Possible corrupt frame detected at position: "+x);
       	      	       	    	
       	    	corruptFrameCount++;
       	    	
			}
            
            frameSizeList[x] = Integer.parseInt(st.nextToken());
            
            frameTypeList[x] = st.nextToken();
            System.out.println(frameCount);
            System.out.println(frameSizeList[x]); 
            System.out.println(frameTypeList[x]);     
                        
            x++;
    	  }
            
    	
    	  
            input.close();
            
            
      	} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
                	
    	
	}

	
		
	public void showFramesizeGraph (String fileIn, String fileName){
		
		OverlaidPlot frameSizeGraph = new OverlaidPlot("ProRes Analyser", fileName );
		
		int x=0;
  	  while (x < frameCount-1) {
  	    
  		  
  		int y0 = frameSizeList[x];
//  		System.out.println(maxDatarate);
  	    int y1 = maxDatarate;
 	    int y2 = targetDatarate;
  	    double y3 = meanDatarate; //Datarate is not what it should be... Not Bytes/sec
  	    
  		frameSizeGraph.addElem0(x, y0);
  		frameSizeGraph.addElem1(x, y1);
  		frameSizeGraph.addElem2(x, y2);
  		frameSizeGraph.addElem3(x, y3);
  		  
  		
  		
  		x++;
  	  }  
  	  
  	  
  	  
		
		frameSizeGraph.pack();
		frameSizeGraph.setVisible(true);
		
	
		
	}


	public Integer getStreamNumber() {
		return streamNumber;
	}


	public void setStreamNumber(Integer streamNumber) {
		this.streamNumber = streamNumber;
	}


	public String getCodecName() {
		return codecName;
	}


	public void setCodecName(String codecName) {
		this.codecName = codecName;
	}


	public String getCodecType() {
		return codecType;
	}


	public void setCodecType(String codecType) {
		this.codecType = codecType;
	}


	public Double getProjectRate() {
		return projectRate;
	}


	public void setProjectRate(Double projectRate) {
		this.projectRate = projectRate;
	}


	public String getCodecFlavor() {
		return codecFlavor;
	}


	public void setCodecFlavor(String codecFlavor) {
		this.codecFlavor = codecFlavor;
	}


	public Integer getDataRate() {
		return dataRate;
	}


	public void setDataRate(Integer dataRate) {
		this.dataRate = dataRate;
	}


	public Integer getFrameCount() {
		return frameCount;
	}


	public void setFrameCount(Integer frameCount) {
		this.frameCount = frameCount;
	}


	public Double getMeanDatarate() {
		return meanDatarate;
	}


	public void setMeanDatarate(Double meanDatarate) {
		this.meanDatarate = meanDatarate;
	}


	public Integer getTargetDatarate() {
		return targetDatarate;
	}


	public void setTargetDatarate(Integer targetDatarate) {
		this.targetDatarate = targetDatarate;
	}


	public Integer getMaxDatarate() {
		return maxDatarate;
	}


	public void setMaxDatarate(Integer maxDatarate) {
		this.maxDatarate = maxDatarate;
	}


	public String getCodecDetailname() {
		return codecDetailname;
	}


	public void setCodecDetailname(String codecDetailname) {
		this.codecDetailname = codecDetailname;
	}


	public Integer[] getFrameSizeList() {
		return frameSizeList;
	}


	public void setFrameSizeList(Integer[] frameSizeList) {
		this.frameSizeList = frameSizeList;
	}


	public String[] getFrameTypeList() {
		return frameTypeList;
	}


	public void setFrameTypeList(String[] frameTypeList) {
		this.frameTypeList = frameTypeList;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public Integer getCorruptFrameCount() {
		return corruptFrameCount;
	}


	public void setCorruptFrameCount(Integer corruptFrameCount) {
		this.corruptFrameCount = corruptFrameCount;
	}
		
	
	
	
}
	
	
	


