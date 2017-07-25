package pa_hw1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Kmeans {

	//data matrix 
	HashMap<String, ArrayList> purchaseInfo;
	
	// constructor
	public Kmeans(String campaignInfo, String purchaseHistory) throws FileNotFoundException, IOException {

		// create hashmap
		purchaseInfo = new HashMap<String, ArrayList>();

		// step 1: read purchase history data from file
		makeDataMatrix(purchaseHistory);
		
	}
	
	private void makeDataMatrix(String purchaseHistory) throws FileNotFoundException, IOException{
		try (BufferedReader reader = new BufferedReader(new FileReader(purchaseHistory))) {
			// read first line
			String line = reader.readLine();

			// create data matrix
			while (line != null && line !="") {
				
				// get index of comma
				int index = line.indexOf(",");
				String name = line.substring(0, index);
				int offerNumber = Integer.parseInt(line.substring(index + 1));

				// put name and offer number in hashmap if not seen
				if (!purchaseInfo.containsKey(name)) {
					ArrayList<Integer> purchases = new ArrayList<Integer>();
					// add 32 0's to arraylist
					for (int i = 0; i < 32; i++) {
						purchases.add(0);
					}

					// populate hashmap
					purchaseInfo.put(name, purchases);
				}

				// updates customer purchase info
				ArrayList<Integer> purchases = purchaseInfo.get(name);
				// update purchases
				purchases.set(offerNumber - 1, 1);
				
				// read line to get name
				line = reader.readLine();
			}
			
			//print out data matrix
			
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// create customers object
		Kmeans customers = new Kmeans(args[1], args[0]);
	}

}
