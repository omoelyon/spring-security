package com.spring.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("tade")
                .password("12345")
                .authorities("read")
          .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

//        var userDetailsManager = new InMemoryUserDetailsManager();
//        var user = User.withUsername("tade")
//                .password("12345")
//                .authorities("read")
//                .build();
//        userDetailsManager.createUser(user);
//        auth.userDetailsService(userDetailsManager)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());

    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        var userDetailsManager = new InMemoryUserDetailsManager();
//        var user = User.withUsername("tade")
//                .password("12345")
//                .authorities("read")
//                .build();
//        userDetailsManager.createUser(user);
//        return userDetailsManager;
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
}
