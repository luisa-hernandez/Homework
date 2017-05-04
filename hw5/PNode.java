package hw5;

class PNode<K extends Comparable<K>, V> {

	private K key;
	private V value;

	private PNode<K, V> leftChild;
	private PNode<K, V> rightChild;

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

	public int compareTo(PNode<K, V> other) {
		return key.compareTo(other.getKey());
	}

	public PNode<K, V> getLeft() {
		return leftChild;
	}

	public void setLeft(PNode<K, V> leftChild) {
		this.leftChild = leftChild;
	}

	public PNode<K, V> getRight() {
		return rightChild;
	}

	public void setRight(PNode<K, V> rightChild) {
		this.rightChild = rightChild;
	}

	public void setValue(V value) {
		this.value = value;
	}
} // end class Node