package pro.jianbing.aboutme.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import pro.jianbing.aboutme.entity.User;
import pro.jianbing.aboutme.repository.UserRepositoty;
import pro.jianbing.aboutme.security.SecurityUser;
import pro.jianbing.aboutme.util.NetworkUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author 李建兵
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserRepositoty userRepositoty;
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
    @Override
    protected void configure(HttpSecurity http) throws Exception { //配置策略
        http.csrf().disable();
        http.authorizeRequests().
                antMatchers("/static/**").permitAll().anyRequest().authenticated().
                and().formLogin().loginPage("/login").permitAll().successHandler(loginSuccessHandler()).
                and().logout().permitAll().invalidateHttpSession(true).
                deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler()).
                and().sessionManagement().maximumSessions(10).expiredUrl("/login");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
        return (httpServletRequest, httpServletResponse, authentication) -> {
            try {
                SecurityUser user = (SecurityUser) authentication.getPrincipal();
                logger.info("USER : " + user.getUsername() + " LOGOUT SUCCESS !  ");
            } catch (Exception e) {
                logger.info("LOGOUT EXCEPTION , e : " + e.getMessage());
            }
            httpServletResponse.sendRedirect("/login");
        };
    }

    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
        return new SavedRequestAwareAuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                User userDetails = (User) authentication.getPrincipal();
                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
                super.onAuthenticationSuccess(request, response, authentication);
                LocalDateTime now = LocalDateTime.now();
                String ipAddress = NetworkUtil.getIpAddress(request);
                userRepositoty.updateLoginInfo(ipAddress,now,userDetails.getId());
            }
        };
    }
    @Override
    @Bean
    public UserDetailsService userDetailsService() {    //用户登录实现
        return s -> {
            User user = userRepositoty.findByUsername(s);
            if (user == null) {
                throw new UsernameNotFoundException("Username " + s + " not found");
            }
            return new SecurityUser(user);
        };
    }
}
