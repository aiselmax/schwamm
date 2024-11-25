package objekte;

import math.Vektor2D;

public abstract class MyBeweglichesObjekt extends MyBasisObjekt {
	public Vektor2D speed;
	public MyVerhalten verhalten = null;

	public MyBeweglichesObjekt(double xPos, double yPos,double xSpeed, double ySpeed) {
		super(xPos, yPos);
		this.speed = new Vektor2D(xSpeed, ySpeed);
	}

	public void setVerhalten(MyVerhalten verhalten) {
		this.verhalten = verhalten;
	}

	public void update() {
		if (verhalten != null)
			verhalten.update();
	}
}
