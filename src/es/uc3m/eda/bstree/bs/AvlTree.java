package es.uc3m.eda.bstree.bs;

public class AvlTree<K extends Comparable<K>, E> extends BsTree<K, E> {
	@Override
	public AvlNode<K, E> getRootNode() {
		return (AvlNode<K, E>) this.rootNode;
	}

	@Override
	public void add(K key, E elem) {
		this.rootNode = addRec((AvlNode<K, E>) this.rootNode, key, elem);
	}

	/*
	 * Recursive AVL insertion, (deletion not implemented as AVL)
	 */

	private AvlNode<K, E> addRec(AvlNode<K, E> node, K key, E elem) {
		if (node == null) {
			AvlNode<K, E> newNode = new AvlNode<K, E>(key, elem);
			return newNode;
		} else {
			int cmp = key.compareTo(node.getKey());
			if (cmp > 0) {
				node.rightNode = addRec(node.getRightNode(), key, elem);
				node.updateHeight();
				node = balanceRight(node);
			} else if (cmp < 0) {
				node.leftNode = addRec(node.getLeftNode(), key, elem);
				node.updateHeight();
				node = balanceLeft(node);
			} else {
				// throw new Exception("key already exists");
			}
			return node;
		}
	}

	private AvlNode<K, E> balanceLeft(AvlNode<K, E> node) {
		AvlNode<K, E> leftNode = (AvlNode<K, E>) node.leftNode;
		AvlNode<K, E> rightNode = (AvlNode<K, E>) node.rightNode;
		int leftHeight = (leftNode == null) ? 0 : leftNode.height;
		int rightHeight = (rightNode == null) ? 0 : rightNode.height;
		if (leftHeight > rightHeight + 1) {
			AvlNode<K, E> leftLeftNode = (AvlNode<K, E>) leftNode.leftNode;
			AvlNode<K, E> leftRightNode = (AvlNode<K, E>) leftNode.rightNode;
			int leftLeftHeight = (leftLeftNode == null) ? 0
					: leftLeftNode.height;
			int leftRightHeight = (leftRightNode == null) ? 0
					: leftRightNode.height;
			if (leftLeftHeight > leftRightHeight) {
				node = balanceLeftLeft(node);
			} else {
				node = balanceLeftRight(node);
			}
		}
		return node;
	}

	private AvlNode<K, E> balanceRight(AvlNode<K, E> node) {
		AvlNode<K, E> leftNode = (AvlNode<K, E>) node.leftNode;
		AvlNode<K, E> rightNode = (AvlNode<K, E>) node.rightNode;
		int leftHeight = (leftNode == null) ? 0 : leftNode.height;
		int rightHeight = (rightNode == null) ? 0 : rightNode.height;
		if (rightHeight > leftHeight + 1) {
			AvlNode<K, E> rightLeftNode = (AvlNode<K, E>) rightNode.leftNode;
			AvlNode<K, E> rightRightRight = (AvlNode<K, E>) rightNode.rightNode;
			int rightLeftHeight = (rightLeftNode == null) ? 0
					: rightLeftNode.height;
			int rightRightHeight = (rightRightRight == null) ? 0
					: rightRightRight.height;
			if (rightLeftHeight > rightRightHeight) {
				node = balanceRightLeft(node);
			} else {
				node = balanceRightRight(node);
			}
		}
		return node;
	}

	private AvlNode<K, E> balanceLeftLeft(AvlNode<K, E> node) {
		AvlNode<K, E> node6 = node;
		AvlNode<K, E> node4 = (AvlNode<K, E>) node6.leftNode;
		AvlNode<K, E> node2 = (AvlNode<K, E>) node4.leftNode;
		AvlNode<K, E> node7 = (AvlNode<K, E>) node6.rightNode;
		AvlNode<K, E> node5 = (AvlNode<K, E>) node4.rightNode;
		AvlNode<K, E> node3 = (AvlNode<K, E>) node2.rightNode;
		AvlNode<K, E> node1 = (AvlNode<K, E>) node2.leftNode;
		node2.leftNode = node1;
		node2.rightNode = node3;
		node2.updateHeight();
		node6.leftNode = node5;
		node6.rightNode = node7;
		node6.updateHeight();
		node4.leftNode = node2;
		node4.rightNode = node6;
		node4.updateHeight();
		return node4;
	}

	private AvlNode<K, E> balanceLeftRight(AvlNode<K, E> node) {
		AvlNode<K, E> node6 = node;
		AvlNode<K, E> node2 = (AvlNode<K, E>) node6.leftNode;
		AvlNode<K, E> node4 = (AvlNode<K, E>) node2.rightNode;
		AvlNode<K, E> node7 = (AvlNode<K, E>) node6.rightNode;
		AvlNode<K, E> node5 = (AvlNode<K, E>) node4.rightNode;
		AvlNode<K, E> node3 = (AvlNode<K, E>) node4.leftNode;
		AvlNode<K, E> node1 = (AvlNode<K, E>) node2.leftNode;
		node2.leftNode = node1;
		node2.rightNode = node3;
		node2.updateHeight();
		node6.leftNode = node5;
		node6.rightNode = node7;
		node6.updateHeight();
		node4.leftNode = node2;
		node4.rightNode = node6;
		node4.updateHeight();
		return node4;
	}

	private AvlNode<K, E> balanceRightLeft(AvlNode<K, E> node) {
		AvlNode<K, E> node2 = node;
		AvlNode<K, E> node6 = (AvlNode<K, E>) node2.rightNode;
		AvlNode<K, E> node4 = (AvlNode<K, E>) node6.leftNode;
		AvlNode<K, E> node1 = (AvlNode<K, E>) node2.leftNode;
		AvlNode<K, E> node3 = (AvlNode<K, E>) node4.leftNode;
		AvlNode<K, E> node5 = (AvlNode<K, E>) node4.rightNode;
		AvlNode<K, E> node7 = (AvlNode<K, E>) node6.rightNode;
		node2.leftNode = node1;
		node2.rightNode = node3;
		node2.updateHeight();
		node6.leftNode = node5;
		node6.rightNode = node7;
		node6.updateHeight();
		node4.leftNode = node2;
		node4.rightNode = node6;
		node4.updateHeight();
		return node4;
	}

	private AvlNode<K, E> balanceRightRight(AvlNode<K, E> node) {
		AvlNode<K, E> node2 = node;
		AvlNode<K, E> node4 = (AvlNode<K, E>) node2.rightNode;
		AvlNode<K, E> node6 = (AvlNode<K, E>) node4.rightNode;
		AvlNode<K, E> node1 = (AvlNode<K, E>) node2.leftNode;
		AvlNode<K, E> node3 = (AvlNode<K, E>) node4.leftNode;
		AvlNode<K, E> node5 = (AvlNode<K, E>) node6.leftNode;
		AvlNode<K, E> node7 = (AvlNode<K, E>) node6.rightNode;
		node2.leftNode = node1;
		node2.rightNode = node3;
		node2.updateHeight();
		node6.leftNode = node5;
		node6.rightNode = node7;
		node6.updateHeight();
		node4.leftNode = node2;
		node4.rightNode = node6;
		node4.updateHeight();
		return node4;
	}

}
