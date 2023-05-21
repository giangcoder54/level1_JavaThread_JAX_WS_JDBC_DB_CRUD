package org.example.Ex1;

public class Student {

    private Integer id;
    private static int count;

    private String name;
    private double mark;
    private String email;

    public Student(String name, double mark, String email) {
        this.name = name;
        this.mark = mark;
        this.email = email;
        id = count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
