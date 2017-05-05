package hw5;

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

	/**
	 * Looking for a PNode based on key. Delete if found.
	 * 
	 * @param key
	 */
	// public void delete(K key) {
	//
	//
	// if (node.compareTo(current) < 0){
	// node.left = remove (key);
	// }
	// else if (node.compareTo(current) > 0){
	// node.right = remove(key);
	// }
	// else if
	//
	// }

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

					} else {
						current = current.getRight();
					}

					// TODO -- write code to insert into right child

					// 1- is right free?
					current.setRight(node);
					done = true;
					current = current.getRight();

					// 2- if not, compare to right child

				}

			}

		}

	}

}
