
public class tryExcept {
	
	public static void main(String[] args) {
		int[] array = {5,3,4,8,10,2,7};
		
			try {
				for (int i=0; i<array.length; i++) {
					if (array[i]== 10) {
						throw new IllegalStateException();
					}
					System.out.println(array[i]);
				}
			} catch (IllegalStateException e) {
				System.out.println("caught IllegalStateException");	
			} finally {
				System.out.println("done");
				System.exit(1);
			}
	}
}
		
