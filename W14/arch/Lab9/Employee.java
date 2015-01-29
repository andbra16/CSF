
public class Employee {
	int ID;
	String name;
	static int n;
	
	Employee(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
	public static void main(String[] args) {
		Employee Bob = new Employee(1, "Bob");
		n = 5;
	}
}
