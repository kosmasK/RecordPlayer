package es.uc3m.eda.bstree.bs;

import es.uc3m.eda.bstree.IBsNode;

public class BsNode<K extends Comparable<K>, E> implements IBsNode<K, E> {
	private K key;
	private E elem;

	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public E getElem() {
		return this.elem;
	}

	BsNode<K, E> leftNode;
	BsNode<K, E> rightNode;

	@Override
	public BsNode<K, E> getLeftNode() {
		return this.leftNode;
	}

	@Override
	public BsNode<K, E> getRightNode() {
		return this.rightNode;
	}

	public BsNode(K key, E elem) {
		this.key = key;
		this.elem = elem;
	}

	/*
	 * For debugging purposes
	 */

	@Override
	public String toString() {
		// return "[" + this.key.toString() + "]";
		return "[" + this.elem.toString() + "]";
	}

}
