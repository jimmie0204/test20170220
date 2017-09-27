package com.jimmie.test.akka.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("countingService")  
public class CountingServiceImpl implements CountingService {  
  
    private static Logger logger = LoggerFactory.getLogger(CountingServiceImpl.class);  
  
    /* 
     * (non-Javadoc) 
     *  
     * @see com.elong.sentosa.metadata.service.CountingService#increment(int) 
     */  
    @Override  
    public int increment(int count) {  
        logger.info("increase " + count + "by 1.");  
        return count + 1;  
    }  
  
} 