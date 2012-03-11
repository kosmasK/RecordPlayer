package es.uc3m.eda.list;

/**
 * Helper to iterate over a list
 * 
 * for (IListIterator<T> iterator = list.createIterator(); iterator.isValid();
 * iterator.moveNext()) { E elem = iterator.getCurrentElem(); .... }
 * 
 * @param <T>
 */

public interface IListIterator<E> {

	boolean isValid();

	E getCurrentElem();

	void moveNext();

}
