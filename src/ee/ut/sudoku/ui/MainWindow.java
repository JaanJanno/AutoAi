package ee.ut.sudoku.ui;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Programmi põhiakna klass.
 * 
 * @author jaan
 *
 */

public class MainWindow extends JFrame {

	MainView view = new MainView();

	private static final long serialVersionUID = -7017970115572844571L;

	public MainWindow() {
		super("Sudoku");
		initWindow();
	}

	public void initWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 320, 320, 320);
		setMinimumSize(new Dimension(320, 320));
		setJMenuBar(new MenuBar(this)); // Lisab ülemise menüüriba.
		add(view);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainWindow();
	}

}
