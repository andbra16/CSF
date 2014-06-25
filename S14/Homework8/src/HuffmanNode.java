
public class HuffmanNode implements Comparable<HuffmanNode> {
	public int frequency;
	public int character;
	public String code = "0";
	public HuffmanNode left;
	public HuffmanNode right;
	
	HuffmanNode() {	
	}
	
	HuffmanNode(int frequency, int character) {
		this.frequency = frequency;
		this.character = character;
	}
	
	HuffmanNode(HuffmanNode left, HuffmanNode right) {
		this.frequency = left.frequency + right.frequency;
		this.left = left;
		this.right = right;	
	}

	public int compareTo(HuffmanNode other) {
		return (this.frequency - other.frequency);
	}
	
	public void traverse (HuffmanNode root){ 
	    if (root.left != null){
	    	root.left.code= root.code + "0";
	        traverse (root.left);
	    }
	    System.out.println(root.frequency);
	    if (root.right != null){
	    	root.right.code= root.code + "1";
	        traverse (root.right);
	    }
	}
}
