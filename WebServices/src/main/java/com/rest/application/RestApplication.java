package com.rest.application;

import io.swagger.jaxrs.config.BeanConfig;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RestApplication extends Application {
	
	Properties props = new Properties();
	
	public RestApplication() {		
		String hostBasePath = props.getProperty("http:localhost:8080/rest/api");
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setBasePath(hostBasePath);
        beanConfig.setResourcePackage("com.rest.resource");
        beanConfig.setScan(true);
        beanConfig.setBasePath("/rest/api");
    }
	
	
	
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        
        //Swagger Resources
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }

}