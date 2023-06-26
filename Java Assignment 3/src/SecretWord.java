
/**
 * @author Romil Dhagat
 *
 */
public class SecretWord {
	
	private String secretWord;
	private String displayedWord;
	
	public SecretWord() {
		this.secretWord = "hello";
		this.displayedWord = replaceChars(this.secretWord,'*');
	}
	
	public String getDisplayedWord() {
		return this.displayedWord;
	}
	
	public String getSecretWord() {
		return this.secretWord;
	}

	public String replaceChars(String secretWord, char a) {
		
		StringBuilder myString = new StringBuilder(secretWord);
		
		for(int i = 0; i < secretWord.length(); i++) {
			myString.setCharAt(i,a);
		}
		
		return myString.toString();
	}
	
	public String replaceChars(String secretWord, String hiddenWord, char a) {

		StringBuilder myString = new StringBuilder(this.displayedWord);
		
		for(int i = 0; i < this.displayedWord.length(); i++) {
			if(this.secretWord.charAt(i) == a) {
				myString.setCharAt(i, a);
			}
		}
		
		this.displayedWord = myString.toString();
		
		return this.displayedWord;
	}
	
	public boolean makeGuess(char a) {
		
		if(this.secretWord.indexOf(a) == -1) {
			return false;
		} else {
			replaceChars(this.secretWord,this.displayedWord,a);
			return true;
		}
	}
	
	

}
