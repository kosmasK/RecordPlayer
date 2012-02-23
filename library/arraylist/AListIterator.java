package es.uc3m.eda.list.arraylist;

import es.uc3m.eda.list.IList;
import es.uc3m.eda.list.IListIterator;

public class AListIterator<E> implements IListIterator<E> {

	AList<E> list;

	int currentIndex;

	public AListIterator(AList<E> list) {
		this.list = list;
		this.currentIndex = 0;
	}

	@Override
	public boolean isValid() {
		return this.currentIndex >= 0
				&& this.currentIndex < this.list.array.length;
	}

	@Override
	public E getCurrentElem() {
		if (this.currentIndex >= 0
				&& this.currentIndex < this.list.array.length) {
			return (E) this.list.array[this.currentIndex];
		}
		return null;
	}

	@Override
	public void moveNext() {
		if (isValid()) {
			++this.currentIndex;
		}
	}

	
	public static void main(String[] args) {
		// incomplete test
		IList<String> list = new AList<String>();
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
