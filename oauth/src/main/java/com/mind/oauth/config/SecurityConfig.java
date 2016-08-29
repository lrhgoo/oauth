package com.mind.oauth.config;

import com.mind.oauth.security.CustomUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by lrh on 2016/8/10.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    private static final String PASSWORD_SECRET = "sz-mind-secret-key";

    private static final PasswordEncoder passwordEncoder = new StandardPasswordEncoder(PASSWORD_SECRET);



    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }

    @Override
    @Autowired // <-- This is crucial otherwise Spring Boot creates its own
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder);

//        log.info("Defining inMemoryAuthentication (2 users)");
//        auth
//                .inMemoryAuthentication()
//
//                .withUser("user").password("password")
//                .roles("USER")
//
//                .and()
//
//                .withUser("admin").password("password")
//                .roles("USER", "ADMIN")
//        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
////                .formLogin()
////                    .loginProcessingUrl("/login")
////                    .failureUrl("/login.jsp?authentication_error=true")
////                   .loginPage("/login").permitAll()
//
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login.jsp")
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login")
//                .failureUrl("/login.jsp?authentication_error=true")
//                .loginPage("/login.jsp")
//                .and()
//
//                .httpBasic().disable()
////                .anonymous().disable()
//                .authorizeRequests()
//                    . antMatchers("/login.jsp").permitAll()
//                    . anyRequest().authenticated()
//        ;


        http
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//                .logoutSuccessHandler()
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID").permitAll()
                .and()
                .requestMatchers()
                .antMatchers("/", "/login", "/4.3", "/oauth/authorize", "/oauth/confirm_access")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

}
