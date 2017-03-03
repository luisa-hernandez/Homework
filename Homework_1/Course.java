package Homework_1;

import java.util.Comparator;
import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Comparable, Serializable {
	// initializing variables
	public String Course_Name;
	public String Course_Id;
	public int Maximum_Students;
	public int Current_Students;
	public String Course_Instructor;
	public int Course_Section_Number;
	public String Course_Location;
	public ArrayList<Student> students;

	public boolean compareTo(Course c) {
		return c.Current_Students < this.Current_Students;
	}

	public Course(String coursename, String courseid, int maximumstudents, int currentstudents, String courseinstructor,
			int coursesectionnumber, String courselocation) {
		this.Course_Name = coursename;
		this.Course_Id = courseid;
		this.Maximum_Students = maximumstudents;
		this.Current_Students = currentstudents;
		this.Course_Instructor = courseinstructor;
		this.Course_Section_Number = coursesectionnumber;
		this.Course_Location = courselocation;

		this.students = new ArrayList<Student>();
	}

	public String getId() {
		// TODO Auto-generated method stub
		return Course_Id;
	}

	public int getSection() {
		// TODO Auto-generated method stub
		return Course_Section_Number;
	}
	
	public void printInfo() {
		System.out.println("Course Name: " + Course_Name);
		System.out.println("Course ID: " + Course_Id);
		System.out.println("Maximum Students: " + Maximum_Students);
		System.out.println("Current Students: " + students.size());
		System.out.println("Course Instructor: " + Course_Instructor);
		System.out.println("Course Section Number: " + Course_Section_Number);
		System.out.println("Course Location: " + Course_Location);
	}

	@Override
	public int compareTo(Object oCourse) {
		/**
		 * compare number of students to see which is more full
		 */
		Course course = (Course) oCourse;
		if (students.size() < course.students.size()) {
			// fewer students
			return -1;
		} else if (students.size() > course.students.size()) {
			// more students
			return 1;
		}
		// equal number of students
		return 0;
	}

	public boolean equals(Course c) {
		return (c.Course_Id.equals(Course_Id) && c.Course_Section_Number == Course_Section_Number);
	}

}