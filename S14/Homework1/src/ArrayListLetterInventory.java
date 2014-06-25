import java.util.*;

public class ArrayListLetterInventory implements LetterInventory {
	ArrayList<Integer> count = new ArrayList<Integer>();
	int size;
	char[] chars;
	String data;

	ArrayListLetterInventory(String data) {
		//converts the data to lower case
		this.data = data.toLowerCase();
		//removes all non letters from the string
		this.data = this.data.replaceAll("[^a-z]", "");
		
		//load the count arraylist with 0s
		for (int i=0; i<26; i++) {
			count.add(0);
		}
		
		//turns data to a char array
		chars = this.data.toCharArray();
				
		//for every character in data
		for (int i=0; i<this.data.length(); i++) {	
			//check if char isn't an 'a'
			if (chars[i] > 'a') {
				//see how far away from a the char is
				int index = chars[i] - 'a';
				//count it in the appropriate index
				count.set(index, count.get(index)+1);
			//char is an a
			} else {
				count.set(0, count.get(0)+1);
			}
		}
		
		//used for the size method
		size = this.data.length();
				
		/*size = 0;
		for (int i=0; i<count.length; i++) {
			size = size +count[i];
		} */
	}
		
	public int get(char letter) {
		//if not an alphabet character throw illegal argument exception
		if (!Character.isLetter(letter)) {
			throw new IllegalArgumentException();
		}
		
		letter = Character.toLowerCase(letter);
		//-10 for value offset
		int index = Character.getNumericValue(letter)-10;
		return count.get(index);
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
		
		//-10 for value offset
		int index = Character.getNumericValue(letter)-10;
		count.set(index, value);
		
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
		chars = this.data.toCharArray();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		//checks if any value is greater than 0 (not empty)
		for (int i=0; i<count.size(); i++) {
			if (count.get(i)>0) {
				return false;
			}
		}
		//else its empty
		return true;
	}
	
	public String toString() {
		//put the chars array in alphabetical order
		Arrays.sort(chars);
		//turn sorted char array into a string
		String sorted = new String(chars);
		sorted = "[" + sorted + "]";
				
		return sorted;
	}
	
	public LetterInventory add(LetterInventory other) {
		ArrayList<Integer> newCount = new ArrayList<Integer>();
		
		//load the count arraylist with 0s
		for (int i=0; i<26; i++) {
			newCount.add(0);
		}
				
		
		//new count arraylist for new arraylistletterinventory
		for (int i=0; i<newCount.size(); i++) {
			//used to get the count of letter in other
		    char letter = (char) (i+97);
		        
			int value = count.get(i) + other.get(letter);
			newCount.set(i, value);
		}
		
		String inventoryString="";
		//creates a string of letters from the count
		for (int i=0; i<newCount.size(); i++) {
			while (newCount.get(i) > 0) {
				inventoryString += String.valueOf((char)(i + 97));
				//decrements the count
				newCount.set(i, newCount.get(i)-1);
			}
		}
		LetterInventory newInventory = new ArrayListLetterInventory(inventoryString);
		return newInventory;
	}
	
	public LetterInventory subtract(LetterInventory other) {
		ArrayList<Integer> newCount = new ArrayList<Integer>();
		
		//load the count arraylist with 0s
		for (int i=0; i<26; i++) {
			newCount.add(0);
		}
				
		
		//new count arraylist for new arraylistletterinventory
		for (int i=0; i<newCount.size(); i++) {
			
			//used to get the count of letter in other
		    char letter = (char) (i+97);
		        
			int value = count.get(i) - other.get(letter);
			newCount.set(i, value);
			
			if (newCount.get(i) < 0) {
				return null;
			}
		}
		
		String inventoryString="";
		//creates a string of letters from the count
		for (int i=0; i<newCount.size(); i++) {
			while (newCount.get(i) > 0) {
				inventoryString += String.valueOf((char)(i + 97));
				//decrements the count
				newCount.set(i, newCount.get(i)-1);
			}
		}
		LetterInventory newInventory = new ArrayListLetterInventory(inventoryString);
		return newInventory;
	}
}
