package org.example.Ex23;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XFile {
    public static final String PATH="students.txt";
    public static List<Student> readFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            ObjectInputStream objInStream = new ObjectInputStream(fileInputStream);
            // ArrayList<>() : <> used to provide data type for array. While () used to provide initial capacity for array

            List<Student> students = (List<Student>) objInStream.readObject();
            return students;
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void writeFile(List<Student> students){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutputStream);
            objOutStream.writeObject(students);
            System.out.println("Write to file successfully");
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Write to file unsuccessfully");
            throw new RuntimeException(e);
        }
    }
}
