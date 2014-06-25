import java.util.*;

public class GrammarSolver {
	
	private Map<String, String[]> grammarRules;
	
	//checks if list is empty
	GrammarSolver(List<String> grammar) {
		if (grammar.isEmpty() || grammar == null) {
			throw new IllegalArgumentException("List is empty.");
		}
		
		grammarRules = new TreeMap<String, String[]>();
		
		//for each string in grammar
		for (String rule : grammar) {
			//separate the nonterminal from the rules
			String[] parts = rule.split("::=");
			//nonterminal
			String key = parts[0];
			//rules
			String[] value = parts[1].split("[|]");
			//check for more than one of the same nonterminal
			for (int i=0; i<value.length; i++) {
				if (value[i].equals(key)) {
					throw new IllegalArgumentException("Grammar contains more "
							+ "than one of the same nonterminal.");
				}
			}
			//System.out.println(grammar);
			grammarRules.put(key, value);
			//System.out.println(grammarRules.toString());
		}
	}
	
	//Returns true if the given symbol is a nonterminal of the grammar; 
	//returns false otherwise.
	boolean grammarContains(String symbol) {
		if (grammarRules.containsKey(symbol)) {
			return true;
		}
		return false;
	}
	
	//returns a String representation of the various nonterminal symbols from the grammar
	//as a sorted, comma-separated list enclosed in square brackets, as in “[<np>, <s>, <vp>]”
	String getSymbols() {
		return grammarRules.keySet().toString();
	}
	
	//generates the given number of occurrences of the symbol
	//with random selection of rules
	String[] generate(String symbol, int times) {		
		if (times < 0 || !grammarContains(symbol)) {
			throw new  IllegalArgumentException("times is less than 0, or "
					+ "the nonterminal isn't in the list");
		}
		
		String[] result = new String[times];
		for (int i=0; i<times; i++) {
			result[i]= "";
		}
		
		 for(int i = 0; i <times; i++) {
			//random generator
			Random randy = new Random();
			//get the rules for the symbol
		    String[] rules = grammarRules.get(symbol);
		    //picks a random rule from the rules
		    String randomRule = rules[randy.nextInt(rules.length)];
		    //checks if there is more than one rule in the randomRule (nonterminal case)
		    String[] randomRules = randomRule.split("[ \t]+");
		    //if the random rule is a nonterminal
		    if(grammarContains(randomRules[0])) {
		    	//only one nonterminal
		    	if(randomRules.length==1) {
		    		//get the rule for the nonterminal
		    		String[] returnString = generate(randomRules[0], 1);
		    		returnString[0] = returnString[0].trim(); //get rid of white spaces
                    result[i] += returnString[0]; //add the string to the result index
                //more than one nonterminal
		    	} else if (randomRules.length >1) {
		    		//for each nonterminal get the rule for them
		    		for (int j=0; j<randomRules.length; j++) {
		    			String[] returnString = generate(randomRules[j], 1);
		    			returnString[0] = returnString[0].trim(); //get rid of white spaces
                        result[i] += returnString[0]; //add the string to the result index
                        result[i] += " "; //space after the sring
		    		}
		    	}
		    //rule wasn't a nonterminal	
		    } else {
		    	result[i]=randomRule;
		    }
		}
		return result;
	}
}
