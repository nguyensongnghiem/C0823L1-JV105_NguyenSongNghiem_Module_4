package com.example.demo_security_17.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    // xác thực
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    // phân quyền
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // cấu hình có thể logout
        http.csrf(AbstractHttpConfigurer::disable);
        // các đường dẫn không phải login
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/", "/blog", "/login", "/logout", "/logoutSuccessful", "/403").permitAll());
        // cấp quyền cho user
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/blog").hasRole("USER"));

        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/admin").hasRole("ADMIN"));
        // cấp quyền cho user và admin
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/userInfo", "/blog/create").hasAnyRole("USER", "ADMIN"));
        // cấu hình form login
        http.formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/process-login") // đường dẫn trùng với url form login
                .defaultSuccessUrl("/userInfo")//
                .failureUrl("/login")
                .usernameParameter("username")//trùng với tên trong form đăng nhập
                .passwordParameter("password")// trung với tên trong form đăng nhập
        );
        // cấu hình logout
        http.logout(form -> form.logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful"));

        // cấu hình remember-me : lưu trạng thái đăng nhập khi tắt trình duyệt => mở lại không cần login
        http.rememberMe(remember -> remember.tokenRepository(persistentTokenRepository()));

        // cấu hình trả về trang 403 khi không có quyền (role) truy cập
        http.exceptionHandling(ex -> ex.accessDeniedPage("/403"));
        ;
        return http.build();

    }

    // Cấu hình vùng nhớ lưu trạng thái đăng nhập trên bộ nhớ của máy tính người dùng
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }


}