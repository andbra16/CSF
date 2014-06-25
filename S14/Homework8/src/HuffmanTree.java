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
				System.out.println("character: " + node.character);
				que.add(node);
			}
		}
		
		//start creating the huffman tree with the individual nodes from que
		while (que.size() != 1) {
			HuffmanNode node1 = que.remove();
			HuffmanNode node2 = que.remove();
			HuffmanNode sum = new HuffmanNode(node1, node2);
			
			que.add(sum);
		}
		
		tree = que.remove();
		
		//insert codes into the tree
		tree.traverse(tree);
		
		//figure out how to implement the "code" in the tree for the write out
	}
	
	void write(PrintStream output) {
		System.out.println("nothing");
		//output = write(output, tree);
	}
	
	private PrintStream write(PrintStream output, HuffmanNode root) {
		if(root != null) {
			//output.println(root.character);
			//output.println(root.code);
			//write(output, root.left);
			//write(output, root.right);
		}
		return output;
	}
}
