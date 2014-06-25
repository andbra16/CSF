import java.awt.*;

public class Doodle {
	
	public static void main(String[] args) {
		DrawingPanel p = new DrawingPanel(800,800);
		Graphics g = p.getGraphics();
		p.setBackground(Color.WHITE);
		
		face(g);
		eyes(g);
		eyebrows(g);
		mouth(g);
		nose(g);
		chin(g);
	}
	
	public static void face(Graphics g) {
		Color peach = new Color(238, 203, 173);
		g.setColor(peach);
		g.fillOval(150, 250, 500, 500);
	}
	public static void eyes(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(275, 350, 50, 50);
		g.fillOval(475, 350, 50, 50);
		g.setColor(Color.BLACK);
		g.fillOval(285, 360, 25, 25);
		g.fillOval(485, 360, 25, 25);
		g.fillRect(150, 180, 500, 100);
		g.fillRect(300, 10, 200, 225);
	}
	public static void eyebrows(Graphics g) {
		g.setColor(Color.BLACK);
		
		for (int i=0; i<6; i++) {
			g.fillOval(350-i*10, 350-i*10, 20, 20);
			g.fillOval(430+i*10, 350-i*10, 20, 20);
		}
	}
	
	public static void mouth(Graphics g) {
		g.setColor(Color.RED);
		
		for (int i=0; i<4; i++) {
			g.fillOval(350-i*10, 550+i*10, 20, 20);
			g.fillOval(430+i*10, 550+i*10, 20, 20);
		}
		for (int i=0; i<9; i++) {
			g.fillOval(350+i*10, 550, 20, 20);
		}
	}
	
	public static void nose(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(350, 400, 10, 75);
		g.fillRect(430, 400, 10, 75);
		g.fillOval(340, 470, 30, 10);
		g.fillOval(420, 470, 30, 10);
		for (int i=0; i<4; i++) {
			g.fillOval(385-i*10, 500-i*10, 20, 20);
			g.fillOval(385+i*10, 500-i*10, 20, 20);
		}
	}
	
	public static void chin(Graphics g) {
		g.fillRect(395, 700, 10, 50);
	}
}
