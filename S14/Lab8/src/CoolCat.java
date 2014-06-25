
public class CoolCat extends Hipster {
	String catchphrase;
	
	CoolCat(String name, String catchphrase) {
		super(name);
		this.catchphrase = catchphrase;
	}
	
	public void achieveFlowState() {
		System.out.println(name + ": " + this.catchphrase);
	}
	
}
