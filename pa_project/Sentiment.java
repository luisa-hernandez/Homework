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

	// create hash map to hold source objects
	private HashMap<String, Source> sources;
	private ArrayList<String> sourceNames;
	private ArrayList<String> topics;

	public Sentiment(String commentData) {
		// 1: create sources
		sources = new HashMap<String, Source>();

		// source names
		sourceNames = new ArrayList<String>();
		sourceNames.add("MSNBC");
		sourceNames.add("youngTurks");
		sourceNames.add("BBC");
		sourceNames.add("CNN");
		sourceNames.add("deFranco");
		sourceNames.add("Fox");
		sourceNames.add("Jones");

		// create sources
		for (String sourceName : sourceNames) {
			sources.put(sourceName, new Source());
		}

		// topic names
		topics = new ArrayList<String>();
		topics.add("testimony");
		topics.add("fired");
		topics.add("election");
		topics.add("agreement");
		topics.add("m_attack");
		topics.add("l_attack");
		topics.add("ban");
		topics.add("pope");
		topics.add("baseball");

		// add topics to sources
		for (String sourceName : sourceNames) {
			Source source = sources.get(sourceName);
			for (String topic : topics) {
				source.addTopic(topic);
			}
		}
	}

	public void readFile(String filePath) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			// read first line
			String line = reader.readLine();
			line = reader.readLine();

			while (line != null && line != "") {
				// step 1: parse line
				ArrayList<String> comments = new ArrayList();
				comments.addAll(Arrays.asList(line.split("\t")));

				// hard coded :(
				while (comments.size() < 63) {
					comments.add("");
				}

				// add comments to sources
				for (String topicName : topics) {
					for (String sourceName : sourceNames) {
						sources.get(sourceName).addComment(topicName, comments.remove(0));
					}
				}

				line = reader.readLine();

			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Sentiment internetComments = new Sentiment(args[0]);
		internetComments.readFile(args[0]);

		System.out.println("");
	}

}
