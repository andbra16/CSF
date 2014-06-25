import static org.junit.Assert.*;

import org.junit.Test;


public class RatNumberTest {
	RatNumber rn1 = new RatNumber(1, 2);
	RatNumber rn2 = new RatNumber(1, 4);

	@Test
	public void testGetNumer() {
		assertEquals(rn1.getNumer(), 1);
	}
	
	@Test
	public void testGetDenom() {
		assertEquals(rn1.getDenom(), 2);
	}

	@Test
	public void testAdd() {
		RatNumber Rat= rn1.add(rn2);
		assertEquals(Rat.getNumer(), 3);
		assertEquals(Rat.getDenom(), 4);
	}

	@Test
	public void testSubtract() {
		RatNumber Rat= rn1.subtract(rn2);
		assertEquals(Rat.getNumer(), 1);
		assertEquals(Rat.getDenom(), 4);
	}

	@Test
	public void testMultiply() {
		RatNumber Rat= rn1.multiply(rn2);
		assertEquals(Rat.getNumer(), 1);
		assertEquals(Rat.getDenom(), 8);
	}

	@Test
	public void testDivide() {
		RatNumber Rat= rn1.divide(rn2);
		assertEquals(Rat.getNumer(), 2);
		assertEquals(Rat.getDenom(), 1);
	}
}
