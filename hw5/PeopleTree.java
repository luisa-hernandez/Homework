package hw5;

public class PeopleTree<K extends Comparable<K>, V> {

	PNode<K, V> root = null;

	public PeopleTree() {
	}

	public V find(K key) {
		return null;
	}

	public void delete(K key) {

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
					if(current.getLeft() == null){
						current.setLeft(node);
						done = true;
					}

				} else {
					// go to right
				}

			}

		}

	}

}
