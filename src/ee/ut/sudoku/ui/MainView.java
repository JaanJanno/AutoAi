package ee.ut.sudoku.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import ee.ut.sudoku.game.Field;
import ee.ut.sudoku.game.FieldSlot;
import ee.ut.sudoku.game.Parser;

/**
 * Mängu vaade, mis sisaldab joonistatud ruute ja numberid.
 * 
 * @author jaan
 *
 */

public class MainView extends JPanel {

	private static final long serialVersionUID = 4056960530231784348L;

	int height = 100; // Mängu akna suuruseid iseloomustavad arvud.
	int width = 100;

	Field field = new Field(9, 9);

	public MainView() {
		super(true); // Enabled double buffering
		field.initAreas();
		Parser.parseField(field, Parser.test);
	}

	@Override
	public void paintComponent(Graphics graphics) {

		/*
		 * Esmalt kogutakse info vaate jaoks eraldatud ekraaniruumi kohta.
		 */

		Graphics2D g = (Graphics2D) graphics;
		height = g.getClipBounds().height;
		width = g.getClipBounds().width;

		/*
		 * Valitakse sätted hilisemaks joonistamiseks.
		 */

		g.setFont(new Font("Arial", 0, Math.min(height / 9, width / 9)));
		g.setStroke(new BasicStroke(3));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		drawGrid(g);
	}

	/**
	 * Joonistab mänguvälja ruudustiku.
	 */

	private void drawGrid(Graphics2D g) {
		for (int i = 0; i < 9; i++) {
			for (FieldSlot s : field.areas.get(i)) {
				int x = s.getX();
				int y = s.getY();
				g.setColor(new Color((200 + 25 * i) % 255, (120 * i) % 255,
						90 * i % 255));
				g.fillRect(x * width / 9, y * height / 9, width / 9 + 1,
						height / 9 + 1);
				g.setColor(Color.BLACK);
			}
		}

		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				int xPos = (int) ((float) width / 9 * (x) + (float) width / 32);
				int yPos = (int) ((float) height / 9 * (y + 1) - (float) height / 64);
				g.drawChars(field.getSlotChar(x, y), 0, 1, xPos, yPos);
			}
		}
		for (int i = 0; i < 8; i++) {
			int lineHeight = (int) ((float) height / 9 * (i + 1));
			int linePos = (int) ((float) width / 9 * (i + 1));
			g.drawLine(0, lineHeight, width, lineHeight);
			g.drawLine(linePos, 0, linePos, height);
		}
	}

}
