package org.liangxiong.springboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liangxiong
 * @Date:2018-10-28
 * @Time:17:25
 * @Description 自定义filter;servletNames拦截指定servlet
 */
@WebFilter(filterName = "diyFilter", urlPatterns = {"/diy/servlet", "/diy/servlet2"})
public class DiyFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(DiyFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        logger.info("servlet context: " + servletContext);
        // 执行下一个filter
        filterChain.doFilter(request, response);
    }
}
