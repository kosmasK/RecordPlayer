package es.uc3m.recordplayer.logic;

import es.uc3m.eda.list.singlelink.SListIterator;
import es.uc3m.eda.tree.BSTNode;
import es.uc3m.eda.tree.BSTree;
//import es.uc3m.eda.tree.view.BSTreeView;

public class TrackTreeByTitle extends BSTree<String, Song> {
	
	//constructor
	public TrackTreeByTitle(TrackCollection collection){
		for(SListIterator<Song> iterator=collection.createIterator();iterator.isValid();iterator.moveNext()){
			insert(iterator.getCurrentElem().getTitle(),iterator.getCurrentElem());
		}
	}
	
	//method that shows the content of the tree InOrder Traversal
	public void showTrackTreeByTitleInOrder(){ 
		showTrackTreeByTitleInOrder(getRoot());
		//BSTreeView.draw(this);
	}
	
	private void showTrackTreeByTitleInOrder(BSTNode<String, Song> node){
		if (node != null) {
			showTrackTreeByTitleInOrder(node.getLeftChild());
	        System.out.print(node.getKey() + " \n");
	        showTrackTreeByTitleInOrder(node.getRightChild());
	    }
	}
	
	//method that returns if the tree contains a track with a given title
	public boolean containsTrackByTitle(String title){
		return containsTrackByTitle(getRoot(),title);
	}
	
	private boolean containsTrackByTitle(BSTNode<String, Song> node, String title) {
		if (node == null)
			return false;
		if (title.compareTo(node.getKey())<0)		
			return containsTrackByTitle(node.getLeftChild(), title);
		if (title.compareTo(node.getKey())>0)	
			return containsTrackByTitle(node.getRightChild(), title);
		return true;
	}
	
	//method that returns a track collection containing tracks that recorded between two years
	public TrackCollection tracksByYearsRange(int lowBound, int upperBound){
		TrackCollection collection= new TrackCollection();
		tracksByYearsRange(getRoot(), lowBound, upperBound, collection);
		return collection;
	}
	
	private void tracksByYearsRange(BSTNode<String, Song> node, int lowBound, int upperBound, TrackCollection collection){
		
			int key = node.getElement().getYear();
			if (lowBound <= key && key <= upperBound)
				collection.addLast(node.getElement());
			
			if (node.hasLeftChild())
				tracksByYearsRange(node.getLeftChild(), lowBound, upperBound, collection);
			
			if (node.hasRightChild())
				tracksByYearsRange(node.getRightChild(), lowBound, upperBound, collection);
		
	}
		
}
