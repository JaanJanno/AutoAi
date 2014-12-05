package ee.ut.sudoku.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import ee.ut.sudoku.game.Parser;
import ee.ut.sudoku.game.Solver;

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

		JMenuItem resetAction = new JMenuItem("Kõik tühjaks");
		JMenuItem newAction = new JMenuItem("Lae uus seis");
		JMenuItem loadAction = new JMenuItem("Lae uus regioonikaart");
		JMenuItem calcAction = new JMenuItem("Arvuta lahendus");
		JMenuItem exitAction = new JMenuItem("Välju");

		fileMenu.add(resetAction);
		fileMenu.add(newAction);
		fileMenu.add(loadAction);
		fileMenu.add(calcAction);
		fileMenu.addSeparator();
		fileMenu.add(exitAction);

		MenuListener listener = new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				window.repaint();
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				window.repaint();
			}

			@Override
			public void menuCanceled(MenuEvent e) {
				window.repaint();
			}
		};

		fileMenu.addMenuListener(listener);
		
		/*
		 * "Kõik tühaks" nupu vajutus.
		 */
		
		resetAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.view.field.initAll();
				window.repaint();
			}
		});
		
		/*
		 * "Lae uus seis" nupuvajutus.
		 */

		newAction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String loaded = FileURLQuery.getFileAsString(window);
				if (loaded != null)
					Parser.parseField(window.view.field, loaded);
				window.repaint();
			}
		});
		
		/*
		 * "Lae uus regioonikaart" nupuvajutus.
		 */
		
		loadAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String loaded = FileURLQuery.getFileAsString(window);
				if (loaded != null)
					Parser.parseRegions(window.view.field, loaded);
				window.repaint();
			}
		});
		
		/*
		 * "Arvuta lahendus" nupuvajutus
		 */
		
		calcAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Solver.solve(window.view.field);
			}
		});
		
		/*
		 * "Välju" nupuvajutus
		 */

		exitAction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
			}
		});
	}

}
