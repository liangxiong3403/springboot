package org.liangxiong.springboot.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liangxiong
 * @Description 自定义servlet
 * @Date 2018-10-25
 * @Time 9:59
 */
@WebServlet(name = "DiyWebServlet", urlPatterns = {"/diy/servlet", "/diy/servlet2"})
public class DiyWebServlet extends HttpServlet {

    /**
     * 响应地消息内容
     */
    private String message;

    private static final Logger logger = LoggerFactory.getLogger(DiyWebServlet.class);

    @Override
    public void init() throws ServletException {
        message = "diy servlet";
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<h1>" + message + "</h1>");
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("URI: " + req.getRequestURI());
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        logger.info("servlet container closed");
    }
}
