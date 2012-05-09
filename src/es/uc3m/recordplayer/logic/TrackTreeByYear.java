package es.uc3m.recordplayer.logic;

import es.uc3m.eda.list.singlelink.SListIterator;
import es.uc3m.eda.tree.BSTNode;
import es.uc3m.eda.tree.BSTree;
//import es.uc3m.eda.tree.view.BSTreeView;

public class TrackTreeByYear extends BSTree<Integer, Song> {
	
	//constructor
	public TrackTreeByYear(TrackCollection collection){
		for(SListIterator<Song> iterator=collection.createIterator();iterator.isValid();iterator.moveNext()){
			insert(iterator.getCurrentElem().getYear(),iterator.getCurrentElem());
		}
	}
	
	//method that shows the content of the tree
	public void showTrackTreeByYearInOrder(){
		showTrackTreeByYearInOrder(getRoot());
		//BSTreeView.draw(this);
	}
	
	private void showTrackTreeByYearInOrder(BSTNode<Integer, Song> node){
		if (node != null) {
			showTrackTreeByYearInOrder(node.getLeftChild());
	        System.out.print(node.getElement().getTitle() + " \n");
	        showTrackTreeByYearInOrder(node.getRightChild());
	    }
	}
	
	//method that returns if the tree contains a track with a given title
	public boolean containsTrackByTitle(String title){   // <======== is it correct?
		return containsTrackByTitle(getRoot(),title);
	}
	
	private boolean containsTrackByTitle(BSTNode<Integer, Song> node, String title) {
		if (node == null)
			return false;
		if (title.compareToIgnoreCase(node.getElement().getTitle())<0)	{	
			System.out.println("!!!!!"+node.getElement().getTitle()+"\n");
			return containsTrackByTitle(node.getLeftChild(), title);}
		if (title.compareToIgnoreCase(node.getElement().getTitle())>0)	{
			System.out.println("!!!!!"+node.getElement().getTitle()+"\n");

			return containsTrackByTitle(node.getRightChild(), title);}
		return true;
	}
	
	//method that returns a track collection containing tracks that recorded between two years
	public TrackCollection tracksByYearsRange(int lowBound, int upperBound){
		TrackCollection collection= new TrackCollection();
		getYearRange(getRoot(), lowBound, upperBound, collection);
		return collection;
	}
		
	private void getYearRange(BSTNode<Integer, Song> node, int key1, int key2, TrackCollection result){
		if (node != null) {
			int key = node.getKey();
			if (key1 <= key && key <= key2)
				result.addLast(node.getElement());
			
			if (node.hasLeftChild())
				getYearRange(node.getLeftChild(), key1, key2, result);
			
			if (node.hasRightChild())
				getYearRange(node.getRightChild(), key1, key2, result);
		}
	}
	
}
