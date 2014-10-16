package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

public class StreamAudio extends Stream{

    //Audio only
    private String sample_fmt;
    private int sample_rate;
    private int channels;
    private String channel_layout;
    private int bits_per_sample;
	
    
    @JsonProperty
    private String codec_name;

    @JsonCreator
   	public StreamAudio(@JsonProperty("codec_name") String codec_name) {
	this.codec_name = codec_name;
	}
    
    public String getSample_fmt() {
		return sample_fmt;
	}
	public void setSample_fmt(String sample_fmt) {
		this.sample_fmt = sample_fmt;
	}
	public int getSample_rate() {
		return sample_rate;
	}
	public void setSample_rate(int sample_rate) {
		this.sample_rate = sample_rate;
	}
	public int getChannels() {
		return channels;
	}
	public void setChannels(int channels) {
		this.channels = channels;
	}
	public String getChannel_layout() {
		return channel_layout;
	}
	public void setChannel_layout(String channel_layout) {
		this.channel_layout = channel_layout;
	}
	public int getBits_per_sample() {
		return bits_per_sample;
	}
	public void setBits_per_sample(int bits_per_sample) {
		this.bits_per_sample = bits_per_sample;
	}
    
  
}
