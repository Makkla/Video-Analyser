package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Clip {

	private Format format;
	private List<Frame> frames;
	private List<Stream> streams;
	
	public Format getFormat() {
		
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	public List<Frame> getFrames() {
		return frames;
	}
	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
	public List<Stream> getStreams() {
		return streams;
	}
	public void setStreams(List<Stream> streams) {
		this.streams = streams;
	}
	
	public List<FrameAudio> getFramesAudio(){
		List<FrameAudio> audioFrames = new ArrayList<FrameAudio>();
		
		for(Frame s: frames){
			
			if(s.getClass().equals(FrameAudio.class)){
				
				audioFrames.add((FrameAudio) s);
				
			}
			
		}
		
		return audioFrames;
	
	}

	public List<FrameVideo> getFramesVideo(){
	        List<FrameVideo> videoFrames = new ArrayList<FrameVideo>();
	        
	        for(Frame s: frames){
	            
	            if(s.getClass().equals(FrameVideo.class)){
	                
	                videoFrames.add((FrameVideo) s);
	                
	            }
	            
	        }
	        
	        return videoFrames;
	        
	}
}
