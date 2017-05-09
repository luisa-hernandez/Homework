package hw5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Community {

	// queries as linked list
	private ArrayList<String> queries;

	// variables
	private PeopleTree<Integer, Person> pTree;

	public Community(String peopleFile, String queryFile) throws FileNotFoundException, IOException {
		// query file
		readQueryFile(queryFile);

		// person files
		readPersonFile(peopleFile);
	}

	private void processQueries() {
		for (String query : queries) {
			String result = "";
			int id = Integer.parseInt(query.substring(query.lastIndexOf(" ") + 1));

			if (query.startsWith("NAME")) {
				result = nameOf(id);
			} else if (query.startsWith("FATHER")) {
				result = fatherOf(id);
			} else if (query.startsWith("MOTHER")) {
				result = motherOf(id);
			} else if (query.startsWith("HALF")) {
				result = halfSiblingsOf(id);
			} else if (query.startsWith("FULL")) {
				result = fullSiblingsOf(id);
			} else if (query.startsWith("CHILDREN")) {
				result = childrenOf(id);
			} else if (query.startsWith("MUTUAL")) {
				result = mutualFriendsOf(id);
			} else if (query.startsWith("INVERSE")) {
				result = inverseFriendsOf(id);
			} else {
				// "WHO"
				result = mostMutualFriends();
			}

			System.out.println(query + ": " + result);
		}
	}

	// TODO 2 -- start implementing methods, using PeopleTree.find()
	private String nameOf(int id) {
		// use PeopleTree.find() to get appropriate PNode
		Person p = pTree.find(id).getValue();

		// construct response and return below
		return p.getFirstName() + " " + p.getLastName();
	}

	private String fatherOf(int id) {
		Person p = pTree.find(id).getValue();

		return nameOf(p.getFatherSSN());
	}

	private String motherOf(int id) {
		Person p = pTree.find(id).getValue();

		return nameOf(p.getMotherSSN());
	}

	private String halfSiblingsOf(int id) {
		Person p = pTree.find(id).getValue();

		int fId = p.getFatherSSN();
		int mIf = p.getMotherSSN();

		ArrayList<Person> errybody = pTree.getAllValues();
		String halfSiblings = "";

		for (Person somebody : errybody) {
			if ((somebody.getFatherSSN() == fId && somebody.getMotherSSN() != mIf)
					|| (somebody.getMotherSSN() == mIf && somebody.getFatherSSN() != fId)) {
				halfSiblings += " " + nameOf(somebody.getSSN());
			}
		}
		return halfSiblings;
	}

	private String fullSiblingsOf(int id) {
		Person p = pTree.find(id).getValue();

		int fId = p.getFatherSSN();
		int mIf = p.getMotherSSN();

		ArrayList<Person> errybody = pTree.getAllValues();
		String siblings = "";

		for (Person somebody : errybody) {
			if (somebody.getFatherSSN() == fId && somebody.getMotherSSN() == mIf) {
				siblings += " " + nameOf(somebody.getSSN());
			}
		}
		return siblings;
	}

	private String childrenOf(int id) {
		Person p = pTree.find(id).getValue();
		ArrayList<Person> errybody = pTree.getAllValues();
		String childrenOf = "";

		for (Person somebody : errybody) {
			if (p.getMotherSSN() == somebody.getSSN() || p.getFatherSSN() == somebody.getSSN()) {
				childrenOf += " " + nameOf(somebody.getSSN());
			}
		}

		return childrenOf;
	}

	private String mutualFriendsOf(int id) {
		Person p = pTree.find(id).getValue();
		String mutualFriends = "";

		for (int friendId : p.getFriends()) {
			Person friend = pTree.find(friendId).getValue();
			ArrayList<Integer> friendsOfFriends = friend.getFriends();

			if (friendsOfFriends.contains(id)) {
				mutualFriends += " " + nameOf(friendId);
			}
		}

		return mutualFriends;
	}

	private String inverseFriendsOf(int id) {
		ArrayList<Person> errybody = pTree.getAllValues();
		String inverseFriends = " ";

		for (Person somebody : errybody) {
			if (somebody.getFriends().contains(id)) {
				inverseFriends += "  " + nameOf(id);
			}
		}

		return inverseFriends;
	}

	private int countMutualFriends(int id) {
		Person p = pTree.find(id).getValue();
		int friendsCount = 0;

		for (int friendId : p.getFriends()) {
			Person friend = pTree.find(friendId).getValue();
			ArrayList<Integer> friendsOfFriends = friend.getFriends();

			if (friendsOfFriends.contains(id)) {
				friendsCount++;
			}
		}

		return friendsCount;
	}

	private String mostMutualFriends() {
		ArrayList<Person> errybody = pTree.getAllValues();
		Person mostFriends = errybody.get(0);

		for (Person somebody : errybody) {
			if (countMutualFriends(somebody.getSSN()) > countMutualFriends(mostFriends.getSSN())) {
				mostFriends = somebody;
			}
		}

		return nameOf(mostFriends.getSSN());
	}

	private void readQueryFile(String queryFilePath) throws FileNotFoundException, IOException {
		queries = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(queryFilePath))) {
			String line = reader.readLine();
			while (line != null) {
				queries.add(line);
				line = reader.readLine();
			}
		}
	}

	private void readPersonFile(String personFilePath) throws FileNotFoundException, IOException {
		// open and read person file
		try (BufferedReader reader = new BufferedReader(new FileReader(personFilePath))) {
			String line = reader.readLine();
			while (line != null) {
				// read line to get first name
				line = reader.readLine();
				// get first name from end of string
				int firstNameSpace = line.lastIndexOf(" ");
				String firstName = line.substring(firstNameSpace + 1);

				// read line to get last name
				line = reader.readLine();
				// get last name from end of string
				// get first name from end of string
				int lastNameSpace = line.lastIndexOf(" ");
				String lastName = line.substring(lastNameSpace + 1);

				// read line to get SSN
				line = reader.readLine();
				// get integer from end of string
				int lastSNSpace = line.lastIndexOf(" ");
				String SNString = line.substring(lastSNSpace + 1);
				int SSN = Integer.parseInt(SNString);

				// read line to get mother's SSN
				line = reader.readLine();
				// get integer from end of string
				int lastMotherSpace = line.lastIndexOf(" ");
				String motherSNString = line.substring(lastMotherSpace + 1);
				int motherSSN = Integer.parseInt(motherSNString);

				// read line to get father's SSN
				line = reader.readLine();
				// get integer from end of string
				int lastFatherSpace = line.lastIndexOf(" ");
				String fatherSNString = line.substring(lastFatherSpace + 1);
				int fatherSSN = Integer.parseInt(fatherSNString);

				// read line to get friends
				line = reader.readLine();
				// get integer from end of string
				int friendsSpace = line.lastIndexOf(" ");
				String friendsString = line.substring(friendsSpace + 1);
				// separate friends by commas using split method
				String[] friends = friendsString.split(",");
				ArrayList<Integer> intFriends = new ArrayList<Integer>();
				for (int i = 0; i < friends.length; i++) {
					intFriends.add(Integer.parseInt(friends[i]));
				}

				// create a person and add each one to the people array list
				Person p = new Person(firstName, lastName, SSN, fatherSSN, motherSSN, intFriends);

				// insert person into people tree
				pTree.insert(SSN, p);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// args[0] is query file path
		// args[1] is person file path

		// instantiate Community class w/ paths of files
		Community community = new Community(args[0], args[1]);

	}

}
