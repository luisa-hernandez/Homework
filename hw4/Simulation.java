package hw4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import Homework_1.Student;

public class Simulation<G> {
	/*
	 * Program to simulate a business serving customers
	 * 
	 */

	// customers as linked list
	private Customer firstCustomer;
	private Customer lastCustomer;

	// infos
	private int longestBreak;
	private int idleTime;
	private int longestLineGot;
	private int serviceTime;

	public Simulation(String customerFilePath, String queryFilePath) {
		// read data from files
		readCustomerData(customerFilePath);
		readQueryData(queryFilePath);

		// process data and queries
		processData();

		// maybe print results here?
		outputData();
	}

	private void readCustomerData(String customerFilePath) {
		/**
		 * load customers from a file
		 */
		File customerFile = new File(customerFilePath);

		try (BufferedReader reader = new BufferedReader(new FileReader(customerFilePath))) {
			String line = reader.readLine();

			// read the service time
			serviceTime = Integer.parseInt(line);

			// read the customer data
			line = reader.readLine();
			while (line != null) {
				//read line to get ide
				line = reader.readLine();
				//convert line into integer
				//int id = someId
				
				//read line to get arrival time
				//string arrivetime = someTime
				

				//create customer object, attach to queue
				//Customer c = new Customer(id, arrivetime);
				//attach customer to last customer
				
				//lastly
				line = reader.readLine();
			}

		} catch (IOException e) {
			// first time running
		}

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

		// create object to perform simulation
		Simulation sim = new Simulation(args[0], args[1]);
	}

}
