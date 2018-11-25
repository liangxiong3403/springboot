package org.liangxiong.springboot.webservice.endpoint;

import org.liangxiong.springboot.webservice.entity.Elephant;
import org.liangxiong.springboot.webservice.entity.ElephantIdRequest;
import org.liangxiong.springboot.webservice.entity.ElephantResponse;
import org.liangxiong.springboot.webservice.repository.ElephantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author liangxiong
 * @Date:2018-11-25
 * @Time:15:52
 * @Description 服务端点
 */
@Endpoint
public class ElephantServerEndpoint {

    @Autowired
    private ElephantRepository elephantRepository;

    private static final Logger logger = LoggerFactory.getLogger(ElephantServerEndpoint.class);

    /**
     * 根据参数查询数据
     *
     * @param request
     * @return 查询结果
     * @see ResponsePayload
     * @see ResponseBody
     */
    @PayloadRoot(namespace = "http://liangxiong.org/schemas", localPart = "ElephantIdRequest")
    @ResponsePayload
    public ElephantResponse selectElephantById(@RequestPayload ElephantIdRequest request) {
        long id = request.getElephantId();
        Instant inputTime = Instant.ofEpochMilli(request.getTimestamp());
        ZonedDateTime zonedDateTime = inputTime.atZone(ZoneId.of("Asia/Shanghai"));
        logger.info("请求进来,用户ID: " + id + ",请求进入时间: " + zonedDateTime);
        Elephant elephant = elephantRepository.selectElephantById(id);
        ElephantResponse response = new ElephantResponse();
        response.setElephant(elephant);
        response.setTimestamp(Instant.now().toEpochMilli());
        return response;
    }
}
