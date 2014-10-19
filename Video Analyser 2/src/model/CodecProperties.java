package model;

import java.util.HashMap;
import java.util.Map;

public class CodecProperties
{

    private  HashMap<String, Integer> targetBitrateVideo = new HashMap<String, Integer>();
    private Map<String, Integer> maxBitrateVideo;
    private String fourCc;
  

    
    public int getTargetBitrateVideo(String fourCC){
        
        if (targetBitrateVideo.get(fourCC)==null)
            throw new NullPointerException ( "Unknown Codec, ask Gregor");
        
        return targetBitrateVideo.get(fourCC);
    }
    
    public int getMaxBitrateVideo(String fourCC){
        
        if (maxBitrateVideo.get(fourCC)==null)
            throw new NullPointerException ( "Unknown Codec, ask Gregor");
        
        return maxBitrateVideo.get(fourCC);
    }
}
