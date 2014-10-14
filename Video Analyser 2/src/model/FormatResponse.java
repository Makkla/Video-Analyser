package model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormatResponse
{

    
    
    @JsonProperty("format")
    List<Probe_format> formats;
    
    
  
    public List<Probe_format> getFormats()
    {
        return formats;
    }
    public void setFormats(List<Probe_format> formats)
    {
        this.formats = formats;
    }
    
    
        
    
}
