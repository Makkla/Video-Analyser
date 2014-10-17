package model;


/**
 * Class that actually holds the elements of the "stream" JSON Objects that are returned when -show_streams is executed
 * 
 * Output of ffprobe -loglevel quiet -print_format json -show_streams -i " +file.getPath():
 * 
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

public class StreamData extends Stream{

  
    
	
}
