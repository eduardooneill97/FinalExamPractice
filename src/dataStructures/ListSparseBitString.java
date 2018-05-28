package dataStructures;

import java.util.ArrayList;
import java.util.Iterator;

public class ListSparseBitString implements SparseBitString{
	
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private int length = 0;
	
	public ListSparseBitString(String s) {
		// TODO Auto-generated constructor stub
		for(int i = 0; i<s.length(); i++)
			if(s.charAt(i) == '1')
				list.add(i);
		length = s.length();
	}

	@Override
	public Iterator<Character> iterator() {
		// TODO Auto-generated method stub
		return new BitStringIterator(list, length);
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public char charAt(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(list.contains(index))
			return '1';
		return '0';
	}

	@Override
	public void append(SparseBitString s) {
		// TODO Auto-generated method stub
		int lastIndex = list.get(list.size()-1);
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i) == '1')
				list.add(lastIndex+1+i);
		}
		length+=s.length();
	}

	@Override
	public void bwAND(SparseBitString s) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(this.length != s.length())
			throw new IllegalArgumentException();
		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(int i = 0; i<length; i++) {
			char s1 = this.charAt(i);
			char s2 = s.charAt(i);
			
			if(s1 == '1' && s2 == '1')
				newList.add(i);	
		}
		list = newList;
		
	}

	@Override
	public void bwOR(SparseBitString s) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(this.length != s.length())
			throw new IllegalArgumentException();
		
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(int i = 0; i<length; i++) {
			char s1 = this.charAt(i);
			char s2 = s.charAt(i);
			
			if(s1 == '1' || s2 == '1')
				newList.add(i);	
		}
		list = newList;
	}

	@Override
	public void set(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index >= length || index < 0)
			throw new IndexOutOfBoundsException("Index out of bounds for this string.");
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i) == index) return;
			if(list.get(i)>index) { list.add(i, index); return;}
		}
		list.add(index);
	}

	@Override
	public void clear(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index >= length || index < 0)
			throw new IndexOutOfBoundsException("Index out of bounds for this string.");
		for(int i = 0; i<list.size(); i++) 
			if(list.get(i) == index) { list.remove((Integer)index); return;}
		
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i<length; i++) {
			if(list.contains(i))
				s+="1";
			else s+="0";
		}
		return s;
	}
	
	public class BitStringIterator implements Iterator<Character>{

		private int index, length;
		private ArrayList<Integer> list;
		
		public BitStringIterator(ArrayList<Integer> list, int length) {
			this.list = list;
			this.length = length;
			index = 0;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index<length;
		}

		@Override
		public Character next() {
			// TODO Auto-generated method stub
			char ctr;
			if(list.contains(index))
				ctr = '1';
			else ctr = '0';
			index++;
			return ctr;
		}
		
	}

}
