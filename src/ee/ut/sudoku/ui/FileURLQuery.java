package ee.ut.sudoku.ui;

import java.awt.Component;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;

/**
 * Klass failist ruudustiku info sisse laadimiseks.
 * 
 * @author jaan
 *
 */

public class FileURLQuery {

	/**
	 * Avab dialoogi, mis laseb kasutajal fail valida.
	 * 
	 * @param parent
	 * @return
	 */

	public static String fileLocationQuery(Component parent) {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath();
		}
		return null;
	}

	/**
	 * Loeb sisse faili sisu saades listi ridade stringidest.
	 * 
	 * @param url
	 * @return
	 */

	public static List<String> readFile(String url) {
		File file = new File(url);
		try {
			return Files.readAllLines(file.toPath(), Charset.defaultCharset());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Loeb sisse kasutaja valitud faili sisu ühe reavahetustega stringina.
	 * 
	 * @param parent
	 * @return
	 */

	public static String getFileAsString(Component parent) {
		String url = fileLocationQuery(parent);
		List<String> content = readFile(url);
		if (content == null)
			return null;
		StringBuilder string = new StringBuilder();
		for (String line : content) {
			string.append(line);
			string.append('\n');
		}
		string.append('\n');
		return string.toString();
	}

}
