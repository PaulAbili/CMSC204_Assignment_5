package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
 * Utilizes the MorseCodeTree Class to Convert Morse Code into English
 * @author Paul Abili
 */

public class MorseCodeConverter {

	private static MorseCodeTree MCT = new MorseCodeTree();

	/**
	 * Implemented Currently not in use
	 */

	public MorseCodeConverter() {

	}

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘)
	 * @param code letters in morse code
	 * @return the code converted into English 
	 */

	public static String convertToEnglish(String code) {
		String[] codeWords;
		String[] codeLetters;
		String result = "";
		codeWords = code.split("/");
		for(int i = 0; i < codeWords.length; i++) {
			codeWords[i] = codeWords[i].trim();
			codeLetters = codeWords[i].split(" ");
			for(int j = 0; j < codeLetters.length; j++) {
				result += MCT.fetch(codeLetters[j]);
			}
			result += " ";
		}
		result = result.trim();
		return result;
	}

	/**
	 * Converts Morse code into English
	 * @param infoFile inputed file to be read
	 * @return result the morse code converted into English 
	 * @throws FileNotFoundException
	 */

	public static String convertToEnglish(File infoFile) throws FileNotFoundException {
		Scanner inputFile = new Scanner(infoFile);
		String result = "";
		String line;
		while(inputFile.hasNext()) {
			line = inputFile.nextLine();
			result += convertToEnglish(line);
		}
		inputFile.close();
		return result;
	}

	/**
	 * Returns a string with all the data in the tree in LNR order with an space in between them
	 * @return info a string containing all of the letters in the tree in LNR order
	 */

	public static String printTree() {
		String info = "";
		ArrayList<String> letters = MCT.toArrayList();
		for(int i = 0; i < letters.size(); i++){
			info += letters.get(i);
		}
		info =  info.substring(0,info.length()-1);
		return info;
	}
}
