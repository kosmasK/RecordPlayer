package es.uc3m.eda.tree;

import es.uc3m.eda.list.IList;
import es.uc3m.eda.list.singlelink.SList;
import es.uc3m.eda.tree.view.BSTreeView;

public class BSTree<K extends Comparable<K>, E> implements IBSTree<K, E> {
	BSTNode<K, E> root;

	public BSTree() {
		this.root = null;
	}

	public BSTree(BSTNode<K, E> node) {
		this.root = node;
	}

	@Override
	public BSTNode<K, E> getRoot() {
		return this.root;
	}

	@Override
	public void insert(K key, E elem) {
		BSTNode<K, E> newNode = new BSTNode<K, E>(key, elem);
		if (this.root == null) {
			this.root = newNode;
			return;
		}
		insert(newNode, this.root);
	}

	private void insert(BSTNode<K, E> newNode, BSTNode<K, E> node) {
		K key = newNode.key;
		// if (key.compareTo(node.key) == 0) {
		// System.out
		// .println("Cannot insert, the key already exists");
		// return;
		// }
		if (key.compareTo(node.key) < 0) {
			if (node.leftChild == null) {
				node.leftChild = newNode;
				newNode.parent = node;
				return;
			} else {
				insert(newNode, node.leftChild);
			}
		} else {
			if (node.rightChild == null) {
				node.rightChild = newNode;
				newNode.parent = node;
				return;
			} else {
				insert(newNode, node.rightChild);
			}
		}
	}

	@Override
	public E getElementByKey(K key) {
		return BSTNode.getElementByKey(this.root, key);
	}

	@Override
	public void remove(K key) {
		if (this.root == null) {
			System.out.println("Cannot remove: The tree is empty");
			return;
		}
		this.root = remove(key, this.root);
	}

	private BSTNode<K, E> remove(K key, BSTNode<K, E> node) {
		if (node == null) {
			System.out.println("Cannot remove: The key doesn't exist");
			return null;
		}
		if (key.equals(node.key)) {
			if (!node.hasLeftChild() && !node.hasRightChild()) {
				return null;
			}
			if (!node.hasLeftChild()) {
				node.rightChild.parent = node.parent;
				return node.rightChild;
			}
			if (!node.hasRightChild()) {
				node.leftChild.parent = node.parent;
				return node.leftChild;
			}
			// Get the predecessor
			BSTNode<K, E> predecessorNode = node.leftChild;
			while (predecessorNode.hasRightChild()) {
				predecessorNode = predecessorNode.rightChild;
			}
			// Remove the predecessor from the subtree
			BSTNode<K, E> leftNode = remove(predecessorNode.key, node.leftChild);
			BSTNode<K, E> rightNode = node.rightChild;
			// The predecessor is the new root, set its parent and subtrees
			predecessorNode.parent = node.parent;
			predecessorNode.leftChild = leftNode;
			if (leftNode != null)
				leftNode.parent = predecessorNode;
			predecessorNode.rightChild = rightNode;
			if (rightNode != null)
				rightNode.parent = predecessorNode;
			// Return the predecessor
			return predecessorNode;
		}
		if (key.compareTo(node.key) < 0) {
			node.leftChild = remove(key, node.leftChild);
			return node;
		} else {
			node.rightChild = remove(key, node.rightChild);
			return node;
		}
	}

	@Override
	public IList<E> getPreorder() {
		IList<E> list = new SList<E>();
		BSTNode.getPreorder(this.root, list);
		return list;
	}

	@Override
	public boolean containsKey(K key) {
		return BSTNode.containsKey(this.root, key);
	}

	@Override
	public boolean containsElement(E element) {
		return BSTNode.containsElement(this.root, element);
	}

	/*
	 * Methods used to check the tree is well constructed
	 */
	
	// private void checkParents() {
	// if (this.root != null && this.root.parent != null)
	// System.out.println("checkParents: Error - root");
	// checkParents(this.root);
	// }
	//
	// private void checkParents(BSTNode<K, E> node) {
	// if (node == null)
	// return;
	// if (node.hasLeft() && node.leftNode.parent != node)
	// System.out.println("checkParents: Error - node.leftNode - "
	// + node.key);
	// if (node.hasRight() && node.rightNode.parent != node)
	// System.out
	// .println("checkParents: Error - node.rightNode - " + node.key);
	// checkParents(node.leftNode);
	// checkParents(node.rightNode);
	// }
	
	@SuppressWarnings("boxing")
	public static void main(String args[]) {
	
		IBSTree<Integer, String> bstree = new BSTree<Integer, String>();
	
		bstree.insert(19, "19");
		bstree.insert(12, "12");
		bstree.insert(16, "16");
		bstree.insert(23, "23");
		bstree.insert(20, "20");
		bstree.insert(34, "34");
		// bstree.checkParents();
	
		bstree.remove(19);
		// bstree.checkParents();
	
		bstree.remove(16);
		// bstree.checkParents();
	
		BSTreeView.draw(bstree);
	
		IList<String> preorderList = bstree.getPreorder();
		System.out.println(preorderList);
	
	}

}
