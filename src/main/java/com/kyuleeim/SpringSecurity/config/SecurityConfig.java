package com.kyuleeim.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
         /*
         @flow
         - csrf 셋팅 제거
         - 인증 없이 페이지 접근 불가
         - 페이지 내용을 결과값으로 받음
         - 세션을 사용하지 않음 (매 요청마다 인증처리)
         - 적용
         */
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    /**
     * @method userDetailService
     * @description user hardcoding
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User
            .withDefaultPasswordEncoder()
            .username("kyuleelim01")
            .password("springsecurity")
            .roles("USER")
            .build();


        UserDetails user2 = User
            .withDefaultPasswordEncoder()
            .username("kyuleelim02")
            .password("springsecurity")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
