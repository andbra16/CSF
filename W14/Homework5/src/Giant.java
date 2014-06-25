import java.awt.Color;

public class Giant extends Critter {
	//used to determine return string
	int count= 0;
	//array of the return strings
	String[] feeFieFoe= {"fee", "fie", "foe", "fum"};
	int index = -1;
	
	public Action getMove(CritterInfo info) {
	    if (info.getFront() == Neighbor.OTHER) {
	 	    return Action.INFECT;
	    } else if (info.getFront() == Neighbor.EMPTY) {
	    		return Action.HOP;
	    } else {
	    	return Action.RIGHT;
	    }
	}
	 
	public Color getColor() {
		return Color.GRAY;
	}
	 
	public String toString() {
		//after 6 times change the index to another string
		if (count%6 == 0) {
			count++;
			index++;
			//reset index to fee after fum
			if (index>3) {
				index=0;
			}
			return feeFieFoe[index];
		} else {
			count++;
			return feeFieFoe[index];
		}
	}
}

