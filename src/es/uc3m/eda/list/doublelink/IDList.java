package es.uc3m.eda.list.doublelink;


public interface IDList<E> {

	public IDListIterator<E> createIterator();

	public IDListIterator<E> createIterator(boolean reverse);

	public DNode<E> getFirstNode();

	public DNode<E> getLastNode();

	public DNode<E> getHeader();

	public DNode<E> getTrailer();

}
