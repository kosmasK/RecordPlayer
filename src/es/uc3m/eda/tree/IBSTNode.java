package es.uc3m.eda.tree;

import es.uc3m.eda.list.IList;

public interface IBSTNode<K extends Comparable<K>, E> {
	public K getKey();
	public E getElement();
	public IBSTNode<K, E> getParent();
	public IBSTNode<K, E> getLeftChild();
	public IBSTNode<K, E> getRightChild();
	public boolean hasLeftChild();
	public boolean hasRightChild();
	public boolean isInternal();
	public boolean isExternal();
	public IBSTNode<K, E> getRoot();
	public boolean isRoot();
	public int getSize();
	public int getHeight();
	public int getDepth();
	public IList<IBSTNode<K, E>> getChildren();
	public IList<E> getPreorder();
}
