package dataStructures;

public interface SparseBitString extends Iterable<Character>{
	int length();
	char charAt(int index) throws IndexOutOfBoundsException;
	void append(SparseBitString s);
	void bwAND(SparseBitString s) throws IllegalArgumentException;
	void bwOR(SparseBitString s) throws IllegalArgumentException;
	void set(int index) throws IndexOutOfBoundsException;
	void clear(int index) throws IndexOutOfBoundsException;
}
