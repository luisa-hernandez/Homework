package Homework_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable{

	protected String username;
	protected String password;
	protected ArrayList<Course> courses;

	public User() {

	}

	public User(String username, String password, ArrayList<Course> courses) {
		this.username = username;
		this.password = password;
		this.courses = courses;
	}

	public boolean login(String username, String password) {

		if (this.username.compareTo(username) == 0 && this.password.compareTo(password) == 0) {
			return true;
		}
		return false;
	}

	public void viewCourses() {
		/**
		 * view all courses
		 */
		for (int i = 0; i < courses.size(); i++) {
			System.out.println("The course name is: " + courses.get(i).Course_Name);
			System.out.println("The course ID is: " + courses.get(i).Course_Id);
			System.out.println("The number of students in the course is:  " + courses.get(i).Current_Students);
			System.out.println("The maximum number of students that can be enrolled in this class is: "
					+ courses.get(i).Maximum_Students + "\n");

		}
	}

}
