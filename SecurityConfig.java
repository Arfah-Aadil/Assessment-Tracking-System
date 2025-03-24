package com.example.Assessment.Tracking.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    public static final String[] ENDPOINTS_WHITELIST = {"/css/**","/javascript/**","/document/**"};
    public static final String[] USER_ENDPOINTS_WHITELIST = {"/","/assessment","/thankYou"};
    public static final String[] INTERNAL_ENDPOINTS_WHITELIST = {"/internal"};
    public static final String[] EXTERNAL_ENDPOINTS_WHITELIST = {"/external"};
    public static final String[] PANEL_ENDPOINTS_WHITELIST = {"/panel"};
    public static final String[] ADMIN_ENDPOINTS_WHITELIST = {"/admin"};
    public static final String[] LEADER_ENDPOINTS_WHITELIST = {"/moduleLead","/leaderResponse"};


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http .authorizeHttpRequests(request -> request
                .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                .requestMatchers(USER_ENDPOINTS_WHITELIST).hasRole("USER")
                .requestMatchers(INTERNAL_ENDPOINTS_WHITELIST).hasRole("INTERNAL")
                .requestMatchers(EXTERNAL_ENDPOINTS_WHITELIST).hasRole("EXTERNAL")
                .requestMatchers(PANEL_ENDPOINTS_WHITELIST).hasRole("PANEL")
                .requestMatchers(LEADER_ENDPOINTS_WHITELIST).hasRole("LEADER")
                .anyRequest().hasRole("ADMIN")
                )
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.loginPage("/login"). permitAll())
            .logout((logout) -> logout.logoutSuccessUrl("/login"));
        return http.build();
    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
    //     UserDetails user = User.withUsername("Module Leader")
    //         .password(passwordEncoder.encode("moduleleader"))
    //         .roles("USER")
    //         .build();

    //     UserDetails admin = User.withUsername("admin")
    //         .password(passwordEncoder.encode("admin"))
    //         .roles("USER", "ADMIN")
    //         .build();

    //     return new InMemoryUserDetailsManager(user, admin);
    // }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    //     http
    //         .authorizeHttpRequests((authorize) -> authorize
	// 			.anyRequest().authenticated()
	// 		)
    //         .formLogin(form -> form
    //             .loginPage("/login")
    //             .permitAll()
    //         );
    //     return http.build();
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcUserDetails = new JdbcDaoImpl();
        jdbcUserDetails.setDataSource(dataSource);
        jdbcUserDetails.setUsersByUsernameQuery("select UserName, Password, enabled from users where UserName=?");
        jdbcUserDetails.setAuthoritiesByUsernameQuery("select UserName, authority from user_authorities where UserName=?");
        return jdbcUserDetails;
    }
}