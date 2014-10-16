package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.media.jai.codec.StreamSegment;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
/**
 * Class that hold the Top Level "streams" JSON Object that is returned when -show_streams is executed
 *  
 * @author Simon Pott
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, include = As.PROPERTY, property = "@class")
public class StreamResponse
{
	
    @JsonProperty("streams")
    private List<Stream> streams;

//    @JsonCreator
//    public StreamResponse(@JsonProperty("streams") List<Stream> streams) {
//        this.streams = streams;
// 
//    }
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
