package es.uc3m.eda.list.singlelink;

public class SNode<E> {

	SNode<E> nextNode = null;

	E elem;

	public SNode<E> getNextNode() {
		return this.nextNode;
	}

	public E getElement() {
		return this.elem;
	}

	public SNode(E e) {
		this.elem = e;
	}

}
