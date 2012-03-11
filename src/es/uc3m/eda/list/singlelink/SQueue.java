package es.uc3m.eda.list.singlelink;

import es.uc3m.eda.list.IQueue;

public class SQueue<E> implements IQueue<E> {
	private SNode<E> frontNode;
	private SNode<E> tailNode;

	@Override
	public boolean isEmpty() {
		return this.frontNode == null;
	}

	@Override
	public void enqueue(E elem) {
		SNode<E> node = new SNode<E>(elem);
		if (this.tailNode == null) {
			this.frontNode = node;
		} else {
			this.tailNode.nextNode = node;
		}
		this.tailNode = node;
	}

	@Override
	public E dequeue() {
		if (this.frontNode == null) {
			return null;
		} else {
			E firstObj = this.frontNode.getElement();
			this.frontNode = this.frontNode.nextNode;
			if (this.frontNode == null) {
				this.tailNode = null;
			}
			return firstObj;
		}
	}

	@Override
	public E front() {
		return this.frontNode.getElement();
	}


	@Override
	public String toString() {
		String result = null;
		for (SNode<E> nodeIt = this.frontNode; nodeIt!=null; nodeIt = nodeIt.nextNode) {
			if (result == null) {
				result = "[" + nodeIt.getElement().toString() + "]";
			} else {
				result += "," + nodeIt.getElement().toString();
			}
		}
		return result == null?"empty":result;
	}
	
	public SNode<E> getFrontNode() {
		return this.frontNode;		
	}
	
	public SNode<E> getTailNode() {
		return this.tailNode;		
	}
	
}
