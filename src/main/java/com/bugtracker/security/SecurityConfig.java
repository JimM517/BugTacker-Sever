package com.bugtracker.security;

import com.bugtracker.security.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final UserModelDetailsService userModelDetailsService;





    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .apply(securityConfigurerAdapter());

                .authorizeHttpRequests(auth -> auth

                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
                return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    private OAuth2ResourceServerConfigurer.JwtConfigurer securityConfigurerAdapter() {
        return new OAuth2ResourceServerConfigurer.JwtConfigurer(tokenProvider);
    }

//    @Bean
//    InMemoryUserDetailsManager users() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("dan")
//                        .password("{noop}password")
//                        .roles("ADMIN")
//                        .build()
//        );
//    }

//    @Bean
//    DataSource dataSource() {
//        return  new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.valueOf("jdbc:postgresql://localhost:5432/Issues"))
//                .setName("Issues")
//                .addScript(JdbcDaoImpl.DEF_USERS_BY_USERNAME_QUERY)
//                .build();
//    }
//
//
//    @Bean
//    JdbcUserDetailsManager users(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//        return jdbcUserDetailsManager;
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////            http
////                    .csrf().disable()
////                    .authorizeRequests()
////                    .requestMatchers(HttpMethod.GET).permitAll()
////                    .anyRequest().authenticated()
////                    .and()
////                    .httpBasic();
////
////
////            return http.build();
//        return http
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/login"))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/login").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .headers(headers -> headers.frameOptions().sameOrigin())
//                .formLogin(withDefaults())
//                .build();
//    }


//    @Bean
//    public UserDetailsService users() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("password")
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password("userpassword")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }




}
