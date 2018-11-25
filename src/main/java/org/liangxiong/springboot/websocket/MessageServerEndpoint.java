package org.liangxiong.springboot.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liangxiong
 * @Date:2018-11-24
 * @Time:11:31
 * @Description WebSocket服务端
 */
@ServerEndpoint("/webSocket/server/{username}")
public class MessageServerEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(MessageServerEndpoint.class);

    /**
     * 由于MessageServerEndpoint是单例(Spring管理),为了保证sessionMap中所有会话都收到消息,所以使用static修饰
     */
    private static Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * 打开连接时
     *
     * @param username 用户名
     * @PathParam 等同于SpringMVC中的@PathVariable
     */
    @OnOpen
    public void onOpenConnection(@PathParam("username") String username, Session session) {
        logger.info("open connection");
        String sessionId = session.getId();
        sessionMap.put(sessionId, session);
        sendMessageForEachSession("会话连接打开,欢迎用户[" + username + "]进入");
    }

    /**
     * 接受客户端消息
     *
     * @param message
     */
    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        logger.info("message: {}", message);
        sendMessageForEachSession("用户[" + username + "]: " + message);
    }

    /**
     * 客户端关闭WebSocket连接
     */
    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        logger.info("close WebSocket connection");
        String sessionId = session.getId();
        sessionMap.remove(sessionId);
        sendMessageForEachSession("用户[" + username + "]已经离开");
    }

    /**
     * 当WebSocket连接出现异常
     */
    @OnError
    public void onError(Throwable e) {
        logger.error("WebSocket occur exception: {}", e.getMessage());
    }

    /**
     * 对每一个session响应消息
     *
     * @param message
     */
    private void sendMessageForEachSession(String message) {
        sessionMap.forEach((sessionId, session) -> sendMessage(session, message));
    }

    /**
     * 封装发送消息地方法
     *
     * @param session 会话
     * @param message 消息
     */
    private void sendMessage(Session session, String message) {
        if (session.isOpen()) {
            RemoteEndpoint.Basic basic = session.getBasicRemote();
            try {
                basic.sendText(message);
            } catch (IOException e) {
                logger.error("sending message error");
            }
        }
    }
}
