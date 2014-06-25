
public class Hipster implements Flow {
	String name;
	
	Hipster(String name) {
		this.name = name;
	}
	
	public void achieveFlowState() {
		System.out.println(this.name + " tips his/her fedora.");
	}

}
