package objekte;

import math.Vektor2D;

public abstract class MyBasisObjekt {
	public int id;
	Vektor2D pos;

	public MyBasisObjekt() {
		this(0, 0);
	}

	public MyBasisObjekt(double xPos, double yPos) {
		this.pos=new Vektor2D(xPos,yPos);
	}

	public abstract void render();
}
