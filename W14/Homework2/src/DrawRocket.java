
//this programs draws a rocket ship in Ascii Art
public class DrawRocket {
	
	//creates a class constant that changes the 
	//size of the rocket ship
	public static final int SIZE=3;
	
	// main method
	public static void main(String[] args) {
		topBot();
		divider();
		upperDiamond();
		lowerDiamond();
		divider();
		lowerDiamond();
		upperDiamond();
		divider();
		topBot();
	}
	
	//creates the top and bottom of the rocket (triangle shape of /**\)
	static void topBot() {
		for (int down=1; down<=SIZE+2; down++) {
			for (int across=1; across<=2*SIZE-down; across++) {
				System.out.print(" ");
			}
			for (int across=1; across<=down; across++) {
				System.out.print("/");
			}
			System.out.print("**");
			for (int across=1; across<=down; across++) {
				System.out.print("\\");
			}
			System.out.println();	
		}
	}
	
	//creates the straight line of (*=*=*=) found 3 times in the rocket
	static void divider() {
		System.out.print("+");
		for (int across=1; across<=2*SIZE; across++) {
			System.out.print("*=");
		}
		System.out.print("+");
		System.out.println();
	}
	
	//creates the (../\..../\..) found twice in the body of the rocket
	static void upperDiamond() {
		for (int down=1; down<=SIZE; down++) {
			System.out.print("|");
			for (int across=1; across<=SIZE-down; across++) {
				System.out.print(".");
			}
			for (int across=1; across<=down; across++) {
				System.out.print("/\\");
			}
			for (int across=1; across<=2*SIZE-2*down; across++) {
				System.out.print(".");
			}
			for (int across=1; across<=down; across++) {
				System.out.print("/\\");
			}
			for (int across=1; across<=SIZE-down; across++) {
				System.out.print(".");
			}
			System.out.print("|");
			System.out.println();
		}
	}
	
	//creates the (..\/....\/..) found twice in the body of the rocket
	static void lowerDiamond() {
		for (int down=1; down<=SIZE; down++) {
			System.out.print("|");
			for (int across=1; across<=down-1; across++) {
				System.out.print(".");
			}
			for (int across=1; across<=SIZE+1-down; across++) {
				System.out.print("\\/");
			}
			for (int across=1; across<=2*down-2; across++) {
				System.out.print(".");
			}
			for (int across=1; across<=SIZE+1-down; across++) {
				System.out.print("\\/");
			}
			for (int across=1; across<=down-1; across++) {
				System.out.print(".");
			}
			System.out.print("|");
			System.out.println();
		}
	}
}
