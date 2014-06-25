import java.util.*;

public class HangmanManager {

	private int length;
	private int max;
	Set<String> wordSet;
	private SortedSet<Character> guesses;
	private char[] pattern;
	
	// passed a dictionary of words, a target word length, 
	// and the maximum number of wrong guesses the player is allowed to make.
	// The set of words should initially contain all words from the dictionary 
	// of the given length, eliminating any duplicates.
	HangmanManager(Collection<String> dictionary, int length, int max) {
		if (max<0 || dictionary.size() < 1) {
			throw new IllegalArgumentException("Max is less than 0, or length is less than 1.");
		}
		
		guesses = new TreeSet<Character>();
		wordSet = new TreeSet<String>();
		
		//adds all the words of the chosen length to the wordset
		for (String s : dictionary) {
			if(s.length() == length) {
				wordSet.add(s);
			}
		}
		
		this.length = length;
		this.max = max;
		
		pattern = new char[length];
		//fill pattern with dashes of the word length.
		for (int i=0; i<this.length; i++) {
			pattern[i]= '-';
		}
	}
	
	// The client calls this method to get access to the 
	// current set of words being considered by the hangman manager.
	Set<String> words() {
		return wordSet;
	}
	
	//The client calls this method to find out how many guesses the player has left.
	int guessesLeft() {
		return this.max;
	}
	
	//The client calls this method to find out the current set of letters that 
	//have been guessed by the user.
	SortedSet<Character> guesses() {
		return guesses;
	}
	
	//This should return the current pattern to be displayed for the hangman game 
	//taking into account guesses that have been made.
	String pattern() {
		if (wordSet.isEmpty()) {
			throw new IllegalStateException("Word set is empty");
		}
		
		//turn pattern array into a string 
		String patternStr = new String(pattern);
		//put spaces in between all the chars
		patternStr = patternStr.replace("", " ").trim();
		return patternStr;
	}
	
	int record(char guess) {
		//if there is no word or you've used all your guesses
		if (wordSet.isEmpty() || max == 0) {
			throw new IllegalStateException("Word set is empty or no guesses left.");
		}
		//if you've already guessed the letter
	    if (guesses.contains(guess)) {
	    	throw new IllegalArgumentException("You've already guessed this.");
	    }
	    
	    //update guesses
	    guesses.add(guess);
	    
	    //get the word families for the guessed char
	    Map<String, Set<String>> wordFam = getWordFam(guess);
	    
	    //pick the word family with the most words in it to be the new wordSet
	    wordFam = pickWordFam(wordFam);
	    
	    //System.out.println("wordFam: " +wordFam.toString());
	    
	    //get the number of letters you guessed in the word
	    int guessCount = getGuessCount(wordFam);
	    
	    return guessCount;
	}
	
	//makes word families out of all the words in the wordset based upon the
	//guessed pattern
	Map<String, Set<String>> getWordFam(char guess) {
		
		Map<String, Set<String>> wordFam = new HashMap<String, Set<String>>();
		char[] famPattern = new char[length];
		    
		//iterate through the dictionary of words
		for (String word: wordSet) {
			//reset famWords
		    Set<String> famWords = new TreeSet<String>();
		    //reset the famPattern
		    for (int i=0; i<this.length; i++) {
				famPattern[i]= '-';
			}
		    //create the famPattern for the guess
		    for (int i=0; i<word.length(); i++) {
		    	if (word.charAt(i) == guess) {
		    		famPattern[i]= guess;
		    	}
		    //add the word to the set
		    famWords.add(word);
		    }
		    //change famPattern char array into string
		    String famPatString = new String(famPattern);
		    
		    Set<String> famWordsTemp = new TreeSet<String>();
		    //get old set of strings
		    famWordsTemp = wordFam.get(famPatString);
		    //add the new string to the old set of strings
		    if (famWordsTemp!= null) {
		    	famWords.addAll(famWordsTemp);
		    }
		    //put the pattern and word in the map
		    wordFam.put(famPatString, famWords);
		}
		return wordFam;
	}
	
	//chooses the word family with the most words in it and reduces the 
	//wordset to this wordfamily
	Map<String, Set<String>> pickWordFam(Map<String, Set<String>> wordFam) {
		Set<String> tempWords = new TreeSet<String>();
	    String tempPattern = null;
	    Map<String, Set<String>> tempFam = new HashMap<String, Set<String>>();
	    
	    //iterate through map and check for the largest word family 
	    for (Map.Entry<String, Set<String>> entry : wordFam.entrySet()) {
	    	String key = entry.getKey();
	    	Set<String> value = entry.getValue();
	    	//check if there are more words in this set
	    	//and if there are, get rid of the old words and update tempWords
	    	//and tempPattern
	    	if(value.size() > tempWords.size()) {
	    		tempWords.removeAll(tempWords);
	    		tempWords.addAll(value);
	    		tempPattern = key;
	    	}
	    }
	    //update wordFam with the largest word family and the pattern
	    tempFam.put(tempPattern, tempWords);
	    wordFam = tempFam;
	    //update pattern with the new guess
	    for (int i=0; i<pattern.length; i++) {
	    	if (pattern[i] == '-') {
	    		pattern[i] = tempPattern.charAt(i);
	    	}
	    }
	  
	    //update the wordSet
	    wordSet = tempWords;
	    
	    return wordFam;
	}
	
	//get the number of occurrences of the guessed letter in the new pattern
	int getGuessCount(Map<String, Set<String>> wordFam) {
	    int guessCount = 0;
	    //to iterate through the map
	    for (Map.Entry<String, Set<String>> entry : wordFam.entrySet()) {
	    	//get the pattern from the map
	    	String key = entry.getKey();
	    	for (int i=0; i<key.length(); i++) {
	    		//count the characters of the pattern
	    		if (key.charAt(i)!= '-') {
	    			guessCount++;
	    		}
	    	}
	    }
	    //if you guessed no correct letter
	    if(guessCount == 0) {
	    	//update how many guesses you have left
		    this.max= this.max-1;
	    }
	    return guessCount;
	}
}
