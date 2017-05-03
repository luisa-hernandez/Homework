package hw5;

import java.util.ArrayList;

public class Community {

	private ArrayList<String> queries;

	public Community(String peopleFile, String queryFile) {
		// TODO 1 -read input files and process information
		// query file
		readQueryFile(queryFile);
		
		// person files
		readPersonFile(peopleFile);
		
		// read and put into temporary array list
		
		// shuffle the array list using java.util.Collections.shuffle

		// put it into a binary search tree
	}

	
	private void readQueryFile(String queryFilePath) {
		queries = new ArrayList<String>();
		//TODO: do the rest of the things
	}
	
	private void readPersonFile(String personFilePath){
		ArrayList people = new ArrayList<Person>();
	}

	public static void main(String[] args) {
		// TODO 0 - instantiate Community class w/ paths of files
	}

}
