package es.uc3m.eda.list.doublelink;

import es.uc3m.eda.list.IListIterator;

public interface IDListIterator<E> extends IListIterator<E> {

	public DNode<E> getCurrentNode();
	
	public void movePrevious();

}
