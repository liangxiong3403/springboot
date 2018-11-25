//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.11.25 时间 04:00:33 PM CST 
//


package org.liangxiong.springboot.webservice.entity;

import javax.xml.bind.annotation.*;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elephant" type="{http://liangxiong.org/schemas}Elephant"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author liangxiong
 * @description schema生成命令: xjc -d src/main/java -p org.liangxiong.springboot.webservice.entity -xmlschema src/main/resources/META-INF/schemas/elephant.xsd -encoding
 * utf-8
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "elephant",
        "timestamp"
})
@XmlRootElement(name = "ElephantResponse")
public class ElephantResponse {

    @XmlElement(required = true)
    protected Elephant elephant;
    protected long timestamp;

    /**
     * 获取elephant属性的值。
     *
     * @return possible object is
     * {@link Elephant }
     */
    public Elephant getElephant() {
        return elephant;
    }

    /**
     * 设置elephant属性的值。
     *
     * @param value allowed object is
     *              {@link Elephant }
     */
    public void setElephant(Elephant value) {
        this.elephant = value;
    }

    /**
     * 获取timestamp属性的值。
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * 设置timestamp属性的值。
     */
    public void setTimestamp(long value) {
        this.timestamp = value;
    }

    @Override
    public String toString() {
        return "ElephantResponse{" +
                "elephant=" + elephant +
                ", timestamp=" + timestamp +
                '}';
    }
}
