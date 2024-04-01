package org.example.week7_OOP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;

public class ITECCourse
{
    // an ITEC Course object has a name, code, max number of students, and a list of enrolled students
    private String name;
    private int code;
    private List<String> students;
    private int maxStudents;

    // public getter and setter methods for the private fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        // only set the max students if it is a positive number
        if (maxStudents < 0)
        {
            return;
        }
        this.maxStudents = maxStudents;
    }

    // Constructor
    ITECCourse(String name, int code, int maxStudents)
    {
        this.name = name;
        this.code = code;
        this.maxStudents = maxStudents;
        // init students to a new empty list
        students = new ArrayList<>();
    }

    public void addStudent(String studentName)
    {
        // add student to student list only if there is room
        if (students.size() >= maxStudents)
        {
            System.out.println("Course is full, can't add " + studentName);
            return; // do nothing if the course is full
        }

        students.add(studentName);
    }

    // prints all the course info to console
    public void writeCourseInfo()
    {
        System.out.println("Course name: " + name);
        System.out.println("Course code: " + code);

        System.out.println("Students enrolled:");
        for (String student : students)
        {
            System.out.println(student);
        }

        System.out.println("There are " + getNumberOfStudents() + " students enrolled.");
        System.out.println("The max number of students that can enroll in this course is " + maxStudents);
    }

    public int getNumberOfStudents()
    {
        return students.size();
    }

    public void removeStudent(String studentName)
    {
        // list remove function returns a boolean true if successful,
        // so can just put the remove function directly in the conditional
        if (students.remove(studentName))
        {
            System.out.println(studentName + " was un-enrolled from " + name);
        } else
        {
            // if removing failed, the student was not found in the student list
            System.out.println(studentName + " was not found in " + name);
        }
    }
}
