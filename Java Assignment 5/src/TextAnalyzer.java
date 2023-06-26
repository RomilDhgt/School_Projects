
/**
 * @author Romil Dhagat
 * Text analyzer uses string manipulation on a text to get numOfSentances and numOfWords, these are then outputs in the GUI.
 *
 */
public class TextAnalyzer {
	private int numOfSentences; 
	private int numOfWords;
	
	public TextAnalyzer(String text) {
		getText(text);
	}
	
	public void getText(String text) {
		
		String[] sentences = text.split("[.!?]"); 
		
		String[] words = text.split("\\s+"); 
		numOfWords = words.length;
		
		for(String sentence : sentences) {
			if(!sentence.trim().isEmpty()) {
				numOfSentences++;
			}
		}
	}
	
	public int numOfSentences() {
		return numOfSentences;
	}
	
	public int numOfWords() {
		return numOfWords;
	}
	
	@Override
	public String toString() { //print the number of words and strings
		return "The number of sentences are: " + numOfSentences + "\nThe number of words are: " + numOfWords;
	}
}
