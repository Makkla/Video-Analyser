package model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


/**
 * Class that actually holds the elements of the "stream" JSON Objects that are returned when -show_streams is executed
 * 
 * Output of ffprobe -loglevel quiet -print_format json -show_streams -i " +file.getPath():
 * 
 * "streams": [
    {
        "index": 0,
        "codec_name": "prores",
        "codec_long_name": "ProRes",
        "codec_type": "video",
        "codec_time_base": "1/30000",
        "codec_tag_string": "apcs",
        "codec_tag": "0x73637061",
        "width": 480,
        "height": 270,
        "has_b_frames": 0,
        "sample_aspect_ratio": "0:1",
        "display_aspect_ratio": "0:1",
        "pix_fmt": "yuv422p10le",
        "level": -99,
        "r_frame_rate": "30000/1001",
        "avg_frame_rate": "30000/1001",
        "time_base": "1/30000",
        "start_pts": 0,
        "start_time": "0.000000",
        "duration_ts": 596596,
        "duration": "19.886533",
        "bit_rate": "2079294",
        "nb_frames": "596",
        "disposition": {
            "default": 1,
            "dub": 0,
            "original": 0,
            "comment": 0,
            "lyrics": 0,
            "karaoke": 0,
            "forced": 0,
            "hearing_impaired": 0,
            "visual_impaired": 0,
            "clean_effects": 0,
            "attached_pic": 0
        },
        "tags": {
            "creation_time": "2013-11-20 13:45:53",
            "language": "eng",
            "handler_name": "DataHandler"
        }
    },
    
    {
    "index": 1,
    "codec_name": "aac",
    "codec_long_name": "AAC (Advanced Audio Coding)",
    "codec_type": "audio",
    "codec_time_base": "1/44100",
    "codec_tag_string": "mp4a",
    "codec_tag": "0x6134706d",
    "sample_fmt": "fltp",
    "sample_rate": "44100",
    "channels": 1,
    "channel_layout": "mono",
    "bits_per_sample": 0,
    "r_frame_rate": "0/0",
    "avg_frame_rate": "0/0",
    "time_base": "1/44100",
    "start_pts": 0,
    "start_time": "0.000000",
    "duration_ts": 877568,
    "duration": "19.899501",
    "bit_rate": "62263",
    "nb_frames": "857",
    "disposition": {
        "default": 1,
        "dub": 0,
        "original": 0,
        "comment": 0,
        "lyrics": 0,
        "karaoke": 0,
        "forced": 0,
        "hearing_impaired": 0,
        "visual_impaired": 0,
        "clean_effects": 0,
        "attached_pic": 0
    },
    "tags": {
        "creation_time": "2013-11-20 13:45:53",
        "language": "eng",
        "handler_name": "DataHandler"
    }
 *   
 *  
 *  {
    "index": 2,
    "codec_type": "data",
    "codec_time_base": "1/24",
    "codec_tag_string": "tmcd",
    "codec_tag": "0x64636d74",
    "r_frame_rate": "0/0",
    "avg_frame_rate": "0/0",
    "time_base": "1/24",
    "start_pts": 0,
    "start_time": "0.000000",
    "duration_ts": 144,
    "duration": "6.000000",
    "bit_rate": "5",
    "nb_frames": "1",
    "disposition": {
        "default": 1,
        "dub": 0,
        "original": 0,
        "comment": 0,
        "lyrics": 0,
        "karaoke": 0,
        "forced": 0,
        "hearing_impaired": 0,
        "visual_impaired": 0,
        "clean_effects": 0,
        "attached_pic": 0
    },
    "tags": {
        "creation_time": "2014-04-12 00:05:31",
        "language": "eng",
        "handler_name": "\u0018Apple Alias Data Handler",
        "timecode": "11:31:09:00"
    }
 *  
 *  
 * @author Simon Pott
 */
@JsonTypeInfo(  
	    use = JsonTypeInfo.Id.NAME,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "codec_type")  
@JsonSubTypes({ @Type(value = StreamVideo.class, name = "video"), @Type(value = StreamAudio.class, name = "audio"), @Type(value = StreamData.class, name = "data") })
public abstract class Stream
{
    private short index;
	
    private String codec_time_base;
    private String codec_tag_string;
    private String codec_tag;
    private String r_frame_rate;
    private String avg_frame_rate;
    private String time_base;
    private int start_pts;
    private double start_time;
    private long duration_ts;
    private double duration;
    private long bit_rate;
    private long nb_frames;
    private Map<String, String> disposition;
    private Map<String, String> tags;
    private int nb_read_frames;
    
    public short getIndex() {
		return index;
	}
	public void setIndex(short index) {
		this.index = index;
	}

//	public String getCodec_type() {
//		return codec_type;
//	}
//	public void setCodec_type(String codec_type) {
//		this.codec_type = codec_type;
//	}
	public String getCodec_time_base() {
		return codec_time_base;
	}
	public void setCodec_time_base(String codec_time_base) {
		this.codec_time_base = codec_time_base;
	}
	public String getCodec_tag_string() {
		return codec_tag_string;
	}
	public void setCodec_tag_string(String codec_tag_string) {
		this.codec_tag_string = codec_tag_string;
	}
	public String getCodec_tag() {
		return codec_tag;
	}
	public void setCodec_tag(String codec_tag) {
		this.codec_tag = codec_tag;
	}
	public String getR_frame_rate() {
		return r_frame_rate;
	}
	public void setR_frame_rate(String r_frame_rate) {
		this.r_frame_rate = r_frame_rate;
	}
	public String getAvg_frame_rate() {
		return avg_frame_rate;
	}
	public void setAvg_frame_rate(String avg_frame_rate) {
		this.avg_frame_rate = avg_frame_rate;
	}
	public String getTime_base() {
		return time_base;
	}
	public void setTime_base(String time_base) {
		this.time_base = time_base;
	}
	public int getStart_pts() {
		return start_pts;
	}
	public void setStart_pts(int start_pts) {
		this.start_pts = start_pts;
	}
	public double getStart_time() {
		return start_time;
	}
	public void setStart_time(double start_time) {
		this.start_time = start_time;
	}
	public long getDuration_ts() {
		return duration_ts;
	}
	public void setDuration_ts(long duration_ts) {
		this.duration_ts = duration_ts;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public long getBit_rate() {
		return bit_rate;
	}
	public void setBit_rate(long bit_rate) {
		this.bit_rate = bit_rate;
	}
	public long getNb_frames() {
		return nb_frames;
	}
	public void setNb_frames(long nb_frames) {
		this.nb_frames = nb_frames;
	}
	public Map<String, String> getDisposition() {
		return disposition;
	}
	public void setDisposition(Map<String, String> disposition) {
		this.disposition = disposition;
	}
	public Map<String, String> getTags() {
		return tags;
	}
	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}
	public int getNb_read_frames() {
		return nb_read_frames;
	}
	public void setNb_read_frames(int nb_read_frames) {
		this.nb_read_frames = nb_read_frames;
	}

    


    
    

    
    

}
    
    

