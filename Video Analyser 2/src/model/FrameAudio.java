package model;

public class FrameAudio extends Frame{

  //Audio only
  private String sample_fmt;
  private int nb_samples;
  private int channels;
  private String channel_layout;
  
  
public String getSample_fmt() {
	return sample_fmt;
}
public void setSample_fmt(String sample_fmt) {
	this.sample_fmt = sample_fmt;
}
public int getNb_samples() {
	return nb_samples;
}
public void setNb_samples(int nb_samples) {
	this.nb_samples = nb_samples;
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
  
  
	
	
}
