package pa_project;

import java.util.ArrayList;
import java.util.HashMap;

public class Source {
	// source can be "MSNCB," "CNN," etc

	// topics this source handles
	//key is topic name, value is list of comments related to topic
	private HashMap<String, ArrayList<String>> topics;

	public Source(){
		topics = new HashMap<String, ArrayList<String>>();
	}
	
	public void addComment(String topic){
		
	}

}
