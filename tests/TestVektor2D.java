package Aufg1;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import Aufg2.LineareAlgebra;

public class TestVektor2D {

	@Test
	public void testVektor2D() {
		Vektor2D a = new Vektor2D(1, -1);
		assertEquals(1, a.x, 0);
		assertEquals(-1, a.y, 0);

		a = new Vektor2D(0.5, -0.5);
		assertEquals(0.5, a.x, 0.0);
		assertEquals(-0.5, a.y, 0.0);
	}

	@Test
	public void testSub() {
		double[] testValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		Vektor2D a, b, c, d;

		for (double wert : testValue) {
			/*
			 * Komponenteweise subtrahieren
			 */
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = a.sub(b);
			assertEquals(wert, a.x, 0.0);
			assertEquals(-wert, a.y, 0.0);

			c = b.sub(a);
			assertEquals(-wert, b.x, 0.0);
			assertEquals(wert + wert, c.y, 0.0);

			/*
			 * Rückführung auf Addition a − b = a +(−b)
			 */
			a = new Vektor2D(wert, wert);
			b = new Vektor2D(-wert, -wert);
			c = a;
			a.sub(b);
			d = new Vektor2D(-b.x, -b.y);
			d = a.add(d);
			assertTrue(c.isEqual(d));
		}
	}

	@Test
	public void testAdd() {
		double[] testValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		Vektor2D a, b, c, d, e;
		for (double wert : testValue) {

			/*
			 * Komponenteweise addieren
			 */
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = a;
			a.add(b);
			assertEquals(a.x, c.x, 0.0);
			assertEquals(b.y, c.y, 0.0);

			/*
			 * Addition des Nullvektors a + 0 = a
			 */
			a = new Vektor2D(wert, wert);
			b = new Vektor2D(0, 0);
			c = a;
			a.add(b);
			assertTrue(a.isEqual(c));

			/*
			 * Das additive Inverse a+(-a) = 0
			 */
			b = new Vektor2D(-wert, -wert);
			a.add(b);
			assertTrue(a.isNullVector());

			/*
			 * Kommutativgesetz a + b = b + a
			 */
			a = new Vektor2D(wert, wert);
			b = new Vektor2D(wert * 2, wert * 2);
			c = new Vektor2D(a.x, a.y);
			a.add(b);
			b.add(c);
			assertTrue(LineareAlgebra.isEqual(a, b));

			/*
			 * Assoziativgesetz (a + b) + c = a + (b + c)
			 */
			a = new Vektor2D(wert, wert);
			b = new Vektor2D(wert * 2, wert * 2);
			c = new Vektor2D(a.x, a.y);
			d = a.add(b).add(c);

			a = new Vektor2D(wert, wert);
			b = new Vektor2D(wert * 2, wert * 2);
			c = new Vektor2D(a.x, a.y);
			e = b.add(c).add(a);

			assertTrue(LineareAlgebra.isEqual(d, e));
		}

	}

	@Test
	public void testMult() {
		double[] testValue = new double[] { -2.0, -1.5, -0.1, 0.1, 1.5, 2.0 };
		Vektor2D a, b, c, d;
		for (double wert : testValue) {
			/*
			 * Komponenteweise multiplizieren
			 */
			a = new Vektor2D(wert, 0);
			c = LineareAlgebra.mult(a, wert);
			assertEquals(a.x * wert, c.x, 0.0);
			assertEquals(0, c.y, 0.0);

			b = new Vektor2D(0, wert);
			c = LineareAlgebra.mult(b, wert);
			assertEquals(0, c.x, 0.0);
			assertEquals(b.y * wert, c.y, 0.0);

			/*
			 * Multiplikation mit der Zahl 1
			 */
			a = new Vektor2D(wert, -wert);
			b = LineareAlgebra.mult(a, 1);
			assertTrue(LineareAlgebra.isEqual(a, b));
			/*
			 * Multiplikation mit der Zahl 0
			 */
			b = LineareAlgebra.mult(a, 0);
			assertTrue(b.isNullVector());
			/*
			 * Distributivgesetz
			 */
			a = new Vektor2D(wert, wert);
			b = new Vektor2D(wert * 2, wert * 2);
			c = LineareAlgebra.add(a, b);
			c = LineareAlgebra.mult(c, wert);
			d = LineareAlgebra.add(LineareAlgebra.mult(a, wert), LineareAlgebra.mult(b, wert));
			assertTrue(LineareAlgebra.isEqual(c, d));
		}
	}

	@Test
	public void testMultMitÜberlauf() {
		Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
		assertNull(a.mult(2.0));
		assertNull(a.mult(-2.0));
		assertNotNull(a.mult(1.0));
		assertNotNull(a.mult(-1.0));

		a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
		assertNull(a.mult(2.0));
		assertNull(a.mult(-2.0));
		assertNotNull(a.mult(1.0));
		assertNotNull(a.mult(-1.0));
	}

	@Test
	public void testDiv() {
		Vektor2D a = new Vektor2D(2.0, -2.0);
		Vektor2D b = new Vektor2D(-2.0, 2.0);
		assertNull(a.div(0));
		assertTrue(a.isEqual(a.div(1)));
		assertTrue(b.isEqual(a.div(-1)));

		a.div(2);
		assertEquals(-1.0, a.x, 0.0);
		assertEquals(1.0, a.y, 0.0);

		a.div(-2);
		assertEquals(0.5, a.x, 0.0);
		assertEquals(-0.5, a.y, 0.0);

		assertTrue(a.div(0.5).isEqual(a.mult(5)));
		assertTrue(a.div(-0.5).isEqual(a.mult(-5)));
	}

	@Test
	public void testDivMitÜberlauf() {
		Vektor2D a = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);
		assertNotNull(a.div(Double.MIN_VALUE));

		a = new Vektor2D(-Double.MIN_VALUE, -Double.MIN_VALUE);
		assertNotNull(a.div(-Double.MIN_VALUE));

		a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
		assertNull(a.div(0.1));
		assertNull(a.div(-0.1));
		assertNotNull(a.div(2));

		a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
		assertNull(a.div(0.1));
		assertNull(a.div(-0.1));
		assertNotNull(a.div(-2));
	}

	@Test
	public void testSetPosition() {
		Vektor2D a = new Vektor2D(1, 1);
		a.setPosition(2.1, 2.2);
		assertEquals(2.1, a.x, 0.0);
		assertEquals(2.2, a.y, 0.0);
	}

	@Test
	public void testLength() {
		Vektor2D a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
		assertEquals(-1, a.length(), 0);
		a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
		assertEquals(-1, a.length(), 0);

		a = new Vektor2D(3.0, 4.0);
		assertEquals(5, a.length(), 0);
		a = new Vektor2D(-4.0, -3.0);
		assertEquals(5, a.length(), 0);

		a = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);
		assertEquals(0, a.length(), 0);
		a = new Vektor2D(-Double.MIN_VALUE, -Double.MIN_VALUE);
		assertEquals(0, a.length(), 0);

		a = new Vektor2D(0, 0);
		assertEquals(0, a.length(), 0);
	}

	@Test
	public void testNormalize() {
		Vektor2D a = new Vektor2D(1.0, 0.0);
		Vektor2D b = new Vektor2D(0.0, 1.0);
		assertEquals(1, a.length(), 0);
		assertEquals(1, b.length(), 0);

		a = new Vektor2D(0, 0);
		assertNull(a.normalize());

		a = new Vektor2D(4, 3);
		a.normalize();
		assertEquals(1, a.length(), 0);
		assertEquals(0.8, a.x, 0);
		assertEquals(0.6, a.y, 0);

		a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
		assertNull(a.normalize());
		a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
		assertNull(a.normalize());

		a = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);
		assertNull(a.normalize());
		a = new Vektor2D(-Double.MIN_VALUE, -Double.MIN_VALUE);
		assertNull(a.normalize());
	}

	@Test
	public void testIsNullVector() {
		Vektor2D a = new Vektor2D(0, 0);
		Vektor2D b = new Vektor2D(1, 0);
		assertTrue(a.isNullVector());
		assertFalse(b.isNullVector());
	}

	@Test
	public void testIsNotEqual() {
		Vektor2D a = new Vektor2D(1, 1);
		Vektor2D b = new Vektor2D(2, 2);
		assertTrue(a.isNotEqual(b));
		assertFalse(a.isNotEqual(a));
	}

	@Test
	public void testIsEqual() {
		// Trivialfall
		Vektor2D a = new Vektor2D(1, 1);
		Vektor2D b = new Vektor2D(1, 1);
		assertTrue(a.isEqual(b));

		a = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);
		b = new Vektor2D(Double.MIN_VALUE, Double.MIN_VALUE);

		a.mult(2.5);
		a.div(2.6);
		b.mult(2.5);
		b.div(2.6);
		assertTrue(a.isEqual(b));

		a = new Vektor2D(10, 10);
		b = new Vektor2D(10.0, 10.0);
		a.div(3.0);
		assertFalse(a.isEqual(b));
		a.mult(3.0);
		assertTrue(a.isEqual(b));
		a = new Vektor2D(Double.valueOf(10), Double.valueOf(10));
		b = new Vektor2D(Double.valueOf(10) + Double.MIN_NORMAL, Double.valueOf(10) + Double.MIN_NORMAL);
		// System.out.println(Double.doubleToRawLongBits(10) + "\t"+
		// Double.doubleToRawLongBits(10+Double.MIN_NORMAL));

		assertFalse(a.isEqual(b));
	}

}
