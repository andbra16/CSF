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
	
	static String flyDie() {
		return "I don't know why she swallowed that fly,\n"
				+ "Perhaps she'll die. \n";
	}
	
	//creates the series of animals catching each other that builds as
	//the verses increase
	static void swallowedStrings(int x) {
		String[] swallows = new String[5];
		
		swallows[4]= "She swallowed the spider to catch the fly, \n"
				+ flyDie();
		
		swallows[3]= "She swallowed the bird to catch the spider,";
		
		swallows[2]="She swallowed the cat to catch the bird,";
		
		swallows[1]="She swallowed the dog to catch the cat,";
		
		swallows[0]="She swallowed the man to catch the dog,";
         
		for (int i = x; i<swallows.length; i++) {
			System.out.println(swallows[i]);
		}
		}
	
	static void firstVerse() {
		firstLine("fly");
		System.out.println(flyDie());
	}
	
	static void secondVerse() {
		firstLine("spider");
		System.out.println("That wriggled and iggled and jiggled inside her.");
		swallowedStrings(4);
	}
	
	static void thirdVerse() {
		firstLine("bird");
		System.out.println("How absurd to swallow a bird.");
		swallowedStrings(3);
	}
	
	static void fourthVerse() {
		firstLine("cat");
		System.out.println("Imagine that to swallow a cat.");
		swallowedStrings(2);
	}
	
	static void fifthVerse() {
		firstLine("dog");
		System.out.println("What a hog to swallow a dog.");
		swallowedStrings(1);
	}
	
	static void sixthVerse() {
		firstLine("man");
		System.out.println("Quite the plan to swallow a man.");
		swallowedStrings(0);
	}
	
	static void lastVerse() {
		firstLine("horse");
		System.out.println("She died of course.");
	}
}
