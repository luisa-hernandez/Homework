package pa_hw1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Kmeans {
	// data matrix
	HashMap<String, ArrayList<Double>> purchaseInfo;
	int initialK;
	ArrayList<Cluster> clusters;

	// constructor
	public Kmeans(String campaignInfo, String purchaseHistory, int initialK) throws FileNotFoundException, IOException {
		this.initialK = initialK;
		// create hashmap
		purchaseInfo = new HashMap<String, ArrayList<Double>>();
		clusters = new ArrayList<Cluster>();

		// step 1: read purchase history data from file
		makeDataMatrix(purchaseHistory);

	}

	private void createClusters() {
		ArrayList<String> names = new ArrayList<String>(purchaseInfo.keySet());
		Random rand = new Random();
		for (int i = 0; i < initialK; i++) {
			int n = rand.nextInt(names.size());
			String name = names.get(n);
			ArrayList<Double> purchases = purchaseInfo.get(name);
			Cluster initialCluster = new Cluster(purchases);
			clusters.add(initialCluster);
		}
	}

	private void assignClusters() {
		for (Entry<String, ArrayList<Double>> purchases : purchaseInfo.entrySet()) {
			// step 1: calculate distance for each cluster & store it
			ArrayList<Double> distances = new ArrayList<Double>();
			for (Cluster cluster : clusters) {
				distances.add(cluster.calculateDistance(purchases.getValue()));
			}

			// step 2: determine cluster with smaller distance
			int minIndex = distances.indexOf(Collections.min(distances));

			// step 3: add customer to cluster
			clusters.get(minIndex).addMember(purchases.getKey(), purchases.getValue());
		}
		System.out.println("");
		
	}

	private void makeDataMatrix(String purchaseHistory) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(purchaseHistory))) {
			// read first line
			String line = reader.readLine();

			// create data matrix
			while (line != null && line != "") {

				// get index of comma
				int index = line.indexOf(",");
				String name = line.substring(0, index);
				int offerNumber = Integer.parseInt(line.substring(index + 1));

				// put name and offer number in hashmap if not seen
				if (!purchaseInfo.containsKey(name)) {
					ArrayList<Double> purchases = new ArrayList<Double>();
					// add 32 0's to arraylist
					for (int i = 0; i < 32; i++) {
						purchases.add(0.);
					}

					// populate hashmap
					purchaseInfo.put(name, purchases);
				}

				// updates customer purchase info
				ArrayList<Double> purchases = purchaseInfo.get(name);
				// update purchases
				purchases.set(offerNumber - 1, 1.);

				// read line to get name
				line = reader.readLine();
			}

			// print out data matrix

		}
	}

	public void updateClusters() {
		Boolean clustersChanged = true;
		
		while (clustersChanged) {
			clustersChanged = false;
			for (Cluster cluster : clusters) {
				ArrayList<String> names = new ArrayList<String>();
				
				for (Entry<String, ArrayList<Double>> customer : cluster.getMembers().entrySet()) {
					Double currentDistance = cluster.calculateDistance(customer.getValue());
					ArrayList<Double> distances = new ArrayList<Double>();
					for (Cluster otherCluster : clusters) {
						distances.add(otherCluster.calculateDistance(customer.getValue()));
					}

					// step 2: determine cluster with smaller distance
					int minIndex = distances.indexOf(Collections.min(distances));

					if (cluster != clusters.get(minIndex)) {
						names.add(customer.getKey());
						clusters.get(minIndex).addMember(customer.getKey(), customer.getValue());
						clustersChanged = true;
					}
				}
				//remove customers from cluster
				for(String name: names){
					cluster.removeMember(name);
				}
				

			}
		}
		System.out.println("");
	}

	public void printClusters() {
		for (int i = 0; i < clusters.size(); i++) {
			System.out.println("Cluster" + i);
			Cluster cluster = clusters.get(i);
			for(Entry<String, ArrayList<Double>> customer : cluster.getMembers().entrySet()) {
				System.out.println(customer.getKey());
			}
			System.out.println(" ");	
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// create customers object
		Kmeans customers = new Kmeans(args[1], args[0], 10);

		customers.createClusters();
		customers.assignClusters();
		customers.updateClusters();
		customers.printClusters();
		

	}

}
