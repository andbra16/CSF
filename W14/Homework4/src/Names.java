import java.io.*;
import java.util.*;
import java.awt.*;

public class Names {
	
	public static final int decades=14;
	public static final int start=1880;
	public static final int width=70;
	
	public static void main(String[] args) 
		throws FileNotFoundException {
		String nameGend = getName(); //get name from user
		String[] tokens = findName(nameGend); //check if name is in file
		drawGraph(tokens); //draw graph if name was in file
	}
	
	
	//gets the name from the user
	public static String getName() {
		Scanner console = new Scanner(System.in);
		System.out.println("This program allows you to search through the");
		System.out.println("data from the Social Security Administration");
		System.out.println("to see how popular a particular name has been");
		System.out.println("since 1920.");
		System.out.println();
		
		System.out.println("name? ");
		String name = console.nextLine();
		System.out.println("gender (M or F)? ");
		String gender = console.nextLine();
		
		String nameGend = name+ " " + gender;
		console.close();
		return nameGend;
	}
	
	//checks if the name given by the user was in the file and 
	//if it was it returns the line of the file with the correct name
	//in an array of strings
	//if it wasn't it returns a null variable and tells the user
	//that the name wasn't found
	public static String[] findName(String nameGend) throws FileNotFoundException {
		Scanner input = new Scanner(new File("names.txt"));
		while (input.hasNextLine()) {
			String line = input.nextLine();
			//if the line isn't blank, proceed
			if (!(line.isEmpty())) {
				//breaks the line into an array by its spacing
				String[] tokens = line.split(" ");
				String nameGend2= tokens[0]+ " " + tokens[1];
				if (nameGend.equalsIgnoreCase(nameGend2)) {
					input.close();
					return tokens;
				}
			}
		}
		input.close();
		System.out.println("name/gender combination not found");
		return null;
	}
	
	//draws the graph if the name was in the file
	public static void drawGraph(String[] tokens) {
		//checks if name was in file (name has data)
		if (tokens!=null) {
			//creates a new panel
			int length = decades*width;
			DrawingPanel p = new DrawingPanel(length,550);
			
			//creates a drawing object
			Graphics g = p.getGraphics();
			g.setColor(Color.BLACK);
			
			//draw horizontal top and bot lines
			g.drawLine(0,25, length, 25);
			g.drawLine(0, 525, length, 525);
			
			//draws the vertical lines and decade strings
			for (int i=0; i<=decades-1; i++) {
				g.drawLine(i*width, 0, i*width, 550);
				g.drawString(""+(start+10*i), i*width, 550);
			}
			
			//draws the ranking lines and the name/gender/rank strings
			g.setColor(Color.RED);	
			String nameGender=tokens[0]+ " " + tokens[1];
			for (int i=0; i<tokens.length-3; i++) { 
				//tokens[0] and tokens[1] hold the name and gender
				//so skip these
				int rank1= Integer.valueOf(tokens[i+2]);
				int rank2= Integer.valueOf(tokens[i+3]);
				
				//method to convert rank into pixel location
				int y1 = getPixel(rank1); 
				int y2 = getPixel(rank2);
				
				//draw the data lines
				g.drawLine(i*width, y1, (i+1)*width, y2);
				
				//gets the number for the name/gender string
				String num = tokens[i+2];
				//draws name/gender/number string
				g.drawString(nameGender+" "+num, i*width, y1);
				
				//draws the last name/gender/number string
				//because the loop cuts out at the tokens.length-3
				if (i==tokens.length-4) {
					String num2 = tokens[i+3];
					g.drawString(nameGender+ " " + num2, (i+1)*width, y2);
				}
			} 
		}
	}
	
	//turns the ranking into its pixel on the panel
	public static int getPixel(int rank) {
		int pixel;
		
		//accounts for the duplicate ranks 
		// I.E. (1 and 2 = 25, 3 and 4 = 26, etc...
		rank = (int)(Math.ceil(rank/2.0));
		
		if (rank==0) {
			pixel=525;
		
		} else {
			pixel=24+rank;
		}
		return pixel;	
	}
}
