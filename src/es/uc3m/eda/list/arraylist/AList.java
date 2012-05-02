package es.uc3m.eda.list.arraylist;

import es.uc3m.eda.list.IList;
import es.uc3m.eda.list.IListIterator;

public class AList<E> implements IList<E> {

	@SuppressWarnings("unchecked")
	E[] array = (E[]) new Object[0];

	@Override
	public void addFirst(E elem) {
		insertAt(0, elem);
	}

	@Override
	public void addLast(E elem) {
		insertAt(this.array.length, elem);
	}

	@Override
	public void insertAt(int index, E elem) {
		if (index < 0 || index > this.array.length) {
			System.out.println("AList: Insertion out of bounds");
			return;
		}
		@SuppressWarnings("unchecked")
		E[] a = (E[]) new Object[this.array.length + 1];
		for (int i = 0; i < index; ++i) {
			a[i] = this.array[i];
		}
		a[index] = elem;
		for (int i = index; i < this.array.length; ++i) {
			a[i + 1] = this.array[i];
		}
		this.array = a;
	}

	@Override
	public int getSize() {
		return this.array.length;
	}

	@Override
	public boolean isEmpty() {
		return (this.array.length == 0);
	}

	@Override
	public boolean contains(E elem) {
		for (int i = 0; i < this.array.length; ++i) {
			if (this.array[i].equals(elem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getIndexOf(E elem) {
		for (int i = 0; i < this.array.length; ++i) {
			if (this.array[i].equals(elem)) {
				return i;
			}
		}
		System.out.println("AList: Not found");
		return -1;
	}

	@Override
	public E getFirst() {
		if (this.array.length == 0) {
			System.out.println("AList: List is empty");
			return null;
		}
		return (E) this.array[0];
	}

	@Override
	public E getLast() {
		if (this.array.length == 0) {
			System.out.println("AList: List is empty");
			return null;
		}
		return (E) this.array[this.array.length - 1];
	}

	@Override
	public E getAt(int index) {
		if (index < 0 || index >= this.array.length) {
			System.out.println("AList: Get out of bounds");
			return null;
		}
		return this.array[index];
	}

	@Override
	public void removeFirst() {
		removeAt(0);
	}

	@Override
	public void removeLast() {
		removeAt(this.array.length - 1);
	}

	@Override
	public void removeAt(int index) {
		if (index < 0 || index > this.array.length) {
			System.out.println("AList: Deletion out of bounds");
			return;
		}
		@SuppressWarnings("unchecked")
		E[] a = (E[]) new Object[this.array.length - 1];
		for (int i = 0; i < index; ++i) {
			a[i] = this.array[i];
		}
		for (int i = index + 1; i < this.array.length; ++i) {
			a[i - 1] = this.array[i];
		}
		this.array = a;
	}

	@Override
	public void removeAll(E elem) {
		for (int i = 0; i < this.array.length; ++i) {
			if (this.array[i].equals(elem)) {
				removeAt(i);
			}
		}
	}

	@Override
	public AListIterator<E> createIterator() {
		return new AListIterator<E>(this);
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

}
