package org.example.Ex23;



import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);


    public static String menuB2(){
        String menu = "---------------Menu--------------";
        return menu +String.format( "\n%s","1.Add New Student")+
                String.format("\n%s","2.Show All Students")+
                String.format("\n%s","3.Exit")+
                "\n-------------------------------------";
    }
    public static void options(){
        boolean checked = true;


        while(checked){
            System.out.println(menuB2());

            System.out.print("Your Option:");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 : {
                    System.out.print("Please Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Please Enter Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Please Enter Code: ");
                    int code = Integer.parseInt(sc.nextLine());

                    System.out.print("Please Enter ClassName: ");
                    String className = sc.nextLine();

                    System.out.print("Please Enter Address: ");
                    String address = sc.nextLine();



                    Student newStudent = new Student(name, age, code, className, address);
                    ThreadOne threadOne = new ThreadOne(newStudent);
                    threadOne.start();
                    break;
                }
                case 2 : {
                    ThreadTwo thread = new ThreadTwo();
                    Thread threadTwo = new Thread(thread);
                    threadTwo.start();

                    System.out.println("Nhấn 0 để dừng chương trình...");

                    while (true) {
                        int userInput = Integer.parseInt(sc.nextLine());
                        if (userInput == 0) {

                            thread.stop();
                        }
                        break;
                    }
                    break;

                }
                case 3 : {
                    System.out.println("Goodbye!!");
                    checked = false;
                    break;
                }
                default : System.out.println("Invalid option!");
            }

        }

    }
}
