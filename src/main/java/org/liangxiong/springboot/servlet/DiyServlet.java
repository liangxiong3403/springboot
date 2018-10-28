package org.liangxiong.springboot.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
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
@WebServlet(name = "diyServlet", urlPatterns = {"/diy/servlet", "/diy/servlet2"}, initParams = {@WebInitParam(name = "address", value = "南充")})
public class DiyServlet extends HttpServlet {

    /**
     * 响应地消息内容
     */
    private String message;

    /**
     * servlet初始化参数
     */
    private String address;

    private static final Logger logger = LoggerFactory.getLogger(DiyServlet.class);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("servlet init");
        message = "diy servlet";
        address = servletConfig.getInitParameter("address");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><h1>" + message + "</h1></html>");
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 初始化参数
        logger.info("servlet init parameter address: " + address);
        // 请求uri
        logger.info("URI: " + req.getRequestURI());
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        logger.info("servlet container closed");
    }
}
