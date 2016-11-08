package com.cybage.project.configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * Base class for {@link org.springframework.web.WebApplicationInitializer}
 * Spring since version 3.2 provides us a few classes implementing WebApplicationInitializer interface,
 * from which first is AbstractContextLoaderInitializer. This class included in spring-web module uses 
 * abstract createRootApplicationContext() method to create application context, delegates it to 
 * ContextLoaderListener which then is being registered in the ServletContext instance. Creating
 * application context using this class looks as follows:
 * public class SpringAnnotationWebInitializer
 * extends AbstractContextLoaderInitializer {

 * @Override
 * protected WebApplicationContext createRootApplicationContext() {
 *   AnnotationConfigWebApplicationContext applicationContext =
 *     new AnnotationConfigWebApplicationContext();
 *   applicationContext.register(SpringAnnotationConfig.class);
 *   return applicationContext;
 *  }
 *
 * }

 * That was the simplest way to start up Spring web context. But if we want to experience benefits 
 * provided by Spring MVC and don't want to manually register DispatcherServlet it'll be better to 
 * use another class: AbstractDispatcherServletInitializer. It extends previous class and adds two 
 * abstract methods: createServletApplicationContext() and getServletMappings().  First method 
 * returns WebApplicationContext that will be passed to DispatcherServlet, which will be 
 * automatically added into container ServletContext. Please notice that this context will be 
 * established as a child of the context returned by createRootApplicationContext() method. 
 * Second method - as you have probably already deduced - returns mappings that are used 
 * during servlet registration. You can also override getServletFilters() method if you need any 
 * custom filters, because default implementation returns just empty array. Exemplary implementation
 * using this class could be:
 * public class SpringWebMvcInitializer
 * extends AbstractDispatcherServletInitializer {

 * @Override
 * protected WebApplicationContext createRootApplicationContext() {
 *   AnnotationConfigWebApplicationContext applicationContext =
 *     new AnnotationConfigWebApplicationContext();
 *   applicationContext.register(SpringRootConfig.class);
 *   return applicationContext;
 * }
 *
 * @Override
 * protected WebApplicationContext createServletApplicationContext() {
 *   AnnotationConfigWebApplicationContext applicationContext =
 *     new AnnotationConfigWebApplicationContext();
 *   applicationContext.register(SpringMvcConfig.class);
 *   return applicationContext;
 * }
 *
 * @Override
 * protected String[] getServletMappings() {
 *   return new String[]{"/*"};
 * }
 *
 *}

 * @author      Aniket Deshmukh
 * @see         org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
 * @version     %1%
 */
public class WebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
	
	
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebMvcConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
/*    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CORSFilter()};
        return singleton;
    }*/
 
}