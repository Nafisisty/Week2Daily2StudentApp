package com.example.week2daily2_studentapp;

public class Student {

    private String studentName;
    private String studentMajor;
    private String studentMinor;
    private String studentGPA;
    private String studentDOB;
    private String studentHomeCity;
    private String studentHomeState;
    private String studentSSN;

    public Student() {

    }

    public Student(String studentName, String studentMajor, String studentMinor, String studentGPA, String studentDOB, String studentHomeCity, String studentHomeState, String studentSSN) {
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        this.studentMinor = studentMinor;
        this.studentGPA = studentGPA;
        this.studentDOB = studentDOB;
        this.studentHomeCity = studentHomeCity;
        this.studentHomeState = studentHomeState;
        this.studentSSN = studentSSN;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentMinor() {
        return studentMinor;
    }

    public void setStudentMinor(String studentMinor) {
        this.studentMinor = studentMinor;
    }

    public String getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(String studentGPA) {
        this.studentGPA = studentGPA;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

    public String getStudentHomeCity() {
        return studentHomeCity;
    }

    public void setStudentHomeCity(String studentHomeCity) {
        this.studentHomeCity = studentHomeCity;
    }

    public String getStudentHomeState() {
        return studentHomeState;
    }

    public void setStudentHomeState(String studentHomeState) {
        this.studentHomeState = studentHomeState;
    }

    public String getStudentSSN() {
        return studentSSN;
    }

    public void setStudentSSN(String studentSSN) {
        this.studentSSN = studentSSN;
    }
}
