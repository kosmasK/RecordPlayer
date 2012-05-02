package es.uc3m.eda.list.doublelink;

public class DNode<E> {

	DNode<E> previousNode = null;
	DNode<E> nextNode = null;

	E elem;

	public DNode<E> getPreviousNode() {
		return this.previousNode;
	}

	public DNode<E> getNextNode() {
		return this.nextNode;
	}

	public E getElement() {
		return this.elem;
	}

	public DNode(E elem) {
		this.elem = elem;
	}

}
