package model;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Class that hold the Top Level "format" JSON Object that is returned when -show_format is executed
 *  
 * @author Simon Pott
 */
public class FormatResponse
{
	
    @JsonProperty("format")
    private Format format;
        
    public Format getFormat()
    {
        return format;
    }
    public void setFormat(Format format)
    {
        this.format = format;
    }
        
}
