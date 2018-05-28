package dataStructures;

import java.util.Iterator;

import org.w3c.dom.views.AbstractView;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E>{
	
	protected Node<E> root = null;
	private int size = 0;
	
	public LinkedBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getRight();
	}

	@Override
	public Position<E> root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node.getParent();
	}

	@Override
	public boolean isRoot(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		return node == root;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node(e, parent, left, right);
	}
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node))
			throw new IllegalArgumentException();
		Node<E> node = (Node<E>) p;
		if(node.getParent() == node)
			throw new IllegalArgumentException();
		return node;
	}

	private class Node<E> implements Position<E>{
		private E element;
		private Node<E> left, right, parent;
		
		public Node(E e, Node<E> parent, Node<E> left, Node<E> right) {
			element = e;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		@Override
		public E getElement() {
			// TODO Auto-generated method stub
			return element;
		}
		public Node<E> getLeft() {
			return left;
		}
		public void setLeft(Node<E> left) {
			this.left = left;
		}
		public Node<E> getRight() {
			return right;
		}
		public void setRight(Node<E> right) {
			this.right = right;
		}
		public void setElement(E element) {
			this.element = element;
		}
		public Node<E> getParent() {
			return parent;
		}
		public void setParent(Node<E> parent) {
			this.parent = parent;
		}
		
	}

	@Override
	public Position<E> addRoot(E e) throws IllegalStateException{
		// TODO Auto-generated method stub
		if(root != null)
			throw new IllegalStateException();
		size++;
		root = createNode(e, null, null, null);
		return root;
	}

	@Override
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		if(node.getLeft()!=null)
			throw new IllegalArgumentException();
		node.setLeft(createNode(e, node, null, null));
		size++;
		return node.getLeft();
	}

	@Override
	public Position<E> addRight(Position<E> p, E e)  throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		if(node.getRight()!=null)
			throw new IllegalArgumentException();
		node.setRight(createNode(e, node, null, null));
		size++;
		return node.getRight();
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		E etr = node.getElement();
		node.setElement(e);
		return etr;
	}

	@Override
	public E remove(Position<E> p)  throws IllegalArgumentException{
		// TODO Auto-generated method stub
		Node<E> node = validate(p);
		if(numChildren(node) == 2)
			throw new IllegalArgumentException();
		Node<E> child = (node.getLeft()!=null ? node.getLeft():node.getRight());
		if(child!=null)
			child.setParent(node.getParent());
		if(p == root)
			root = child;
		else {
			Node<E> parent = node.getParent();
			if(node == parent.getLeft())
				parent.setLeft(child);
			else 
				parent.setRight(child);
		}
		size--;
		E etr = node.getElement();
		node.setElement(null);
		node.setParent(node);
		node.setLeft(null);
		node.setRight(null);
		return etr;
	}
}
