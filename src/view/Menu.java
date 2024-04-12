package view;

import controller.StudentManager;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-----StudentManager-----");
            System.out.println("1. Add Student");
            System.out.println("2. Show ListStudents");
            System.out.println("3. Find Student By Id");
            System.out.println("4. Find Student By Name");
            System.out.println("5. Show Best Student");
            System.out.println("6. Remove Student");
            System.out.println("0. Exit ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    StudentManager.addNewStudent(scanner);
                    break;
                case 2:
                    StudentManager.showStudentList();
                    break;
                case 3:
                    System.out.println("Enter Student ID");
                    int id = scanner.nextInt();
                    StudentManager.findStudentById(id);
                    break;
                case 4:
                    System.out.println("Enter Student Name");
                    String name = scanner.nextLine();
                    StudentManager.findStudentByName(name);
                    break;
                case 5:
                    StudentManager.getStudentWithHighestAverageScore();
                    break;
                case 6:
                    System.out.println("Enter ID Student");
                    int idRemove = scanner.nextInt();
                    StudentManager.removeStudent(idRemove,scanner);
                    break;
                case 0:
                    System.out.println("Exit Program");
                    break;
                default:
                    System.out.println("Try Enter Again!");
                    break;
            }
        } while (choice != 0);
    }
}
