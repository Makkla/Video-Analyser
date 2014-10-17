package model;

public class StreamAudio extends Stream{

    //Audio only
	private String codec_name;
    private String codec_long_name;
    
    private String sample_fmt;
    private int sample_rate;
    private int channels;
    private String channel_layout;
    private int bits_per_sample;
    
	   
    
    public String getCodec_name() {
		return codec_name;
	}
	public void setCodec_name(String codec_name) {
		this.codec_name = codec_name;
	}
	public String getCodec_long_name() {
		return codec_long_name;
	}
	public void setCodec_long_name(String codec_long_name) {
		this.codec_long_name = codec_long_name;
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
