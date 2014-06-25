import java.util.Arrays;

public class ArrayLetterInventory implements LetterInventory {
	String data;
	int letters = 26;
	//array to count the letters
	int[] count = new int[letters];
	//array to separate string into chars
	char[] chars;
	int size;

	public static void main(String[] args) {
		LetterInventory inventory1 = new ArrayLetterInventory("Barbara Bush");
		//System.out.println(inventory1.get('w'));
		
		LetterInventory inventory2 = new ArrayLetterInventory("abash");
		//System.out.println(inventory2.get('L'));
		
		//System.out.println(inventory2.size());
		
		//System.out.println(inventory2.isEmpty());
		
		//System.out.println(inventory2.toString());
		//inventory2.set('g', 0);
		//System.out.println(inventory2.get('L'));
		//System.out.println(inventory2.size());
		
		//System.out.println(inventory2.toString());
        
		
		//LetterInventory inventory1 = new LetterInventory("Hillary Clintonz");

		//LetterInventory inventory2 = new LetterInventory("Hillary Clinton");

		LetterInventory sub = inventory1.subtract(inventory2);
		System.out.println(sub.toString()); 
	}
	
	ArrayLetterInventory(String data) {
		//converts the data to lower case
		this.data = data.toLowerCase();
		//removes all non letters from the string
		this.data = this.data.replaceAll("[^a-z]", "");
		
		//turns data to a char array
		chars = this.data.toCharArray();
		
		//for every character in data
		for (int i=0; i<this.data.length(); i++) {	
			//check if char isn't an 'a'
			if (chars[i] > 'a') {
				//see how far away from a the char is
				int index = chars[i] - 'a';
				//count it in the appropriate index
				count[index] = count[index] +1;	
			//char is an a
			} else {
				count[0] = count[0] +1;
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
		return count[index];
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
		
		//update the count index (-10 for value offset)
		int index = Character.getNumericValue(letter)-10;
		count[index] = value;
		
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
		for (int i=0; i<count.length; i++) {
			if (count[i]>0) {
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
	
	public ArrayLetterInventory add(LetterInventory other) {
		int[] newCount = new int[letters];
		
		//new count array for new arrayletterinventory
		for (int i=0; i<newCount.length; i++) {
			//used to get the count of letter in other
			char letter = (char) (i+97);
			newCount[i] = count[i] + other.get(letter);
		}
		
		String inventoryString="";
		//creates a string of letters from the count
		for (int i=0; i<newCount.length; i++) {
			while (newCount[i] > 0) {
				inventoryString += String.valueOf((char)(i + 97));
				//decrements the count
				newCount[i] = newCount[i]-1;
			}
		}
		ArrayLetterInventory newInventory = new ArrayLetterInventory(inventoryString);
		return newInventory;
	}
	
	public ArrayLetterInventory subtract(LetterInventory other) {
		int[] newCount = new int[letters];
		
		//new count array for new arrayletterinventory
		for (int i=0; i<newCount.length; i++) {
			//used to get the count of letter in other
			char letter = (char) (i+97);
			newCount[i] = count[i] - other.get(letter);
			
			if (newCount[i] < 0) {
				return null;
			}
		}
		
		String inventoryString="";
		//creates a string of letters from the newCount
		for (int i=0; i<newCount.length; i++) {
			while (newCount[i] > 0) {
				inventoryString += String.valueOf((char)(i + 97));
				//decrements the count
				newCount[i] = newCount[i]-1;
			}
		}
		ArrayLetterInventory newInventory = new ArrayLetterInventory(inventoryString);
		return newInventory;
	}
}
