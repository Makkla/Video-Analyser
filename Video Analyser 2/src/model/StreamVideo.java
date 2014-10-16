package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StreamVideo extends Stream{

	
    //video only
    private int width;
    private int height;
    private int has_b_frames;
    private String sample_aspect_ratio;
    private String display_aspect_ratio;
    private String pix_fmt;
    private int level;
	
    
    @JsonProperty
    private String codec_name;

    @JsonCreator
   	public StreamVideo(@JsonProperty("codec_name") String codec_name) {
	this.codec_name = codec_name;
	}
    
    public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHas_b_frames() {
		return has_b_frames;
	}
	public void setHas_b_frames(int has_b_frames) {
		this.has_b_frames = has_b_frames;
	}
	public String getSample_aspect_ratio() {
		return sample_aspect_ratio;
	}
	public void setSample_aspect_ratio(String sample_aspect_ratio) {
		this.sample_aspect_ratio = sample_aspect_ratio;
	}
	public String getDisplay_aspect_ratio() {
		return display_aspect_ratio;
	}
	public void setDisplay_aspect_ratio(String display_aspect_ratio) {
		this.display_aspect_ratio = display_aspect_ratio;
	}
	public String getPix_fmt() {
		return pix_fmt;
	}
	public void setPix_fmt(String pix_fmt) {
		this.pix_fmt = pix_fmt;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
    
    
    
    
	
}
