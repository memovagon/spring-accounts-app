package com.accounts.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *  @Configuration ResourceServerConfig class
 *  The ResourceServerConfig is an implementation for OAUTH2 Resource Server. 
 *  This allow server to resolve access tokens provided. 
 *  Refer to https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/html/index.html.
 */


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        
    	//Allow GET REST API Services and GUI available for unauthenticated Users
    	// PUT, POST, DETETE REST API Services require authentication
    	
    	http
            .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers( "/list","/form","/h2-console/**").permitAll()
                .antMatchers(HttpMethod.PUT).authenticated()
                .antMatchers(HttpMethod.POST).authenticated()
                .antMatchers(HttpMethod.DELETE).authenticated();
    }


}