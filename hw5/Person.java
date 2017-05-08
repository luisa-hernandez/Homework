package hw5;

import java.util.ArrayList;

public class Person {
	
	//variable members
	private int SSN;
	private String firstName;
	private String lastName;
	private int motherSSN;
	private int fatherSSN;
	ArrayList<Integer> friends;
	
	//constructor should take as input the data pieces provided in the input file
	public Person(String firstName, String lastName, int SSN, int motherSSN, int fatherSSN, ArrayList<Integer> friends) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = SSN;
		this.motherSSN = motherSSN;
		this.fatherSSN = fatherSSN;
		this.friends = friends;
	}
	public int getSSN(){
		return SSN;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getMotherSSN(){
		return motherSSN;
	}
	
	public int getFatherSSN(){
		return fatherSSN;
	}
	
	public ArrayList<Integer> getFriends(){
		return friends;
	}

}
