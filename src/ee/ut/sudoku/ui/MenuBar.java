package ee.ut.sudoku.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Jaan Janno
 */

/**
 * Klass ülemise menüüriba loomiseks.
 */

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 2281560688466949272L;

	public MenuBar(final MainWindow window) {
		
		/*
		 * Defineerib menüüriba valikud.
		 */
		
		JMenu fileMenu = new JMenu("File");
		add(fileMenu);
		
		/*
		 * Seostab valikutega alamvalikud..
		 */

		JMenuItem newAction = new JMenuItem("Uus sõit");
		JMenuItem loadAction = new JMenuItem("Lae uus kaart");
		JMenuItem exitAction = new JMenuItem("Välju mängust");


		fileMenu.add(newAction);
		fileMenu.add(loadAction);
		fileMenu.addSeparator();
		fileMenu.add(exitAction);
		
		exitAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
			}
		});
	}
}
