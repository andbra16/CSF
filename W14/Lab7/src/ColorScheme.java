import java.awt.*;

public class ColorScheme {

	Color color1;
	Color color2;
	Color color3;
	Color color4;
	
	public ColorScheme(Color color1, Color color2, Color color3, Color color4) {
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
		this.color4 = color4;
	}
	
	/*
	 * @param	color1 first Color object to combine
	 * @param	color2 second Color object to combine
	 * @return	a new Color whose red, green, and blue components are the
	 * 			average (rounded to nearest integer) of the two params. 
	 */
	public static Color combineColors(Color color1, Color color2) {
		int red1 = color1.getRed();
		int green1 = color1.getGreen();
		int blue1 = color1.getBlue();
		
		int red2= color2.getRed();
		int green2= color2.getGreen();
		int blue2= color2.getBlue();
		
		int newRed= (red1+red2)/2;
		int newGreen= (green1+green2)/2;
		int newBlue= (blue1+blue2)/2;
		
		Color newColor = new Color(newRed, newGreen, newBlue);
		return newColor;
	}
	
	public ColorScheme combineWith(ColorScheme newScheme) {
		Color newColor1 = combineColors(this.color1, newScheme.color1);
		Color newColor2 = combineColors(this.color2, newScheme.color2);
		Color newColor3 = combineColors(this.color3, newScheme.color3);
		Color newColor4 = combineColors(this.color4, newScheme.color4);
		ColorScheme newColorScheme = new ColorScheme(newColor1, newColor2, newColor3, newColor4);
		return newColorScheme;
	}
	
	public Color[] getColorList() {
		return new Color[] {this.color1, this.color2, this.color3, this.color4};
	}
	
}