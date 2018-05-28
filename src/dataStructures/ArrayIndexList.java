package dataStructures;

import java.util.Iterator;

public class ArrayIndexList<E> implements List<E>, Iterable<E>{
	
	private static final int DC = 20;
	private int size;
	private E[] elements;
	
	public ArrayIndexList() {
		// TODO Auto-generated constructor stub
		elements = (E[]) new Object[DC];
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		for(int i = 0; i<size; i++) {
			if(elements[i] == e)
				return true;
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
		return size()==0;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(i>=size)
			throw new IndexOutOfBoundsException();
		return elements[i];
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(i>=size)
			throw new IndexOutOfBoundsException();
		
		E etr = elements[i];
		elements[i] = e;
		return etr;
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(i>=size)
			throw new IndexOutOfBoundsException();
		
		E etr = elements[i];
		for(int x = i+1; x<size; x++) {
			elements[x-1] = elements[x];
		}
		elements[size-1] = null;
		size--;
		return etr;
	}

	@Override
	public E add(E e) {
		// TODO Auto-generated method stub
		if(size>=elements.length)
			changeCapacity(size*2);
		
		elements[size] = e;
		size++;
		return e;
	}

	@Override
	public E add(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(i>=size)
			throw new IndexOutOfBoundsException();
		if(size>=elements.length)
			changeCapacity(size*2);
		
		E etr = elements[i];
		for(int x = size-1; x>=i; x--) {
			elements[x+1] = elements[x];
		}
		elements[i] = e;
		size++;
		return etr;
	}
	
	private void changeCapacity(int x) {
		E[] narr = (E[]) new Object[x];
		
		for(int i = 0; i<size; i++) {
			narr[i] = elements[i];
		}
		elements = narr;
	}
	
	@Override
	public String toString() {
		String str = "{";
		for(int i = 0; i<size-1; i++) {
			str = str+elements[i]+", ";
		}
		str += elements[size-1]+"}";
		
		return str;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<>(this);
	}
	
	private class ListIterator<E> implements Iterator<E> {
		ArrayIndexList<E> list;
		int current;
		public ListIterator(ArrayIndexList<E> list) {
			// TODO Auto-generated constructor stub
			this.list = list;
			current = 0;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return current < list.size();
		}

		@Override
		public E next() throws IllegalStateException{
			// TODO Auto-generated method stub
			if(!hasNext())
				throw new IllegalStateException();
			
			E etr = list.get(current);
			current++;
			return etr;
		}
		
	}

}
