import java.awt.Color;

public class Lion extends Critter {
	//used to determine color
	int count = 0;
	Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
	//random int between 0 and 3
	int random = (int)(Math.random()*3);
	//starting color of the Lion
	Color color = colors[random];
	
	public Action getMove(CritterInfo info) {
	    if (info.getFront() == Neighbor.OTHER) {
	 	    return Action.INFECT;
	    } else if (info.getFront() == Neighbor.WALL ||
	    	info.getRight() == Neighbor.WALL) {
	    		return Action.LEFT;
	    } else if (info.getFront() == Neighbor.SAME) {
	    	 return Action.RIGHT;
	    } else {
	    	return Action.HOP;
	    }
	}
	 
	public Color getColor() {
	    //if the color hasn't been used three times, use same color
	     if (count%3 != 0) {
	    	 count++;
	    	 return color;
	     //else change the color and return new color
	     } else {
	    	 count++;
	    	 random = (int)(Math.random()*3);
	    	 color = colors[random];
	    	 return color;
	     }
	}
	 
	public String toString() {
		return "L";
	}
}
