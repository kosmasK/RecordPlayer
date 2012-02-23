package es.uc3m.eda.list.doublelink;

import es.uc3m.eda.list.IList;
import es.uc3m.eda.list.IListIterator;

/**
 * A double-linked list class without sentinel nodes 
 */

public class DList2<E> implements IList<E> {

	DNode<E> firstNode = null;
	DNode<E> lastNode = null;

	@Override
	public void addFirst(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = this.firstNode;
		if (this.firstNode == null) {
			this.lastNode = newNode;
		} else {
			this.firstNode.previousNode = newNode;
		}
		this.firstNode = newNode;
	}

	@Override
	public void addLast(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.previousNode = this.lastNode;
		if (this.lastNode == null) {
			this.firstNode = newNode;
		} else {
			this.lastNode.nextNode = newNode;
		}
		this.lastNode = newNode;
	}

	@Override
	public void insertAt(int index, E elem) {
		int i = 0;
		for (DNode<E> nodeIt = this.firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				DNode<E> newNode = new DNode<E>(elem);
				if (nodeIt.previousNode == null) {
					this.firstNode = newNode;
				} else {
					nodeIt.previousNode.nextNode = newNode;
				}
				nodeIt.previousNode = newNode;
				newNode.nextNode = nodeIt;
				return;
			}
			++i;
		}
		if (i == index) {
			addLast(elem);
			return;
		}
		System.err.println("DLint: Insertion out of bounds");
	}

	@Override
	public boolean isEmpty() {
		return (this.firstNode == null);
	}

	@Override
	public boolean contains(E elem) {
		for (DNode<E> nodeIt = this.firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getIndexOf(E elem) {
		int index = 0;
		for (DNode<E> node = this.firstNode; node != null; node = node.nextNode) {
			if (node.getElement().equals(elem)) {
				return index;
			}
			++index;
		}
		return -1;
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.err.println("DList: List is empty");
			return;
		}
		this.firstNode = this.firstNode.nextNode;
		if (this.firstNode == null) {
			this.lastNode = null;
		} else {
			this.firstNode.previousNode = null;
		}
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.err.println("DList: List is empty");
			return;
		}
		this.lastNode = this.lastNode.previousNode;
		if (this.lastNode == null) {
			this.firstNode = null;
		} else {
			this.lastNode.nextNode = null;
		}
	}

	@Override
	public void removeAll(E elem) {
		for (DNode<E> nodeIt = this.firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				if (nodeIt.previousNode == null) {
					this.firstNode = nodeIt.nextNode;
				} else {
					nodeIt.previousNode.nextNode = nodeIt.nextNode;
				}
				if (nodeIt.nextNode == null) {
					this.lastNode = nodeIt.previousNode;
				} else {
					nodeIt.nextNode.previousNode = nodeIt.previousNode;
				}
			}
		}
	}

	@Override
	public void removeAt(int index) {
		int i = 0;
		for (DNode<E> nodeIt = this.firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				if (nodeIt.previousNode == null) {
					this.firstNode = nodeIt.nextNode;
				} else {
					nodeIt.previousNode.nextNode = nodeIt.nextNode;
				}
				if (nodeIt.nextNode == null) {
					this.lastNode = nodeIt.previousNode;
				} else {
					nodeIt.nextNode.previousNode = nodeIt.previousNode;
				}
				return;
			}
			++i;
		}
		System.err.println("DList: Deletion out of bounds");
	}

	@Override
	public int getSize() {
		int size = 0;
		for (DNode<E> node = this.firstNode; node != null; node = node.nextNode) {
			++size;
		}
		return size;
	}

	@Override
	public E getFirst() {
		if (this.firstNode == null) {
			System.err.println("DList: List is empty");
			return null;
		}
		return this.firstNode.getElement();
	}

	@Override
	public E getLast() {
		if (this.lastNode == null) {
			System.err.println("DList: List is empty");
			return null;
		}
		return this.lastNode.getElement();
	}

	@Override
	public E getAt(int index) {
		int i = 0;
		for (DNode<E> nodeIt = this.firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				return nodeIt.getElement();
			}
			++i;
		}
		System.err.println("DList: Get out of bounds");
		return null;
	}

	@Override
	public DList2Iterator<E> createIterator() {
		return new DList2Iterator<E>(this);
	}

	public DList2Iterator<E> createIterator(boolean reverse) {
		return new DList2Iterator<E>(this, reverse);
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

	public DNode<E> getFirstNode() {
		return this.firstNode;
	}

	public DNode<E> getLastNode() {
		return this.lastNode;
	}

	public static void main(String[] args) {
		// incomplete test
		IList<String> list = new DList2<String>();
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
