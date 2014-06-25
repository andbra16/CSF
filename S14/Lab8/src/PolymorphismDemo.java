
public class PolymorphismDemo {
	
	public static void main(String[] args) {
		Hipster Tom = new Hipster("Tom");
		Hipster Bob = new CoolCat("Bob", "Groovy, man...");
		Musician Ted = new Spoonman("Ted");
		
		Flow[] f = {Tom, Bob, Ted};
		
		for (Flow object : f) {
			object.achieveFlowState();
		}
	}
}
