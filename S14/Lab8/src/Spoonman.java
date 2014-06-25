
public class Spoonman extends Musician {
	
	Spoonman(String name) {
		super(name, (byte) 0, null, null);
	}

	public void achieveFlowState() {
		System.out.println(name + " plays his/her spoons.");
		
	}
}
