// skeleton version of the class

public class Guitar37 implements Guitar {
    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout   
    
    int time;
    
    //array to hold all the string objects
    GuitarString[] strings = new GuitarString[37];
    
    public Guitar37() {   	
    	//puts the GuitarStrings into the array with the computed frequencies
    	for (int i=0; i<KEYBOARD.length(); i++) {
    		double freq = 440*Math.pow(2,((i-24)/12)); 
    		strings[i] = new GuitarString(freq);
    	}
    }
    
    public void playNote(int pitch) {
    	//converts pitch to the index of keyboard
    	int index = pitch+12;
    	
    	//plucks the string corresponding to the pitch(index)
    	if (index>=0 && index<=37) {
    		strings[index].pluck();
    	}
    }
    
    public boolean hasString(char key) {
    	//checks if the key typed is in our string of keys
    	for (int i=0; i<KEYBOARD.length(); i++) {
    		if (KEYBOARD.charAt(i) == key) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void pluck(char key) {
    	//checks if a valid key was given
    	boolean keyCheck = hasString(key);
    	
    	if(keyCheck==false) {
    		throw new IllegalArgumentException();
    	}
    	
    	//plucks the string corresponding to the key given
    	for (int i=0; i<KEYBOARD.length(); i++) {
    		if (KEYBOARD.charAt(i) == key) {
    			strings[i].pluck();
    		}
    	}
    }
    
    public double sample() {
    	double returnSamp = 0.0;
    	
    	//computes the current sound (sum of all strings)
    	for (int i=0; i<KEYBOARD.length(); i++) {
    		returnSamp = strings[i].sample() + returnSamp;
    	}
    	return returnSamp;
    } 
    
    public void tic() {
    	//used in time()
    	time = time + 1;
    	
    	for (int i=0; i<KEYBOARD.length(); i++) {
    		strings[i].tic();
    	}
    }
    
    //returns the number of times tic has been called
    public int time() {
    	return time;
    }
}