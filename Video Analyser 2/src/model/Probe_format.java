package model;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**   
 * 
 * F:\>ffprobe -loglevel quiet -print_format json -show_entries format=filename,nb_streams,nb_programs,format_name,format_long_name,start_time,duration,size,bit_rate,probe_score A002C001_140220_R00H.mov
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



public class Probe_format
{
    
    private String filename;
    private int nb_streams;
    private int nb_programs;
    private String format_name;
    
    private String format_long_name;
    private float start_time;
    private float duration;
    private double size;
    private double bit_rate;
    private int probe_score;
    
    
    public String getFilename()
    {
        return filename;
    }
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    public int getNb_streams()
    {
        return nb_streams;
    }
    public void setNb_streams(int nb_streams)
    {
        this.nb_streams = nb_streams;
    }
    public int getNb_programs()
    {
        return nb_programs;
    }
    public void setNb_programs(int nb_programs)
    {
        this.nb_programs = nb_programs;
    }
    public String getFormat_name()
    {
        return format_name;
    }
    public void setFormat_name(String format_name)
    {
        this.format_name = format_name;
    }
    public String getFormat_long_name()
    {
        return format_long_name;
    }
    public void setFormat_long_name(String format_long_name)
    {
        this.format_long_name = format_long_name;
    }
    public float getStart_time()
    {
        return start_time;
    }
    public void setStart_time(float start_time)
    {
        this.start_time = start_time;
    }
    public float getDuration()
    {
        return duration;
    }
    public void setDuration(float duration)
    {
        this.duration = duration;
    }
    public double getSize()
    {
        return size;
    }
    public void setSize(double size)
    {
        this.size = size;
    }
    public double getBit_rate()
    {
        return bit_rate;
    }
    public void setBit_rate(double bit_rate)
    {
        this.bit_rate = bit_rate;
    }
    public int getProbe_score()
    {
        return probe_score;
    }
    public void setProbe_score(int probe_score)
    {
        this.probe_score = probe_score;
    }

}
    
    

