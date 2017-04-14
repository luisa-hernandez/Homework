package hw4;

import java.util.ArrayList;

public class Simulation {
	/*
	 *Program to simulate a business serving customers
	 * 
	 */
	
	//class variables -- describe program state
	private ArrayList<Customer> customers;
	private int longestBreak;
	private int idleTime;
	private int longestLineGot;
	private ArrayList<String> queries;
	
	public Simulation(String customerFilePath, String queryFilePath){
		//read data from files
		methodThatDoesThis();
		//process data and queries
		methodThatDoesThat();
		
		//maybe print results here?
	}
	
	private void methodThatDoesThis(){
		
	}
	
	private void methodThatDoesThat(){
		
	}
	
	//method that prints results
	
	public static void main(String[] args){
		//args[0] = customer file path
		//args[1] = query file path
		Simulation sim = new Simulation(args[0], args[1]);
	}

}
