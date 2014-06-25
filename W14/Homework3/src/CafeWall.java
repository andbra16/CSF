import java.awt.*;

public class CafeWall {
	
	public static final int verticalSpace= 2;
	
	public static void main(String[] args) {
		//creates a new panel
		DrawingPanel p = new DrawingPanel(650,400);
		//creates a drawing object
		Graphics g = p.getGraphics();
		//sets the background gray
		p.setBackground(Color.GRAY);
		
		drawRow(g, 0, 0, 4, 20, 0);
		drawRow(g, 50, 70, 5, 30, 0);
		drawGrid(g, 10, 150, 4, 25, 0);
		drawGrid(g, 250, 200, 3, 25, 10);
		drawGrid(g, 425, 180, 5, 20, 10);
		drawGrid(g, 400, 20, 2, 35, 35);
	}
	
	//draws one row of the squares
	public static void drawRow(Graphics g, int x, int y, int pairs, int size, int offset) {
		
		for (int i=0; i<pairs; i++) {
			g.setColor(Color.BLACK);
			//creates a rectangle that gets spaced by the variables
			g.fillRect(x+offset+2*size*i, y, size, size);
			g.setColor(Color.BLUE);
			//creates a line that gets spaced by the variables
			g.drawLine(x+offset+2*size*i, y, x+size+offset+2*size*i, y+size);
			g.drawLine(x+size+offset+2*size*i, y, x+offset+2*size*i, y+size);
			g.setColor(Color.WHITE);
			g.fillRect(x+size+offset+2*size*i, y, size, size);
		}
	}
	
	//draws a grid of the squares
	public static void drawGrid(Graphics g, int x, int y, int pairs, int size, int offset) {
		int offsetCount=0;
		
		for (int i=0; i<2*pairs; i++) {
			//shifts the row every other time
			if (offsetCount%2==0) {
				drawRow(g, x, y+(verticalSpace*i)+size*i, pairs, size, 0);
				offsetCount++;
			}else {
				drawRow(g, x, y+(verticalSpace*i)+size*i, pairs, size, offset);
				offsetCount++;
			}	
		}
	}
}
