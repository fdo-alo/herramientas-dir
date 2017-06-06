package gob.imss.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	
	protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringSecurityConfig.class };
    }

}
