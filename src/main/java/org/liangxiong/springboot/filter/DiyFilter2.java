package org.liangxiong.springboot.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liangxiong
 * @Date:2018-10-28
 * @Time:20:28
 * @Description 通过java API注册filter
 */
public class DiyFilter2 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        request.getServletContext().log("diyFilter2");
        // 执行下一个filter
        filterChain.doFilter(request, response);
    }
}
