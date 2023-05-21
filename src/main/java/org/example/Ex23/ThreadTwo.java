package org.example.Ex23;

import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ThreadTwo implements Runnable{
    private volatile boolean flag = true ;
    public ThreadTwo(){

    }
    @Override
    public void run() {
        List<Student> students = XFile.readFile();
        System.out.println("List Students");
        Scanner sc = new Scanner(System.in);

        while(flag) {
            for (Student student : students) {
                System.out.println(student.getName() + " " + student.getAge());
            }
            try {
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



        }
    }
    public void stop(){
        flag = false;
    }
}
