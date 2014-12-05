package ee.ut.sudoku.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Klass, mis representeerib ruudustikku, mida kasutaja näeb.
 * 
 * @author jaan
 *
 */

public class Field {

	int width;
	int height;
	List<List<FieldSlot>> field;
	public List<List<FieldSlot>> areas = new ArrayList<List<FieldSlot>>();

	public Field(List<List<FieldSlot>> field) {
		this.field = field;
		for (int i = 0; i < 9; i++) {
			areas.add(new ArrayList<FieldSlot>());
		}
	}

	/**
	 * Algväärtustab regioonid.
	 */

	public void flushAreas() {
		areas = new ArrayList<List<FieldSlot>>();
		for (int i = 0; i < 9; i++) {
			areas.add(new ArrayList<FieldSlot>());
		}
	}

	/**
	 * 
	 * @param width
	 * @param height
	 */

	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		this.field = initField(width, height);
		for (int i = 0; i < 9; i++) {
			areas.add(new ArrayList<FieldSlot>());
		}
	}

	/**
	 * Tagastab ruudu väärtuse antud koordinaatidel.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */

	public FieldSlot getSlot(int x, int y) {
		return field.get(y).get(x);
	}

	/**
	 * Määrab ruudule väärtuse antud koordinaatidel.
	 * 
	 * @param x
	 * @param y
	 * @param value
	 */

	public void setSlot(int x, int y, int value) {
		field.get(y).get(x).setValue(value);
	}

	/**
	 * Tagastab koordinaatidel oleva väärtuse char kujul, et see ekraanile
	 * printida.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */

	public char[] getSlotChar(int x, int y) {
		Character c = getSlot(x, y).getValue() == 0 ? ' ' : Integer.toString(
				getSlot(x, y).getValue()).charAt(0);
		char[] array = new char[1];
		array[0] = c;
		return array;
	}

	/*
	 * Tekitab ruudustiku info aluse.
	 */

	private static List<List<FieldSlot>> initField(int width, int height) {
		List<List<FieldSlot>> field = new ArrayList<List<FieldSlot>>();
		for (int i = 0; i < height; i++) {
			List<FieldSlot> line = new ArrayList<FieldSlot>();
			for (int j = 0; j < width; j++) {
				line.add(new FieldSlot(j, i));
			}
			field.add(line);
		}
		return field;
	}

	/**
	 * Algväärtustab kõik.
	 */

	public void initAll() {
		this.field = initField(9, 9);
		flushAreas();
		initAreas();
	}

	/**
	 * Initsialiseerib klassikalise sudoku ruudustiku jaotuse.
	 */

	public void initAreas() {
		setArea(0, 0, 0);
		setArea(3, 0, 1);
		setArea(6, 0, 2);

		setArea(0, 3, 3);
		setArea(3, 3, 4);
		setArea(6, 3, 5);

		setArea(0, 6, 6);
		setArea(3, 6, 7);
		setArea(6, 6, 8);
	}

	/**
	 * Määrab regioonile ruudu antud koordinaatidel.
	 * 
	 * @param x
	 *            Laiuti koordinaat
	 * @param y
	 *            Pikuti koordinaat
	 * @param id
	 *            Regioon vahemikus 1-9
	 */

	private void setArea(int x, int y, int id) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				areas.get(id).add(getSlot(i, j));
			}
		}
	}

	/**
	 * Lisab antud väärtused ala tühjadesse avadesse.
	 * 
	 * @param area
	 *            Millist regiooni täidetakse
	 * @param values
	 *            Pinu väärtustest, millega regioon täidetakse.
	 * @return
	 */

	public List<FieldSlot> fillNext(int area, Stack<Integer> values) {
		List<FieldSlot> ret = new ArrayList<FieldSlot>();
		for (FieldSlot s : areas.get(area)) {
			if (s.getValue() == 0) {
				s.setValue(values.pop());
				ret.add(s);
			}
		}
		return ret;
	}

	@Override
	public String toString() {
		String out = "Field{\n";
		for (int i = 0; i < height; i++) {
			String line = "";
			for (int j = 0; j < width; j++) {
				line += getSlot(j, i).getValue();
			}
			out += line + "\n";
		}
		return out + "}";
	}

}
