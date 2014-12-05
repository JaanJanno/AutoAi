package ee.ut.sudoku.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Klass sudoku ülesande lahendamiseks.
 * 
 * @author jaan
 *
 */

public class Solver {

	static Set<Integer> defElems = new HashSet<Integer>();

	static {
		for (int i = 1; i < 10; i++) {
			defElems.add(i);
		}
	}

	/**
	 * Asub lahendama, alustab nullindalt ruudustiku alajaotuselt.
	 * 
	 * @param f
	 * @return
	 */

	public static boolean solve(Field f) {
		return solveStage(f, 0);
	}

	/**
	 * Kontrollib esmalt, kas mingi arvude permutatsiooni lisamine sobib
	 * lahenduse jätkuks. Kui jah, siis lisatakse uus permutatsioon järgmisesse
	 * ruudustiku alajaotussesse. Kui ei, siis minnakse tagasi eelmisesse
	 * alajaotusesse ja proovitakse seal uut permutatsiooni.
	 * 
	 * @param f
	 * @param area
	 * @return
	 */

	private static boolean solveStage(Field f, int area) {
		if (area == 9)
			return true;
		Set<Integer> addable = new HashSet<Integer>(defElems);
		for (FieldSlot s : f.areas.get(area)) {
			addable.remove(s.getValue());
		}
		Permutation p = new Permutation(addable);
		Stack<Integer> first = p.getNext();
		if (first.isEmpty())
			return solvable(f, area) && solveStage(f, area + 1);
		for (Stack<Integer> nexts = first; !nexts.empty(); nexts = p.getNext()) {
			List<FieldSlot> backTrack = f.fillNext(area, nexts);
			if (solvable(f, area) && solveStage(f, area + 1))
				return true;
			else
				for (FieldSlot s : backTrack)
					s.setValue(0);
		}
		return false;
	}
	
	/**
	 * Kontrollib, kas hetkel on vastuolusid. Teeb eelduse, et sisse antav
	 * sudoku ei sisalda kohe alguses vastuolusid.
	 * @param f
	 * @param area
	 * @return
	 */

	private static boolean solvable(Field f, int area) {
		for (int i = 0; i < 9; i++) {
			Set<Integer> kasutusel = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				int val = f.getSlot(i, j).getValue();
				if (val == 0)
					continue;
				if (!kasutusel.contains(val))
					kasutusel.add(val);
				else
					return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			Set<Integer> kasutusel = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				int val = f.getSlot(j, i).getValue();
				if (val == 0)
					continue;
				if (!kasutusel.contains(val))
					kasutusel.add(val);
				else
					return false;
			}
		}
		return true;
	}

}
