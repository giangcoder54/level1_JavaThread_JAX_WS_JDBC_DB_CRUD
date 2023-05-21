package org.example.Ex45.Model;

import java.io.Serializable;

public class Student  implements Serializable {

    private String name;
    private int age;
    private String className;
    private String address;

    public Student(String name, int age, String className, String address) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
