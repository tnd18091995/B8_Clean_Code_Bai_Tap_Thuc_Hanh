package model;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {
    private int id;
    private String name;
    private String gender;
    private int [] scores;

    public Student() {
    }

    public Student(int id, String name, String gender, int[] scores) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.scores = scores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
    public double calculateAverageScore() {
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }
        return (double) totalScore / scores.length;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", scores=" + Arrays.toString(scores) +
                '}';
    }
}
