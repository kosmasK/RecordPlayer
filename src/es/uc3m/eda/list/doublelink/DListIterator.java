package es.uc3m.eda.list.doublelink;

public class DListIterator<E> implements IDListIterator<E> {
	IDList<E> list;
	boolean reverse = false;

	DNode<E> currentNode;

	public DListIterator(IDList<E> list) {
		this(list, false);
	}

	public DListIterator(IDList<E> list, boolean reverse) {
		this.list = list;
		this.reverse = false;
		if (reverse) {
			this.currentNode = this.list.getTrailer().previousNode;
		} else {
			this.currentNode = this.list.getHeader().nextNode;
		}
	}

	@Override
	public boolean isValid() {
		return (this.currentNode != this.list.getHeader())
				&& (this.currentNode != this.list.getTrailer())
				&& (this.currentNode != null);
	}


	@Override
	public DNode<E> getCurrentNode() {
		return this.currentNode;
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

	@Override
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
