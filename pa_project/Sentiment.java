package pa_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sentiment {

	// create hashmap to hold source objects
	public HashMap<String, Source> sources;

	public Sentiment(String commentData) {
		// 1: create sources hashmap
		sources = new HashMap<String, Source>();

		// insert each source object with a blank arraylist
		ArrayList<String> sourceNames = new ArrayList<String>();

		// insert source names into array list
		sourceNames.add("MSNBC");
		sourceNames.add("youngTurks");
		sourceNames.add("BBC");
		sourceNames.add("CNN");
		sourceNames.add("deFranco");
		sourceNames.add("Fox");
		sourceNames.add("Jones");

		// use a loop on this array list to add each source to our source list
		for (String name : sourceNames) {
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
			
			//add topics to sources
			for(Source source: sources.values()){
				for(String topic: topics){
					source.addTopic(topic);
				}
			}

			// read comments and insert into data source object
			
			//step 1: determine size of data grid
			ArrayList<String> dataGrid;
			//step 2: create array list of source names to maintain order
			
			
			while (line != null && line != "") {
				String[] comments = line.split("\t");
				dataGrid = (ArrayList<String>) Arrays.asList(comments);
				//step 3: check for correct amount of values
				//step 4: insert null in extra spaces
				while(dataGrid.size() < topics.size() * sources.size()){
					dataGrid.add(null);
				}
				
				int index = 0;
					
				for (String topic : topics) {

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

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Sentiment internetComments = new Sentiment(args[0]);
		internetComments.readFile(args[0]);
		// Source CNN = internetComments.sources.get("CNN");
		System.out.println("");

	}

}
