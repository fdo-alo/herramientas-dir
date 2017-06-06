package gob.imss.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer {

	public void onStartup(ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		
		Class<?>[]  configurationClasses = new Class<?>[] {
			SpringConfig.class, SpringSecurityConfig.class
	    };
		
        appContext.register(configurationClasses);
               
        ServletRegistration.Dynamic dispatcher = ctx.addServlet(
                "dispatcher", new DispatcherServlet(appContext));       
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
        
        FilterRegistration.Dynamic filter = ctx.addFilter("OpenSessionInViewFilter", OpenSessionInViewFilter.class);   
        
        filter.setInitParameter("singleSession", "true");
        filter.addMappingForServletNames(null, true, "dispatcher");             
        
        
        ctx.addListener(new ContextLoaderListener(appContext));
        
        

	}
	
	

}
