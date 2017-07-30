package pa_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SentimentAnalyzer {

	// create hashmap to hold source objects
	private HashMap<String, ArrayList<String>> sources;
	// comments
	private ArrayList<String> comments;

	// create source objects
	Sentiment MSNBC = new Sentiment();
	Sentiment youngTurks = new Sentiment();
	Sentiment BBC = new Sentiment();
	Sentiment CNN = new Sentiment();
	Sentiment deFranco = new Sentiment();
	Sentiment Fox = new Sentiment();
	Sentiment Jones = new Sentiment();

	private void readFile(String commentData) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(commentData))) {
			
			// read first line
			String line = reader.readLine();
			
			//read comments and insert into data source object 
			while (line != null && line != "") {
				
				
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
