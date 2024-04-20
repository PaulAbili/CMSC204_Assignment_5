package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Paul Abili
 */

public class MorseCodeConverterTestStudent {
	
	/**
	 * Checks if the Conversion works 
	 */

	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish("- .... .. ... / .. ... / ..-. --- .-. "
				+ "/ -.-. --- -- .--. ..- - . .-. / ... -.-. .. . -. -.-. . / .- ... ... .. --. -. -- . -. - "
				+ "/ ..-. .. ...- .");
		assertEquals("this is for computer science assignment five",converter1);
	}

	/**
	 * Testing for correct implementation of tree and traversal
	 */

	@Test
	public void testPrintTree() {	

		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}

	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */

	@Test
	public void testConvertMorseStringToEnglishString() {	

		String converter1 = MorseCodeConverter.convertToEnglish(".-- .... .- - / .. ... / - .... . / .--. --- .. -. - "
				+ "/ --- ..-. / ... .-.. . . .--. .. -. --.");
		assertEquals("what is the point of sleeping", converter1);

	}
	
	/**
	 *Tests reading files with Daisy
	 */
	
	@Test
	public void testConvertMorseFileToEnglishString() {	
		File file = new File("src/Daisy.txt"); 
		try {
			assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

}
