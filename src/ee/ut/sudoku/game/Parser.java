package ee.ut.sudoku.game;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	public static String test = 
			  "5 3 - - 7 - - - -\n"
			+ "6 - - 1 9 5 - - -\n"
			+ "- 9 8 - - - - 6 -\n"
			+ "8 - - - 6 - - - 3\n"
			+ "4 - - 8 - 3 - - 1\n"
			+ "7 - - - 2 - - - 6\n"
			+ "- 6 - - - - 2 8 -\n"
			+ "- - - 4 1 9 - - 5\n"
			+ "- - - - 8 - - 7 9";
	
	public static String testRegions = 
			  "1 1 1 2 3 3 3 3 3\n"
			+ "1 1 1 2 2 2 3 3 3\n"
			+ "1 4 4 4 4 2 2 2 3\n"
			+ "1 1 4 5 5 5 5 2 2\n"
			+ "4 4 4 4 5 6 6 6 6\n"
			+ "7 7 5 5 5 5 6 8 8\n"
			+ "9 7 7 7 6 6 6 6 8\n"
			+ "9 9 9 7 7 7 8 8 8\n"
			+ "9 9 9 9 9 7 8 8 8\n";
	
	public static String test2 = 
			  "3 - - - - - - - 4\n"
			+ "- - 2 - 6 - 1 - -\n"
			+ "- 1 - 9 - 8 - 2 -\n"
			+ "- - 5 - - - 6 - -\n"
			+ "- 2 - - - - - 1 -\n"
			+ "- - 9 - - - 8 - -\n"
			+ "- 8 - 3 - 4 - 6 -\n"
			+ "- - 4 - 1 - 9 - -\n"
			+ "5 - - - - - - - 7\n";
	
	public static void parseField(Field f, String s) {
		List<List<Integer>> table = getIntList(s);
		for (int x = 0 ; x < 9 ; x ++) {
			for (int y = 0 ; y < 9 ; y ++) {
				f.setSlot(x, y, table.get(y).get(x));
			}
		}
	}
	
	public static void parseRegions(Field f, String s) {
		List<List<Integer>> table = getIntList(s);
		f.flushAreas();
		for (int x = 0 ; x < 9 ; x ++) {
			for (int y = 0 ; y < 9 ; y ++) {
				int region = table.get(y).get(x);
				f.areas.get(region - 1).add(f.getSlot(x, y));
			}
		}
	}
	
	private static List<List<Integer>> getIntList(String s) {
		List<List<Integer>> table = new ArrayList<List<Integer>>();
		for (String l : s.split("\n")) {
			List<Integer> line = new ArrayList<Integer>();
			for (String sym : l.split(" "))
				if (sym.equals("-"))
					line.add(0);
				else
					line.add(Integer.parseInt(sym));
			table.add(line);
		};
		return table;
	}

	
	
}
