package com.volta.voltav2.config;

import com.volta.voltav2.filter.JwtRequestFilter;
import com.volta.voltav2.repository.UserRepository;
import com.volta.voltav2.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.util.AbstractUriTemplateHandler;

import java.awt.image.BandCombineOp;
import java.net.Authenticator;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private  UserRepository userRepository;

    private JwtRequestFilter jwtRequestFilter;

    private MyUserDetailService myUserDetailService;

   @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());
   }

    private PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }
}
