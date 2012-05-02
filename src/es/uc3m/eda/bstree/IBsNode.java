package es.uc3m.eda.bstree;

public interface IBsNode<K extends Comparable<K>, E> {
	public K getKey();

	public E getElem();

	public IBsNode<K, E> getLeftNode();

	public IBsNode<K, E> getRightNode();

}
