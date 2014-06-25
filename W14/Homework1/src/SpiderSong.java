//this program creates the Spider Song
public class SpiderSong {
	
	public static void main(String[] args) {
		firstVerse();
		secondVerse();
		thirdVerse();
		fourthVerse();
		fifthVerse();
		sixthVerse();
		lastVerse();
	}
	
	//creates the first line that appears in all the verses
	static void firstLine(String creature) {
		System.out.println
		("There was an old woman who swallowed a " + creature +".");
	}
	
	//creates the two lines that appear at the end of every verse
	static String flyDie() {
		return "I don't know why she swallowed that fly,\n"
				+ "Perhaps she'll die. \n\n";
	}
	
	//creates the series of animals catching each other that builds as
	//the verses increase
	static void swallowedStrings(int x) {
		String one= "She swallowed the spider to catch the fly, \n"
				+ flyDie(); 
		String two= "She swallowed the bird to catch the spider,\n" 
				+ one;
		String three="She swallowed the cat to catch the bird,\n"
				+ two;
		String four="She swallowed the dog to catch the cat,\n"
				+ three;
		String five="She swallowed the man to catch the dog, \n"
				+ four;
		if (x==1) {
			System.out.print(one);
		} else if (x==2) {
			System.out.print(two);
		} else if (x==3) {
			System.out.print(three);
		} else if (x==4) {
			System.out.print(four);
		} else {
			System.out.print(five);
		}
		}
	
	static void firstVerse() {
		firstLine("fly");
		System.out.println(flyDie());
	}
	
	static void secondVerse() {
		firstLine("spider");
		System.out.println("That wriggled and iggled and jiggled inside her.");
		swallowedStrings(1);
	}
	
	static void thirdVerse() {
		firstLine("bird");
		System.out.println("How absurd to swallow a bird.");
		swallowedStrings(2);
	}
	
	static void fourthVerse() {
		firstLine("cat");
		System.out.println("Imagine that to swallow a cat.");
		swallowedStrings(3);
	}
	
	static void fifthVerse() {
		firstLine("dog");
		System.out.println("What a hog to swallow a dog.");
		swallowedStrings(4);
	}
	
	static void sixthVerse() {
		firstLine("man");
		System.out.println("Quite the plan to swallow a man.");
		swallowedStrings(5);
	}
	
	static void lastVerse() {
		firstLine("horse");
		System.out.println("She died of course.");
	}
}