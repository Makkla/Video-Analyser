package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Class that hold the Top Level "streams" JSON Object that is returned when -show_streams is executed
 *  
 * @author Simon Pott
 */

public class StreamResponse
{
	
    @JsonProperty("streams")
    private List<Stream> streams;

	public List<Stream> getStreams() {
		return streams;
	}

	public void setStreams(List<Stream> streams) {
		this.streams = streams;
	}
       
	public int getNumberOfStreams(){
		return streams.size();
	}
}
