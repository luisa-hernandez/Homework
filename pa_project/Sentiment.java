package pa_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sentiment {

	// create hashmap to hold source objects
	public HashMap<String, Source> sources;

 	public Sentiment(String commentData) {
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

//		Source source = new Source();
//		sources.put("MSNBC", source);
//		
//		source = new Source();
//		sources.put("youngTurks", source);
//		
//		source = new Source();
//		sources.put("BBC", source);
//		
//		source = new Source();
//		sources.put("CNN", source);
//		
//		source = new Source();
//		sources.put("deFranco", source);
//		
//		source = new Source();
//		sources.put("Fox", source);
//		
//		source = new Source();
//		sources.put("Jones", source);
		
		//1: make an array list of strings
		ArrayList<String> sourceNames = new ArrayList<String>();
		
		//2: insert source names into array list
		sourceNames.add("MSNBC");
		sourceNames.add("youngTurks");
		sourceNames.add("BBC");
//		sourceNames.add("CNN");
//		sourceNames.add("deFranco");
//		sourceNames.add("Fox");
//		sourceNames.add("Jones");
		
		
		//3: use a loop on this array list to add each source to our source list
		for (String name : sourceNames){
			Source s = new Source();
			sources.put(name, s);
		}
		System.out.println();
	}

	private void readFile(String filePath) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			// read first line
			String line = reader.readLine();
			line = reader.readLine();

			ArrayList<String> topics = new ArrayList<String>();
			topics.add("testimony");
			topics.add("fired");
			topics.add("election");
			topics.add("agreement");
			topics.add("m_attack");
			topics.add("l_attack");
			topics.add("ban");
			topics.add("pope");
			topics.add("baseball");

			// read comments and insert into data source object
			while (line != null && line != "") {

				String[] comments = line.split("\t");
				int index = 0; 
				
				for (String topic : topics){
					
					for (String sourceName : sources.keySet()) {
						Source source = sources.get(sourceName);
						String comment = comments[index];
						source.addComment(topic, comment);
						index++;
					}
				}

				line = reader.readLine();
			}
		}
	}

	public static void main(String[] args) {
		Sentiment internetComments = new Sentiment(args[0]);
			Source CNN = internetComments.sources.get("CNN");
			System.out.println("");

	}

}
