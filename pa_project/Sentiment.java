package pa_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Sentiment {

	// create hashmap to hold source objects
	private HashMap<String, Source> sources;

	public Sentiment() {
		// 1: create sources hashmap
		sources = new HashMap<String, Source>();

		// 2: insert each source object with a blank arraylist
		// MSNBC
		// youngTurks
		// BBC
		// CNN
		// deFranco
		// Fox
		// Jones
		
		sources.put("MSNBC", new Source());
		sources.put("youngTurks", new Source());
		sources.put("BBC", new Source());
		sources.put("CNN", new Source());
		sources.put("deFranco", new Source());
		sources.put("Fox", new Source());
		sources.put("Jones", new Source());
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
	
	private void addComment(String source, String topic){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
