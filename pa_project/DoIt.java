package pa_project;

import java.util.Properties;

import edu.stanford.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class DoIt {

	public int run(String line) {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoIt dt = new DoIt();
		dt.run("I am a happy person");
		dt.run("I am a sad person");
		dt.run("I am a very sad person");
		dt.run("I am an extremely sad person.  I am so sad.  Nobody is sadder.  I'm so angry and unhappy.  I can't take it anymore.  I'm going to die and go to hell.");
		dt.run("I am an extremely happy person.  No one is happier.  I'm so happy that I will go right to heaven.");
		
		

	}

}
