package dataStructures;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractBinaryTree<E> implements BinaryTree<E>{

	@Override
	public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		ArrayList<Position<E>> list = new ArrayList<Position<E>>();
		Position<E> child = left(p);
		if(child!=null)
			list.add(child);
		child = right(p);
		if(child!=null)
			list.add(child);
 		return list;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		int x = 0;
		if(left(p)!=null)
			x++;
		if(right(p)!=null)
			x++;
		return x;
	}

	@Override
	public boolean isExternal(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return numChildren(p) == 0;
	}

	@Override
	public boolean isInternal(Position<E> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return numChildren(p)>0;
	}

	@Override
	public Position<E> sibling(Position<E> p) {
		// TODO Auto-generated method stub
		Position<E> parent = parent(p);
		if(p == left(parent))
			return right(parent);
		else
			return left(parent);
	}
	
	public abstract Position<E> addRoot(E e);
	public abstract Position<E> addLeft(Position<E> p, E e);
	public abstract Position<E> addRight(Position<E> p, E e);
	public abstract E set(Position<E> p, E e);
	public abstract E remove(Position<E> p);
	
}
