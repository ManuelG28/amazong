package com.kap.amazong.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ApplicationAspect {
    Logger logger = LoggerFactory.getLogger(ApplicationAspect.class);

    @Before("com.kap.amazong.aspect.CommonAspectConfiguration.businessLayerExecution()")
    public void beforeMusicExecution(JoinPoint joinPoint){
        logger.info("Running {} ",joinPoint);
    }
}
