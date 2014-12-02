package ee.ut.sudoku.game;

public class FieldSlot {

	private boolean isRoad;
	private int value = 0;

	int x;
	int y;

	public FieldSlot(int x, int y) {
		isRoad = false;
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

	public FieldSlot(boolean isRoad) {
		this.isRoad = isRoad;
	}

	public boolean isRoad() {
		return isRoad;
	}

	public void setRoad(boolean isRoad) {
		this.isRoad = isRoad;
	}

	@Override
	public String toString() {
		return "FieldSlot [x=" + x + ", y=" + y + "]";
	}

}
