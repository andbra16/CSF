import java.util.LinkedList;
import java.util.Queue;

// This class is used for debugging the Guitar37 class.  It is not an example
// to be emulated.  When a string is plucked, it is set to the integer part of
// the string's frequency.  As tic is called, it goes up or down by 10
// depending upon whether it is positive or negative respectively.

public class GuitarString {
    double value;
    double freq;
    int n;
    double decay = (double) 0.996;
    Queue<Double> ringBuffer;

    public GuitarString(double frequency) {
        freq = frequency;
        //size of ring buffer
	n = (int) Math.round(44100/freq);
		
	if (freq<=0 || n<2) {
		throw new IllegalArgumentException();
	}
		  
	//create linked list for ring buffer
	ringBuffer = new LinkedList<Double>();
	for (int i=0; i<n; i++) {
		ringBuffer.add(0.0);
	}
    }
    
    //used in TestString.java
    public GuitarString(double[] init) {
    	if (init.length < 2) {
    		throw new IllegalArgumentException();
    	}
    	
    	ringBuffer = new LinkedList<Double>();
    	//initializes the contents of the ring buffer to the values in init
    	for (int i=0; i<init.length; i++) {
    		ringBuffer.add(init[i]);
    	}	
    }

    public void pluck() {
        //iterates through the ring buffer and replaces the blank values
        for (int i=0; i<n; i++) {
            //generates a value from -0.5 inclusive to 0.5 exclusive
            value = Math.random()-(0.5);
            //removes old 0.0 value
            ringBuffer.remove();
            //adds new random value
	    ringBuffer.add(value);
	}
    }

    public void tic() {
    	//retrieves and removes head of ring buffer
    	double head = ringBuffer.remove();
    	
    	//retrieves the head of ring buffer
    	double second = ringBuffer.element();
    	
    	//computes karplus-strong
    	double karplus = decay * (0.5) * (head + second);
    	
    	//inserts karplus to the end of ring buffer
    	ringBuffer.add(karplus);			
    }

    public double sample() {
    	value = ringBuffer.peek();
        return value;
    }
}
