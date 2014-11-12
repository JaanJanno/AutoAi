package ee.ut.autoai.game;

public class FieldSlot {

	private boolean isRoad;

	public FieldSlot() {
		isRoad = false;
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

}
