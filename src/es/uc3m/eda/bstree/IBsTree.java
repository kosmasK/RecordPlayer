package es.uc3m.eda.bstree;

public interface IBsTree<K extends Comparable<K>, E> {
	public IBsNode<K, E> getRootNode();

	public boolean isEmpty();

	public void add(K key, E elem);

	public void remove(K key);

	public boolean containsKey(K key); 

	public E searchKey(K key); 
}
