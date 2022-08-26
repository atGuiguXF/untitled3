package com.heying.ssm.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:jdbc.properties",
        "classpath:druid.properties"})
@Import({MyBatisConfig.class})
//@ImportResource("classpath:spring-root.xml")
@EnableAspectJAutoProxy // AOP自动代理
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.heying.ssm"},
excludeFilters =
{@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)})
public class RootConfig {

    @Bean //事务管理器
    public PlatformTransactionManager txManager(DataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }

    @Bean //这一段不能放在有@Value的类中，会导致@Value无法获得数据
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.heying.ssm.mapper");
        msc.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return msc;
    }
}
