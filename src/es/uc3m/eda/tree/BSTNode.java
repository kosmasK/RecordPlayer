package es.uc3m.eda.tree;

import es.uc3m.eda.list.IList;
import es.uc3m.eda.list.singlelink.SList;

public class BSTNode<K extends Comparable<K>, E> implements IBSTNode<K, E>{
	K key;
	E element;
	BSTNode<K, E> parent;
	BSTNode<K, E> leftChild;
	BSTNode<K, E> rightChild;

	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public E getElement() {
		return this.element;
	}

	@Override
	public BSTNode<K, E> getParent() {
		return this.parent;
	}

	@Override
	public BSTNode<K, E> getLeftChild() {
		return this.leftChild;
	}

	@Override
	public BSTNode<K, E> getRightChild() {
		return this.rightChild;
	}

	public BSTNode(K key, E element) {
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
		this.key = key;
		this.element = element;
	}

	@Override
	public boolean hasLeftChild() {
		if (this.leftChild != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasRightChild() {
		if (this.rightChild != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isInternal() {
		if (this.leftChild == null && this.rightChild == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isExternal() {
		if (this.leftChild == null && this.rightChild == null) {
			return true;
		}
		return false;
	}

	@Override
	public IBSTNode<K, E> getRoot() {
		if (this.parent == null) {
			return this;
		} else {
			return this.parent.getRoot();
		}
	}

	@Override
	public boolean isRoot() {
		if (this.parent == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getSize() {
		return getSize(this);
	}

	int getSize(BSTNode<K, E> node) {
		if (node==null)
			return 0;
		else
			return 1 + getSize(node.leftChild) + getSize(node.rightChild);
	}

	@Override
	public int getHeight() {
		return getHeight(this);
	}

	static<K extends Comparable<K>,E>  int getHeight(BSTNode<K, E> node) {
		if (node==null)
			return -1;
		else
			return 1 + Math.max(getHeight(node.leftChild) , getHeight(node.rightChild));
	}

	@Override
	public int getDepth() {
		return getDepth(this);
	}

	static<K extends Comparable<K>,E>  int getDepth(BSTNode<K, E> node) {
		if (node==null) 
			return -1;
		else 
			return 1+getDepth(node.parent);
	}

	@Override
	public IList<IBSTNode<K, E>> getChildren() {
		IList<IBSTNode<K, E>> children = new SList<IBSTNode<K, E>>();
		if (hasLeftChild())
			children.addLast(this.leftChild);
		if (hasRightChild())
			children.addLast(this.rightChild);
		return children;
	}

	@Override
	public IList<E> getPreorder() {
		IList<E> list = new SList<E>();
		getPreorder(this,list);
		return list;
	}

	static<K extends Comparable<K>,E> void getPreorder(BSTNode<K, E> node, IList<E> list) {
		if (node == null)
			return;
		list.addLast(node.element);
		getPreorder(node.leftChild, list);
		getPreorder(node.rightChild, list);
	}

	static<K extends Comparable<K>,E> E getElementByKey(BSTNode<K, E> node, K key) {
		if (node==null) {
			return null;
		} else {
			if (key.equals(node.getKey()))
				return node.getElement();
			if (key.compareTo(node.getKey())<0)
				return getElementByKey(node.leftChild, key);
			else
				return getElementByKey(node.rightChild, key);
		}
	}
	
	static<K extends Comparable<K>,E> boolean containsKey(BSTNode<K, E> node, K key) {
		if (node==null) {
			return false;
		} else {
			if (key.equals(node.getKey()))
				return true;
			if (key.compareTo(node.getKey())<0)
				return containsKey(node.leftChild, key);
			else
				return containsKey(node.rightChild, key);
		}
	}

	static<K extends Comparable<K>,E> boolean containsElement(BSTNode<K, E> node, E element) {
		if (node==null) {
			return false;
		} else {
			return element.equals(node.getElement())
					|| containsElement(node.leftChild, element)
					|| containsElement(node.rightChild, element);
		}
	}


}
