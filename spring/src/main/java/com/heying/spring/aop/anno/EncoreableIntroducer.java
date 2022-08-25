package com.heying.spring.aop.anno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component  //加组件
@Aspect  //加切面
public class EncoreableIntroducer {

    @DeclareParents(value = "com.heying.spring.aop.anno.artist.Performer+",
            defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
