package com.uwjx.spring.security.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Qualifier("userDetailServiceImpl")
//    @Autowired
//    UserDetailsService userDetailsService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client-01")
                .secret(passwordEncoder.encode("123123"))
                .authorizedGrantTypes("authorization_code","password" , "refresh_token")
                .scopes("all")
                .autoApprove(true)
                .accessTokenValiditySeconds(100)//配置访问token的有效期
                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
                .redirectUris("http://localhost:8081/auth/callback")
                .and()
                .withClient("client-02")
                .secret(passwordEncoder.encode("123123"))
                .authorizedGrantTypes("authorization_code","password" , "refresh_token")
                .scopes("all")
                .autoApprove(true)
                .accessTokenValiditySeconds(100)//配置访问token的有效期
                .refreshTokenValiditySeconds(864000)//配置刷新token的有效期
                .redirectUris("http://localhost:8082/auth/callback");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /**
         * 允许 /oauth/check_token
         * isAuthenticated() 需要 basic认证
         * permitAll()   自由访问
         */
        security.checkTokenAccess("isAuthenticated()");
//        security.checkTokenAccess("permitAll()");
    }
}
