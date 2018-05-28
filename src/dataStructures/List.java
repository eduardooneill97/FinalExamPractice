package dataStructures;

public interface List <E>{

	boolean contains(E e);
	int size();
	boolean isEmpty();
	E get(int i) throws IndexOutOfBoundsException;
	E set(int i, E e) throws IndexOutOfBoundsException;
	E remove(int i) throws IndexOutOfBoundsException;
	E add(E e);
	E add(int i, E e) throws IndexOutOfBoundsException;
}
