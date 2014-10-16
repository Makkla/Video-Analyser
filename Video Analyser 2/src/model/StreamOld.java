package model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**   
 * 
 * F:\>ffprobe -loglevel quiet -print_format json -show_entries format=filename,nb_streams,nb_programs,format_name,format_long_name,start_time,duration,size,bit_rate,probe_score -i A002C001_140220_R00H.mov
 * 
 * 
 * "format": {
    "filename": "A002C001_140220_R00H.mov",
    "nb_streams": 3,
    "nb_programs": 0,
    "format_name": "mov,mp4,m4a,3gp,3g2,mj2"
    "format_long_name": "QuickTime / MOV",
    "start_time": "0.000000",
    "duration": "7.800000",
    "size": "193375760",
    "bit_rate": "198334112",
    "probe_score": 100,
    "tags": {
        "major_brand": "qt  ",
        "minor_version": "537199360",
        "compatible_brands": "qt  ARRI",
        "creation_time": "2014-02-20 10:57:3
        "timecode": "00:46:50:09"
**/  

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
 * @author Simon Pott
 */

public class StreamOld
{
    private short index;
	private String codec_name;
    private String codec_long_name;
    private String codec_type;
    private String codec_time_base;
    private String codec_tag_string;
    private String codec_tag;
    
    //Audio only
    private String sample_fmt;
    private int sample_rate;
    private int channels;
    private String channel_layout;
    private int bits_per_sample;
    
    //video only
    private int width;
    private int height;
    private int has_b_frames;
    private String sample_aspect_ratio;
    private String display_aspect_ratio;
    private String pix_fmt;
    private int level;
    
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
	
    
    public short getIndex() {
		return index;
	}
	public void setIndex(short index) {
		this.index = index;
	}
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
	public String getCodec_type() {
		return codec_type;
	}
	public void setCodec_type(String codec_type) {
		this.codec_type = codec_type;
	}
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

    


    
    

    
    

}
    
    

