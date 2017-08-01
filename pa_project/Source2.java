package pa_project;

import java.util.ArrayList;
import java.util.HashMap;

public class Source2 {
	// source can be "MSNCB," "CNN," etc

	// topics this source handles
	//key is topic name, value is list of comments related to topic
	private HashMap<String, ArrayList<String>> topics;

	public Source2(){
		topics = new HashMap<String, ArrayList<String>>();
	}
	
	public void addComment(String topic, String comment){
		topics.get(topic).add(comment);	
	}
	
	public void addTopic(String topic){
		topics.put(topic, new ArrayList<String>());
	}
	
	public ArrayList<String> getTopicComments(String topic){
		return topics.get(topic);
	}

}
