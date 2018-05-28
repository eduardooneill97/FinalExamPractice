package dataStructures;

import java.util.Iterator;

public class SLIndexList<E> implements List<E>, Iterable<E> {
	
	private int size; 
	private SNode<E> first;
	
	public SLIndexList() {
		// TODO Auto-generated constructor stub
		first = null;
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		
		SNode<E> current = first;
		while(current != null) {
			if(current.getElement() == e)
				return true;
			current = current.getNext();
		}
		return false;
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
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(i>=size)
			throw new IndexOutOfBoundsException();
		
		return find(i).getElement();
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(i>=size)
			throw new IndexOutOfBoundsException();
		
		SNode<E> current = find(i);
		
		E etr = current.getElement();
		current.setElement(e);
		return etr;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(i>=size)
			throw new IndexOutOfBoundsException();
		if(i == 0) {
			E etr = first.getElement();
			first = first.getNext();
			size--;
			return etr;
		}
		
		SNode<E> prev = find(i-1);
		E etr = prev.getNext().getElement();
		prev.setNext(prev.getNext().getNext());
		size--;
		return etr;
	}

	@Override
	public E add(E e) {
		// TODO Auto-generated method stub
		return add(size, e);
	}

	@Override
	public E add(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(i>size)
			throw new IndexOutOfBoundsException();
		if(i == 0) {
			first = new SNode<E>(e, first);
			size++;
			return e;
		}
		SNode<E> prev = find(i-1);
		prev.setNext(new SNode<E>(e, prev.getNext()));
		size++;
		return e;
	}
	
	private SNode<E> find(int i) {
		SNode<E> current = first;
		for(int x = 0; x<i; x++)
			current = current.getNext();
		return current;
	}
	
	@Override
	public String toString() {
		String s = "{";
		
		SNode<E> current = first;
		while(current.getNext()!=null) {
			s+= current.getElement()+", ";
			current = current.getNext();
		}
		s+= current.getElement()+"}";
		return s;
	}
	
	private class SNode<E>{
		private E element;
		private SNode<E> next;
		public SNode(E e, SNode<E> next) {
			element = e;
			this.next = next;
		}
		public E getElement() {
			return element;
		}
		public E setElement(E e) {
			E etr = element;
			element = e;
			return etr;
		}
		public SNode<E> getNext() {
			return next;
		}
		public SNode<E> setNext(SNode<E> n) {
			SNode<E> etr = next;
			next = n;
			return etr;
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new SLListIterator<>(first);
	}
	
	private class SLListIterator<E> implements Iterator<E>{

		private SNode<E> current;
		
		public SLListIterator(SNode<E> firstN) {
			// TODO Auto-generated constructor stub
			current = firstN;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			E etr = current.getElement();
			current = current.getNext();
			return etr;
		}
		
	}

}
