package es.uc3m.eda.list;

public interface IStack<E> {

	public boolean isEmpty();

	public void push(E elem);

	public E pop();

	public E top();

}
