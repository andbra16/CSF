import java.awt.Color;

public class Bear extends Critter {
	boolean polar;
	//used for string
	int count = 1;
	
	public Bear(boolean polar) {
		this.polar = polar;
	}
	
	public Action getMove(CritterInfo info) {
	    if (info.getFront() == Neighbor.OTHER) {
	    	return Action.INFECT;	
	    } else if (info.getFront() == Neighbor.EMPTY) {
	    	return Action.HOP;	
	    } else {
	    	return Action.LEFT;
	    }
	}
	 
	public Color getColor() {
	    if (this.polar == true) {
	    	return Color.WHITE;
	    } else {
	    	return Color.BLACK;
	    }
	}
	 
	public String toString() {
	    count++;
	    //start as a /
	    if (count%2 == 0) {
	    	return "/";
	    //switch to a \ every other turn
	    } else {
	    	return "\\";
	    }
	}
}
