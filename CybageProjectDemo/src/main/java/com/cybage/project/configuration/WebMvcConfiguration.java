package com.cybage.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 * Base class for {@org.springframework.web.servlet.config.annotation.WebMvcConfigurer}
 * implementation of callback methods for Java-based configuration. 
 * Spring MVC enabled via {@code @EnableWebMvc}.
 * Bean are configured via {@code @Configuration}.
 * Configures component scanning directives for use with @{@link Configuration} classes.
 * @author      Aniket Deshmukh
 * @see         org.springframework.context.annotation.Configuration
 * @see         org.springframework.web.servlet.config.annotation.EnableWebMvc
 * @see         org.springframework.context.annotation.ComponentScan
 * @version     %1%
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.cybage.project")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	/*
	 * JSP files that just serve as views under WEB-INF, to hide them from direct access 
	 * (e.g. via a manually entered URL).Only controllers will be able to access them.
	 * {@code @Bean} indicates that a method produces a bean to be managed by the 
	 *                  Spring container.
	 * @return          <code>resolver</code>  objects that can resolve views by name. 
	 * @see             org.springframework.web.servlet.ViewResolver
	 * @see             org.springframework.web.servlet.view.InternalResourceViewResolver
	 */
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/*
	 * It add static resources to handler based on the specified URL path patterns.
	 * The handler will be invoked for every incoming request that matches to one 
	 * of the specified path patterns.
	 * @param registry     Stores registrations of resource handlers for serving 
	 *                     static resources such as images, css files and others
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		 registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

}
