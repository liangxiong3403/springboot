//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2018.11.25 时间 04:00:33 PM CST 
//


package org.liangxiong.springboot.webservice.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Elephant complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="Elephant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "Elephant", propOrder = {
        "id",
        "name",
        "age"
})
public class Elephant {

    protected long id;
    protected String name;
    protected Integer age;

    /**
     * 获取id属性的值。
     */
    public long getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * 获取name属性的值。
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取age属性的值。
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置age属性的值。
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setAge(Integer value) {
        this.age = value;
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
