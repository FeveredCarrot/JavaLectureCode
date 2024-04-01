package org.example.week7_OOP;

public class ITECCourseManager
{
    public static void main(String[] args)
    {
        // create new ITECCourse instance with it's constructor, passing in it's data to the constructor arguments
        ITECCourse maintenanceCourse = new ITECCourse("Microcomputer Systems Maintenance", 1310, 20);

        // add some students
        maintenanceCourse.addStudent("Anna");
        maintenanceCourse.addStudent("Bill");
        maintenanceCourse.addStudent("Carl");

        // remove carl
        maintenanceCourse.removeStudent("Carl");

        // print the course info
        maintenanceCourse.writeCourseInfo();

        // create another ITECCourse
        ITECCourse datacomCourse = new ITECCourse("Data Communications", 1425, 30);

        // add students to this other course
        datacomCourse.addStudent("Dave");
        datacomCourse.addStudent("Ed");
        datacomCourse.addStudent("Calvin");

        // this is a different course from the first one so it will print different data
        datacomCourse.writeCourseInfo();

        // create a third ITECCourse object, and add students to it
        ITECCourse softwareDevelopmentProjects = new ITECCourse("Software Development Projects", 2903, 3);
        softwareDevelopmentProjects.addStudent("Gus");
        softwareDevelopmentProjects.addStudent("Harry");
        softwareDevelopmentProjects.addStudent("Jake");
        softwareDevelopmentProjects.addStudent("Goober");

        // use the getNumberOfStudents instance method to get the number of students enrolled in this course
        int totalEnrolled = softwareDevelopmentProjects.getNumberOfStudents();

        // use getter methods to get various course info and print it
        System.out.println("The " + softwareDevelopmentProjects.getName() + " class has " + totalEnrolled + " students");
        System.out.println("ITEC " + softwareDevelopmentProjects.getCode() + ": " + softwareDevelopmentProjects.getName());

        // set the max number of students on this specific ITECCourse using a setter method
        softwareDevelopmentProjects.setMaxStudents(30);
        softwareDevelopmentProjects.writeCourseInfo();
    }
}
