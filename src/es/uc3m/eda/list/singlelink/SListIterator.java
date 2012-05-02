package es.uc3m.eda.list.singlelink;


public class SListIterator<E> implements ISListIterator<E> {

	ISList<E> list;

	SNode<E> currentNode;

	public SListIterator(ISList<E> list) {
		this.list = list;
		this.currentNode = list.getFirstNode();
	}

	@Override
	public boolean isValid() {
		return this.currentNode != null;
	}

	@Override
	public SNode<E> getCurrentNode() {
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
			this.currentNode = this.currentNode.nextNode;
		}
	}

}
