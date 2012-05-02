package es.uc3m.eda.list.singlelink;


public interface ISList<E> {

	public ISListIterator<E> createIterator();

	public SNode<E> getFirstNode();

}
