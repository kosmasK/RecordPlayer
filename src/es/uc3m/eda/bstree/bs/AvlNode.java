package es.uc3m.eda.bstree.bs;

public class AvlNode<K extends Comparable<K>, E> extends BsNode<K, E> {
	public AvlNode(K key, E elem) {
		super(key, elem);
	}

	@Override
	public AvlNode<K, E> getLeftNode() {
		return (AvlNode<K, E>) this.leftNode;
	}

	@Override
	public AvlNode<K, E> getRightNode() {
		return (AvlNode<K, E>) this.rightNode;
	}

	/*
	 * Height management
	 */

	int height = 0;

	void updateHeight() {
		this.height = 0;
		if (this.leftNode != null) {
			this.height = Math.max(this.height, 1 + getLeftNode().height);
		}
		if (this.rightNode != null) {
			this.height = Math.max(this.height, 1 + getRightNode().height);
		}
	}
}
