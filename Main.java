// package JavaTakeHome;

import java.util.ArrayList;
import java.util.Scanner;
import JavaTakeHome.Courses;
import JavaTakeHome.Students;
import JavaTakeHome.GraduateStudents;
import JavaTakeHome.RegularStudents;
import JavaTakeHome.SpecialStudents;


/**
 * Created by Simay on 13.4.2019.
 */

public class Main {

    public static void main(String ...args){
        Students student;
        ArrayList<Courses> coursesArrayList=new ArrayList<>();
        Scanner scanner= new Scanner(System.in);

        int ans;

        do {
        System.out.println("\033[H\033[2J");
        System.out.println("=========================================");
        System.out.println(" Course Registration System for Students ");
        System.out.println("=========================================");
        System.out.println("[1] Create new course");
        System.out.println("[2] Register user to the course");
        System.out.println("[3] Display all the registered students' information to a course");
        System.out.println("[4] Quit");
        System.out.print("\nOPT: ");
        ans = Integer.parseInt(scanner.nextLine());


    if (ans == 1) {
        ArrayList<Courses> returningList = addCourse(coursesArrayList);
        if (returningList != null) {
            coursesArrayList = returningList;
        }

    } else if (ans == 2) {
        System.out.println("\033[H\033[2J");
        System.out.print("Enter course code (Numeric): ");
        int cCode = Integer.parseInt(scanner.nextLine());
        String name, sname;
        int id; float cgpa;
        printCourses(coursesArrayList);
        Courses desiredCourse = findCourse(cCode, coursesArrayList);
        if (desiredCourse == null) {
            System.out.println("There is no such a course...\nPress enter to continue");
            scanner.nextLine();
        }
        else {
                System.out.println("\033[H\033[2J");
                System.out.println("Enter following details of the student : ");
                System.out.print("Name : ");
                name = scanner.nextLine();
                System.out.print("Surname : ");
                sname = scanner.nextLine();
                System.out.print("ID (Numeric): ");
                id = Integer.parseInt(scanner.nextLine());
                System.out.print("CGPA (Real/Float): ");
                cgpa = scanner.nextFloat();
                System.out.println("Press enter to continue....");
                scanner.nextLine();

                if (cCode/100==5){
                   student = new GraduateStudents(name, sname, id, cgpa);
                    addStudentToCourse(student, desiredCourse);

                }
                else if (cCode/100==7){
                    student = new SpecialStudents(name, sname, id, cgpa);
                    addStudentToCourse(student, desiredCourse);
                }
                else if (cCode/100 <=4 && cCode/100 >=1){
                    student = new RegularStudents(name, sname, id, cgpa);
                    addStudentToCourse(student, desiredCourse);
                }
            System.out.println(desiredCourse.getCourseName());
        }

    } else if (ans==3){
        System.out.println("\033[H\033[2J");
        System.out.print("Enter Course code to list students : ");
        int a = Integer.parseInt(scanner.nextLine());

        Courses desiredCourse = findCourse(a, coursesArrayList);
        System.out.println(desiredCourse.studentsArrayList.size());
        for (Students s:desiredCourse.studentsArrayList ) {
            //System.out.println("hi");
            s.display();
            System.out.println("Press enter to continue....");
            scanner.nextLine();

        }

    }


}while (ans!=4);
        System.out.println("Exit..");
    }

    public static ArrayList<Courses> addCourse(ArrayList<Courses> coursesArrayList) {

        Scanner scanner = new Scanner(System.in);

        if (coursesArrayList.size() < 10) {
            System.out.println("\033[H\033[2J");
            System.out.println("Enter following details of the Course : ");
            System.out.print("Course code (Numeric): ");
            int courseCode = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Course name: ");
            String courseName = scanner.nextLine();
            
            System.out.print("Course semester (Numeric): ");
            int courseSemester = Integer.parseInt(scanner.nextLine());

            System.out.println("Course code: " + courseCode);
            System.out.println("Course name: " + courseName.toString());
            System.out.println("Course semester: "+ courseSemester);

            coursesArrayList.add(new Courses(courseName,courseCode,courseSemester));
            System.out.println(courseName + " is added.");

        }
        else System.out.println("Course capacity is full!");

        return coursesArrayList;
    }

    public static Courses findCourse(int code, ArrayList<Courses> coursesArrayList){

        for (Courses courses:coursesArrayList){
            if (courses.getCourseCode()== code)
                return courses;

        }
            return null;

    }
    public static void  addStudentToCourse(Students students,Courses courses){

        courses.addStudent(students);

    }
    public static void printCourses(ArrayList<Courses> coursesArrayList){
        for (Courses courses:coursesArrayList){
            courses.printCourseInfo();
        }

    }
}
