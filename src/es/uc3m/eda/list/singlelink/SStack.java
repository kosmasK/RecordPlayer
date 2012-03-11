package es.uc3m.eda.list.singlelink;

import es.uc3m.eda.list.IStack;

public class SStack<E> implements IStack<E> {
	SNode<E> topNode = null;

	@Override
	public boolean isEmpty() {
		return this.topNode == null;
	}

	@Override
	public void push(E newElem) {
		SNode<E> newNode = new SNode<E>(newElem);
		newNode.nextNode = this.topNode;
		this.topNode = newNode;
	}

	@Override
	public E pop() {
		if (this.topNode == null) {
			return null;
		}
		E elem = this.topNode.getElement();
		this.topNode = this.topNode.nextNode;
		return elem;
	}

	@Override
	public E top() {
		if (this.topNode == null) {
			return null;
		}
		return this.topNode.getElement();
	}

	@Override
	public String toString() {
		String result = null;
		for (SNode<E> nodeIt = this.topNode; nodeIt!=null; nodeIt = nodeIt.nextNode) {
			if (result == null) {
				result = "[" + nodeIt.getElement().toString() + "]";
			} else {
				result += "," + nodeIt.getElement().toString();
			}
		}
		return result == null?"empty":result;
	}

	public SNode<E> getTopNode() {
		return this.topNode;		
	}
	
}
