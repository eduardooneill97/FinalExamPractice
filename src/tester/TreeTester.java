package tester;

import dataStructures.LinkedBinaryTree;
import dataStructures.Position;

public class TreeTester {
	
	public static void main(String[] args) {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
		
		Position<Integer> root = tree.addRoot(5);
		Position<Integer> left = tree.addLeft(root, 50);
		Position<Integer> right = tree.addRight(root, 500);
		tree.remove(right);
		tree.remove(root);
		tree.remove(left);
	}

}
