package model;

public class FrameVideo extends Frame{

	private String media_type;
 
//video only
  private int width;
  private int height;
  private String pix_fmt;
  private String sample_aspect_ratio;
  private char pict_type;
  private int coded_picture_number;
  private int display_picture_number;
  private int interlaced_frame;
  private int top_field_first;
  private int repeat_pict;
  
  
  public String getMedia_type() {
		return media_type;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
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
public String getPix_fmt() {
	return pix_fmt;
}
public void setPix_fmt(String pix_fmt) {
	this.pix_fmt = pix_fmt;
}
public String getSample_aspect_ratio() {
	return sample_aspect_ratio;
}
public void setSample_aspect_ratio(String sample_aspect_ratio) {
	this.sample_aspect_ratio = sample_aspect_ratio;
}
public char getPict_type() {
	return pict_type;
}
public void setPict_type(char pict_type) {
	this.pict_type = pict_type;
}
public int getCoded_picture_number() {
	return coded_picture_number;
}
public void setCoded_picture_number(int coded_picture_number) {
	this.coded_picture_number = coded_picture_number;
}
public int getDisplay_picture_number() {
	return display_picture_number;
}
public void setDisplay_picture_number(int display_picture_number) {
	this.display_picture_number = display_picture_number;
}
public int getInterlaced_frame() {
	return interlaced_frame;
}
public void setInterlaced_frame(int interlaced_frame) {
	this.interlaced_frame = interlaced_frame;
}
public int getTop_field_first() {
	return top_field_first;
}
public void setTop_field_first(int top_field_first) {
	this.top_field_first = top_field_first;
}
public int getRepeat_pict() {
	return repeat_pict;
}
public void setRepeat_pict(int repeat_pict) {
	this.repeat_pict = repeat_pict;
}
  
  
	
	
}
