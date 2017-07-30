package pa_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Sentiment {

	// create hashmap to hold source objects
	private HashMap<String, ArrayList<String>> sources;

	public Sentiment() {
		// 1: create sources hashmap
		sources = new HashMap<String, ArrayList<String>>();

		// 2: insert each source object with a blank arraylist
		// MSNBC
		// youngTurks
		// BBC
		// CNN
		// deFranco
		// Fox
		// Jones
		
		sources.put("MSNBC", new ArrayList<String>());
		sources.put("youngTurks", new ArrayList<String>());
		sources.put("BBC", new ArrayList<String>());
		sources.put("CNN", new ArrayList<String>());
		sources.put("deFranco", new ArrayList<String>());
		sources.put("Fox", new ArrayList<String>());
		sources.put("Jones", new ArrayList<String>());
	}

	private void readFile(String filePath) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			// read first line
			String line = reader.readLine();

			// read comments and insert into data source object
			while (line != null && line != "") {

			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
