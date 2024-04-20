package application;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * @author Paul Abili
 */
public class MorseCodeTreeTestStudent{ 
	// Creates an instance of the class
	MorseCodeTree MCT;
	/**
	 * Initializes the MCT Instance
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		MCT = new MorseCodeTree();

	}
	
	/**
	 * Sets the MCT Instance to Null 
	 * @throws Exception
	 */
	
	@After
	public void tearDown() throws Exception {
		MCT = null;
	}
	
	/**
	 * Checks if the Tree Generation works correctly by determining if LNR order is even possible, with the tree
	 */
	
	@Test
	public void testToArrayList() {	
		ArrayList<String> toArrayList = MCT.toArrayList();
		String result = "";
		for(int i = 0; i < toArrayList.size(); i++) {
			result += toArrayList.get(i);
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o ", result);
	}
}
