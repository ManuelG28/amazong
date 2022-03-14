package com.kap.amazong.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonAspectConfiguration {

    @Pointcut("execution(* com.kap.amazong.music.song..*.*(..))")
    public void businessLayerExecution() {

    }
}
