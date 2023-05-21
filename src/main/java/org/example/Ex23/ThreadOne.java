package org.example.Ex23;

import java.util.ArrayList;
import java.util.List;

public class ThreadOne  extends Thread{
    private List<Student> students;
    private Student student;
    public ThreadOne(Student student){
        this.student = student;
    }

    @Override
    public void run() {
        students = new ArrayList<>();
        students.add(student);
        XFile.writeFile(students);
    }
}
