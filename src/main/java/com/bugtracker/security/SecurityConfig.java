package com.bugtracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Autowired
   private UserDetailsService jdbcUserDetailsService;





    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/login").authenticated()
                        .requestMatchers("/bugs").authenticated()
                        .requestMatchers("/tickets").authenticated()
                        .requestMatchers("/comments").authenticated()
                        .requestMatchers("/dashboard").permitAll()
                )
                .formLogin();
//                .httpBasic();
        return http.build();
    }

//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(jdbcUserDetailsService).passwordEncoder(passwordEncoder());
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
