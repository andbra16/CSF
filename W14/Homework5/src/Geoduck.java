import java.awt.*;
import java.util.*;

//the geoduck is a patient creature and will wait for its prey
//if no prey has been seen by the geoducks they will dig out
//of their holes and go on the hunt
public class Geoduck extends Critter {
	
	// a list of all the geoducks I have
	public static ArrayList<Geoduck> geoduckList = new ArrayList<Geoduck>();
	
	public int moveCheck=0;
	public int neighborCheck= 0;
	public boolean digCheck = false;
	public int movesSinceOther= 0;
	private Neighbor[] sides = new Neighbor[4];
	
	public Geoduck() {
		//adds geoducks to the list
		geoduckList.add(this);
	}
	
	public Color getColor() {
		//random number generator
		Random randy = new Random();
		
		int red = randy.nextInt(255);
		int green = randy.nextInt(255);
		int blue = randy.nextInt(255);
        
		//creates a random color
		Color randomColor = new Color(red, blue, green);
		
		return randomColor;
	}
	
	public String toString() {
		return "G";
	}
	
	public Action getMove(CritterInfo info) {
		activityCheck(info);
	    if (digCheck) {
	    	return digOut(info);
	    } else {
	    	return stationary(info);
	    }
	}
	
	//in stationary the geoduck doesn't move
	//he stays in his hole and products his other friends
	public Action stationary(CritterInfo info) {
		 if (info.getFront() == Neighbor.OTHER) {
		    return Action.INFECT;
		 } else  if (info.getLeft() == Neighbor.SAME) {
			 return Action.RIGHT;
		 } else if (info.getRight() == Neighbor.SAME) {
			 return Action.LEFT;
		 } else {
			 return Action.LEFT;
		 }
	}
	
	//if the geoduck grows tired he will climb out of his
	//hole and move acrossed the grid
	public Action digOut(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getLeft() == Neighbor.OTHER) {
			return Action.LEFT;
		} else if (info.getRight() == Neighbor.OTHER) {
			return Action.RIGHT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		} else {
			return Action.LEFT;
		}
	}
	
	public void activityCheck(CritterInfo info) {
		refreshList(); //removes dead geoducks
		moveCheck++; //keeps track of geoducks moves
		
		//store surroundings in an array
		sides[0] = info.getFront();
		sides[1] = info.getLeft();
		sides[2] = info.getBack();
		sides[3] = info.getRight();
		
		int others = 0;
		
		//checks if the geoduck has encountered an enemy
		for (int i = 0; i < sides.length; i++) {
			if (sides[i] == Neighbor.OTHER) {
				others++;
			}
		}
		
		//if it hasnt seen any1 
		if (others == 0){
			movesSinceOther++;
		//if it has
		} else {
			movesSinceOther=0;
		}
		
		int countNoContact = 0;
		
		//checks if other geoducks have seen an enemy 
		//if they havent seen one in 200 steps then increment
		//no contact
		for (int i = 0; i < geoduckList.size(); i++){
			if (geoduckList.get(i).getMovesSinceOther() > 200){
				countNoContact++;
			}
		}
		
		//if the geoducks havent had contact have them digOut
		//and move
		if (countNoContact > geoduckList.size()*0.9){
			digCheck = true;
		}
	}
	
	public int getMoveCheck() {
		return moveCheck;
	}
	
	public int getMovesSinceOther() {
		return movesSinceOther;
	}
	
	//removes geoducks by checking if they have moved
	//+5 turns for good measure....
	public void refreshList() {
		for (int i = 0; i < geoduckList.size(); i++) {
			if (geoduckList.get(i).getMoveCheck() + 5 < moveCheck) {
				geoduckList.remove(i);
			}
		}
	}
}
