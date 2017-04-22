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
		longestLineGot =0;
		idleTime = 0;
		// read data from files
		readCustomerData(customerFilePath);
		readQueryData(queryFilePath);

		// process data and queries
		processCustomers();

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

				//TODO: only if customer arrived before 5PM
				//if statement
				
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
			while (line != null && line != ""){
				queries.add(line);
			}

		}

		catch (IOException e) {
			// first time running
		}
	}

	private void processCustomers() {
		// update longest break, total idle time, and max line length
		// "I guess just update all the counters."
		Customer currentCustomer = firstCustomer;
		int currentTime = 9*60*60;
		int breakTime = 0;
		while(currentCustomer != null){
			if(currentCustomer.arrivalTime() > currentTime){
				breakTime = currentCustomer.arrivalTime() - currentTime;
				currentTime = currentCustomer.arrivalTime();
			}
			else{
				currentTime += serviceTime;
				breakTime = 0;
			}
			customersServed += 1;
			currentCustomer = currentCustomer.nextCustomer();
			
			Customer lineCustomer = currentCustomer;
			int lineLength = 0;
			
			while (lineCustomer != null && lineCustomer.arrivalTime() <= currentTime){
				lineLength +=1;
				lineCustomer = lineCustomer.nextCustomer();
			}
			if(lineLength > longestLineGot){
				longestLineGot = lineLength;
			}
			
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
