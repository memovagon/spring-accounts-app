package com.accounts.app.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 *  @Configuration AutorizationServerConfig class
 *  The AutorizationServerConfig class is an implementation for OAUTH2 Authorization Server 
 *  This provide the Authorization server and grant access tokens
 *  Refer to https://docs.spring.io/spring-security-oauth2-boot/docs/current/reference/html/index.html 
 */

@Configuration
@EnableAuthorizationServer
public class AutorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("my-trusted-client")
		.authorizedGrantTypes("client_credentials", "password")
		.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
		.scopes("read", "write", "trust")
		.resourceIds("oauth2-resource").accessTokenValiditySeconds(5000)
		.secret(passwordEncoder.encode("secret"));

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		.authenticationManager(authenticationManager);
	}

}
