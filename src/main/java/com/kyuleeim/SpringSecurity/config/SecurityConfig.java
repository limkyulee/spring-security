package com.kyuleeim.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author limkyulee
 * @version 1.0, 7/4/25
 * @see {참조}
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable());
        // @see 인증 없이 페이지 접근 불가
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        // Default 로그인 페이지로 로그인
//        http.formLogin(Customizer.withDefaults());
        // 페이지 내용을 결과값으로 받음
        http.httpBasic(Customizer.withDefaults());
        // 세션을 사용하지 않음 (매 요청마다 인증처리)
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
