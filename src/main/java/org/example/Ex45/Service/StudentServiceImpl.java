package org.example.Ex45.Service;

import org.example.Ex45.Model.Student;
import org.example.Ex45.Thread.ThreadOne;
import org.example.Ex45.XFile.XFile;

import javax.jws.WebService;
import java.io.IOException;
import java.util.Properties;

@WebService(endpointInterface = "org.example.Ex45.Service.StudentService")
public class StudentServiceImpl  implements StudentService{
    public static final String APP_CONF = "app.properties";
    @Override
    public boolean checkLogin(String username, String password) {
        Properties properties = new Properties();
        try {
            properties.load(XFile.readFile(APP_CONF));
            if(properties.getProperty("username").equals(username) && properties.getProperty("password").equals(password)){
                return true;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void saveStudent(String username,String password,Student student) {
        if(checkLogin(username,password)){
            Thread thread = new Thread( new ThreadOne(student));
            thread.start();
            System.out.println("Login successfully");
        }else {
            System.out.println("Login unsuccessfully");
        }


    }
}
