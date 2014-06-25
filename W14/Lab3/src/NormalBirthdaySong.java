
public class NormalBirthdaySong {
	
	public static void main(String[] args) {
		song("Brandon");
	}
	
	static void bDay() {
		System.out.println("Happy birthday to you");
	}
	
	static void dear(String name) {
		System.out.println("Happy birthday, dear " + name);
	}
	
	static void song(String name) {
		bDay();
		bDay();
		dear(name);
		bDay();
	}

}
