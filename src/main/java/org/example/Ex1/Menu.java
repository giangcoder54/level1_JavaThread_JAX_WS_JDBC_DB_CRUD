package org.example.Ex1;


import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private static StudentManagement studentManagment = new StudentManagement();

    public static String menuB1() {
        String horizontalLines = "----------StudentManagement----------";
        return horizontalLines + "\n1.Add A New Student" +
                "\n2.Show Students" +
                "\n3.Search Students By Mark" +
                "\n4.Search Students By Rank" +
                "\n5.Update Students By Id" +
                "\n6.Sort Student By Mark" +
                "\n7.5 Highest Mark Students" +
                "\n8.Average Mark" +
                "\n9.Show List Students Having Mark Higher Average Mark" +
                "\n10.Show List Students According Rank" +
                "\n0.Exist\n" +
                horizontalLines;
    }

    public static void options() {
        boolean checked = true;

        while (checked) {
            System.out.println(menuB1());
            System.out.print("Your option: ");
            int n = Integer.parseInt(sc.nextLine());
            switch (n) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Mark: ");
                    Double mark = Double.parseDouble(sc.nextLine());

                    System.out.print("Enter Student Email: ");
                    String email = sc.nextLine();

                    studentManagment.addStudent(name, mark, email);
                    break;
                case 2:
                    studentManagment.showStudent();
                    break;
                case 3:
                    System.out.print("Search Students Having Mark From  ");
                    double markFrom = Double.parseDouble(sc.nextLine());

                    System.out.print("To ");
                    double markTo = Double.parseDouble(sc.nextLine());

                    studentManagment.searchStudentsByMarkRange(markFrom, markTo);
                    break;
                case 4:
                    Ranked tempRank = null;
                    System.out.println("Rank Student: ");
                    System.out.println("1.POOR\n2.AVERAGE\n3.GOOD\n4.VERY GOOD\n5.EXCELLENT");
                    System.out.print("Enter The Rank: ");
                    int option = Integer.parseInt(sc.nextLine());

                    switch (option) {
                        case 1:
                            tempRank = Ranked.POOR;
                            break;
                        case 2:
                            tempRank = Ranked.AVERAGE;
                            break;
                        case 3:
                            tempRank = Ranked.GOOD;
                            break;
                        case 4:
                            tempRank = Ranked.VERY_GOOD;
                            break;
                        case 5:
                            tempRank = Ranked.EXCELLENT;
                            break;
                        default:
                            System.out.println("Invalid Option. Try again !!");

                    }
                    if (tempRank != null) {
                        studentManagment.searchStudentsByRank(tempRank);
                    }

                case 5:
                    System.out.println("Enter The Student's Id Needed To Update: ");
                    Integer tempId = Integer.parseInt(sc.nextLine());

                    System.out.print(" Enter New Name's Student: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Mark's Student: ");
                    Double newMark = Double.parseDouble(sc.nextLine());

                    System.out.print("Enter New Email's Student: ");
                    String newEmail = sc.nextLine();

                    studentManagment.updateStudentById(tempId, newName, newMark, newEmail);

                    break;
                case 6:
                    studentManagment.sortStudentsByMark();
                        break;
                case 7:
                    studentManagment.fiveHighestMarkStudent();
                        break;
                case 8:
                    System.out.println("Average Mark of class: " + studentManagment.averageMark());
                        break;
                case 9:
                    studentManagment.showStudentsHigherAverageMark();
                        break;
                case 10:
                    studentManagment.showAllStudentsByRank();
                    break;
                case 0:
                    System.out.println("Good Bye!!.See you again !!");
                    checked = false;
                    break;
                default:
                    System.out.println("Invalid Option!!");
            }

        }
        sc.close();
    }



}


