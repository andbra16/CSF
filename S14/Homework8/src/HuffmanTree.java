import java.io.PrintStream;
import java.util.*;

public class HuffmanTree {
	private HuffmanNode tree;
	private PriorityQueue<HuffmanNode> que= new PriorityQueue<HuffmanNode>();
	private HuffmanNode eof = new HuffmanNode(1, 256); //end of file node
	
	HuffmanTree(int[] count) {
		//make a huffman node from the data and put it in the que
		que.add(eof);
		for (int i=0; i<count.length; i++) {
			//if freq >0
			if(count[i]>0) {
				HuffmanNode node = new HuffmanNode(count[i], i);
				//System.out.println("character: " + node.character);
				que.add(node);
				//HuffmanNode test = que.remove();
				//System.out.println(test.character);
			}
		}
		
		/*Iterator iter = que.iterator();
		while(iter.hasNext()) {
			HuffmanNode node = que.remove();
			System.out.println("character: " + node.character);
			System.out.println("frequency: " + node.frequency);
		} */
		
		//start creating the huffman tree with the individual nodes from que
		while (que.size() != 1) {
			HuffmanNode node1 = que.remove();
			HuffmanNode node2 = que.remove();
			//System.out.println("node1 character: " + node1.character);
			//System.out.println("node1 freq: " + node1.frequency);
			//System.out.println("node2 character: " + node2.character);
			//System.out.println("node2 freq: " + node2.frequency);
			HuffmanNode sum = new HuffmanNode(node1, node2);
			//System.out.println("root freq: " + sum.frequency);
			//System.out.println("left freq: " + sum.left.frequency);
			//System.out.println("right freq: " + sum.right.frequency);
			que.add(sum);
		}
		
		tree = que.remove();
		//System.out.println("root freq: " + tree.frequency);
		//System.out.println("left freq: " + tree.left.frequency);
		//System.out.println("right freq: " + tree.right.frequency);
		
		//insert codes into the tree
		tree.traverse(tree);
		
		//figure out how to implement the "code" in the tree for the write out
	}
	
	void write(PrintStream output) {
		//System.out.println("nothing");
		output = write(output, tree);
	}
	
	private PrintStream write(PrintStream output, HuffmanNode root) {
		if(root != null) {
			if(root.character != 0) {
				output.println(root.character);
				output.println(root.code);
				//System.out.println("character: " + root.character);
				//System.out.println("frequency: " +root.frequency);
			}
			write(output, root.left);
			write(output, root.right);
		}
		return output;
	}
}
