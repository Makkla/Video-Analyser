package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;



/**   
 * 
 * F:\>ffprobe -loglevel quiet -print_format json -show_frames -i A002C001_140220_R00H.mov
 * 
 * 
 * 
**/  

/**
 * Class that actually holds the elements of the "frame" JSON Objects that are returned when -show_frames is executed
 * 
 * Output of ffprobe -loglevel quiet -print_format json -show_frames -i " +file.getPath():
 * 
 * "frames": [
    {
        "media_type": "video",
        "key_frame": 1,
        "pkt_pts": 0,
        "pkt_pts_time": "0.000000",
        "pkt_dts": 0,
        "pkt_dts_time": "0.000000",
        "best_effort_timestamp": 0,
        "best_effort_timestamp_time": "0.000000",
        "pkt_duration": 1001,
        "pkt_duration_time": "0.033367",
        "pkt_pos": "18129",
        "pkt_size": "8716",
        "width": 480,
        "height": 270,
        "pix_fmt": "yuv422p10le",
        "pict_type": "I",
        "coded_picture_number": 0,
        "display_picture_number": 0,
        "interlaced_frame": 0,
        "top_field_first": 0,
        "repeat_pict": 0
    },
    {
        "media_type": "audio",
        "key_frame": 1,
        "pkt_pts": 0,
        "pkt_pts_time": "0.000000",
        "pkt_dts": 0,
        "pkt_dts_time": "0.000000",
        "best_effort_timestamp": 0,
        "best_effort_timestamp_time": "0.000000",
        "pkt_duration": 1024,
        "pkt_duration_time": "0.023220",
        "pkt_pos": "26845",
        "pkt_size": "17",
        "sample_fmt": "fltp",
        "nb_samples": 1024,
        "channels": 1,
        "channel_layout": "mono"
    },
 *   
 *  
 * @author Simon Pott
 */
@JsonTypeInfo(  
	    use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "media_type")  
@JsonSubTypes({ @Type(value = FrameVideo.class, name = "video"), @Type(value = FrameAudio.class, name = "audio")})
public abstract class Frame 
{
   
	private String media_type;
    private int key_frame;
    private long pkt_pts;
    private double pkt_pts_time;
    private long pkt_dts;
    private double pkt_dts_time;
    private long best_effort_timestamp;
    private double best_effort_timestamp_time;
    private int pkt_duration;
    private double pkt_duration_time;
    private long pkt_pos;
    private int pkt_size;
    
    
	public String getMedia_type() {
		return media_type;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	public int getKey_frame() {
		return key_frame;
	}
	public void setKey_frame(int key_frame) {
		this.key_frame = key_frame;
	}
	public long getPkt_pts() {
		return pkt_pts;
	}
	public void setPkt_pts(long pkt_pts) {
		this.pkt_pts = pkt_pts;
	}
	public double getPkt_pts_time() {
		return pkt_pts_time;
	}
	public void setPkt_pts_time(double pkt_pts_time) {
		this.pkt_pts_time = pkt_pts_time;
	}
	public long getPkt_dts() {
		return pkt_dts;
	}
	public void setPkt_dts(long pkt_dts) {
		this.pkt_dts = pkt_dts;
	}
	public double getPkt_dts_time() {
		return pkt_dts_time;
	}
	public void setPkt_dts_time(double pkt_dts_time) {
		this.pkt_dts_time = pkt_dts_time;
	}
	public long getBest_effort_timestamp() {
		return best_effort_timestamp;
	}
	public void setBest_effort_timestamp(long best_effort_timestamp) {
		this.best_effort_timestamp = best_effort_timestamp;
	}
	public double getBest_effort_timestamp_time() {
		return best_effort_timestamp_time;
	}
	public void setBest_effort_timestamp_time(double best_effort_timestamp_time) {
		this.best_effort_timestamp_time = best_effort_timestamp_time;
	}
	public int getPkt_duration() {
		return pkt_duration;
	}
	public void setPkt_duration(int pkt_duration) {
		this.pkt_duration = pkt_duration;
	}
	public double getPkt_duration_time() {
		return pkt_duration_time;
	}
	public void setPkt_duration_time(double pkt_duration_time) {
		this.pkt_duration_time = pkt_duration_time;
	}
	public long getPkt_pos() {
		return pkt_pos;
	}
	public void setPkt_pos(long pkt_pos) {
		this.pkt_pos = pkt_pos;
	}
	public int getPkt_size() {
		return pkt_size;
	}
	public void setPkt_size(int pkt_size) {
		this.pkt_size = pkt_size;
	}
        


  


    
    

    
    

}
    
    

