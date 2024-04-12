package com.mydata.authlogin.config;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mydata.authlogin.security.AuthService;

import lombok.extern.slf4j.Slf4j;




@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        AuthService authService;

        
     
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
                
      
                http.csrf(csrf -> csrf.disable());
                http
                        .authorizeHttpRequests((authorize)->authorize
                                .requestMatchers("/member/**").authenticated() // restfull / member 이후로는 인증필요
                                .requestMatchers("/admin/**").hasRole("ADMIN") // 어드민은 어드민이상만
                                .anyRequest().permitAll() //그이후 요청은 모두 가능
                        )
                        .formLogin(login ->login
                                .loginPage("/login") //로그인 페이지를 지정해준다 시큐리티에서는 시큐리티기본로그인폼이있기에 지정해줘야 지정요청으로가능합니다.
                                .loginProcessingUrl("/login") // 로그인 POST 요청을 낚아채서 시큐리티세션을 넣어줌
                                .defaultSuccessUrl("/")//완료되면 가질경로 하지만 요청유알엘이 있을때 인증 하면 요청유알엘로가짐
                                .permitAll()
                        )
                        .logout(logOut -> logOut
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  //로그아웃 요청 url
                                .permitAll() //누구나가능
                        )
                        .oauth2Login(oauth -> oauth
                                .loginPage("/login")
                                // .loginProcessingUrl("/login/oauth2/google")
                                .userInfoEndpoint(e->e.userService(authService))
                                .redirectionEndpoint((end -> end
                                        .baseUri("/login/oauth2/*") //앱프로퍼티에 빈에 등록한 경로입니다.
                                ))
                                .defaultSuccessUrl("/")
                                
                        );
                     
                

                return http.build();
        }
 
    
}


