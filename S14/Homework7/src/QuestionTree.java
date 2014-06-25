import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {
	private QuestionNode tree;
	private Scanner console;
	
	//creates a new question binary searchtree
	QuestionTree() {
		tree = new QuestionNode("A:", "computer");
		console = new Scanner(System.in);
	}
	
	    //passed a Scanner reading a file,
		//assumed the file is legal and in stadard format
		//creates new QuestionTree from the given file 
		public void read(Scanner input) {
			tree = read(input, tree);

		}

		//passed a QuestionNode root
		//returns QuestionNode with data from input file
		//recursively updates subtrees until entire file
		//is read
		private QuestionNode read(Scanner input, QuestionNode root) {
			if(input.hasNextLine()) {
				String rule = input.nextLine();
				String thing = input.nextLine();
				if(rule.equals("Q:")) {
					root = new QuestionNode(rule, thing);
					root.left = read(input , root.left);
					root.right = read(input , root.right);			
				} else {
					root = new QuestionNode(rule, thing);
				}
			}
			return root;
		}
		
		//passed given printstream open for writing
		//stores current tree to output file
		public void write(PrintStream output) {
			output = write(output, tree);
		}
		
		
		//passed a QuestionNode root
		//prints to output file in preoder
		private PrintStream write(PrintStream output, QuestionNode root) {
			if(root != null) {
				output.println(root.rule);
				output.println(root.thing);
				write(output, root.left);
				write(output, root.right);
			}
			return output;
		}
		
		//post: updates the game based off yes/no questions
		public void askQuestions() {
			tree = askQuestions(tree);
		}
		
		//pre: passed QuestionNode root
		//post: returns updated QuestionNode
		//		  asks yes/no questions
		//		  prints whether the client/game won
		private QuestionNode askQuestions(QuestionNode root) {
			if(root != null) {
				//checks to see if root is "leaf" node
				if(root.rule.equals("A:")) {
					if(yesTo("Would your obect happen to be " + root.thing + "?")){
						System.out.println("Great, I got it right");
					}else {
						QuestionNode temp = root;
						System.out.print("What is the name of your object? ");
						QuestionNode answer = new QuestionNode("A:" , console.nextLine());
						System.out.println("Please give me a yes/no question that");
						System.out.println("distinguishes between your object");
						System.out.print("and mine--> ");
						String question = console.nextLine();
						//adds new question and answer to game
						if(yesTo("And what is the answer for your object?")){
							root = new QuestionNode("Q:", question, answer, temp);
						}else {
							root = new QuestionNode("Q:", question, temp, answer);
						}
					}
				} else {
					//recursively goes through the tree based off yes/no answer
					if(yesTo(root.thing)) {
						root.left = askQuestions(root.left);
					}else {
						root.right = askQuestions(root.right);
					}
				}
			}
			return root;
		}
		
		// post: asks the user a question, forcing an answer of "y " or "n";
		//       returns true if the answer was yes, returns false otherwise
		public boolean yesTo(String prompt) {
			System.out.print(prompt + " (y/n)? ");
			String response = console.nextLine().trim().toLowerCase();
			while (!response.equals("y") && !response.equals("n")) {
				System.out.println("Please answer y or n.");
				System.out.print(prompt + " (y/n)? ");
				response = console.nextLine().trim().toLowerCase();
			}
		return response.equals("y");
		}
}