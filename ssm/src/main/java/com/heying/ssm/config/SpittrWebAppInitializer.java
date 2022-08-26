package com.heying.ssm.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * 配置DispatchServlet
 */
public class SpittrWebAppInitializer extends 
   AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * 此方法返回的带有@Configuration注解的类将会用来
	 * 配置ContextLoaderListener创建的应用上下文中的Bean
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class };
	}

	/**
	 * 此方法返回的带有@Configuration注解的类将会用来
	 * 配置ContextLoaderListener创建的应用上下文中的Bean
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {com.heying.ssm.config.WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
		
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(
				new MultipartConfigElement("/tmp",1024*1024*2,1024*1024*4,0));
	}
	
}
