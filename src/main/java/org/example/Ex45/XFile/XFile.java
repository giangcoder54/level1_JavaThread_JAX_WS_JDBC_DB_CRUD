package org.example.Ex45.XFile;

import org.example.Ex45.Model.Student;

import java.io.*;

public class XFile {
    private static final String studentFile ="student.txt";
    public static FileInputStream readFile(String file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            return fileInputStream;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void writeFile(Student student){
        try {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(studentFile));
            objectOutputStream.writeObject(student);
            System.out.println("Write student successfully");
        } catch (IOException e) {
            System.err.println("write student unsuccessfully");
            throw new RuntimeException(e);
        }
    }
}
