package com.simplilearn.maricel.vdf.security;

import com.simplilearn.maricel.vdf.service.UserServiceDB;
import com.simplilearn.maricel.vdf.service.UserServiceDBImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    @Autowired
    private UserServiceDBImpl userServiceDB;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserServiceDB userServiceDB) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userServiceDB);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/product/getAll").hasRole("CUSTOMER")
                        .requestMatchers("/product/getAllAdminPage").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form ->
                        form.loginPage("/showLoginPage")
                                .successForwardUrl("/home")
                                .loginProcessingUrl("/authenticateUser")
                                .permitAll())
                .logout(LogoutConfigurer::permitAll);

        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
