package es.uc3m.eda.list.doublelink;

import es.uc3m.eda.list.IList;
import es.uc3m.eda.list.IListIterator;

/**
 * A double-linked list class with sentinel nodes 
 */

public class DList<E> implements IList<E>, IDList<E> {

	DNode<E> header;
	DNode<E> trailer;

	public DList() {
		this.header=new DNode<E>(null);
		this.trailer=new DNode<E>(null);
		this.header.nextNode = this.trailer;
		this.trailer.previousNode = this.header;				
	}
	
	@Override
	public void addFirst(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode =this.header.nextNode;
		newNode.previousNode =this.header;
		this.header.nextNode.previousNode = newNode;
		this.header.nextNode = newNode;
	}

	@Override
	public void addLast(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode =this.trailer;
		newNode.previousNode =this.trailer.previousNode;
		this.trailer.previousNode.nextNode= newNode;
		this.trailer.previousNode = newNode;
	}

	@Override
	public void insertAt(int index, E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		int i = 0;
		for (DNode<E> nodeIt = this.header; nodeIt != this.trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				newNode.nextNode = nodeIt.nextNode; 
				newNode.previousNode = nodeIt.previousNode; 
				nodeIt.nextNode.previousNode = newNode;				
				nodeIt.nextNode = newNode;				
				return;
			}
			++i;
		}
		System.out.println("DList: Insertion out of bounds");
	}

	@Override
	public boolean isEmpty() {
		return (this.header.nextNode == this.trailer);
	}

	@Override
	public boolean contains(E elem) {
		for (DNode<E> nodeIt = this.header.nextNode; nodeIt != this.trailer; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getIndexOf(E elem) {
		int index = 0;
		for (DNode<E> nodeIt = this.header.nextNode; nodeIt != this.trailer; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				return index;
			}
			++index;
		}
		return -1;
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		this.header.nextNode = this.header.nextNode.nextNode; 
		this.header.nextNode.previousNode = this.header; 
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		this.trailer.previousNode = this.trailer.previousNode.previousNode; 
		this.trailer.previousNode.nextNode = this.trailer; 
	}

	@Override
	public void removeAll(E elem) {
		for (DNode<E> nodeIt = this.header.nextNode; nodeIt != this.trailer; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				nodeIt.previousNode.nextNode = nodeIt.nextNode;
				nodeIt.nextNode.previousNode= nodeIt.previousNode;
			}
		}
	}

	@Override
	public void removeAt(int index) {
		int i = 0;
		for (DNode<E> nodeIt = this.header.nextNode; nodeIt != this.trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				nodeIt.previousNode.nextNode = nodeIt.nextNode;
				nodeIt.nextNode.previousNode= nodeIt.previousNode;
				return;
			}
			++i;
		}
		System.out.println("DList: Deletion out of bounds");
	}

	@Override
	public int getSize() {
		int size = 0;
		for (DNode<E> nodeIt = this.header.nextNode; nodeIt != this.trailer; nodeIt = nodeIt.nextNode) {
			++size;
		}
		return size;
	}

	@Override
	public E getFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return null;
		}
		return this.header.nextNode.getElement();
	}

	@Override
	public E getLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return null;
		}
		return this.trailer.previousNode.getElement();
	}

	@Override
	public E getAt(int index) {
		int i = 0;
		for (DNode<E> nodeIt = this.header.nextNode; nodeIt != this.trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				return nodeIt.getElement();
			}
			++i;
		}
		System.out.println("DList: Get out of bounds");
		return null;
	}

	@Override
	public DListIterator<E> createIterator() {
		return new DListIterator<E>(this);
	}

	@Override
	public DListIterator<E> createIterator(boolean reverse) {
		return new DListIterator<E>(this, reverse);
	}

	@Override
	public String toString() {
		String result = null;
		for (IListIterator<E> iterator = createIterator(); iterator.isValid(); iterator
				.moveNext()) {
			if (result == null) {
				result = iterator.getCurrentElem().toString();
			} else {
				result += "," + iterator.getCurrentElem().toString();
			}
		}
		return result == null ? "empty" : result;
	}
	
	@Override
	public DNode<E> getFirstNode() {
		return this.header.nextNode;
	}

	@Override
	public DNode<E> getLastNode() {
		return this.trailer.previousNode;
	}

	@Override
	public DNode<E> getHeader() {
		return this.header;
	}

	@Override
	public DNode<E> getTrailer() {
		return this.trailer;
	}

	public static void main(String[] args) {
		// incomplete test
		IList<String> list = new DList<String>();
		System.out.println(list);
		list.addLast("1");
		System.out.println(list);
		list.addFirst("2");
		System.out.println(list);
		list.addFirst("3");
		System.out.println(list);
		list.addLast("4");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}
}
