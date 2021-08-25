package com.felix.atmSim.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * AbstractAnnotationConfigDispatcherServletInitializer - abstract class used to
 * specify the servlet mapping and location of your app configuration (replaces web.xml).
 * It is part of the spring framework package so no component annotation required.
 */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// returns the root configuration class, if multiple configuration files exist
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AtmAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
