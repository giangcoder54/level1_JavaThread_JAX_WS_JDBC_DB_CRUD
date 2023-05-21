package org.example.Ex45.Publisher;



import org.example.Ex45.Service.StudentServiceImpl;

import javax.xml.ws.Endpoint;


public class StudentPublisher {
    private static final String URL_STUDENT = "http://localhost:8089/student";

    public static void main(String[] args) {

        Endpoint.publish(URL_STUDENT, new StudentServiceImpl());

    }
}
