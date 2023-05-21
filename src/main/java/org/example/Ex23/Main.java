package org.example.Ex23;

public class Main {
    public static void main(String[] args) {
        Menu.menuB2();
        Menu.options();
    }
}
//import java.util.Scanner;
//
//public class Main {
//    private static volatile boolean running = true;
//
//    public static void main(String[] args) {
//        Thread thread = new Thread(new StudentNamePrinter());
//        thread.start();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhấn 0 để dừng chương trình...");
//        while (running) {
//            int userInput = scanner.nextInt();
//            if (userInput == 0) {
//                running = false; // Dừng chương trình khi người dùng nhấn 0
//            }
//        }
//    }
//
//    static class StudentNamePrinter implements Runnable {
//        @Override
//        public void run() {
//            while (running) {
//                printStudentName();
//                try {
//                    Thread.sleep(5000); // Ngừng thực hiện trong 5 giây
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        public void printStudentName() {
//            System.out.println("Tên sinh viên");
//        }
//    }
//}

