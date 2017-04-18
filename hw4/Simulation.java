package hw4;

import java.util.ArrayList;

public class Simulation {
	/*
	 * Program to simulate a business serving customers
	 * 
	 */
	
	//the queues
	customerQueue<Customer>[] queues = new customerQueue[customers];
	queriesQueue<String>[] 	queues = new queriesQueue[queries];
	
	//instantiate the queues
	for (int i = 0; i < customers; i++) {
		queues[i] = new customerQueue<Customer>();
	}
	
	for (int i = 0; i < queries; i++) {
		queues[i] = new queriesQueue<String>();
	}
	

	// class variables -- describe program state
	private ArrayList<Customer> customers;
	private ArrayList<String> queries;

	private int longestBreak;
	private int idleTime;
	private int longestLineGot;
	
	//next customer from generator
	Customer nextCust; 
	
	//holds customer for temporary use
	Customer cust; 
	
	//count of customers started so far
	int custStartCount = 0;
	
	//count of customers finished so far
	int custEndCount = 0;
	

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
		
		//set customer generator and get first customer
		customer.Gen.reset();
		nextCust = customer.Gen.nextCustomer();
		
	}

	// method that prints results
	private void outputData() {
		// make them fancy print statements
		
	}

	public static void main(String[] args) {
		// args[0] = customer file path
		// args[1] = query file path
		
		//create object to perform simulation
		Simulation sim = new Simulation(args[0], args[1]);
	}

}
