package hw4;

import java.util.ArrayList;

public class Simulation {
	/*
	 * Program to simulate a business serving customers
	 * 
	 */

	// class variables -- describe program state
	private ArrayList<Customer> customers;
	private ArrayList<String> queries;

	private int longestBreak;
	private int idleTime;
	private int longestLineGot;

	public Simulation(String customerFilePath, String queryFilePath) {
		// read data from files
		readCustomerData(customerFilePath);
		readQueryData(queryFilePath);

		// process data and queries
		processData();

		// maybe print results here?
		outputResults();
	}

	private void readCustomerData(String customerFilePath) {
		// update "customer" class variable

		// create a customer object for every customer
	}

	private void readQueryData(String queryFilePath) {
		// update "queries" class variable
	}

	private void processData() {
		// update longest break, total idle time, and max line length
		// "I guess just update all the counters."
	}

	// method that prints results
	private void outputData() {
		// make them fancy print statements
	}

	public static void main(String[] args) {
		// args[0] = customer file path
		// args[1] = query file path
		Simulation sim = new Simulation(args[0], args[1]);
	}

}
