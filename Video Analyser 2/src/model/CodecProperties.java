package model;

import java.util.HashMap;
import java.util.Map;

public class CodecProperties
{

    private static  HashMap<String, Integer> targetBitrateVideo = new HashMap<String, Integer>();
    private static Map<String, Integer> maxBitrateVideo = new HashMap<String, Integer>();
    private String fourCc;
  
public CodecProperties(){
	
	//ProRes 422 HQ
	targetBitrateVideo.put("apch", 917504);
	maxBitrateVideo.put("apch", 1032192);
	
	//ProRes 444
	targetBitrateVideo.put("ap4h", 1376256);
	maxBitrateVideo.put("ap4h", 1548288);
			
	//ProRes 422 
	targetBitrateVideo.put("apcn", 611669);
	maxBitrateVideo.put("apcn", 688128);
		
	//ProRes 422 LT 
	targetBitrateVideo.put("apcs", 425984);
	maxBitrateVideo.put("apcs", 479232);
			
	//ProRes 422 Proxy 
	targetBitrateVideo.put("apco", 189326);
	maxBitrateVideo.put("apco", 212992);
	
}
    
    public static int getTargetBitrateVideo(String fourCc){
        
        if (targetBitrateVideo.get(fourCc)==null)
            throw new NullPointerException ( "Unknown Codec, ask Gregor");
                       
        return targetBitrateVideo.get(fourCc);
    }
    
    public static int getMaxBitrateVideo(String fourCc){
        
        if (maxBitrateVideo.get(fourCc)==null)
            throw new NullPointerException ( "Unknown Codec, ask Gregor");
        
        return maxBitrateVideo.get(fourCc);
    }
    
    
}
