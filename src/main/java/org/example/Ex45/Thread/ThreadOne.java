package org.example.Ex45.Thread;

import org.example.Ex45.Model.Student;
import org.example.Ex45.XFile.XFile;

public class ThreadOne implements Runnable {

    private Student student;

    public ThreadOne(Student student){
        this.student = student;
    }

    @Override
    public void run() {
        XFile.writeFile(student);
    }
}
