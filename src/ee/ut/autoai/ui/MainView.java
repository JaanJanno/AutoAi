package ee.ut.autoai.ui;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class MainView extends JPanel implements MouseListener {

	private static final long serialVersionUID = 4056960530231784348L;
	
	int hight = 100; // Mängu akna suuruseid iseloomustavad arvud.
	int width = 100;

	public MainView() {
		super(true); // Enabled double buffering
		addMouseListener(this); // Seob hiire sisendi.
	}

	@Override
	public void paintComponent(Graphics graphics) {
		
		/*
		 * Esmalt kogutakse info vaate jaoks eraldatud ekraaniruumi kohta.
		 */
		
		Graphics2D g = (Graphics2D) graphics;	
		hight = g.getClipBounds().height;
		width = g.getClipBounds().width;
		
		/*
		 * Valitakse sätted hilisemaks joonistamiseks.
		 */
		
		g.setFont(new Font("Arial", 0, 50));
		g.setStroke(new BasicStroke(5));
		g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);

		drawGrid(g);
		drawSplash(g);
	}
	
	/**
	 * Joonistab teate võitude või viikide kohta.
	 */
	
	private void drawSplash(Graphics2D g){

	}
	
	/**
	 * Joonistab mänguvälja ruudustiku.
	 */
	
	private void drawGrid(Graphics2D g) {

	}
	
	/**
	 * Kuulab sisendit hiirelt ning annab selle
	 * edasi mängu loogikat kontrollivale klassile.
	 */

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Press{" + e.getX() + ", " + e.getY() + "}");
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		return;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		return;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		return;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		return;
	}
}
