package org.liangxiong.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author liangxiong
 * @Date:2018-12-01
 * @Time:9:29
 * @Description Spring Security配置类
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 跨站请求伪造CSRF
            .csrf()
            // token仓库
            .csrfTokenRepository(new CookieCsrfTokenRepository())
            // 匹配请求
            .requireCsrfProtectionMatcher((HttpServletRequest request) ->
                // 限制请求路径和请求方法
                request.getRequestURI().startsWith("/security") && request.getMethod().endsWith(HttpMethod.POST.name())
            );

        http
            // 内容安全策略CSP
            .headers()
            // 设置授权网站(允许Spring内容);script-src表示限制脚本,也可以限制其他如img-src,media-src等
            .contentSecurityPolicy("script-src https://start.spring.io");

        // X-Frame-Options设置,方案一:相同域名允许访问
        /// http.headers().frameOptions().sameOrigin();
        // X-Frame-Options设置,方案二:允许IFrame中指定域名访问;需要配合客户端request相关参数设置:http://example.com?x-frames-allow-from=liangxiong.cn
        http
            .headers()
            .addHeaderWriter(new XFrameOptionsHeaderWriter(new WhiteListedAllowFromStrategy(Arrays.asList("liangxiong.com", "liangxiong.cn"))));

        // XSS设置
        http
            .headers()
            .xssProtection()
            .block(false);

        // 配置授权行为
        http
            .authorizeRequests().anyRequest().fullyAuthenticated()
            // 表单登录
            .and().formLogin().loginPage("/security/login").loginProcessingUrl("/security/process").failureForwardUrl("/security/error").permitAll()
            // 注销页面
            .and().logout().permitAll();
    }

    /**
     * 用户认证设置
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            // 内存认证
            .inMemoryAuthentication()
            // 用户名
            .withUser("liangxiong")
            // 密码
            .password("123456")
            // 角色
            .roles("ADMIN","USER")
            .and()
            .withUser("libai")
            .password("111111")
            .roles("USER");
    }
}
