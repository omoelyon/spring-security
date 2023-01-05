package com.spring.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectConfig  {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.httpBasic(c-> {
//            c.realmName("OTHER");
//            c.authenticationEntryPoint(new CustomEntryPoint());
//        });
        http.formLogin();
        http
                .authorizeRequests().anyRequest().authenticated();
        return http.build();
    }
}
