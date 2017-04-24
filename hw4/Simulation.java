package hw4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class Simulation {
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
				line = reader.readLine();
			}

		} catch (IOException e) {
			// first time running
		}
	}

	private int waitingTime(int customerID) {
		// search linked list of customers
		Customer current = firstCustomer;

		while (current != null) {
			// return waiting time
			if (current.id() == customerID) {
				// this is our customer
				return current.waitTime();
			} else {
				// not our customer
				current = current.nextCustomer();
			}
		}

		// if customer not found, return null
		return -1;
	}

	private void processQueries() {
		for (int i = 0; i < queries.size(); i++) {
			String query = queries.get(i);

			// repeat the query
			// followed by a colon (:)
			// followed by the query-answer
			if (query.equals("TOTAL-IDLE-TIME")) {
				System.out.println(query + ":" + idleTime);
			} else if (query.equals("LONGEST-BREAK-LENGTH")) {
				System.out.println(query + ":" + longestBreak);
			} else if (query.equals("NUMBER-OF-CUSTOMERS-SERVED")) {
				System.out.println(query + ":" + customersServed);
			} else if (query.equals("MAXIMUM-NUMBER-OF-PEOPLE-IN-QUEUE-AT-ANY-TIME")) {
				System.out.println(query + ":" + longestLineGot);
			} else if (query.startsWith("WAITING-TIME-OF")) {
				// get integer from end of string
				int id = Integer.parseInt(query.substring(query.lastIndexOf(" ") + 1));
				System.out.println(query + ":" + waitingTime(id));
			} else {
				System.out.println("INVALID QUERY");
			}

		}
	}

	private void updateLineLength(Customer current, int currentTime) {
		// count how long the line is
		int lineLength = 0;
		Customer next = current;

		while (next != null && next.arrivalTime() <= currentTime) {
			if (next.arrivalTime() < currentTime) {
				lineLength += 1;
			}
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

		// day starts at 9am, i.e. 32400 seconds
		int currentTime = 32400;
		// 5PM = 17, i.e. 61200 seconds
		// TODO -- handle customers that arrive late
		int closingTime = 61200;

		// update the length of the line
		updateLineLength(currentCustomer, currentTime);

		while (currentCustomer != null && currentCustomer.arrivalTime() <= closingTime) {

			// break time
			int breakTime;
			// gap between customers
			if (currentCustomer.arrivalTime() > currentTime) {
				breakTime = currentCustomer.arrivalTime() - currentTime;
				currentTime += breakTime;
			}
			// no gap between customers
			else {
				breakTime = 0;
				currentCustomer.setWaitTime(currentTime - currentCustomer.arrivalTime());
			}

			customersServed += 1;

			// update idle time
			idleTime += breakTime;

			// update longest break
			if (breakTime > longestBreak) {
				longestBreak = breakTime;
			}

			// "Next!"
			currentTime += serviceTime;
			currentCustomer = currentCustomer.nextCustomer();
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// args[0] = customer file path
		// args[1] = query file path

		// create object to perform simulation
		Simulation sim = new Simulation(args[0], args[1]);
	}

}
