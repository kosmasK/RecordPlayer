package es.uc3m.eda.tree.integertree;

import es.uc3m.eda.list.singlelink.SList;
import es.uc3m.eda.tree.BSTNode;
import es.uc3m.eda.tree.BSTree;
import es.uc3m.eda.tree.view.BSTreeView;

public class IntegerTree extends BSTree<Integer, String> {
	public boolean containsKey(int key) {
		return containsKey(getRoot(), key);
	}

	private boolean containsKey(BSTNode<Integer, String> node, int key) {
		if (node == null)
			return false;
		if (key < node.getKey())
			return containsKey(node.getLeftChild(), key);
		if (key > node.getKey())
			return containsKey(node.getRightChild(), key);
		return true;
	}

	public boolean containsValue(String value) {
		return containsValue(getRoot(), value);
	}

	private boolean containsValue(BSTNode<Integer, String> node, String value) {
		if (node != null) {
			if (node.getElement().equals(value))
				return true;
			return containsValue(node.getLeftChild(), value)
					|| containsValue(node.getRightChild(), value);
		}
		return false;
	}

	public SList<Integer> getKeyRange(int key1, int key2) {
		SList<Integer> result = new SList<Integer>();
		getKeyRange(getRoot(), key1, key2, result);
		return result;
	}

	private void getKeyRange(BSTNode<Integer, String> node, int key1, int key2,
			SList<Integer> result) {
		if (node != null) {
			int key = node.getKey();
			if (key1 <= key)
				getKeyRange(node.getLeftChild(), key1, key2, result);
			if (key1 <= key && key <= key2)
				result.addLast(key);
			if (key <= key2)
				getKeyRange(node.getRightChild(), key1, key2, result);
		}

	}

	public SList<String> getValueRange(String value1, String value2) {
		SList<String> result = new SList<String>();
		getValueRange(getRoot(), value1, value2, result);
		return result;
	}

	private void getValueRange(BSTNode<Integer, String> node, String value1,
			String value2, SList<String> result) {
		if (node != null) {
			String value = node.getElement();
			getValueRange(node.getLeftChild(), value1, value2, result);
			if (value.compareTo(value1) >= 0 && value.compareTo(value2) <= 0)
				result.addLast(value);
			getValueRange(node.getRightChild(), value1, value2, result);
		}
	}

	public static void main(String[] args) {
		IntegerTree tree = new IntegerTree();
		tree.insert(13, "thirteen");
		tree.insert(3, "three");
		tree.insert(5, "five");
		tree.insert(20, "twenty");
		tree.insert(12, "twelve");
		tree.insert(30, "thirty");
		System.out.println(tree.containsKey(8));
		System.out.println(tree.containsKey(20));
		System.out.println(tree.containsValue("eight"));
		System.out.println(tree.containsValue("twenty"));
		System.out.println(tree.getKeyRange(5, 13));
		System.out.println(tree.getValueRange("h", "tzzz"));
		BSTreeView.draw(tree);
	}

}
