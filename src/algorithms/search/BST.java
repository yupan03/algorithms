package algorithms.search;

public class BST<Key extends Comparable<Key>, Value>{
private Node root; 
	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int N;
		
		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value=value;
			this.N = N;
		}
		
		public int size() {
			return size(root);
		}
		
		public int size(Node node) {
			if(node == null) return 0;
			return size(node);
		}
		
		public Value get(Key key) {
			return get(root, key);
		}
		
		public Value get(Node node, Key key) {
			if(node == null) return null;
			int cmp = key.compareTo(node.key);
			if(cmp < 0 ) return get(node.left,key);
			if(cmp> 0 ) return get(node.right,key);
			
			return node.value;
			
		}
		
		public void put() {
			
		}
	}
}