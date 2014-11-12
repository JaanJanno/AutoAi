package ee.ut.autoai.ui;

import java.awt.Dimension;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	MainView view = new MainView();

	private static final long serialVersionUID = -7017970115572844571L;

	public MainWindow() {
		super("Auto Ai");
		initWindow();
	}
	

	public void initWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 320, 800, 600);
		setMinimumSize(new Dimension(800, 600));
		setJMenuBar(new MenuBar(this)); // Lisab ülemise menüüriba.
		add(view);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainWindow();
	}

}
