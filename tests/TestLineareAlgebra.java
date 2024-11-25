package Aufg2;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import Aufg1.Vektor2D;
import Aufg1.Vektor3D;

public class TestLineareAlgebra {

	@Test
	public void testAddVektor2DVektor2D() {
		double[] testValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		Vektor2D a, b, c, d, e;
		for (double wert : testValue) {

			/*
			 * Komponenteweise addieren
			 */
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = LineareAlgebra.add(a, b);
			assertEquals(a.x, c.x, 0.0);
			assertEquals(b.y, c.y, 0.0);

			/*
			 * Addition des Nullvektors a + 0 = a
			 */
			a = new Vektor2D(wert, wert);
			b = new Vektor2D(0, 0);
			c = LineareAlgebra.add(a, b);
			assertTrue(LineareAlgebra.isEqual(a, c));

			/*
			 * Das additive Inverse a+(-a) = 0
			 */
			b = new Vektor2D(-wert, -wert);
			c = LineareAlgebra.add(a, b);
			assertTrue(c.isNullVector());

			/*
			 * Kommutativgesetz a + b = b + a
			 */
			b = new Vektor2D(wert, wert);
			c = LineareAlgebra.add(a, b);
			d = LineareAlgebra.add(b, a);

			assertTrue(LineareAlgebra.isEqual(c, d));

			/*
			 * Assoziativgesetz (a + b) + c = a + (b + c)
			 */
			d = LineareAlgebra.add(LineareAlgebra.add(a, b), c);
			e = LineareAlgebra.add(a, LineareAlgebra.add(b, c));

			assertTrue(LineareAlgebra.isEqual(d, e));
		}
	}

	@Test
	public void testAddVektor3DVektor3D() {
		double[] testValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		Vektor3D a, b, c, d, e;
		for (double wert : testValue) {

			/*
			 * Komponenteweise addieren
			 */
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);

			d = LineareAlgebra.add(a, b);
			assertEquals(a.x, d.x, 0.0);
			assertEquals(b.y, d.y, 0.0);
			d = LineareAlgebra.add(d, c);
			assertEquals(c.z, d.z, 0.0);

			/*
			 * Addition des Nullvektors
			 */
			a = new Vektor3D(wert, wert, wert);
			b = new Vektor3D(0, 0, 0);
			c = LineareAlgebra.add(a, b);
			assertTrue(LineareAlgebra.isEqual(a, c));

			/*
			 * Das additive Inverse a+(-a) = 0
			 */
			b = new Vektor3D(-wert, -wert, -wert);
			c = LineareAlgebra.add(a, b);
			assertTrue(c.isNullVector());

			/*
			 * Kommutativgesetz a + b = b + a
			 */
			b = new Vektor3D(wert, wert, wert);
			c = LineareAlgebra.add(a, b);
			d = LineareAlgebra.add(b, a);

			assertTrue(LineareAlgebra.isEqual(c, d));

			/*
			 * Assoziativgesetz (a + b) + c = a + (b + c)
			 */
			d = LineareAlgebra.add(LineareAlgebra.add(a, b), c);
			e = LineareAlgebra.add(a, LineareAlgebra.add(b, c));

			assertTrue(LineareAlgebra.isEqual(d, e));

		}

		// a = new Vektor3D(1, 1, -1);
		// b = new Vektor3D(-1, -1, 1);
		//
		// c = LineareAlgebra.add(a, a);
		// assertEquals(2, c.x, 0.0);
		// assertEquals(2, c.y, 0.0);
		// assertEquals(-2, c.z, 0.0);
		//
		// c = LineareAlgebra.add(b, b);
		// assertEquals(-2, c.x, 0.0);
		// assertEquals(-2, c.y, 0.0);
		// assertEquals(2, c.z, 0.0);
		//
		// c = LineareAlgebra.add(a, b);
		// assertEquals(0, c.x, 0.0);
		// assertEquals(0, c.y, 0.0);
		// assertEquals(0, c.z, 0.0);
		//
		// int test = 1;
		// if (test == 1) {
		// a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE,
		// Double.MAX_VALUE);
		// b = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE,
		// Double.MIN_VALUE);
		// try {
		// LineareAlgebra.add(a, b);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test == 2) {
		// a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE,
		// -Double.MAX_VALUE);
		// b = new Vektor3D(-Double.MIN_VALUE, -Double.MIN_VALUE,
		// -Double.MIN_VALUE);
		// try {
		// LineareAlgebra.add(a, b);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test != 3)
		// fail("Überlauf Test: " + test + " nicht bestanden");
	}

	@Test
	public void testAddDoubleDouble() {
		double[] testValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		double a, b, c, d;
		for (double wert : testValue) {
			/*
			 * Kommutativgesetz
			 */
			a = wert;
			b = wert;
			assertEquals(LineareAlgebra.add(a, b), LineareAlgebra.add(b, a), 0.0);

			/*
			 * Neutralität der Null
			 */
			assertEquals(a, LineareAlgebra.add(a, 0), 0.0);

			/*
			 * Das additive Inverse
			 */
			assertEquals(0, LineareAlgebra.add(a, -a), 0.0);
		}

		/*
		 * Speicherüberlauf
		 */

		int test = 1;
		if (test == 1) {
			try {
				LineareAlgebra.add(Double.MAX_VALUE, Double.MIN_VALUE);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 2) {
			try {
				LineareAlgebra.add(-Double.MAX_VALUE, -Double.MIN_VALUE);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 3) {
			try {
				LineareAlgebra.add(Double.MIN_VALUE, Double.MAX_VALUE);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 4) {
			try {
				LineareAlgebra.add(-Double.MIN_VALUE, -Double.MAX_VALUE);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test != 5)
			fail("Test: " + test + " nicht bestanden");

	}

	@Test
	public void testSubVektor2DVektor2D() {

		double[] testValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		Vektor2D a, b, c, d;

		for (double wert : testValue) {
			/*
			 * Komponenteweise subtrahieren
			 */
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = LineareAlgebra.sub(a, b);
			assertEquals(a.x, c.x, 0.0);
			assertEquals(-b.y, c.y, 0.0);

			c = LineareAlgebra.sub(b, a);
			assertEquals(-a.x, c.x, 0.0);
			assertEquals(b.y, c.y, 0.0);

			/*
			 * Rückführung auf Addition a − b = a +(−b)
			 */
			a = new Vektor2D(wert, wert);
			b = new Vektor2D(-wert, -wert);
			c = LineareAlgebra.sub(a, b);
			d = new Vektor2D(-b.x, -b.y);
			d = LineareAlgebra.add(a, d);
			assertTrue(LineareAlgebra.isEqual(c, d));
		}
		//
		//
		// a = new Vektor2D(1, -1);
		// b = new Vektor2D(-1, 1);
		//
		// c = LineareAlgebra.sub(a, a);
		// assertEquals(0, c.x, 0.0);
		// assertEquals(0, c.y, 0.0);
		//
		// c = LineareAlgebra.sub(b, b);
		// assertEquals(0, c.x, 0.0);
		// assertEquals(0, c.y, 0.0);
		//
		// c = LineareAlgebra.sub(a, b);
		// assertEquals(2, c.x, 0.0);
		// assertEquals(-2, c.y, 0.0);
		//
		// int test = 1;
		// if (test == 1) {
		// a = new Vektor2D(Double.MAX_VALUE, Double.MIN_VALUE);
		// b = new Vektor2D(-Double.MIN_VALUE, -Double.MAX_VALUE);
		// try {
		// LineareAlgebra.sub(a, b);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test == 2) {
		// a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
		// b = new Vektor2D(Double.MIN_VALUE, Double.MAX_VALUE);
		// try {
		// LineareAlgebra.sub(a, b);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test != 3)
		// fail("Überlauf Test: " + test + " nicht bestanden");
	}

	@Test
	public void testSubVektor3DVektor3D() {

		double[] testValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		Vektor3D a, b, c, d;

		for (double wert : testValue) {
			/*
			 * Komponenteweise subtrahieren
			 */

			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);

			d = LineareAlgebra.sub(a, b);
			assertEquals(a.x, d.x, 0.0);
			assertEquals(-b.y, d.y, 0.0);
			d = LineareAlgebra.sub(d, c);
			assertEquals(-c.z, d.z, 0.0);

			/*
			 * Rückführung auf Addition a − b = a +(−b)
			 */
			a = new Vektor3D(wert, wert, wert);
			b = new Vektor3D(-wert, -wert, -wert);
			c = LineareAlgebra.sub(a, b);
			d = new Vektor3D(-b.x, -b.y, -b.z);
			d = LineareAlgebra.add(a, d);
			assertTrue(LineareAlgebra.isEqual(c, d));
		}

		// Vektor3D a = new Vektor3D(1, 1, 1);
		// Vektor3D b = new Vektor3D(-1, -1, -1);
		//
		// Vektor3D c = LineareAlgebra.sub(a, a);
		// assertEquals(0, c.x, 0.0);
		// assertEquals(0, c.y, 0.0);
		// assertEquals(0, c.z, 0.0);
		//
		// c = LineareAlgebra.sub(b, b);
		// assertEquals(0, c.x, 0.0);
		// assertEquals(0, c.y, 0.0);
		// assertEquals(0, c.z, 0.0);
		//
		// c = LineareAlgebra.sub(a, b);
		// assertEquals(2, c.x, 0.0);
		// assertEquals(2, c.y, 0.0);
		// assertEquals(2, c.z, 0.0);
		//
		// int test = 1;
		// if (test == 1) {
		// a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE,
		// Double.MAX_VALUE);
		// b = new Vektor3D(-Double.MIN_VALUE, -Double.MIN_VALUE,
		// -Double.MIN_VALUE);
		// try {
		// LineareAlgebra.sub(a, b);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test == 2) {
		// a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE,
		// -Double.MAX_VALUE);
		// b = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE,
		// Double.MIN_VALUE);
		// try {
		// LineareAlgebra.sub(a, b);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test != 3)
		// fail("Überlauf Test: " + test + " nicht bestanden");
	}

	@Test
	public void testSubDoubleDouble() {
		double[] testValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		double a, b, c, d;
		for (double wert : testValue) {
			/*
			 * Rückführung auf Addition a − b = a +(−b)
			 */
			a = wert;
			b = -wert;
			c = LineareAlgebra.sub(a, b);
			d = -b;
			d = LineareAlgebra.add(a, d);
		}

		/*
		 * Speicherüberlauf abfangen
		 */

		int test = 1;
		if (test == 1) {
			try {
				LineareAlgebra.sub(Double.MAX_VALUE, -Double.MIN_VALUE);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 2) {
			try {
				LineareAlgebra.sub(Double.MIN_VALUE, -Double.MAX_VALUE);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 3) {
			try {
				LineareAlgebra.sub(-Double.MAX_VALUE, Double.MIN_VALUE);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 4) {
			try {
				LineareAlgebra.sub(-Double.MIN_VALUE, Double.MAX_VALUE);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test != 5)
			fail("Test: " + test + " nicht bestanden");
	}

	@Test
	public void testMultVektor2DDouble() {
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

		// int test = 1;
		// if (test == 1) {
		// a = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
		// skalar = 1.000000000000001;
		// try {
		// LineareAlgebra.mult(a, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test == 2) {
		// skalar = -1.000000000000001;
		// try {
		// LineareAlgebra.mult(a, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test == 3) {
		// a = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
		// try {
		// LineareAlgebra.mult(a, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test == 4) {
		// skalar = 1.000000000000001;
		// try {
		// LineareAlgebra.mult(a, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// }
		// if (test != 5)
		// fail("Überlauf Test: " + test + " nicht bestanden");
	}

	@Test
	public void testMultVektor3DDouble() {

		double[] testValue = new double[] { -2.0, -1.5, -0.1, 0.1, 1.5, 2.0 };
		Vektor3D a, b, c, d;
		for (double wert : testValue) {
			/*
			 * Komponenteweise multiplizieren
			 */
			a = new Vektor3D(wert, 0, 0);
			c = LineareAlgebra.mult(a, wert);
			assertEquals(a.x * wert, c.x, 0.0);
			assertEquals(0, c.y, 0.0);
			assertEquals(0, c.z, 0.0);

			b = new Vektor3D(0, wert, 0);
			c = LineareAlgebra.mult(b, wert);
			assertEquals(0, c.x, 0.0);
			assertEquals(b.y * wert, c.y, 0.0);
			assertEquals(0, c.z, 0.0);

			d = new Vektor3D(0, 0, wert);
			c = LineareAlgebra.mult(d, wert);
			assertEquals(0, c.x, 0.0);
			assertEquals(0, c.y, 0.0);
			assertEquals(d.z * wert, c.z, 0.0);

			/*
			 * Multiplikation mit der Zahl 1
			 */
			a = new Vektor3D(wert, -wert, wert);
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
			a = new Vektor3D(wert, wert, wert);
			b = new Vektor3D(wert * 2, wert * 2, wert * 2);
			c = LineareAlgebra.add(a, b);
			c = LineareAlgebra.mult(c, wert);
			d = LineareAlgebra.add(LineareAlgebra.mult(a, wert), LineareAlgebra.mult(b, wert));
			assertTrue(LineareAlgebra.isEqual(c, d));
		}

		// double[] skalarValue = new double[] { -1.000000000000001,
		// 1.000000000000001 };
		// double[] vektorValue = new double[] { -Double.MAX_VALUE,
		// Double.MAX_VALUE };
		// int test = 1;
		// for (double value : vektorValue) {
		// a = new Vektor3D(value, 0, 0);
		// b = new Vektor3D(0, value, 0);
		// c = new Vektor3D(0, 0, value);
		// for (double skalar : skalarValue) {
		// try {
		// LineareAlgebra.mult(a, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// try {
		// LineareAlgebra.mult(b, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// try {
		// LineareAlgebra.mult(c, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// if (test != 4)
		// fail("Test: " + test + " Wert: " + value + "Skalar: " + skalar);
		// test = 1;
		// }
		// }
	}

	@Test
	public void testMultDoubleDouble() {
		double[] testValue = new double[] { -2.0, -1.5, -0.1, 0.1, 1.5, 2.0 };
		double a, b, c, d;
		for (double wert : testValue) {
			/*
			 * Komponenteweise multiplizieren
			 */
			a = wert;
			assertEquals(a * wert, LineareAlgebra.mult(a, wert), 0.0);

			/*
			 * Multiplikation mit der Zahl 1
			 */
			assertEquals(a, LineareAlgebra.mult(a, 1), 0.0);
			/*
			 * Multiplikation mit der Zahl 0
			 */
			assertEquals(0, LineareAlgebra.mult(a, 0), 0.0);
			/*
			 * Distributivgesetz
			 */
			b = wert;
			b = wert;
			c = LineareAlgebra.add(a, b);
			c = LineareAlgebra.mult(c, wert);
			d = LineareAlgebra.add(LineareAlgebra.mult(a, wert), LineareAlgebra.mult(b, wert));
			assertTrue(c == d);
		}

		/*
		 * Speicherüberlauf abfangen
		 */

		a = Double.MAX_VALUE;
		b = -Double.MAX_VALUE;
		int test = 0;
		if (test == 0) {
			try {
				LineareAlgebra.mult(a, a);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 1) {
			try {
				LineareAlgebra.mult(a, b);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 2) {
			try {
				LineareAlgebra.mult(b, a);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test == 3) {
			try {
				LineareAlgebra.mult(b, b);
			} catch (doubleOverflow e) {
				test++;
			}
		}
		if (test != 4)
			fail("Test: " + test + " nicht bestanden");
	}

	@Test
	@Ignore("Daselbe wie testMultVektor2DDouble()")
	public void testMultDoubleVektor2D() {

	}

	@Test
	@Ignore("Daselbe wie testMultVektor3DDouble()")
	public void testMultDoubleVektor3D() {

	}

	@Test

	public void testDivVektor2DDouble() {
		Vektor2D a, b, c, d;
		double[] testValue = new double[] { -1.5, -0.1, 0.1, 1.5 };

		for (double skalar : testValue) {
			/*
			 * Komponenteweise dividieren
			 */
			a = new Vektor2D(skalar * 2, 0);
			b = LineareAlgebra.div(a, skalar);
			assertEquals(a.x / skalar, b.x, 0.0);
			assertEquals(0, b.y, 0.0);

			a = new Vektor2D(0, skalar * 2);
			b = LineareAlgebra.div(a, skalar);
			assertEquals(0, b.x, 0.0);
			assertEquals(a.y / skalar, b.y, 0.0);

			a = new Vektor2D(skalar * 2, skalar * 2);
			b = LineareAlgebra.div(a, skalar);
			assertEquals(a.x / skalar, b.x, 0.0);
			assertEquals(a.y / skalar, b.y, 0.0);

			/*
			 * Distributivgesetz
			 */
			b = new Vektor2D(skalar * 3, skalar * 3);
			c = LineareAlgebra.div(LineareAlgebra.add(a, b), skalar);
			d = LineareAlgebra.add(LineareAlgebra.div(a, skalar), LineareAlgebra.div(b, skalar));
			assertTrue(LineareAlgebra.isEqual(c, d));
		}

		// double[] skalarValue = new double[] { -Double.MIN_VALUE, -0.5, 0,
		// 0.5, Double.MIN_VALUE };
		// double[] vektorValue = new double[] { -Double.MAX_VALUE,
		// Double.MAX_VALUE };
		// int test = 1;
		// for (double value : vektorValue) {
		// a = new Vektor2D(value, 0);
		// b = new Vektor2D(0, value);
		// for (double skalar : skalarValue) {
		// try {
		// LineareAlgebra.div(a, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// try {
		// LineareAlgebra.div(b, skalar);
		// } catch (doubleOverflow e) {
		// test++;
		// }
		// if (test != 3)
		// fail("Test: " + test + " Wert: " + value + "Skalar: " + skalar);
		// test = 1;
		// }
		// }
	}

	@Test

	public void testDivVektor3DDouble() {

		Vektor3D a, b, c, d;
		double[] testValue = new double[] { -1.5, -0.1, 0.1, 1.5 };

		for (double skalar : testValue) {
			/*
			 * Komponenteweise dividieren
			 */
			a = new Vektor3D(skalar * 2, 0, 0);
			b = LineareAlgebra.div(a, skalar);
			assertEquals(a.x / skalar, b.x, 0.0);
			assertEquals(0, b.y, 0.0);
			assertEquals(0, b.z, 0.0);

			a = new Vektor3D(0, skalar * 2, 0);
			b = LineareAlgebra.div(a, skalar);
			assertEquals(0, b.x, 0.0);
			assertEquals(a.y / skalar, b.y, 0.0);
			assertEquals(0, b.z, 0.0);

			a = new Vektor3D(0, 0, skalar * 2);
			b = LineareAlgebra.div(a, skalar);
			assertEquals(0, b.x, 0.0);
			assertEquals(0, b.y, 0.0);
			assertEquals(a.z / skalar, b.z, 0.0);

			a = new Vektor3D(skalar * 2, skalar * 2, skalar * 2);
			b = LineareAlgebra.div(a, skalar);
			assertEquals(a.x / skalar, b.x, 0.0);
			assertEquals(a.y / skalar, b.y, 0.0);
			assertEquals(a.z / skalar, b.z, 0.0);

			/*
			 * Distributivgesetz
			 */
			b = new Vektor3D(skalar * 3, skalar * 3, skalar * 3);
			c = LineareAlgebra.div(LineareAlgebra.add(a, b), skalar);
			d = LineareAlgebra.add(LineareAlgebra.div(a, skalar), LineareAlgebra.div(b, skalar));
			assertTrue(LineareAlgebra.isEqual(c, d));
		}

		double[] vektorValue = new double[] { -Double.MAX_VALUE, Double.MAX_VALUE };
		double[] skalarValue = new double[] { -0.1, 0.1 };

		int test = 1;
		for (double value : vektorValue) {
			a = new Vektor3D(value, 0, 0);
			b = new Vektor3D(0, value, 0);
			c = new Vektor3D(0, 0, value);
			for (double skalar : skalarValue) {
				try {
					LineareAlgebra.div(a, skalar);
				} catch (doubleOverflow e) {
					test++;
				}
				try {
					LineareAlgebra.div(b, skalar);
				} catch (doubleOverflow e) {
					test++;
				}
				try {
					LineareAlgebra.div(c, skalar);
				} catch (doubleOverflow e) {
					test++;
				}
				if (test != 4)
					fail("Test: " + test + " Wert: " + value + " Skalar: " + skalar);
				test = 1;
			}
		}

		vektorValue = new double[] { -0.1, 0.1 };
		skalarValue = new double[] { -Double.MIN_VALUE, 0, Double.MIN_VALUE };
		for (double value : vektorValue) {
			a = new Vektor3D(value, 0, 0);
			b = new Vektor3D(0, value, 0);
			c = new Vektor3D(0, 0, value);
			for (double skalar : skalarValue) {
				try {
					LineareAlgebra.div(a, skalar);
				} catch (doubleOverflow e) {
					test++;
				}
				try {
					LineareAlgebra.div(b, skalar);
				} catch (doubleOverflow e) {
					test++;
				}
				try {
					LineareAlgebra.div(c, skalar);
				} catch (doubleOverflow e) {
					test++;
				}
				if (test != 4)
					fail("Test: " + test + " Wert: " + value + " Skalar: " + skalar);
				test = 1;
			}
		}

	}

	@Test
	public void testDivDoubleDouble() {
		double[] dividendValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };
		double[] divisorValue = new double[] { -2, -1.5, -0.1, 0.1, 1.5, 2 };

		for (double dividend : dividendValue)
			for (double divisor : divisorValue) {
				double quotient = LineareAlgebra.div(dividend, divisor);
				assertEquals(dividend / divisor, quotient, 0.0);
				assertEquals(quotient * divisor, dividend, 0.0);
			}
		/*
		 * Speicherüberlauf abfangen
		 */

		dividendValue = new double[] { -Double.MAX_VALUE, Double.MAX_VALUE };
		divisorValue = new double[] { -0.1, 0.1 };
		int test = 1;
		for (double dividend : dividendValue)
			for (double divisor : divisorValue) {
				try {
					LineareAlgebra.div(dividend, divisor);
				} catch (doubleOverflow e) {
					test++;
				}
				if (test != 2)
					fail("Dividend: " + dividend + " Divisor: " + divisor);
				test = 1;
			}

		dividendValue = new double[] { -0.1, 0.1 };
		divisorValue = new double[] { -Double.MIN_VALUE, 0, Double.MIN_VALUE };

		for (double dividend : dividendValue)
			for (double divisor : divisorValue) {
				try {
					LineareAlgebra.div(dividend, divisor);
				} catch (doubleOverflow e) {
					test++;
				}
				if (test != 2)
					fail("Dividend: " + dividend + " Divisor: " + divisor);
				test = 1;
			}
	}

	@Test
	public void testIsEqualVektor2DVektor2D() {

		double[] testValue = new double[] { -2.0, -1.5, -0.1, 0.1, 1.5, 2.0 };
		Vektor2D a, b, c;
		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = new Vektor2D(wert, wert);
			assertTrue(LineareAlgebra.isEqual(a, a));
			assertTrue(LineareAlgebra.isEqual(b, b));
			assertTrue(LineareAlgebra.isEqual(c, c));
			assertFalse(LineareAlgebra.isEqual(a, b));
			assertFalse(LineareAlgebra.isEqual(b, a));
			assertFalse(LineareAlgebra.isEqual(a, c));
			assertFalse(LineareAlgebra.isEqual(b, c));
		}
	}

	@Test
	public void testIsEqualVektor3DVektor3D() {
		double[] testValue = new double[] { -2.0, -1.5, -0.1, 0.1, 1.5, 2.0 };
		Vektor3D a, b,c,d;
		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);
			assertTrue(LineareAlgebra.isEqual(a, a));
			assertTrue(LineareAlgebra.isEqual(b, b));
			assertTrue(LineareAlgebra.isEqual(c, c));
			assertFalse(LineareAlgebra.isEqual(a, b));
			assertFalse(LineareAlgebra.isEqual(b, a));
			assertFalse(LineareAlgebra.isEqual(a, c));
			assertFalse(LineareAlgebra.isEqual(b, c));
		}
	}

	@Test
	public void testIsNotEqualVektor2DVektor2D() {
		double[] testValue = new double[] { -2.0, -1.5, -0.1, 0.1, 1.5, 2.0 };
		Vektor2D a, b, c;
		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = new Vektor2D(wert, wert);
			assertFalse(LineareAlgebra.isNotEqual(a, a));
			assertFalse(LineareAlgebra.isNotEqual(b, b));
			assertFalse(LineareAlgebra.isNotEqual(c, c));
			assertTrue(LineareAlgebra.isNotEqual(a, b));
			assertTrue(LineareAlgebra.isNotEqual(b, a));
			assertTrue(LineareAlgebra.isNotEqual(a, c));
			assertTrue(LineareAlgebra.isNotEqual(c, b));
		}
	}

	@Test
	public void testIsNotEqualVektor3DVektor3D() {
		double[] testValue = new double[] { -2.0, -1.5, -0.1, 0.1, 1.5, 2.0 };
		Vektor3D a, b,c;
		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0,0,wert);
			assertFalse(LineareAlgebra.isNotEqual(a, a));
			assertFalse(LineareAlgebra.isNotEqual(b, b));
			assertFalse(LineareAlgebra.isNotEqual(c, c));
			assertTrue(LineareAlgebra.isNotEqual(a, b));
			assertTrue(LineareAlgebra.isNotEqual(b, a));
			assertTrue(LineareAlgebra.isNotEqual(a, c));
			assertTrue(LineareAlgebra.isNotEqual(c, b));
		}
	}

	@Test
	public void testLengthVektor2D() {
		double[] testValue = new double[] { -1.5, -Double.MIN_VALUE, 0, Double.MIN_VALUE, 1.5 };
		Vektor2D a, b;
		for (int x = 0, y = testValue.length - 1; x < testValue.length; x++, y--) {
			a = new Vektor2D(testValue[x], testValue[y]);
			double lenght = Math.sqrt(testValue[x] * testValue[x] + testValue[y] * testValue[y]);
			assertEquals(lenght, LineareAlgebra.length(a), 0.0);
		}

		testValue = new double[] { -Double.MAX_VALUE, Double.MAX_VALUE, };
		int test = 1;

		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			try {
				LineareAlgebra.length(a);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.length(b);
			} catch (doubleOverflow e) {
				test++;
			}
			if (test != 3)
				fail("Test: " + test + " Wert: " + wert);
			test = 1;
		}

	}

	@Test
	public void testLengthVektor3D() {
		double[] testValue = new double[] { -1.5, -Double.MIN_VALUE, 0, Double.MIN_VALUE, 1.5 };
		Vektor3D a, b, c;

		for (double wert : testValue) {
			a = new Vektor3D(wert, wert, wert);
			double lenght = Math.sqrt(wert * wert + wert * wert + wert * wert);
			assertEquals(lenght, LineareAlgebra.length(a), 0.0);
		}

		testValue = new double[] { -Double.MAX_VALUE, Double.MAX_VALUE, };
		int test = 1;

		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);
			try {
				LineareAlgebra.length(a);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.length(b);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.length(c);
			} catch (doubleOverflow e) {
				test++;
			}
			if (test != 4)
				fail("Test: " + test + " Wert: " + wert);
			test = 1;
		}
	}

	@Test
	public void testNormalizeVektor2D() {
		double[] testValue = new double[] { -1.5, -1, -0.5, 0.5, 1, 1.5 };
		Vektor2D a, b, c;
		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = new Vektor2D(wert, wert);

			a = LineareAlgebra.normalize(a);
			b = LineareAlgebra.normalize(b);
			c = LineareAlgebra.normalize(c);

			assertEquals(1, LineareAlgebra.length(a), 0);
			assertEquals(1, LineareAlgebra.length(b), 0);
			// assertEquals(1.0, LineareAlgebra.length(c), 0.0);
		}

		testValue = new double[] { -Double.MAX_VALUE, 0, Double.MAX_VALUE, };
		int test = 1;

		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);

			try {
				LineareAlgebra.normalize(a);
			} catch (doubleOverflow e) {
				test++;
			} catch (IllegalArgumentException e) {
				test++;
			}
			try {
				LineareAlgebra.normalize(b);
			} catch (doubleOverflow e) {
				test++;
			} catch (IllegalArgumentException e) {
				test++;
			}
			if (test != 3)
				fail("Test: " + test + " Wert: " + wert);
			test = 1;
		}

	}

	@Test
	public void testNormalizeVektor3D() {
		double[] testValue = new double[] { -1.5, -1, -0.5, 0.5, 1, 1.5 };
		Vektor3D a, b, c, d;
		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);
			d = new Vektor3D(wert, wert, wert);

			a = LineareAlgebra.normalize(a);
			b = LineareAlgebra.normalize(b);
			c = LineareAlgebra.normalize(c);
			d = LineareAlgebra.normalize(d);

			assertEquals(1, LineareAlgebra.length(a), 0.0);
			assertEquals(1, LineareAlgebra.length(b), 0.0);
			assertEquals(1, LineareAlgebra.length(c), 0.0);
			assertEquals(1, LineareAlgebra.length(d), 0.0);
		}

		testValue = new double[] { -Double.MAX_VALUE, 0, Double.MAX_VALUE, };
		int test = 1;

		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);

			try {
				LineareAlgebra.normalize(a);
			} catch (doubleOverflow e) {
				test++;
			} catch (IllegalArgumentException e) {
				test++;
			}
			try {
				LineareAlgebra.normalize(b);
			} catch (doubleOverflow e) {
				test++;
			} catch (IllegalArgumentException e) {
				test++;
			}
			try {
				LineareAlgebra.normalize(c);
			} catch (doubleOverflow e) {
				test++;
			} catch (IllegalArgumentException e) {
				test++;
			}

			if (test != 4)
				fail("Test: " + test + " Wert: " + wert);
			test = 1;
		}
	}

	@Test
	public void testEuklDistanceVektor2DVektor2D() {
		double[] testValue = new double[] { -1.5, -Double.MIN_VALUE, 0, Double.MIN_VALUE, 1.5 };
		Vektor2D a, b, c;
		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = LineareAlgebra.sub(a, b);

			assertEquals(0, LineareAlgebra.euklDistance(a, a), 0.0);
			assertEquals(0, LineareAlgebra.euklDistance(b, b), 0.0);
			assertEquals(0, LineareAlgebra.euklDistance(c, c), 0.0);
			assertEquals(LineareAlgebra.length(c), LineareAlgebra.euklDistance(a, b), 0.0);
			assertEquals(LineareAlgebra.euklDistance(a, b), LineareAlgebra.euklDistance(b, a), 0.0);

		}

		testValue = new double[] { -Double.MAX_VALUE, Double.MAX_VALUE, };
		int test = 1;

		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			try {
				LineareAlgebra.euklDistance(a, b);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.euklDistance(b, a);
			} catch (doubleOverflow e) {
				test++;
			}
			if (test != 3)
				fail("Test: " + test + " Wert: " + wert);
			test = 1;
		}

	}

	@Test
	public void testEuklDistanceVektor3DVektor3D() {
		double[] testValue = new double[] { -1.5, -Double.MIN_VALUE, 0, Double.MIN_VALUE, 1.5 };
		Vektor3D a, b, c, d;
		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);

			assertEquals(0, LineareAlgebra.euklDistance(a, a), 0.0);
			assertEquals(0, LineareAlgebra.euklDistance(b, b), 0.0);
			assertEquals(0, LineareAlgebra.euklDistance(c, c), 0.0);

			d = LineareAlgebra.sub(a, b);
			assertEquals(LineareAlgebra.length(d), LineareAlgebra.euklDistance(a, b), 0.0);
			assertEquals(LineareAlgebra.euklDistance(a, b), LineareAlgebra.euklDistance(b, a), 0.0);

			d = LineareAlgebra.sub(a, c);
			assertEquals(LineareAlgebra.length(d), LineareAlgebra.euklDistance(a, c), 0.0);
			assertEquals(LineareAlgebra.euklDistance(a, b), LineareAlgebra.euklDistance(c, a), 0.0);

			d = LineareAlgebra.sub(b, c);
			assertEquals(LineareAlgebra.length(d), LineareAlgebra.euklDistance(b, c), 0.0);
			assertEquals(LineareAlgebra.euklDistance(b, c), LineareAlgebra.euklDistance(c, b), 0.0);

		}

		testValue = new double[] { -Double.MAX_VALUE, Double.MAX_VALUE, };
		int test = 1;

		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);
			try {
				LineareAlgebra.euklDistance(a, b);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.euklDistance(a, c);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.euklDistance(b, c);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.euklDistance(LineareAlgebra.add(a, b), b);
			} catch (doubleOverflow e) {
				test++;
			}

			if (test != 5)
				fail("Test: " + test + " Wert: " + wert);
			test = 1;
		}

	}

	@Test
	public void testManhattanDistanceVektor2DVektor2D() {
		double[] testValue = new double[] { -1.5, -Double.MIN_VALUE, 0, Double.MIN_VALUE, 1.5 };
		Vektor2D a, b, c;
		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = new Vektor2D(wert, -wert);

			assertEquals(0, LineareAlgebra.manhattanDistance(a, a), 0.0);
			assertEquals(0, LineareAlgebra.manhattanDistance(b, b), 0.0);
			assertEquals(0, LineareAlgebra.manhattanDistance(c, c), 0.0);

			assertEquals(Math.abs(a.x - b.x) + Math.abs(a.y - b.y), LineareAlgebra.manhattanDistance(a, b), 0.0);
			assertEquals(Math.abs(a.x - c.x) + Math.abs(a.y - c.y), LineareAlgebra.manhattanDistance(a, c), 0.0);
			assertEquals(Math.abs(b.x - c.x) + Math.abs(b.y - c.y), LineareAlgebra.manhattanDistance(b, c), 0.0);

			assertEquals(LineareAlgebra.manhattanDistance(b, a), LineareAlgebra.manhattanDistance(a, b), 0.0);
			assertEquals(LineareAlgebra.manhattanDistance(c, a), LineareAlgebra.manhattanDistance(a, c), 0.0);
			assertEquals(LineareAlgebra.manhattanDistance(c, b), LineareAlgebra.manhattanDistance(b, c), 0.0);
		}

		testValue = new double[] { -Double.MAX_VALUE, Double.MAX_VALUE, };
		int test = 1;

		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			try {
				LineareAlgebra.manhattanDistance(a, b);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.manhattanDistance(b, a);
			} catch (doubleOverflow e) {
				test++;
			}
			if (test != 3)
				fail("Test: " + test + " Wert: " + wert);
			test = 1;
		}

	}

	@Test
	public void testManhattanDistanceVektor3DVektor3D() {
		double[] testValue = new double[] { -1.5, -Double.MIN_VALUE, 0, Double.MIN_VALUE, 1.5 };
		Vektor3D a, b, c, d;
		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);
			d = LineareAlgebra.add(a, b);

			assertEquals(0, LineareAlgebra.manhattanDistance(a, a), 0.0);
			assertEquals(0, LineareAlgebra.manhattanDistance(b, b), 0.0);
			assertEquals(0, LineareAlgebra.manhattanDistance(c, c), 0.0);
			assertEquals(0, LineareAlgebra.manhattanDistance(d, d), 0.0);

			assertEquals(Math.abs(a.x - b.x) + Math.abs(a.y - b.y) + Math.abs(a.z - b.z),
					LineareAlgebra.manhattanDistance(a, b), 0.0);
			assertEquals(Math.abs(a.x - c.x) + Math.abs(a.y - c.y) + Math.abs(a.z - c.z),
					LineareAlgebra.manhattanDistance(a, c), 0.0);
			assertEquals(Math.abs(b.x - c.x) + Math.abs(b.y - c.y) + Math.abs(b.z - c.z),
					LineareAlgebra.manhattanDistance(b, c), 0.0);
			assertEquals(Math.abs(d.x - c.x) + Math.abs(d.y - c.y) + Math.abs(d.z - c.z),
					LineareAlgebra.manhattanDistance(d, c), 0.0);

			assertEquals(LineareAlgebra.manhattanDistance(b, a), LineareAlgebra.manhattanDistance(a, b), 0.0);
			assertEquals(LineareAlgebra.manhattanDistance(c, a), LineareAlgebra.manhattanDistance(a, c), 0.0);
			assertEquals(LineareAlgebra.manhattanDistance(c, b), LineareAlgebra.manhattanDistance(b, c), 0.0);
			assertEquals(LineareAlgebra.manhattanDistance(c, d), LineareAlgebra.manhattanDistance(d, c), 0.0);
		}
		testValue = new double[] { -Double.MAX_VALUE, Double.MAX_VALUE, };
		int test = 1;

		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);
			try {
				LineareAlgebra.manhattanDistance(a, b);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.manhattanDistance(a, c);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.manhattanDistance(b, c);
			} catch (doubleOverflow e) {
				test++;
			}
			try {
				LineareAlgebra.manhattanDistance(LineareAlgebra.add(a, b), c);
			} catch (doubleOverflow e) {
				test++;
			}

			if (test != 5)
				fail("Test: " + test + " Wert: " + wert);
			test = 1;
		}

	}

	@Test
	public void testCrossProduct() {
		double[] testValue = new double[] { -1.5, -0.5, 0.5, 1.5 };
		Vektor3D a, b, c, d, e, f, ab, ca, bc, tmp;
		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, 0, wert);

			/*
			 * Alternierende Abbildung: Das Kreuzprodukt eines Vektors mit sich
			 * selbst oder einem kollinearen Vektor ergibt den Nullvektor
			 */
			d = LineareAlgebra.crossProduct(a, a);
			assertTrue(d.isNullVector());
			d = LineareAlgebra.crossProduct(b, b);
			assertTrue(d.isNullVector());
			d = LineareAlgebra.crossProduct(c, c);
			assertTrue(d.isNullVector());

			d = LineareAlgebra.crossProduct(a, LineareAlgebra.mult(a, 2));
			assertTrue(d.isNullVector());
			d = LineareAlgebra.crossProduct(b, LineareAlgebra.mult(b, 2));
			assertTrue(d.isNullVector());
			d = LineareAlgebra.crossProduct(c, LineareAlgebra.mult(c, 2));
			assertTrue(d.isNullVector());

			/*
			 * Das Kreuzprodukt ist antikommutativ. Das heißt, bei Vertauschung
			 * der Vektoren wechselt es das Vorzeichen
			 */

			d = LineareAlgebra.crossProduct(a, b);
			e = LineareAlgebra.crossProduct(b, a);
			assertFalse(LineareAlgebra.isEqual(d, e));
			e = LineareAlgebra.crossProduct(LineareAlgebra.mult(b, -1), a);
			assertTrue(LineareAlgebra.isEqual(d, e));

			d = LineareAlgebra.crossProduct(a, c);
			e = LineareAlgebra.crossProduct(c, a);
			assertFalse(LineareAlgebra.isEqual(d, e));
			e = LineareAlgebra.crossProduct(LineareAlgebra.mult(c, -1), a);
			assertTrue(LineareAlgebra.isEqual(d, e));

			d = LineareAlgebra.crossProduct(b, c);
			e = LineareAlgebra.crossProduct(c, b);
			assertFalse(LineareAlgebra.isEqual(d, e));
			e = LineareAlgebra.crossProduct(LineareAlgebra.mult(c, -1), b);
			assertTrue(LineareAlgebra.isEqual(d, e));

			/*
			 * Jacobi-Identität zyklische Summe wiederholter Kreuzprodukte = 0
			 */
			bc = LineareAlgebra.crossProduct(b, c);
			ca = LineareAlgebra.crossProduct(c, a);
			ab = LineareAlgebra.crossProduct(a, b);

			a = LineareAlgebra.crossProduct(a, bc);
			b = LineareAlgebra.crossProduct(b, ca);
			c = LineareAlgebra.crossProduct(c, ab);
			tmp = LineareAlgebra.add(LineareAlgebra.add(a, b), c);
			assertTrue(tmp.isNullVector());

			/*
			 * Bilinearität Das Kreuzprodukt ist bilinear.
			 */

			d = LineareAlgebra.crossProduct(a,
					LineareAlgebra.add(LineareAlgebra.mult(b, wert * 2), LineareAlgebra.mult(c, wert * 3)));
			e = LineareAlgebra.add(LineareAlgebra.mult(wert * 2, LineareAlgebra.crossProduct(a, b)),
					LineareAlgebra.mult(wert * 3, LineareAlgebra.crossProduct(a, c)));
			assertTrue(d.isEqual(e));

			d = LineareAlgebra.crossProduct(
					LineareAlgebra.add(LineareAlgebra.mult(a, wert), LineareAlgebra.mult(b, wert * 3)), c);
			e = LineareAlgebra.add(LineareAlgebra.mult(wert, LineareAlgebra.crossProduct(a, c)),
					LineareAlgebra.mult(wert * 2, LineareAlgebra.crossProduct(b, c)));
			assertTrue(d.isEqual(e));

			/*
			 * Graßmann-Identität Das Kreuzprodukt ist nicht assoziativ.
			 */

			bc = LineareAlgebra.crossProduct(b, c);
			d = LineareAlgebra.crossProduct(a, bc);
			e = LineareAlgebra.sub(LineareAlgebra.mult(LineareAlgebra.dotProduct(a, c), b),
					LineareAlgebra.mult(LineareAlgebra.dotProduct(a, b), c));
			assertTrue(d.isEqual(e));

		}
	}

	@Test
	public void testDotProductVektor2DVektor2D() {
		double[] testValue = new double[] { -1.5, -0.5, 0, 0.5, 1.5 };
		Vektor2D a, b, c;
		double skalar1, skalar2;

		for (double wert : testValue) {
			a = new Vektor2D(wert, 0);
			b = new Vektor2D(0, wert);
			c = new Vektor2D(wert, -wert);

			assertEquals(a.x * b.x + a.y * b.y, LineareAlgebra.dotProduct(a, b), 0.0);
			assertEquals(a.x * c.x + a.y * c.y, LineareAlgebra.dotProduct(a, c), 0.0);
			assertEquals(b.x * c.x + b.y * c.y, LineareAlgebra.dotProduct(b, c), 0.0);

			/*
			 * Das Skalarprodukt ist symmetrisch.
			 */
			skalar1 = LineareAlgebra.dotProduct(a, b);
			skalar2 = LineareAlgebra.dotProduct(b, a);
			assertEquals(skalar1, skalar2, 0.0);

			/*
			 * Das Skalarprodukt ist homogen in jedem Argument (gemischtes
			 * Assoziativgesetz).
			 */

			skalar1 = LineareAlgebra.dotProduct(LineareAlgebra.mult(a, wert), b);
			skalar2 = wert * LineareAlgebra.dotProduct(a, b);
			assertEquals(skalar1, skalar2, 0.0);

			skalar2 = LineareAlgebra.dotProduct(a, LineareAlgebra.mult(b, wert));
			assertEquals(skalar1, skalar2, 0.0);

			/*
			 * Das Skalarprodukt ist additiv in jedem Argument
			 * (Distributivgesetz).
			 */
			skalar1 = LineareAlgebra.dotProduct(a, LineareAlgebra.add(b, c));
			skalar2 = LineareAlgebra.add(LineareAlgebra.dotProduct(a, b), LineareAlgebra.dotProduct(a, c));
			assertEquals(skalar1, skalar2, 0.0);

			skalar1 = LineareAlgebra.dotProduct(LineareAlgebra.add(a, b), c);
			skalar2 = LineareAlgebra.add(LineareAlgebra.dotProduct(a, c), LineareAlgebra.dotProduct(b, c));
			assertEquals(skalar1, skalar2, 0.0);

		}
		// Vektor2D v=new Vektor2D(1,1);
		// assertEquals(LineareAlgebra.dotProduct(v,
		// v),v.length()*v.length(),0.0);
	}

	@Test
	public void testDotProductVektor3DVektor3D() {
		double[] testValue = new double[] { -1.5, -0.5, 0, 0.5, 1.5 };
		Vektor3D a, b, c;
		double skalar1, skalar2;

		for (double wert : testValue) {
			a = new Vektor3D(wert, 0, 0);
			b = new Vektor3D(0, wert, 0);
			c = new Vektor3D(0, wert, 0);

			assertEquals(a.x * b.x + a.y * b.y + a.z * b.z, LineareAlgebra.dotProduct(a, b), 0.0);
			assertEquals(a.x * c.x + a.y * c.y + a.z * c.z, LineareAlgebra.dotProduct(a, c), 0.0);
			assertEquals(b.x * c.x + b.y * c.y + b.z * c.z, LineareAlgebra.dotProduct(b, c), 0.0);

			/*
			 * Das Skalarprodukt ist symmetrisch.
			 */
			skalar1 = LineareAlgebra.dotProduct(a, b);
			skalar2 = LineareAlgebra.dotProduct(b, a);
			assertEquals(skalar1, skalar2, 0.0);

			/*
			 * Das Skalarprodukt ist homogen in jedem Argument (gemischtes
			 * Assoziativgesetz).
			 */

			skalar1 = LineareAlgebra.dotProduct(LineareAlgebra.mult(a, wert), b);
			skalar2 = wert * LineareAlgebra.dotProduct(a, b);
			assertEquals(skalar1, skalar2, 0.0);

			skalar2 = LineareAlgebra.dotProduct(a, LineareAlgebra.mult(b, wert));
			assertEquals(skalar1, skalar2, 0.0);

			/*
			 * Das Skalarprodukt ist additiv in jedem Argument
			 * (Distributivgesetz).
			 */
			skalar1 = LineareAlgebra.dotProduct(a, LineareAlgebra.add(b, c));
			skalar2 = LineareAlgebra.add(LineareAlgebra.dotProduct(a, b), LineareAlgebra.dotProduct(a, c));
			assertEquals(skalar1, skalar2, 0.0);

			skalar1 = LineareAlgebra.dotProduct(LineareAlgebra.add(a, b), c);
			skalar2 = LineareAlgebra.add(LineareAlgebra.dotProduct(a, c), LineareAlgebra.dotProduct(b, c));
			assertEquals(skalar1, skalar2, 0.0);

		}
	}

	@Test
	@Ignore
	public void testCosEquationVektor2DVektor2D() {
		fail("Not yet implemented");
	}

	@Test
	
	public void testCosEquationVektor3DVektor3D() throws Exception {
		Vektor2D a = new Vektor2D(2,3);
		Vektor2D b = new Vektor2D(-1,-1);
		double d = LineareAlgebra.cosEquation(a, b);
		System.out.println(d);
	}

	@Test
	@Ignore
	public void testSinEquationVektor2DVektor2D() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSinEquationVektor3DVektor3D() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testAngleRadVektor2DVektor2D() throws Exception {
//		Vektor2D a = new Vektor2D(1,1);
//		Vektor2D b = new Vektor2D(-1,-1);
//		double d = LineareAlgebra.angleRad(a, b);
//		System.out.println(d);
	}

	@Test
	@Ignore
	public void testAngleRadVektor3DVektor3D() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testAngleDegreeVektor2DVektoer2D() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testAngleDegreeVektor3DVektoer3D() {
		fail("Not yet implemented");
	}

	@Test
	public void testRadToDegree() {
		double[] radValue = new double[] { 0, 1.0 / 6, 1.0 / 4, 1.0 / 3, 1.0 / 2, 2.0 / 3, 3.0 / 4, 5.0 / 6, 1, 3.0 / 2,
				2 };
		double[] degValue = new double[] { 0, 30, 45, 60, 90, 120, 135, 150, 180, 270, 360 };
		for (int i = 0; i < radValue.length; i++) {
			double rad = radValue[i] * Math.PI;
			assertEquals(degValue[i], LineareAlgebra.radToDegree(rad), 0.0);
		}
	}

	@Test
	public void testDegreeToRad() {
		double[] radValue = new double[] { 0, 1.0 / 6, 1.0 / 4, 1.0 / 3, 1.0 / 2, 2.0 / 3, 3.0 / 4, 5.0 / 6, 1, 3.0 / 2,
				2 };
		double[] degValue = new double[] { 0, 30, 45, 60, 90, 120, 135, 150, 180, 270, 360 };

		for (int i = 0; i < degValue.length; i++) {
			assertEquals(radValue[i] * Math.PI, LineareAlgebra.degreeToRad(degValue[i]), 0.0);
		}
	}

	@Test
	public void testDeterminanteVektor2DVektor2D() {
		double[] testValue = new double[] { -1.5, -0.5, 0.5, 1.5 };
		Vektor2D a, b, c;
		double det1, det2;

		for (double wert : testValue) {
			/*
			 * Determinante ist Null, falls Spaltenvektoren gleich oder linear
			 * abhängig sind
			 */
			a = new Vektor2D(wert, wert * 2);
			b = LineareAlgebra.mult(a, 4);

			assertEquals(0, LineareAlgebra.determinante(a, a), 0.0);
			assertEquals(0, LineareAlgebra.determinante(a, b), 0.0);

			/*
			 * Determinante ist alternierend
			 */
			a = new Vektor2D(wert, wert);
			b = new Vektor2D(wert * 2, wert * 3);

			assertEquals(-LineareAlgebra.determinante(b, a), LineareAlgebra.determinante(a, b), 0.0);

			/*
			 * Determinante ist normiert
			 */
			a = new Vektor2D(1, 0);
			b = new Vektor2D(0, 1);
			assertEquals(1, LineareAlgebra.determinante(a, b), 0.0);

			/*
			 * Determinante ist Null, falls ein Spaltenvektor der Nullvektor ist
			 */
			b = new Vektor2D(0, 0);
			assertEquals(0, LineareAlgebra.determinante(a, b), 0.0);
			/*
			 * der Wert der Determinante ändert sich nicht, wenn zu einer Spalte
			 * das Vielfache einer anderen Spalte addiert wird
			 */
			a = new Vektor2D(wert * 2, wert * 4);
			b = new Vektor2D(1, 1);

			det1 = LineareAlgebra.determinante(a, b);
			b = LineareAlgebra.add(b, LineareAlgebra.div(a, 2));
			det2 = LineareAlgebra.determinante(a, b);
			assertEquals(det1, det2, 0.0);

			/*
			 * 
			 */

			c = new Vektor2D(wert, wert);
			det1 = LineareAlgebra.determinante(a, LineareAlgebra.add(b, c));
			det2 = LineareAlgebra.determinante(a, b) + LineareAlgebra.determinante(a, c);
			;
		}

	}

	@Test
	public void testDeterminanteVektor3DVektor3DVektor3D() {

		double[] testValue = new double[] { -1.5, -0.1, 0.1, 1.5 };
		Vektor3D a, b, c;
		double det1, det2;

		// /*
		// * Determinante ist normiert
		// */
		a = new Vektor3D(1, 0, 0);
		b = new Vektor3D(0, 1, 0);
		c = new Vektor3D(0, 0, 1);
		assertEquals(1, LineareAlgebra.determinante(a, b, c), 0.0);

		/*
		 * Determinante ist alternierend
		 */
		/*
		 * linksdrehend
		 * 
		 */
		assertEquals(1, LineareAlgebra.determinante(b, c, a), 0.0);
		assertEquals(1, LineareAlgebra.determinante(c, a, b), 0.0);
		/*
		 * rechtsdrehend
		 */
		assertEquals(-1, LineareAlgebra.determinante(a, c, b), 0.0);
		assertEquals(-1, LineareAlgebra.determinante(c, b, a), 0.0);

		for (double wert : testValue) {
			/*
			 * Determinante ist Null, falls Spaltenvektoren gleich oder linear
			 * abhängig sind
			 */
			a = new Vektor3D(wert, wert * 2, wert * 3);
			b = LineareAlgebra.mult(a, 2);
			c = new Vektor3D(wert, wert, wert);
			assertEquals(0, LineareAlgebra.determinante(a, a, a), 0.0);
			assertEquals(0, LineareAlgebra.determinante(a, b, c), 0.0);

			/*
			 * Determinante ist alternierend
			 */
			a = new Vektor3D(wert, wert, wert);
			b = new Vektor3D(wert, wert * 2, wert * 3);
			c = new Vektor3D(wert * 4, wert * 5, wert * 6);
			// a = new Vektor3D(1, 1, 1);
			// b = new Vektor3D(1, 2, 3);
			// c = new Vektor3D(4, 5, 6);

			assertEquals(-LineareAlgebra.determinante(c, b, a), LineareAlgebra.determinante(a, b, c), 0.0);

			/*
			 * Determinante ist Null, falls ein Spaltenvektor der Nullvektor ist
			 */
			c = new Vektor3D(0, 0, 0);
			assertEquals(0, LineareAlgebra.determinante(a, b, c), 0.0);

			/*
			 * der Wert der Determinante ändert sich nicht, wenn zu einer Spalte
			 * das Vielfache einer anderen Spalte addiert wird
			 */
			a = new Vektor3D(1, 1, 1);
			b = new Vektor3D(wert * 2, wert * 4, wert * 6);
			c = new Vektor3D(3, 2, 1);

			det1 = LineareAlgebra.determinante(a, b, c);
			c = LineareAlgebra.add(b, LineareAlgebra.div(a, 2));
			det2 = LineareAlgebra.determinante(a, b, c);
			assertEquals(det1, det2, 0.0);
		}

	}

	@Test
	public void testAbs() {
		double[] testValue = new double[] { -1.5, -0.1, -Double.MIN_VALUE, 0, 1 };
		for (double wert : testValue)
			assertEquals(Math.abs(wert), LineareAlgebra.abs(wert), 0.0);
	}

	@Test
	@Ignore
	public void testShowVektor2D() {
		Vektor2D v = new Vektor2D(1, -1);
		LineareAlgebra.show(v);
	}

	@Test
	@Ignore
	public void testShowVektor3D() {
		Vektor3D v = new Vektor3D(1, 2, 3);
		LineareAlgebra.show(v);
	}

}
