package es.uc3m.eda.bstree.bs;

import es.uc3m.eda.bstree.IBsTree;

public class BsTree<K extends Comparable<K>, E> implements IBsTree<K, E> {
	BsNode<K, E> rootNode;

	@Override
	public BsNode<K, E> getRootNode() {
		return this.rootNode;
	}

	static boolean recursive = true;

	@Override
	public boolean isEmpty() {
		return this.rootNode == null;
	}

	@Override
	public void add(K key, E elem) {
		if (recursive) {
			this.rootNode = addRec(this.rootNode, key, elem);
		} else {
			addIt(key, elem);
		}
	}

	@Override
	public void remove(K key) {
		if (recursive) {
			this.rootNode = removeRec(this.rootNode, key);
		} else {
			removeIt(key);
		}
	}

	@Override
	public boolean containsKey(K key) {
		if (recursive) {
			return searchKeyRec(this.rootNode, key) != null;
		} else {
			return searchKeyIt(key) != null;
		}
	}

	@Override
	public E searchKey(K key) {
		if (recursive) {
			return searchKeyRec(this.rootNode, key);
		} else {
			return searchKeyIt(key);
		}
	}

	/*
	 * Recursive insertion, deletion, search
	 */

	private BsNode<K, E> addRec(BsNode<K, E> node, K key, E elem) {
		if (node == null) {
			return new BsNode<K, E>(key, elem);
		} else {
			int cmp = key.compareTo(node.getKey());
			if (cmp > 0) {
				node.rightNode = addRec(node.rightNode, key, elem);
			} else if (cmp < 0) {
				node.leftNode = addRec(node.leftNode, key, elem);
			} else {
				// throw new Exception("key already exists");
			}
			return node;
		}
	}

	private BsNode<K, E> removeRec(BsNode<K, E> node, K key) {
		if (node == null) {
			return null;
		} else {
			int cmp = key.compareTo(node.getKey());
			if (cmp > 0) {
				node.rightNode = removeRec(node.rightNode, key);
			} else if (cmp < 0) {
				node.leftNode = removeRec(node.leftNode, key);
			} else {
				//* case A - no left node (possibly no right node)
				if (node.leftNode == null) {
					return node.rightNode;
				}
				//* case B - no right node
				if (node.rightNode == null) {
					return node.leftNode;
				}
				//* case C - left and right nodes
				// 1. get midNode, the biggest node in the left branch
				BsNode<K, E> midNode = node.leftNode;
				BsNode<K, E> midNodeParent = null;
				while (midNode.rightNode!=null) {
					midNodeParent = midNode;
					midNode = midNode.rightNode;					
				}
				// 2. unlink midNode from the tree
				if (midNodeParent!=null) {
					midNodeParent.rightNode = null;
				}				
				// 3. link the new left and right branches to midNode
				midNode.leftNode = node.leftNode;
				midNode.rightNode = node.rightNode;
				// 4. return midNode as the new branch
				return midNode;				
			}
			return node;
		}
	}

	private E searchKeyRec(BsNode<K, E> node, K key) {
		if (node == null) {
			return null;
		} else {
			int cmp = key.compareTo(node.getKey());
			if (cmp > 0) {
				return searchKeyRec(node.rightNode, key);
			} else if (cmp < 0) {
				return searchKeyRec(node.leftNode, key);
			} else {
				return node.getElem();
			}
		}
	}

	/*
	 * Iterative insertion, deletion, search
	 */

	private void addIt(K key, E elem) {
		BsNode<K, E> newNode = new BsNode<K, E>(key, elem);
		BsNode<K, E> node = this.rootNode;
		if (node == null) {
			this.rootNode = newNode;
		} else {
			while (true) {
				int cmp = key.compareTo(node.getKey());
				if (cmp > 0) {
					if (node.rightNode == null) {
						node.rightNode = newNode;
						break;
					} else {
						node = node.rightNode;
					}
				} else if (cmp < 0) {
					if (node.leftNode == null) {
						node.leftNode = newNode;
						break;
					} else {
						node = node.leftNode;
					}
				} else {
					// throw new Exception("key already exists");
				}
			}
		}
	}

	private void removeIt(K key) {
		// TODO Not implemented!!	
	}

	private E searchKeyIt(K key) {
		BsNode<K, E> node = this.rootNode;
		while (node != null) {
			int cmp = key.compareTo(node.getKey());
			if (cmp > 0) {
				node = node.rightNode;
			} else if (cmp < 0) {
				node = node.leftNode;
			} else {
				return node.getElem();
			}
		}
		return null;
	}

	/*
	 * For debugging purposes
	 */

	public void show() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return toStringRec(this.rootNode);
	}

	public String toStringRec(BsNode<K, E> node) {
		if (node == null) {
			return "#";
		} else {
			// pre-order
			String str = "";
			str += "[" + node.getKey() + "]";
			str += toStringRec(node.leftNode);
			str += toStringRec(node.rightNode);
			return str;
		}
	}

}
