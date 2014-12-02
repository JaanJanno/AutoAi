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
			for (Integer i : usable) {
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

}
