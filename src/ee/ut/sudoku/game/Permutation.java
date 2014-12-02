package ee.ut.sudoku.game;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Permutation {
	
	Stack<Stack<Integer>> permutations = new Stack<Stack<Integer>>();
	Stack<Set<Integer>> freeElems = new Stack<Set<Integer>>();
	int length;
	
	public Permutation(Set<Integer> elements) {
		this.length = elements.size();
		for (Integer i : elements) {
			Stack<Integer> singleStack = new Stack<Integer>();
			singleStack.push(i);
			permutations.push(singleStack);
			HashSet<Integer> usable = new HashSet<Integer>(elements);
			usable.remove(i);
			freeElems.push(usable);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Stack<Integer> getNext() {
		if (permutations.empty()) {
			return new Stack<Integer>();
		}
		while (permutations.peek().size() != length) {
			Stack<Integer> top = permutations.pop();
			Set<Integer> usable = freeElems.pop();
			for (Integer i : usable){
				Set<Integer> nextUsable = new HashSet<Integer>(usable);
				nextUsable.remove(i);
				freeElems.push(nextUsable);
				Stack<Integer> nextTop = (Stack<Integer>) top.clone();
				nextTop.push(i);
				permutations.push(nextTop);
			}
		}
		freeElems.pop();
		return permutations.pop();
	}
	
	/*
	
	public static void main(String[] args) {
		HashSet<Integer> e = new HashSet<Integer>();
		e.add(1);
		e.add(2);
		e.add(3);
		e.add(4);
		e.add(5);
		e.add(6);
		e.add(7);
		e.add(8);
		e.add(9);
		Permutation p = new Permutation(e);
		
		System.out.println("algus");
		for (int i = 0 ; i < 362880 ; i ++) {
			//System.out.println(p.permutations);
			//System.out.println(p.freeElems);
			//System.out.println(p.getNext());
			p.getNext();
		}
		System.out.println("lopp");

	}
	*/
}