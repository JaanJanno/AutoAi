package ee.ut.sudoku.game;

/**
 * Klass ühe ruudukese info hoidmiseks.
 * 
 * @author jaan
 *
 */

public class FieldSlot {

	private int value = 0;

	int x;
	int y;

	public FieldSlot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "FieldSlot [x=" + x + ", y=" + y + "]";
	}

}
