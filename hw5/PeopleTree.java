package hw5;

class PNode<K, V> {

	private K key;
	private V value;

	public PNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public K getKey() {
		return key;
	}
} // end class Node

public class PeopleTree<K, V> {

	Node root = null;

	public PeopleTree() {
	}

	public V find(K key) {
		return null;
	}

	public void delete(K key) {

	}

	public void insert(K key, V value) {

	}
}
