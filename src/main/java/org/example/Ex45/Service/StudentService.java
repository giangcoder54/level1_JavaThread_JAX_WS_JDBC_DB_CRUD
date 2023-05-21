package org.example.Ex45.Service;


import org.example.Ex45.Model.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService
public interface StudentService {

        @WebMethod
        boolean checkLogin(String username, String password);

        @WebMethod
        void saveStudent(String username, String password, Student student);
}
