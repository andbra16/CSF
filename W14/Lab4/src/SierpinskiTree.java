
public class SierpinskiTree {
	
	public static int base=7;
	
	public static void main(String[] args) {
         String baseString = "";
         baseString += triangles(1, 0, 12);
         baseString += triangles(2, 0, 8);
         baseString += triangles(2, 4, 0);
         baseString += triangles(4, 0, 0);
         baseString += trunk(8, 12);
         System.out.println(baseString);
 }
	static String triangles(int n, int d, int l) {
		String result="";
		
		for (int i=1; i<=base; i+=2) {
			
			for (int k=0; k<l; k++) {
				result+=" ";
			}
			
			for (int k=0; k<n; k++) {
				
				for (int j=0; j<d; j++) {
					result+=" ";
				}
				
				for (int j=0; j<(base-i)/2; j++) {
					result+= " ";
				}
				
				for (int j=0; j<i; j++) {
					result+="*";
				}
				
				result+=" ";
				
				for (int j=0; j<(base-i)/2; j++) {
					result+=" ";
				}
				for (int j=0; j<d; j++) {
					result+=" ";
				}
			}
			result+="\n";
		}
		return result;
	}
	
	static String trunk(int n, int d) {
		String result="";
		
		for (int i=1; i<=n; i++) {
			
			for (int j=1; j<=d; j++) {
				result+= " ";
			}
			
			for (int j=1; j<=n; j++) {
				result+="*";
			}
			
			for (int j=1; j<=d; j++) {
				result+= " ";
			}
		result+="\n";
		}
	return result;
	}
	
}
