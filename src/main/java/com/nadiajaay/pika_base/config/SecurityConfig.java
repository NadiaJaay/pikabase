package com.nadiajaay.pika_base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public UserDetailsService userDetailsService () {

        UserDetails demoUser = User.withDefaultPasswordEncoder()
            .username("demo")
            .password("pikabase")
            .roles("USER")
            .build();

        UserDetails secondDemoUser = User.withDefaultPasswordEncoder()
            .username("demoTwo")
            .password("pikabaseTwo")
            .roles("USER")
            .build();

        UserDetails adminUser = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("pikabaseadmin")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(demoUser, adminUser, secondDemoUser);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.GET, "/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/discussions/**")
                    .hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }
}
