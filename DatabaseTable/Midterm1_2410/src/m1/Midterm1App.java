package m1;

import java.util.Scanner;

import queue.LinkedQueue;
import queue.Point;

public class Midterm1App {

	public static void main(String[] args) {
		Tree[] trees = { new Tree("Beech", "BE", 3), new Tree("Black Ash", "BA", 8), new Tree("Chestnut", "CH", 9), new Tree("Hawthorn", "HA", 7), 
				new Tree("Hemlock", "TS", 4), new Tree("IronWood", "IW", 9), new Tree("Larch", "LR", 8), new Tree("Red Pine", "RP", 6), 
				new Tree("Star Magnolia", "SR", 2), new Tree("White Ash", "WA", 6), new Tree("Willow", "WI", 7), new Tree("Yellow Wood", "YW", 5)};
		
		for (int i = 0; i < trees.length; i++) {
			System.out.println(trees[i]);
		}
		System.out.println();
		
		// Part 1
		System.out.println("Part1 a)");
		System.out.println("--------");
		
		for (int i = trees.length - 1; i >= 0; i--) {
			System.out.println(trees[i]);
		}
		System.out.println();
		
		
		System.out.println("Part1 b)");
		System.out.println("--------");
		for (int i = 0; i < trees.length; i++) {
			String code = trees[i].getCode();
			int age = trees[i].getAge();
			System.out.print(code +"("+ age +")");
		}
		System.out.println();
		
		System.out.println("Part1 c)");
		System.out.println("--------");
		for (int i = 0; i < trees.length; i++) {
			StringBuilder reversename = new StringBuilder(trees[i].getName()).reverse();
			System.out.print(reversename.toString().toLowerCase()+ " ");
			System.out.println(trees[i].getName().toUpperCase());
		}
		System.out.println();
		
		
		// Part 2
		System.out.println("Part2 a) .. creating a stack of trees");
		System.out.println("--------");
		TreeStack newStack = new TreeStack();
		for (int i = 0; i < trees.length; i++) {
			Tree newTree = trees[i];
			newStack.push(newTree);
		}
		

		System.out.println("Part2 b)");
		System.out.println("--------");	
		for (int i = 0; i < newStack.size();) {
			System.out.print(newStack.pop().getCode()+ " ");
		}
		System.out.println();
		
		// Part 3 
		System.out.println("Part3 a) .. creating a queue of trees");
		System.out.println("--------");	
		LinkedQueue<Tree> treeQueue = new LinkedQueue<>();
		for (int i = 0; i < trees.length; i++) {
			treeQueue.enqueue(new Tree(trees[i].getName(), trees[i].getCode(), trees[i].getAge()));
		}
		

		System.out.println("Part3 b)");
		System.out.println("--------");	
		TreeStack newStack2 = new TreeStack();
		for (int i = 0; i < trees.length; i++) {
			Tree newTree = trees[i];
			newStack2.push(newTree);
		}
		for (int i = 0; i < newStack2.size();) {
			String name = newStack2.pop().getName();
					if (name.split(" ").length > 1) {
						System.out.println(name);
					}
					else {
						System.out.println("***");
					}
		}
		System.out.println();

	}
	

}
