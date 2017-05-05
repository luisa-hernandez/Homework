package hw5;

public class PeopleTree<K extends Comparable<K>, V> {

	PNode<K, V> root = null;

	public PeopleTree() {
	}

	public V find(K key) {
		if (root == null){
			return null;
		}
		if (node.compareTo(current) < 0) {
			return find(node, root.left);
		}
		else if (node.compareTo(current) > 0){
			return find(node, root.right);
		}
		else{
			//this means it's a match
			return root;
		}
	}

	public void delete(K key) {
		
		
		if (node.compareTo(current) < 0){
			node.left = remove (key);
		}
		else if (node.compareTo(current) > 0){
			node.right = remove(key);
		}
		else if

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
						//left is free, so set left child
						current.setLeft(node);
						done = true;
					}
					
					else{
						//left is not free, set current to left
						current = current.getLeft();
					}

				} else {
					// go to right
					if(current.getRight()==null){
					
					}
					else{
						current = current.getRight();
					}
					
					//TODO -- write code to insert into right child
					
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
