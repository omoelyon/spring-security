//package com.spring.springsecurity.config;
//
//import com.spring.springsecurity.security.CustomAuthenticationProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//public class ProjectConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private CustomAuthenticationProvider authenticationProvider;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic();
//        http.authorizeRequests()
//                .anyRequest().authenticated();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.authenticationProvider(authenticationProvider);
//    }
//    //    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http.httpBasic();
////        http
////                .authorizeHttpRequests((authz) -> authz
////                        .anyRequest().authenticated()
////                )
////                .httpBasic(withDefaults());
////        return http.build();
////    }
//}
