package com.mxixm.spring.boot.chapter03.entity;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlType;

// 测试的数据定义
@XmlType // 标记该类型可通过XML序列化与反序列化
public class MyPostData {

    private String name;

    // 校验最小值为0，即不能为负数
    @Min(0)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyPostData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}