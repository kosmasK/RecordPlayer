package es.uc3m.eda.tree;

import es.uc3m.eda.list.IList;

public interface IBSTree<K extends Comparable<K>, E>{
	
	public IBSTNode<K,E> getRoot() ;

	public void insert(K key, E elem);

	public void remove(K key);
	
	public E getElementByKey (K key);
	
	public IList<E> getPreorder();

	public boolean containsKey(K key);

	public boolean containsElement(E element);

}
