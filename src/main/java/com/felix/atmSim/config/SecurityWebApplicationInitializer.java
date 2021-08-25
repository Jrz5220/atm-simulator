package com.felix.atmSim.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*
 * AbstractSecurityWebApplicationInitializer - initializes the spring security filters for 
 * pre-processing/post-processing web requests (no code required)
 * Without this class, the Spring Security filters will not be registered.
 * It is part of the spring framework package so no component annotation required.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}
