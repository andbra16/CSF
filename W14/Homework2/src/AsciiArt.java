
//this program creates a Christmas Tree in Ascii Art
public class AsciiArt {
	
	//creates a class constant that changes
	//the size of the Christmas Tree
	public static final int SIZE=5;
	
	public static void main(String[] args) {
		star();
		tree();
		stump();
	}
	
	//creates the star of the tree
	static void star() {
		for (int across=1; across<=SIZE; across++) {
			System.out.print(" ");
		}
		System.out.print("\\ /");
		System.out.println();
		
		for (int across=1; across<=SIZE-2; across++) {
			System.out.print(" ");
		}
		System.out.print("-->*<--");
		System.out.println();
	}
	
	//creates the body of the tree
	static void tree() {
		int x=1;
		for (int down=1; down<=SIZE; down++) {
			x++;
			for (int across=1; across<=SIZE+1-down; across++) {
				System.out.print(" ");
			}
			System.out.print("/");
			System.out.print("_");
			if (x%2==0) {
				for (int across=1; across<=down-1; across++) {
					System.out.print("\\");
					System.out.print("_");
				}			
			}else {
				for (int across=1; across<=down-1; across++) {
					System.out.print("/");
					System.out.print("_");
				}
			}
			System.out.print("\\");
			System.out.println();
		}
	}
	
	//creates the stump of the tree
	static void stump() {
		for (int across=1; across<=SIZE; across++) {
			System.out.print(" ");
		}
		System.out.print("[");
		for (int across=1; across<=SIZE/3; across++) {
			System.out.print("_");
		}
		System.out.print("]");
	}
}
