package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.media.jai.codec.StreamSegment;
/**
 * Class that hold the Top Level "streams" JSON Object that is returned when -show_streams is executed
 *  
 * @author Simon Pott
 */
public class FrameResponse
{
	
    @JsonProperty("frames")
    private List<Frame> frames;

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	public int getNumberOfFrames(){
		return frames.size();
	}
}
