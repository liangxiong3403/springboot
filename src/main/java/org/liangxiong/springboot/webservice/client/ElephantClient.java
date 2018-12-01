package org.liangxiong.springboot.webservice.client;

import org.liangxiong.springboot.webservice.entity.Elephant;
import org.liangxiong.springboot.webservice.entity.ElephantIdRequest;
import org.liangxiong.springboot.webservice.entity.ElephantResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.time.Instant;

/**
 * @author liangxiong
 * @Date:2018-11-25
 * @Time:18:59
 * @Description WebService客户端, 生产中与服务端不在同一机器
 */
public class ElephantClient {

    public static void main(String[] args) {
        // Marshaller将对象序列化为XML;Unmarshaller将XML反序列化为对象
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(ElephantIdRequest.class, ElephantResponse.class, Elephant.class);
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller, jaxb2Marshaller);
        // 构造SOAP请求
        ElephantIdRequest request = new ElephantIdRequest();
        request.setElephantId(3L);
        request.setTimestamp(Instant.now().toEpochMilli());
        // 发送请求
        ElephantResponse response = (ElephantResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:9999/services/web-service/elephant", request);
        System.out.println("response: " + response);
    }
}
