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
	private int customersServed;
	private ArrayList<String> queries;

	public Simulation(String customerFilePath, String queryFilePath) {
		customersServed = 0;
		longestLineGot = 0;
		idleTime = 0;
		// read data from files
		readCustomerData(customerFilePath);
		readQueryData(queryFilePath);

		// process data and queries
		processCustomers();
		processQueries();

		// maybe print results here?
		outputData();
	}

	private int convertToSeconds(String arrivalTime) {
		String[] arrivalTimeArray = arrivalTime.split(":");
		int hours = Integer.parseInt(arrivalTimeArray[0]);
		if (hours >= 1 && hours <= 5) {
			hours += 12;
		}
		int minutes = Integer.parseInt(arrivalTimeArray[1]);
		int seconds = Integer.parseInt(arrivalTimeArray[2]);
		return hours * 60 * 60 + minutes * 60 + seconds;
	}

	private void readCustomerData(String customerFilePath) {
		/**
		 * load customers from a file
		 */

		try (BufferedReader reader = new BufferedReader(new FileReader(customerFilePath))) {
			String line = reader.readLine();

			// read the service time
			serviceTime = Integer.parseInt(line);

			// read the customer data
			line = reader.readLine();
			while (line != null) {
				// read line to get id
				line = reader.readLine();
				// get integer from end of string
				int lastSpace = line.lastIndexOf(" ");
				String idString = line.substring(lastSpace + 1);
				int id = Integer.parseInt(idString);

				// read line to get arrival time
				line = reader.readLine();
				// get arrival time from end of string
				lastSpace = line.lastIndexOf(" ");
				String arrivalTimeString = line.substring(lastSpace + 1);
				int arrivalTime = convertToSeconds(arrivalTimeString);

				// create customer object, attach to queue
				Customer c = new Customer(id, arrivalTime);

				// TODO: only if customer arrived before 5PM
				// if statement

				// attach customer to last customer
				if (firstCustomer == null) {
					firstCustomer = c;
					lastCustomer = c;
				} else {
					lastCustomer.setNextCustomer(c);
					lastCustomer = c;
				}

				// lastly
				line = reader.readLine();
			}

		} catch (IOException e) {
			// first time running
		}

		// create a customer object for every customer
	}

	private void readQueryData(String queryFilePath) {
		// update "queries" class variable
		queries = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader(new FileReader(queryFilePath))) {
			String line = reader.readLine();
			while (line != null && line != "") {
				queries.add(line);
			}

		} catch (IOException e) {
			// first time running
		}
	}

	private int numberOfCustomersServed() {
		return customersServed;
	}

	private int longestBreakLength() {
		return longestBreak;
	}

	private int totalIdleTime() {
		return idleTime;
	}

	private int maxPeopleServed() {
		return longestLineGot;
	}
	
	private int waitingTime(int customerID){
		//search linked list of customers
		
		//return waiting time
		
		//if customer not found, return null
		return -1;
	}

	private void processQueries() {
		for (int i = 0; i < queries.size(); i++) {
			String query = queries.get(i);

			// can process query
		}
	}

	private void updateLineLength(Customer current, int currentTime) {
		// count how long the line is
		int lineLength = 0;
		Customer next = current.nextCustomer();

		while (next != null && next.arrivalTime() <= currentTime) {
			lineLength += 1;
			next = next.nextCustomer();
		}

		// set max line length
		if (lineLength > longestLineGot) {
			longestLineGot = lineLength;
		}
	}

	private void processCustomers() {
		// update longest break, total idle time, and max line length
		// "I guess just update all the counters."
		Customer currentCustomer = firstCustomer;

		// day starts at 9am
		int currentTime = 9 * 60 * 60;
		// 5PM = 17
		int closingTime = 17 * 60 * 60;

		// break time
		int breakTime = 0;
		while (currentCustomer != null && currentCustomer.arrivalTime() <= currentTime) {
			// check to make sure customer "arrives" before current time
			if (currentCustomer.arrivalTime() > currentTime) {
				// update break time
				breakTime = currentCustomer.arrivalTime() - currentTime;
				// "serve" customer
				currentTime = currentCustomer.arrivalTime();
			} else {
				currentTime += serviceTime;
			}

			// update wait time
			int waitTime = currentTime - currentCustomer.arrivalTime();
			if (waitTime > 0) {
				currentCustomer.setWaitTime(waitTime);
			} else {
				currentCustomer.setWaitTime(0);
			}

			customersServed += 1;

			// update the length of the line
			updateLineLength(currentCustomer, currentTime);

			// update idle time
			idleTime += breakTime;

			// update longest break
			if (breakTime > longestBreak) {
				longestBreak = breakTime;
			}

			// "Next!"
			currentCustomer = currentCustomer.nextCustomer();
		}
	}

	// method that prints results
	private void outputData() {
		// make them fancy print statements
		System.out.println("The person will wait:");
		System.out.println("Cutomers in the group served: ");
		System.out.println("Total idle time of employee: ");
		System.out.println("Longest break employee has: ");
		System.out.println("Longest waiting line: ");

	}

	public static void main(String[] args) {
		// args[0] = customer file path
		// args[1] = query file path

		// create object to perform simulation
		Simulation sim = new Simulation(args[0], args[1]);
	}

}
