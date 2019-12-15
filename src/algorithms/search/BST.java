package algorithms.search;

public class BST<Key extends Comparable<Key>, Value> {

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int N; // 该节点下的所有子节点数量（包含自身）

		public Node(Key key, Value value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}

	private Node root;

	public BST() {
	}

	public void recursivePreOrder() {
		recursivePreOrder(root);
	}

	/**
	 * 先序遍历
	 * 
	 * @param node
	 */
	private void recursivePreOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.key + " ");
		recursivePreOrder(node.left);
		recursivePreOrder(node.right);
	}

	public void recursiveInOrder() {
		recursiveInOrder(root);
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */
	private void recursiveInOrder(Node node) {
		if (node == null)
			return;
		recursiveInOrder(node.left);
		System.out.print(node.key + " ");
		recursiveInOrder(node.right);
	}

	public void recursivePostOrder() {
		recursivePostOrder(root);
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 */
	private void recursivePostOrder(Node node) {
		if (node == null)
			return;
		recursivePostOrder(node.left);
		recursivePostOrder(node.right);
		System.out.print(node.key + " ");
	}

	/**
	 * 二叉树大小
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 * 节点大小
	 * 
	 * @param node
	 * @return
	 */
	private int size(Node node) {
		if (node == null)
			return 0;
		return node.N;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			return get(node.left, key);
		if (cmp > 0)
			return get(node.right, key);

		return node.value;

	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node node, Key key, Value value) {
		if (node == null)
			return new Node(key, value, 1);

		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = put(node.left, key, value);
		if (cmp > 0)
			node.right = put(node.right, key, value);
		else
			node.value = value;
		node.N = size(node.left) + size(node.right) + 1;

		return node;
	}

	public Key min() {
		return min(root).key;
	}

	private Node min(Node node) {
		if (node.left == null)
			return node;
		return min(node.left);
	}

	public Key max() {
		return max(root).key;
	}

	private Node max(Node node) {
		if (node.right == null)
			return node;
		return max(node.right);
	}

	public Key floor(Key key) {
		return floor(key, root).key;
	}

	private Node floor(Key key, Node node) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);

		if (cmp == 0) {
			return node;
		} else if (cmp < 0) {
			return floor(key, node.left);
		}
		Node t = floor(key, node.right);

		if (t == null) {
			return node;
		} else {
			return t;
		}
	}

	public Key ceil(Key key) {
		if (key == null)
			return null;
		return ceil(key, root).key;
	}

	private Node ceil(Key key, Node node) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.key);

		if (cmp == 0) {
			return node;
		} else if (cmp < 0) {
			Node t = ceil(key, node.left);

			if(t != null) return t;
			else return node;
		}

		return ceil(key, node.right);
	}

	public Key select(int k) {
		return select(k, root).key;
	}

	private Node select(int k, Node node) {
		if (node == null)
			return null;
		int t = size(node.left);

		if (t > k)
			return select(k, node.left);
		else if (t < k)
			return select(k - t - 1, node.right);
		else
			return node;
	}

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node node) {
		if (node == null)
			return 0;

		int cmp = key.compareTo(node.key);

		if (cmp == 0)
			return size(node.left);
		else if (cmp < 0)
			return rank(key, node.left);
		else
			return 1 + size(node.left) + rank(key, node.right);
	}
}