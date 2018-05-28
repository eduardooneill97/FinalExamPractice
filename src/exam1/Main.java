package exam1;

import java.util.Random;

import dataStructures.ArrayIndexList;
import dataStructures.SLIndexList;

public class Main {
	
	public static void main(String[] args) {
//		Integer arr[] = {1,2,5,3,7,8,0,1,23,45};
//		for(Integer x:arr)
//			System.out.print(x+" ");
//		removesAll(arr);
//		for(Integer x:arr)
//			System.out.print(x+" ");
		
		SLIndexList<Integer> list = new SLIndexList<>();
		for(int i = 0; i<50; i++) {
			list.add(i);
		}
		System.out.println(list);
		for(int i = 0; i<10; i++) {
			list.remove(i);
		}
		System.out.println(list);
		
		try {
			list.remove(50);
		}catch(Exception e) {
			System.out.println("good");
		}
		try {
			list.add(list.size(), 40);
		}catch(Exception e) {
			System.out.println("really bad");
		}
		System.out.println(list);
		System.out.println(list.size());
		for(Integer x: list) {
			System.out.println(x);
		}
		System.out.println(list.contains(51));
	}
	
	public static <E> void removesAll(E[] arr) {
		Random rand = new Random();
		int end = arr.length;
		for(int i = 0; i<arr.length; i++) {
			int itr = rand.nextInt(end);
			arr[itr] = arr[end-1];
			arr[end-1] = null;
			end--;
		}
	}

}
