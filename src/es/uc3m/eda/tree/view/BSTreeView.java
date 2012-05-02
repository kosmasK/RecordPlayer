package es.uc3m.eda.tree.view;

/*
 * Adapted from:
 * 
 * Programming graphical user interfaces
 * Example: BinaryTreeView.java
 * Jarkko Leponiemi 2003
 */

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import es.uc3m.eda.tree.IBSTNode;
import es.uc3m.eda.tree.IBSTree;


/**
 * A class representing a graphical view of a binary tree.
 */
@SuppressWarnings("serial")
public class BSTreeView extends JPanel implements ActionListener {
	
	// the binary tree
	private IBSTree<?, ?> tree = null;
	// the node location of the tree
	private HashMap<IBSTNode<?, ?>, Rectangle> nodeLocations = null;
	// the sizes of the subtrees
	private HashMap<IBSTNode<?, ?>, Dimension> subtreeSizes = null;
	// do we need to calculate locations
	private boolean dirty = true;
	// space between nodes
	private int parent2child = 20, child2child = 30;
	
	// helpers
	private Dimension empty = new Dimension(0, 0);
	private FontMetrics fm = null;
	
	public BSTreeView(IBSTree<?, ?> tree) {
		this.tree = tree;
		this.nodeLocations = new HashMap<IBSTNode<?, ?>, Rectangle>();
		this.subtreeSizes = new HashMap<IBSTNode<?, ?>, Dimension>();

	}
	
	// event handler for pressing "A"
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("a")) {
			String c = JOptionPane.showInputDialog("Add a new node:");
			if (c != null && !"".equals(c)) {
				this.dirty = true;
				repaint();
			}
		}
	}
	
	// calculate node locations
	private void calculateLocations() {
		this.nodeLocations.clear();
		this.subtreeSizes.clear();
		IBSTNode<?, ?> root = this.tree.getRoot();
		if (root != null) {
			calculateSubtreeSize(root);
			calculateLocation(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
		}
	}
	
	// calculate the size of a subtree rooted at n
	private Dimension calculateSubtreeSize(IBSTNode<?, ?> n) {
		if (n == null) return new Dimension(0, 0);
		// String s = n.element.toString();
		Dimension ld = calculateSubtreeSize(n.getLeftChild());
		Dimension rd = calculateSubtreeSize(n.getRightChild());
		int h = this.fm.getHeight() + this.parent2child + Math.max(ld.height, rd.height);
		int w = ld.width + this.child2child + rd.width;
		Dimension d = new Dimension(w, h);
		this.subtreeSizes.put(n, d);
		return d;
	}
	
	// calculate the location of the nodes in the subtree rooted at n
	private void calculateLocation(IBSTNode<?, ?> n, int left, int right, int top) {
		if (n == null) return;
		Dimension ld = (Dimension) this.subtreeSizes.get(n.getLeftChild());
		if (ld == null) ld = this.empty;
		Dimension rd = (Dimension) this.subtreeSizes.get(n.getRightChild());
		if (rd == null) rd = this.empty;
		int center = 0;
		if (right != Integer.MAX_VALUE)
			center = right - rd.width - this.child2child/2;
		else if (left != Integer.MAX_VALUE)
			center = left + ld.width + this.child2child/2;
		int width = this.fm.stringWidth(n.getElement().toString());
		Rectangle r = new Rectangle(center - width/2 - 3, top, width + 6, this.fm.getHeight());
		this.nodeLocations.put(n, r);
		calculateLocation(n.getLeftChild(), Integer.MAX_VALUE, center - this.child2child/2, top + this.fm.getHeight() + this.parent2child);
		calculateLocation(n.getRightChild(), center + this.child2child/2, Integer.MAX_VALUE, top + this.fm.getHeight() + this.parent2child);
	}
	
	// draw the tree using the pre-calculated locations
	private void drawTree(Graphics2D g, IBSTNode<?, ?> n, int px, int py, int yoffs) {
		if (n == null) return;
		Rectangle r = (Rectangle) this.nodeLocations.get(n);
		g.draw(r);
		g.drawString(n.getElement().toString(), r.x + 3, r.y + yoffs);
		if (px != Integer.MAX_VALUE)
			g.drawLine(px, py, r.x + r.width/2, r.y);
		drawTree(g, n.getLeftChild(), r.x + r.width/2, r.y + r.height, yoffs);
		drawTree(g, n.getRightChild(), r.x + r.width/2, r.y + r.height, yoffs);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.fm = g.getFontMetrics();
		// if node locations not calculated
		if (this.dirty) {
			calculateLocations();
			this.dirty = false;
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(getWidth() / 2, this.parent2child);
		drawTree(g2d, this.tree.getRoot(), Integer.MAX_VALUE, Integer.MAX_VALUE, this.fm.getLeading() + this.fm.getAscent());
		this.fm = null;
	}
	
	@SuppressWarnings("deprecation")
	public static void draw(IBSTree<?, ?> tree) {
		JFrame f = new JFrame("BinaryTree");
		f.getContentPane().add(new BSTreeView(tree));
		f.setBounds(50, 50, 800, 500);
		f.show();
	}

	// @SuppressWarnings("deprecation")
	// public static void main(String[] args) {
	// IBSTree<?, ?> tree = new BSTree<Integer, Object>();
	// JFrame f = new JFrame("BinaryTree");
	// f.getContentPane().add(new BSTreeView(tree));
	// f.setBounds(50, 50, 500, 500);
	// f.show();
	// }
}
