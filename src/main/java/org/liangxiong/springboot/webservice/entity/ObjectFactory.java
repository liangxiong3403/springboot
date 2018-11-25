//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.11.25 时间 04:00:33 PM CST 
//


package org.liangxiong.springboot.webservice.entity;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.liangxiong.springboot.webservice.entity package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 * @author liangxiong
 * @description schema生成命令: xjc -d src/main/java -p org.liangxiong.springboot.webservice.entity -xmlschema src/main/resources/META-INF/schemas/elephant.xsd -encoding
 * utf-8
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.liangxiong.springboot.webservice.entity
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ElephantIdRequest }
     */
    public ElephantIdRequest createElephantIdRequest() {
        return new ElephantIdRequest();
    }

    /**
     * Create an instance of {@link ElephantResponse }
     */
    public ElephantResponse createElephantResponse() {
        return new ElephantResponse();
    }

    /**
     * Create an instance of {@link Elephant }
     */
    public Elephant createElephant() {
        return new Elephant();
    }

}
