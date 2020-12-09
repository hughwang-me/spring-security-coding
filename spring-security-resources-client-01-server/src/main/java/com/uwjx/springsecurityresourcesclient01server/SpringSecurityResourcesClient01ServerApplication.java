package com.uwjx.springsecurityresourcesclient01server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


@EnableOAuth2Sso
@SpringBootApplication
public class SpringSecurityResourcesClient01ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityResourcesClient01ServerApplication.class, args);
	}

}
