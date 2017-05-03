package hw5;

public class Person {
	
	//variable members
	private int SSN;
	private String firstName;
	private String lastName;
	private int motherSSN;
	private int fatherSSN;
	//friends
	
	//constructor should take as input the data pieces provided in the input file
	public Customer(String firstName, String lastName, int SSN, int motherSSN, int fatherSSN //, friends) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.SSN = SSN;
		this.motherSSN = motherSSN;
		this.fatherSSN = fatherSSN;
		//friends
	}
	//accessors to return the values:
	//getSSN()
	//getFullName()
	//getFatherSSN()
	//getMotherSSN()
	//getFriends()

}
