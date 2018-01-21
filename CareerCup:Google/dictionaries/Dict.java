import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// Insertion is O(1) per word or O(n) where n is the number of words to add to dict
// Lookup is O(1) per word or O(n) for n words
// Conversion is O(1) per word or O(n) where n is the number of words to convert

// Loads the strings from a dictionary.properties file
// TODO: use a set here for cleaner code. Used a Map since  I am rusty with Java and trying to code this from memory
public class Dict {
	
	Properties map = new Properties();
	static boolean DEBUG = true;
	public static final String PROPERTIES_FILE_NAME = "dictionary.properties";

	// Main method used to test Dict. 
	//	- Adds carry, candy, dummy to the PROPERTIES_FILE_NAME file, 
	//	- then loads the file
	// 	- then calls isUniqueDictionaryWord() on a few test words
	public static void main(String[] args) throws IOException {
		Dict dict = new Dict();

		// If there are no values, create some for testing
		if(DEBUG) {
			dict.add("carry");
			dict.add("candy");
			dict.add("dummy");
			dict.store(PROPERTIES_FILE_NAME);
		}

		// Load initial values
		dict.load(PROPERTIES_FILE_NAME);
		
		for(String word: new String[] {"dandy", "diddly", "dancing", "domes","cappy"}) {
			System.out.printf("%s is %sin dict\n",word, dict.isUniqueDictionaryWord(word) ? "" : "not ");
		}
	}
	
	public void load(String fileName) throws FileNotFoundException, IOException {
		map.load(new FileReader(fileName));
	}
	
	public void store(String fileName) throws IOException {
		map.store(new FileWriter(fileName), "Dictionary for Dict.java");
	}


	// Convert words 3 or longer to CxC => first character+ (length-2) +last character
	private String getConvertedWord(String word) {
		String newWord = "";
		if(word == null || word.length() == 0)
			newWord = "";
		else if(word.length() < 3)
			newWord = word;
		else 
			newWord = ""+word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
			
		if(DEBUG)
			System.out.printf("Converted %s to %s\n", word, newWord);
		return newWord;

	}
	
	public void add(String word) {
		map.put(getConvertedWord(word), "");
	}
	
	public boolean isUniqueDictionaryWord(String word) {
		String newWord = getConvertedWord(word);
		return map.containsKey(newWord);
	}

}