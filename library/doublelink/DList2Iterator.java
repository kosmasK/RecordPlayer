package es.uc3m.eda.list.doublelink;

import es.uc3m.eda.list.IListIterator;

public class DList2Iterator<E> implements IListIterator<E> {

	DList2<E> list;
	boolean reverse = false;

	DNode<E> currentNode;

	public DList2Iterator(DList2<E> list)	{
		this(list, false);
	}

	public DList2Iterator(DList2<E> list, boolean reverse) {
		this.list = list;
		this.reverse = false;
		if (reverse) {
			this.currentNode = this.list.lastNode;
		} else {
			this.currentNode = this.list.firstNode;
		}
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
