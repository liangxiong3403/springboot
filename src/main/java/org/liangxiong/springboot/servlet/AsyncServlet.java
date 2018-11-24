package org.liangxiong.springboot.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author liangxiong
 * @Date:2018-11-24
 * @Time:19:40
 * @Description asyncSupported, The optional asyncsupported element, when specified, indicates that the Servlet can support
 * asynchronous request processing.
 */
@WebServlet(asyncSupported = true, name = "asyncServlet", urlPatterns = "/asyncServlet")
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 启动异步上下文(不调用则报错:java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false))
        AsyncContext asyncContext = request.startAsync();
        // 设置响应文本内容
        response.setContentType("text/html;charset=utf-8");
        // 获取应用上下文
        final ServletContext servletContext = request.getServletContext();
        // 获取流
        Writer writer = response.getWriter();
        writer.write(threadInfo(request));
        // 添加监听器,监听异步事件
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
                Writer writer = response.getWriter();
                writer.write("onComplete: " + threadInfo((HttpServletRequest) event.getSuppliedRequest()));
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                servletContext.log("onTimeout: " + threadInfo((HttpServletRequest) event.getSuppliedRequest()));
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                servletContext.log("onError: " + threadInfo((HttpServletRequest) event.getSuppliedRequest()));
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                servletContext.log("onStartAsync: " + threadInfo((HttpServletRequest) event.getSuppliedRequest()));
            }
        });
        // 启动异步上下文
        asyncContext.start(() -> {
            HttpServletResponse httpServletResponse = (HttpServletResponse) asyncContext.getResponse();
            try (Writer w = httpServletResponse.getWriter()) {
                w.write(threadInfo(request));
            } catch (IOException e) {
                servletContext.log("async start error");
            }
        });
    }

    private String threadInfo(HttpServletRequest request) {
        return "Current thread [" + Thread.currentThread().getName() + "] on request URI[" + request.getRequestURI() + "[ was executed! <br/>";
    }
}
