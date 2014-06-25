
//Class for storing a single node of a QuestionTree
public class QuestionNode {
	public String thing;
	public String rule;
	public QuestionNode left;
	public QuestionNode right;
	
	//constructs null node
	public QuestionNode() {
	}
	
	//constructs leaf node with given data
	public QuestionNode(String rule, String thing) {
		this.rule=rule;
		this.thing=thing;
		
	}
	
	//constructs leaf/branch node with given data
	public QuestionNode(String rule, String thing, QuestionNode left, QuestionNode right) {
		this.rule = rule;
		this.thing = thing;
		this.left = left;
		this.right = right;
	}
}