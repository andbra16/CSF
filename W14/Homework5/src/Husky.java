import java.awt.*;
import java.util.*;
 
public class Husky extends Critter{
	
	public Color getColor() {
	    //create the color purple
	    Color Purple = new Color(160, 32, 240);
	    return Purple;
	}
	
	public String toString() {
	   return "H";
	}
	
	//the husky moves in a random unpredictable fashion
	public Action getMove(CritterInfo info) {
	    if (info.getFront() == Neighbor.OTHER) {
	    	return Action.INFECT;	
	    } else if (info.getFront() == Neighbor.EMPTY) {
	    	return Action.HOP;	
	    } else {
	    	//random number generator
	    	Random randy = new Random();
	    	//random number between 1-2
	    	int randNum= randy.nextInt(2)+1;
	    	
	    	if (randNum==1) {
	    		return Action.LEFT;
	    	} else {
	    		return Action.RIGHT;
	    	}
	    }
	}
}
