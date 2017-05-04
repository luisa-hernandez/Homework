package hw5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Community {

	// queries as linked list
	private ArrayList<String> queries;
	private ArrayList<Integer> friends;

	// variables
	private int SSN;
	private int firstName;
	private int lastName;
	private int motherSSN;
	private int fatherSSN;
	private PeopleTree<Integer, Person> pTree;

	public Community(String peopleFile, String queryFile) {
		// query file
		readQueryFile(queryFile);

		// person files
		readPersonFile(peopleFile);
	}

	private void readQueryFile(String queryFilePath) {
		queries = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(queryFilePath))) {
			String line = reader.readLine();
			while (line != null) {
				queries.add(line);
				line = reader.readLine();
			}

		} catch (IOException e) {
			// first time running
		}
	}

	private void readPersonFile(String personFilePath) {
		ArrayList people = new ArrayList<Person>();

		// open and read person file
		try (BufferedReader reader = new BufferedReader(new FileReader(personFilePath))) {
			String line = reader.readLine();
			while (line != null) {
				// read line to get first name
				line = reader.readLine();
				//get first name from end of string
				int firstNameSpace = line.lastIndexOf(" ");
				String firstName = line.substring(firstNameSpace + 1);

				// read line to get last name
				line = reader.readLine();
				//get last name from end of string
				//get first name from end of string
				int lastNameSpace = line.lastIndexOf(" ");
				String lastName = line.substring(lastNameSpace + 1);

				// read line to get SSN
				line = reader.readLine();
				// get integer from end of string
				int lastSNSpace = line.lastIndexOf(" ");
				String SNString = line.substring(lastSNSpace + 1);
				int SN = Integer.parseInt(SNString);

				// read line to get mother's SSN
				line = reader.readLine();
				// get integer from end of string
				int lastMotherSpace = line.lastIndexOf(" ");
				String motherSNString = line.substring(lastMotherSpace + 1);
				int motherSN = Integer.parseInt(motherSNString);

				// read line to get father's SSN
				line = reader.readLine();
				// get integer from end of string
				int lastFatherSpace = line.lastIndexOf(" ");
				String fatherSNString = line.substring(lastFatherSpace + 1);
				int fatherSN = Integer.parseInt(fatherSNString);

				// read line to get friends
				line = reader.readLine();
				// get integer from end of string
				int friendsSpace = line.lastIndexOf(" ");
				String friendsString = line.substring(friendsSpace + 1);
				//separate friends by commas using split method
				String [] friends = friendsString.split(",");
				ArrayList<Integer> intFriends = new ArrayList<Integer>();
				for(int i=0; i<friends.length; i++){
					intFriends.add(Integer.parseInt(friends[i]));
				}
			
				// create a person and add each one to the people array list
				Person p = new Person(firstName, lastName, SSN, fatherSSN, motherSSN, intFriends);
				
				//TODO -- insert person into people tree
			}
		}


		// shuffle the people array list
		ArrayList<String> shufflePeople = new ArrayList<String>();
		Collections.shuffle(shufflePeople);

		// put the people in the binary search tree
		public void addPeople(ArrayList<String> shufflePeople, Node root){
			if (root == null){
				root = (Node) s;
			}
			else if (s.compareTo(n) < 0){
				root.left = add(s, root.leftChild);
			}
			else {
				root.right = add(s, root.rightChild);	
			}
		}
//
//		catch (IOException e) {
//		}

	}

	public static void main(String[] args) {
		// args[0] is query file path
		// args[1] is person file path

		// TODO 0 - instantiate Community class w/ paths of files
		Community community = new Community(args[0], args[1]);

	}

}
