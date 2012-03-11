package es.uc3m.eda.list.singlelink;

import es.uc3m.eda.list.IListIterator;

public class SListIterator<E> implements IListIterator<E> {

	SList<E> list;

	SNode<E> currentNode;

	public SListIterator(SList<E> list) {
		this.list = list;
		this.currentNode = list.firstNode;
	}

	@Override
	public boolean isValid() {
		return this.currentNode != null;
	}

	@Override
	public E getCurrentElem() {
		if (this.currentNode != null) {
			return this.currentNode.getElement();
		}
		return null;
	}

	@Override
	public void moveNext() {
		if (isValid()) {
			this.currentNode = this.currentNode.nextNode;
		}
	}

}
