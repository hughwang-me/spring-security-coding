package com.uwjx.spring.security.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class JwtTokenStoreConfig {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Bean
    public JwtTokenStore redisTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("wanghuanKey");
        return jwtAccessTokenConverter;
    }

    @Bean(name = "myJwtTokenEnhancer")
    public TokenEnhancer tokenEnhancer(){
        return new MyJwtTokenEnhancer();
    }
}
