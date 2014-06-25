import java.util.*;

public class AssassinManager {
	AssassinNode alive;
	AssassinNode dead;
	List<String> names;
	
	public static void main(String[] args) {
		
	}
	
	AssassinManager(List<String> names) {
		//check if list is empty
		if (names.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		dead = null;
		//the front of the list
		alive = new AssassinNode(names.get(0));
		//creates a list following alive
		AssassinNode current = alive;
		//creates a list of AssassinNodes from the string of names 
		for (int i=1; i<names.size(); i++) {
			 current.next = new AssassinNode(names.get(i));
			 //move down the list one time
			 current = current.next;
		}
		
	}
	
	//prints a list of players still in the kill ring
	void printKillRing() {
		 AssassinNode current = alive;
		//iterates through the AssassinNode list of alive
		while (current.next != null) {
           System.out.println("    "+ current.name + " is stocking " + current.next.name);
           current = current.next;
        }
        System.out.println("    "+ current.name + " is stocking " + current.name);
	}
	
	//prints a list of players that have been killed in most recent order
	void printGraveyard() {
		AssassinNode current = dead;
		//iterates through the AssassinNode list of dead
		while (current != null) {
			System.out.println("    " + current.name + " was killed by " + current.killer);
	        current = current.next;
	    }
	}
	
	//returns true if the player is still alive
	boolean killRingContains(String name) {
		AssassinNode current = alive;
		
		//iterates through the list of alive ppl
		while(current != null) {
            if (current.name.equalsIgnoreCase(name)) {
            	return true;
            }
            current = current.next;
		}
    return false;
	}
	
	//returns true if the given name is in the current graveyard
	boolean graveyardContains(String name) {
		AssassinNode current = dead;
		
		//iterates through the lest of dead ppl
		while (current != null) {
			if (current.name.equalsIgnoreCase(name)) {
                return true;
			}
			
			current = current.next;
		}
		return false;
	}
	
	//returns true if one player is left alive
	boolean gameOver() {
		if (alive.next == null) {
			return true;
		} else {
			return false;
		}
	}
	
	//returns the name of the last player alive
	String winner() {
		if (gameOver() == true) {
			return alive.name;
		} else {
             return null;
		}
	}
	
	public void kill(String name) {
        if(gameOver() == true) {
                throw new IllegalStateException();
        }
        if(killRingContains(name) == false) {
                throw new IllegalArgumentException();
        }
        
        AssassinNode aliveCurrent = alive;
        AssassinNode deadCurrent = dead;
        
        //current name is the victim
        if (aliveCurrent.name.equalsIgnoreCase(name)) {
        	//get the victims killer
            while(aliveCurrent.next != null) {
                   aliveCurrent = aliveCurrent.next;
            }
            
            //temporary dead list
            AssassinNode temp = dead;
            //the killer
            alive.killer = aliveCurrent.name;
            //the person who just got killed (first one in the alive list)
            deadCurrent = alive;
            //put a new person as the killers next
            alive = alive.next;
            //shift the null spot in the dead
            deadCurrent.next = null;
            //take the person who just got killed and put them in dead list
            dead = deadCurrent;
            //dead.next is the old dead list
            dead.next = temp;
            
        //current name isn't victim
        } else {
        	while(aliveCurrent.next != null) {
        		//next name is victim
                if(aliveCurrent.next.name.equalsIgnoreCase(name)) {
                		//person after the victim
                        AssassinNode temp = aliveCurrent.next.next;
                        //the victims killer is the current name
                        aliveCurrent.next.killer = aliveCurrent.name;
                        //victim
                        dead = aliveCurrent.next;
                        //dead.next is the old dead list
                        dead.next = deadCurrent;
                        //put a new person as the killers next
                        aliveCurrent.next = temp;
                //keep looking for the victim      
                } else {
                        aliveCurrent = aliveCurrent.next;
                }
        	}
        }
	}
}
        
   
