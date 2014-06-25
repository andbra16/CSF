import static org.junit.Assert.*;
import java.awt.*;

import org.junit.Test;


public class CritterTest {
	Geoduck g = new Geoduck();
	Husky h = new Husky();
	Giant giant = new Giant();
	
	@Test
	public void testGetColor() {
		assertEquals(giant.getColor(), Color.GRAY);
	}

	@Test
	public void testToString() {
		assertEquals(g.toString(), "G");
		assertEquals(h.toString(), "H");
	}
}
