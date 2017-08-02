package pa_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

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

	public void processComments() {
		for (String topic : topics) {
			System.out.println(topic);
			for (String sourceName : sourceNames) {
				double sum = 0;
				for (String comment : sources.get(sourceName).getTopic(topic)) {
					sum += getSentiment(comment);
				}
				double average = sum / sources.get(sourceName).getTopic(topic).size();
				System.out.println(sourceName + ": " + average);
			}
			System.out.println();
		}
	}

	public int getSentiment(String line) {

		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		int mainSentiment = 0;

		if (line != null && line.length() > 0) {
			int longest = 0;
			Annotation annotation = pipeline.process(line);
			for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
				Tree tree = sentence.get(SentimentAnnotatedTree.class);
				int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
				String partText = sentence.toString();
				if (partText.length() > longest) {
					mainSentiment = sentiment;
					longest = partText.length();
				}

			}
		}

		System.out.println(mainSentiment);
		return 0;
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

				System.out.println("");

			}

		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Sentiment internetComments = new Sentiment(args[0]);
		internetComments.readFile(args[0]);
		internetComments.processComments();
		System.out.println("");
	}

}
