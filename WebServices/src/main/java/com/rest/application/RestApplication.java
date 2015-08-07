package com.rest.application;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.wordnik.swagger.jaxrs.config.BeanConfig;

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
        resources.add(com.wordnik.swagger.jersey.listing.ApiListingResourceJSON.class);
        resources.add(com.wordnik.swagger.jersey.listing.JerseyApiDeclarationProvider.class);
        resources.add(com.wordnik.swagger.jersey.listing.JerseyResourceListingProvider.class);

        return resources;
    }

}