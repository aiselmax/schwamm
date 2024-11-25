package objekte;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;

import math.LineareAlgebra;
import math.Vektor2D;

public class Agent extends MyBeweglichesObjekt {
	private static int objCounter = 0;
	private double radius;
	public static double maxSpeed = 3;
	public static double panicDist = 100;
	public double separationDist;

	public Agent() {
		this(0, 0, maxSpeed, maxSpeed, 20.0);
	}

	public Agent(double xPos, double yPos, double xSpeed, double ySpeed) {
		this(xPos, yPos, xSpeed, ySpeed, 20.0);
	}

	public Agent(double xPos, double yPos, double xSpeed, double ySpeed, double radius) {
		super(xPos, yPos, xSpeed, ySpeed);
		this.radius = radius;
		this.separationDist = 100;
		this.id = ++objCounter;
	}

	@Override
	public void render() {

		glBegin(GL_TRIANGLE_FAN); // Kreis rendern
		glVertex2d(pos.x, pos.y);
		for (int angle = 0; angle < 360; angle += 5) {
			Vektor2D v = LineareAlgebra.add(pos, new Vektor2D(Math.sin(angle), Math.cos(angle)).mult(radius));
			glVertex2d(v.x, v.y);

		}
		glEnd();
	}
}
