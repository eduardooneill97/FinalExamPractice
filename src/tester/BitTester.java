package tester;

import dataStructures.ListSparseBitString;

public class BitTester {
	
	public static void main(String[] args) {
		ListSparseBitString s1 = new ListSparseBitString("100011101");
		ListSparseBitString s2 = new ListSparseBitString("011010101");
		
		print(s1);
		print(s2);
		
		s1.append(s2);
		print(s1);
		s1.clear(s1.length()-1);
		print(s1);
//		s1.bwAND(s2);
//		print(s1);
//		s1.bwOR(s2);
//		print(s1);
//		s1.set(0);
//		print(s1);
//		s1.set(0);
//		print(s1);
//		s1.clear(2);
//		print(s1);
//		s1.clear(0);
//		print(s1);
	}
	
	public static void print(ListSparseBitString s) {
		for(Character x:s) {
			System.out.print(x);
		}
		System.out.println("");
	}

}
