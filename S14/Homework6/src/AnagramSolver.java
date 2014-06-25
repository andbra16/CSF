import java.util.*;

public class AnagramSolver {
	
	 private Map<String, ArrayLetterInventory> dict;
     private Map<String, ArrayLetterInventory> anagram;
	
	AnagramSolver(List<String> list) {
		
		  dict = new HashMap<String, ArrayLetterInventory>();
	      
		 //gets each string in the list and matches that string
		 //with its letterinventory and puts it in the dictionary
         for (int i=0; i<list.size(); i++) {
             String temp = list.get(i);
             ArrayLetterInventory words = 
            		 	new ArrayLetterInventory(temp);
             dict.put(temp, words);
         }
	}
	
	void print(String s, int max) {
		//checks if the string is null or not
		if (s == null || max<0) {
			throw new IllegalArgumentException("s is null, or max is less than 0.");
		}
       
        ArrayLetterInventory words = new ArrayLetterInventory(s);
        anagram = new HashMap<String, ArrayLetterInventory>();
        
        //list of possible anagrams
        List<List<String>> possible = new ArrayList<List<String>>();
        //sets keys and values for the maps
        for (String word : dict.keySet()) {
            if (words.subtract(dict.get(word)) != null)
                anagram.put(word, dict.get(word));
        }
        
        ArrayList<String> anagrams = new ArrayList<String>();
        possible.add(findAnagrams(words, anagrams, max, anagram, 0));
       
        //System.out.println(possible.toString());
    }
	
	//method that finds the different anagrams in the list using the maps the max and the dictionary
    private ArrayList<String> findAnagrams(ArrayLetterInventory words, ArrayList<String> anagram, int max,
            Map<String, ArrayLetterInventory> smallDict, int level) {
        //creates a list of the solved anagrams
        ArrayList<String> solvedWord = new ArrayList<String>();
        //shells to keep track of the anagrams
        ArrayLetterInventory tempShell1;
        ArrayLetterInventory tempShell2;
        //checks if the level is smaller than the max or if max is equal to 0
        if (level < max || max == 0) {
            Iterator<String> iter = smallDict.keySet().iterator();
            //loop that goes through the list
            while (iter.hasNext()) {     
                String temp = iter.next();
                tempShell1 = new ArrayLetterInventory(temp);
                tempShell2 = words;
                if (tempShell2.subtract(tempShell1) != null) {
                       
                    anagram.add(temp);

                    tempShell2 = words.subtract(tempShell1);

                    if (tempShell2.isEmpty()) {

                        //System.out.println(anagram.toString());

                        solvedWord = anagram;
                	} else {
                        findAnagrams(tempShell2, anagram, max, smallDict, level + 1);
                        anagram.remove(anagram.size()-1);
                	}
                }
            }
        }
        return solvedWord;
    }
		
}


