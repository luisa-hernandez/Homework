package pa_hw1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Cluster {
	// create clusters
	// put everyone in a cluster

	// create hashmap to hold members
	private HashMap<String, ArrayList<Integer>> members;
	// representative
	private ArrayList<Double> representative;

	// creates a new cluster
	public Cluster(ArrayList<Double> representative) {
		members = new HashMap<String, ArrayList<Integer>>();
		this.representative = representative;
	}

	public void addMember(String name, ArrayList<Integer> purchases) {
		members.put(name, purchases);
		calculateRepresentative();
	}

	public void removeMember(String name) {
		members.remove(name);
		calculateRepresentative();
	}

	// calculate representatives
	public void calculateRepresentative() {
		for (int i = 0; i < representative.size(); i++) {
			Integer sum = 0;
			for (Entry<String, ArrayList<Integer>> member: members.entrySet()) {
				Integer value = member.getValue().get(i);
				sum = sum + value;
			}
			Double average = (double) (sum/representative.size());
			representative.set(i, average);
		}
	}
}
