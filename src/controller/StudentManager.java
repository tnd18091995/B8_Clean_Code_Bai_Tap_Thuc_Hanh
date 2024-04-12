package controller;

import model.Student;
import storage.IReadWriteFile;
import storage.ReadWriteFile;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class StudentManager{
    private static IReadWriteFile readWriteFileStudent = new ReadWriteFile();
    private static List<Student> studentsList = readWriteFileStudent.readFile();
    public static void addNewStudent(Scanner scanner) {
        int id;
        boolean idExists;
        do{
            System.out.println("Enter ID: ");
            id = scanner.nextInt();
            idExists = false;
            for(Student student: studentsList ){
                if(student.getId() == id){
                    System.err.println("ID already exists! Please entry again!");
                    idExists = true;
                    break;
                }
            }
        }while (idExists);
        scanner.nextLine();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Choice Gender: ");
        System.out.println("1. Male \n2. Female");
        int choice = scanner.nextInt();
        String gender = null;
        switch (choice){
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            default:
                System.out.println("Invalid selection");
        }
        System.out.println("Enter Math Score");
        int mathScore = scanner.nextInt();
        System.out.println("Enter Physical Score");
        int physicalScore = scanner.nextInt();
        System.out.println("Enter Chemistry Score");
        int chemistryScore = scanner.nextInt();
        int [] scores = {mathScore,physicalScore,chemistryScore};
        Student student = new Student(id,name,gender,scores);
        studentsList.add(student);
        readWriteFileStudent.writeFile(studentsList);
    }
    public static void showStudentList(){
        if(studentsList.isEmpty()){
            System.out.println("Student list is empty!");
        }
        for ( Student student: studentsList){
            System.out.println(student);
        }
    }
    public static void findStudentById(int id) {
        for (Student student : studentsList) {
            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Not Student Found!");
    }
    public static void findStudentByName(String name) {
        boolean found = false;
        for (Student student : studentsList) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Student Found!");
        }
    }
    public static void getStudentWithHighestAverageScore() {
        Student highestScoringStudent = null;
        double highestAverageScore = 0;
        for (Student student : studentsList) {
            double averageScore = student.calculateAverageScore();
            if (averageScore > highestAverageScore) {
                highestAverageScore = averageScore;
                highestScoringStudent = student;
            }
        }
        System.out.println(highestScoringStudent);
    }
    public static void removeStudent(int id, Scanner scanner) {
        Student removeStudent = null;
        for (Student student : studentsList) {
            if (student.getId() == id) {
                removeStudent = student;
                break;
            }
        }
        if (removeStudent != null) {
            System.out.println("Are you sure you want to remove this student? (YES/NO)");
            String confirmation = scanner.next().toUpperCase();
            if (confirmation.equals("YES")) {
                studentsList.remove(removeStudent);
                readWriteFileStudent.writeFile(studentsList);
                System.out.println("Student removed successfully.");
            } else if (confirmation.equals("NO")) {
                System.out.println("Removal cancelled.");
            } else {
                System.out.println("Invalid input. Removal cancelled.");
            }
        } else {
            System.out.println("Student not found!");
        }
    }
}
