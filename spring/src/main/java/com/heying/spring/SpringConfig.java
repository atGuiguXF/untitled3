package com.heying.spring;

import com.heying.spring.javaconfig.BBB;
import com.heying.spring.javaconfig.CCC;
import org.springframework.context.annotation.*;

@Configuration//该类用于配置 相当于applicationContext.xml
@ComponentScan//组件扫描器 默认会从SpringConfig 所在的包和子包进行扫描注解
@PropertySource("classpath:spring.properties")

@EnableAspectJAutoProxy //开关
public class SpringConfig {

    @Bean("bbb")//默认用的方法名作为bean的name
    public BBB bbb(CCC ccc) {
        final BBB bbb = new BBB();
        bbb.setName("bbb");
        bbb.setAge(20);
        bbb.setCcc(ccc);
        return bbb;
    }

    @Bean
    public CCC ccc() {
        return new CCC(1, "ccc");
    }
}
