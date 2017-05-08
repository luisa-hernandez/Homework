package hw5;

import java.util.ArrayList;

public class PeopleTree<K extends Comparable<K>, V> {

	PNode<K, V> root;

	public PeopleTree() {
	}

	/**
	 * Finding a PNode based on key. Return null if not found.
	 */
	public PNode<K, V> find(K key) {
		PNode<K, V> node = root;
		boolean notFound = true;

		while (notFound) {
			if (node == null) {
				notFound = false;
			} else if (key.compareTo(node.getKey()) == 0) {
				// match
				notFound = false;
			} else if (key.compareTo(node.getKey()) < 0) {
				// look at left child
				node = node.getLeft();
			} else {
				// look at right child
				node = node.getRight();
			}
		}
		return node;
	}

	public void insert(K key, V value) {
		PNode<K, V> node = new PNode<K, V>(key, value);
		if (root == null) {
			root = node;
		} else {
			boolean done = false;
			PNode<K, V> current = root;

			while (!done) {
				// compare keys
				if (node.compareTo(current) < 0) {
					// go to left
					if (current.getLeft() == null) {
						// left is free, so set left child
						current.setLeft(node);
						done = true;
					}

					else {
						// left is not free, set current to left
						current = current.getLeft();
					}

				} else {
					// go to right
					if (current.getRight() == null) {
						current.setRight(node);
						done = true;

					} else {
						// if right is not free, set current to right
						current = current.getRight();
					}
				}
			}
		}
	}

	public ArrayList<V> getAllValues() {
		ArrayList<V> allValues = new ArrayList<V>();
		ArrayList<PNode<K, V>> allNodes = getValues(root);
		for (PNode<K, V> node : allNodes) {
			allValues.add(node.getValue());
		}

		return allValues;
	}

	public ArrayList<PNode<K, V>> getValues(PNode<K, V> n) {
		ArrayList<PNode<K, V>> values = new ArrayList<PNode<K, V>>();
		if (n == null) {
			return values;
		}

		// get left and right children
		PNode<K, V> left = n.getLeft();
		PNode<K, V> right = n.getRight();

		for (PNode<K, V> node : getValues(left)) {
			values.add(node);
		}

		values.add(n);

		for (PNode<K, V> node : getValues(right)) {
			values.add(node);
		}

		return values;
	}

}
