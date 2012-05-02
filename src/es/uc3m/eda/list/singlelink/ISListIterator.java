package es.uc3m.eda.list.singlelink;

import es.uc3m.eda.list.IListIterator;

public interface ISListIterator<E> extends IListIterator<E> {

public SNode<E> getCurrentNode();
	
}
