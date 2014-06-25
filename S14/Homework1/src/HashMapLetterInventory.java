import java.util.*;

public class HashMapLetterInventory implements LetterInventory {
	HashMap<Character, Integer> count = new HashMap<Character, Integer>();
	int size;
	String data;

	HashMapLetterInventory(String data) {
		//converts the data to lower case
		this.data = data.toLowerCase();
		//removes all non letters from the string
		this.data = this.data.replaceAll("[^a-z]", "");
		
		//load the count hashmap with letters a-z
		for (int i=97; i<123; i++) {
			count.put((char)i, 0);
		}
		
		//increment the letter if it is found in the string data
		for (int i=0; i<this.data.length(); i++) {
			count.put(this.data.charAt(i), count.get(this.data.charAt(i)) +1);
		}
		//used for the size method
		size = this.data.length();
	}

	public int get(char letter) {
		//if not an alphabet character throw illegal argument exception
		if (!Character.isLetter(letter)) {
			throw new IllegalArgumentException();
		}
		
		letter = Character.toLowerCase(letter);
		
		return count.get(letter);
	}

	public void set(char letter, int value) {
		//if not an alphabet character or value is negative, 
		//throw illegal argument exception
		if (!Character.isLetter(letter) || value<0) {
			throw new IllegalArgumentException();
		}
		
		letter = Character.toLowerCase(letter);
		
		//update size for the new value
		if (value == 0) {
			size = size - get(letter);
		} else if (value < get(letter)) {
			size = size - value;
		} else {
			size = size + value;
		}
		
		//update count
		count.put(letter, value);
		
		//update the toString for the new value
		//get the new value of letters
		String newLetters = "";
		for (int i=0; i<value; i++) {
			newLetters = newLetters + letter;
		}
		//remove old letters
		this.data = this.data.replace(String.valueOf(letter), "");
		//replace new letters		
		this.data = this.data + newLetters;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		Iterator iter = count.keySet().iterator();
		
		//checks if any value is greater than 0 (not empty)
		while(iter.hasNext()) {
			Character key = (Character)iter.next();
			if (count.get(key) > 0) {
				return false;
			}
		}
		//else its empty
		return true;
	}

	public String toString() {
		//turn the string into an array
		char[] chars = this.data.toCharArray();
		
		//put the chars array in alphabetical order
		Arrays.sort(chars);
		
		//turn sorted char array into a string
		String sorted = new String(chars);
		sorted = "[" + sorted + "]";
				
		return sorted;
	}

	public LetterInventory add(LetterInventory other) {
		HashMap<Character, Integer> newCount= new HashMap<Character, Integer>();
		
		//load the newCount hashmap with letters a-z
		for (int i=97; i<123; i++) {
			newCount.put((char)i, 0);
		}
		
		Iterator iter = newCount.keySet().iterator();
		while(iter.hasNext()) {
			Character key = (Character)iter.next();
			//combine the values of the two hashmap keys
			Integer value = count.get(key) + other.get(key);
			
			//make new value in new hashmap
			newCount.put(key, value);
		}
		
		String inventoryString="";
		//creates a string of letters from the newCount
		iter = newCount.keySet().iterator();
		while(iter.hasNext()) {
			Character key = (Character)iter.next();
			while (newCount.get(key)>0) {
				inventoryString += key;
				//decrements the count
				newCount.put(key, newCount.get(key)-1);
			}
		}
		
		LetterInventory newInventory = new HashMapLetterInventory(inventoryString);
		return newInventory;
	}

	public LetterInventory subtract(LetterInventory other) {
		HashMap<Character, Integer> newCount= new HashMap<Character, Integer>();
		
		//load the newCount hashmap with letters a-z
		for (int i=97; i<123; i++) {
			newCount.put((char)i, 0);
		}
		
		Iterator iter = newCount.keySet().iterator();
		while(iter.hasNext()) {
			Character key = (Character)iter.next();
			//combine the values of the two hashmap keys
			Integer value = count.get(key) - other.get(key);
			if (value < 0) {
				return null;
			}
			
			//put new value in new hashmap
			newCount.put(key, value);
		}
		
		String inventoryString="";
		//creates a string of letters from the newCount
		iter = newCount.keySet().iterator();
		while(iter.hasNext()) {
			Character key = (Character)iter.next();
			while (newCount.get(key)>0) {
				inventoryString += key;
				//decrements the count
				newCount.put(key, newCount.get(key)-1);
			}
		}
		LetterInventory newInventory = new HashMapLetterInventory(inventoryString);
		return newInventory;
	}
}