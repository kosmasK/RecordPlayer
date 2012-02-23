package es.uc3m.eda.list.doublelink;

import es.uc3m.eda.list.IListIterator;

public class DListIterator<E> implements IListIterator<E> {
	DList<E> list;
	boolean reverse = false;

	DNode<E> currentNode;

	public DListIterator(DList<E> list)	{
		this(list, false);
	}

	public DListIterator(DList<E> list, boolean reverse) {
		this.list = list;
		this.reverse = false;
		if (reverse) {
			this.currentNode = this.list.trailer.previousNode;
		} else {
			this.currentNode = this.list.header.nextNode;
		}
	}

	@Override
	public boolean isValid() {
		return (this.currentNode != this.list.header) && (this.currentNode != this.list.trailer);
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
			if (this.reverse) {
				this.currentNode = this.currentNode.previousNode;
			} else {
				this.currentNode = this.currentNode.nextNode;
			}
		}
	}

	public void movePrevious() {
		if (isValid()) {
			if (this.reverse) {
				this.currentNode = this.currentNode.nextNode;
			} else {
				this.currentNode = this.currentNode.previousNode;
			}
		}
	}
}
