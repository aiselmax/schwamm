package Aufg1;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestVektor3D {

	@Test
	public void testVektor3D() {
		Vektor3D a = new Vektor3D(1, 0, -1);
		assertEquals(1, a.x, 0);
		assertEquals(0, a.y, 0);
		assertEquals(-1, a.z, 0);
	}

	@Test
	public void testSub() {
		Vektor3D a = new Vektor3D(1.0, 0.0, -1.0);
		Vektor3D b = new Vektor3D(1.0, 1.0, 1.0);
		a.sub(b);
		assertEquals(0.0, a.x, 0.0);
		assertEquals(-1.0, a.y, 0.0);
		assertEquals(-2.0, a.z, 0.0);
	}

	@Test
	public void testSubMit‹berlauf() {
		Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		Vektor3D b = new Vektor3D(-Double.MIN_VALUE, -Double.MIN_VALUE, -Double.MIN_VALUE);
		assertNull(a.sub(b));
		assertNull(b.sub(a));

		a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
		b = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
		assertNull(a.sub(b));
		assertNull(b.sub(a));
	}

	@Test
	public void testAdd() {
		Vektor3D a = new Vektor3D(1.0, 0.0, -1.0);
		Vektor3D b = new Vektor3D(-1.0, -1.0, -1.0);
		a.add(b);

		assertEquals(0.0, a.x, 0.0);
		assertEquals(-1.0, a.y, 0.0);
		assertEquals(-2.0, a.z, 0.0);
	}

	@Test
	public void testAddMit‹berlauf() {
		Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		Vektor3D b = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
		assertNull(a.add(b));
		assertNull(b.add(a));

		a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
		b = new Vektor3D(-Double.MIN_VALUE, -Double.MIN_VALUE, -Double.MIN_VALUE);
		assertNull(a.add(b));
		assertNull(b.add(a));
	}

	@Test
	public void testMult() {
		Vektor3D a = new Vektor3D(1.0, -1.0, 0.0);
		a.mult(2.0);
		assertEquals(2.0, a.x, 0.0);
		assertEquals(-2.0, a.y, 0.0);
		assertEquals(0.0, a.z, 0.0);
		assertTrue(a.isEqual(a.mult(1.0)));

		Vektor3D b = new Vektor3D(1.0, -1.0, 0.0);
		b.mult(-2.0);
		assertEquals(-2.0, b.x, 0.0);
		assertEquals(2.0, b.y, 0.0);
		assertEquals(0.0, b.z, 0.0);
	}

	@Test
	public void testMultMit‹berlauf() {
		Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		assertNull(a.mult(2.0));
		assertNull(a.mult(-2.0));
		assertNotNull(a.mult(1.0));
		assertNotNull(a.mult(-1.0));

		a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
		assertNull(a.mult(2.0));
		assertNull(a.mult(-2.0));
		assertNotNull(a.mult(1.0));
		assertNotNull(a.mult(-1.0));
	}

	@Test
	public void testDiv() {
		Vektor3D a = new Vektor3D(2.0, -2.0, 0.0);
		Vektor3D b = new Vektor3D(-2.0, 2.0, 0.0);
		assertNull(a.div(0));
		assertTrue(a.isEqual(a.div(1)));
		assertTrue(b.isEqual(a.div(-1)));

		a.div(2);
		assertEquals(-1.0, a.x, 0.0);
		assertEquals(1.0, a.y, 0.0);
		assertEquals(0.0, a.z, 0.0);

		a.div(-2);
		assertEquals(0.5, a.x, 0.0);
		assertEquals(-0.5, a.y, 0.0);
		assertEquals(0.0, a.z, 0.0);

		assertTrue(a.div(0.5).isEqual(a.mult(5)));
		assertTrue(a.div(-0.5).isEqual(a.mult(-5)));
	}

	@Test
	public void testDivMit‹berlauf() {
		Vektor3D a = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
		assertNotNull(a.div(Double.MIN_VALUE));

		a = new Vektor3D(-Double.MIN_VALUE, -Double.MIN_VALUE, -Double.MIN_VALUE);
		assertNotNull(a.div(-Double.MIN_VALUE));

		a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		assertNull(a.div(0.1));
		assertNull(a.div(-0.1));
		assertNotNull(a.div(2));

		a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
		assertNull(a.div(0.1));
		assertNull(a.div(-0.1));
		assertNotNull(a.div(-2));
	}

	@Test
	public void testSetPosition() {
		Vektor3D a = new Vektor3D(1.0, 1.0, 1.0);
		a.setPosition(2.1, 2.2, 2.3);
		assertEquals(2.1, a.x, 0.0);
		assertEquals(2.2, a.y, 0.0);
		assertEquals(2.3, a.z, 0.0);
	}

	@Test
	public void testLength() {
		Vektor3D a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		assertEquals(-1, a.length(), 0);
		a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
		assertEquals(-1, a.length(), 0);

		a = new Vektor3D(1.0, 2.0, 2.0);
		assertEquals(3, a.length(), 0);
		a = new Vektor3D(-1.0, -2.0, -2.0);
		assertEquals(3, a.length(), 0);

		a = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
		assertEquals(0, a.length(), 0);
		a = new Vektor3D(-Double.MIN_VALUE, -Double.MIN_VALUE, -Double.MIN_VALUE);
		assertEquals(0, a.length(), 0);

		a = new Vektor3D(0, 0, 0);
		assertEquals(0, a.length(), 0);
	}

	@Test
	public void testNormalize() {
		Vektor3D a = new Vektor3D(1.0, 0.0, 0.0);
		Vektor3D b = new Vektor3D(0.0, 1.0, 0.0);
		Vektor3D c = new Vektor3D(0.0, 0.0, 1.0);
		assertEquals(1, a.length(), 0);
		assertEquals(1, b.length(), 0);
		assertEquals(1, c.length(), 0);

		a = new Vektor3D(0, 0, 0);
		assertNull(a.normalize());

		a = new Vektor3D(4, 3, 0);
		a.normalize();
		assertEquals(1, a.length(), 0);
		assertEquals(0.8, a.x, 0);
		assertEquals(0.6, a.y, 0);
		assertEquals(0, a.z, 0);

		a = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
		assertNull(a.normalize());
		a = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
		assertNull(a.normalize());

		a = new Vektor3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
		assertNull(a.normalize());
		a = new Vektor3D(-Double.MIN_VALUE, -Double.MIN_VALUE, -Double.MIN_VALUE);
		assertNull(a.normalize());
	}

	@Test
	public void testIsNullVector() {
		Vektor3D a = new Vektor3D(0.0, 0.0, 0.0);
		Vektor3D b = new Vektor3D(1.0, 0.0, 0.0);
		assertTrue(a.isNullVector());
		assertFalse(b.isNullVector());
	}

	@Test
	public void testIsNotEqual() {
		Vektor3D a = new Vektor3D(1.0, 1.0, 1.0);
		Vektor3D b = new Vektor3D(2.0, 2.0, 2.0);
		assertTrue(a.isNotEqual(b));
		assertFalse(a.isNotEqual(a));

	}

	@Test
	public void testIsEqual() {
		Vektor3D a = new Vektor3D(1.0, 1.0, 1.0);
		Vektor3D b = new Vektor3D(2.0, 2.0, 2.0);
		assertTrue(a.isEqual(a));
		assertFalse(a.isEqual(b));
	}

}
