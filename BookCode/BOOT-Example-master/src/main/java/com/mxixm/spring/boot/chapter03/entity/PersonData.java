package com.mxixm.spring.boot.chapter03.entity;

import java.util.List;
import java.util.Map;

public class PersonData {
    // 简单属性
    private String name;
    // 嵌套属性
    private Nested nested;
    // 数组属性
    private String[] hobbies;
    // List属性
    private List<String> things;
    // Map属性
    private Map<String, String> properties;
    // Map中嵌套Nested属性
    private Map<String, Nested> nestedProperties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nested getNested() {
        return nested;
    }

    public void setNested(Nested nested) {
        this.nested = nested;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getThings() {
        return things;
    }

    public void setThings(List<String> things) {
        this.things = things;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, Nested> getNestedProperties() {
        return nestedProperties;
    }

    public void setNestedProperties(Map<String, Nested> nestedProperties) {
        this.nestedProperties = nestedProperties;
    }
    // 嵌套类型
    public static class Nested {
        // 嵌套的name
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}