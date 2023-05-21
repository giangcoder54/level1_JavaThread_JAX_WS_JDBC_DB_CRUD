package org.example.Ex1;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentManagement {
    List<Student> students;
    private static final int MIN_MARK = 0;
    private static final int MAX_MARK = 10;

    public StudentManagement(){
        students = new ArrayList<>();
    }

    public void addStudent(String name,Double mark, String email){

        if(validateEmail(email) && validateMark(mark) ){
            students.add(new Student(name,mark,email));
            System.out.println("Adding Student Successfully !!");
        }else {
            System.out.println("Adding Student Fail. Try again !!.");
        }
    }

    public void showStudent(){
        if(students.size()==0 ){
            System.out.println("empty!!");
        }else {
            System.out.format("%-5s %-45s %-10s %-45s %-10s\n","Id","Name","Mark","Email","Rank");
            for(Student student : students){
                printStudent(student);
            }
        }
    }

    public static Ranked rank(Double  mark){
        if(0< mark && mark<5){
            return Ranked.POOR;
        }
        else if (5<= mark && mark<6.5){
            return Ranked.AVERAGE;
        }
        else if(6.5<= mark && mark< 7.5){
            return Ranked.GOOD;
        }
        else if(7.5<= mark && mark< 9){
            return Ranked.VERY_GOOD;
        }
        else if(9<= mark && mark  <=10){
            return Ranked.EXCELLENT;
        }
        return null;
    }


    public void searchStudentsByMarkRange(double from, double to){
        int count = 0;
        if(from< MIN_MARK || to> MAX_MARK || from> to){
            System.out.println("Mark is limited from 0 to 10.Try Again !!");
        }else {
            for(Student student : students){
                if( student.getMark()>=from && student.getMark()<= to){
                    printStudent(student);
                    count++;
                }
            }
        }
        if(count ==0){
            System.out.println("Class don't have any students having mark from " + from +" to "+ to);
        }
    }

    public void searchStudentsByRank(Ranked rank){
        int count = 0;
        for(Student student : students){
            Ranked tempRanked = rank(student.getMark());
            if(rank.equals(tempRanked)){
                printStudent(student);
                count++;
            }
        }
        if(count ==0){
            System.out.println("Does Not Exit Student In Rank Here.");
        }
    }

    public void updateStudentById(Integer id,String newName, Double newMark,String newEmail){
        Student setStudent = getStudentById(id);

        if(setStudent == null){
            System.out.println("Invalid Id !!");
        }
        if(!(validateEmail(newEmail )&& validateMark(newMark))){
            System.out.println("Invalid Email or Mark !!");
        }
        else {

            setStudent.setName(newName);
            setStudent.setMark(newMark);
            setStudent.setEmail(newEmail);
            System.out.println("Update Successfully !!");
        }
    }

    public void sortStudentsByMark(){

        Collections.sort(students, Comparator.comparing(Student::getMark));
    }

    public void fiveHighestMarkStudent(){
        sortStudentsByMark();
        int size = students.size();
        if(size == 0){
            System.out.println("Class do not have any students");
        } else if(size < 5){
            System.out.println("Class just has "+ size +" students");
            for (Student student : students){
                printStudent(student);
            }
        }else
            System.out.println("5 students having mark highest : ");
        for(int i = size-1 ;i>size-5-1;i--){
            printStudent(students.get(i));
        }
    }

    public  double averageMark(){
        double sum = 0;
        int size = students.size();
        if(size == 0){
            return 0;
        }
        for(Student student : students){
            sum +=student.getMark();
        }
        return sum/size;
    }

    public void showStudentsHigherAverageMark(){

        double averageMark = averageMark();
        for(Student student: students){
            if(student.getMark()>averageMark){
                printStudent(student);
            }
        }
    }

    public void showAllStudentsByRank(){
        sortStudentsByMark();

        for (Student student : students){
            printStudent(student);
        }
    }
    public Student getStudentById(Integer id){
        for(Student student: students){
            if(student.getId().equals(id) ){
                return students.get(id);
            }
        }
        return  null;
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static boolean validateMark(Double mark){
        return (MIN_MARK <= mark && mark <= MAX_MARK);
    }
    public static void printStudent(Student student){
        System.out.format("%-5s %-45s %-10.2f %-45s %-10s\n",student.getId(),student.getName(),student.getMark(),student.getEmail(),rank(student.getMark()));
    }

}




