package com.heying.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//@ImportResource("classpath:spring-root.xml")
@EnableAspectJAutoProxy // AOP自动代理
@EnableTransactionManagement //启用事务管理
@ComponentScan(basePackages = {"com.heying.springmvc"},
excludeFilters =
{@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {

}
