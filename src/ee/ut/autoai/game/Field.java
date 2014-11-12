package ee.ut.autoai.game;

import java.util.ArrayList;
import java.util.List;

public class Field {
	
	int width;
	int height;
	List<List<FieldSlot>> field;
	
	public Field(List<List<FieldSlot>> field) {
		this.field = field;
	}
	
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		this.field = initField(width, height);
	}
	
	public FieldSlot getSlot(int x, int y){
		return field.get(y).get(x);
	}

	private static List<List<FieldSlot>> initField(int width, int height) {
		List<List<FieldSlot>> field = new ArrayList<List<FieldSlot>>();
		for (int i = 0; i < height; i++){
			List<FieldSlot> line = new ArrayList<FieldSlot>();
			for (int j = 0; j < width; j++){
				line.add(new FieldSlot());
			}
			field.add(line);
		}
		return field;
	}
	
	@Override
	public String toString() {
		String out = "Field{\n";
		for (int i = 0; i < height; i++){
			String line = "";
			for (int j = 0; j < width; j++){
				line += getSlot(i, j).isRoad() ? 1 : 0;
			}
			out += line + "\n";
		}
		return out + "}";
	}
	
}
