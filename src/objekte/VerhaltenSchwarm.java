package objekte;

import org.lwjgl.input.Mouse;

import math.LineareAlgebra;
import math.Vektor2D;

public class VerhaltenSchwarm implements MyVerhalten {

	private Agent agent;
	private MyObjektManager agents;
	private int width, height;
	private double coh, ali, sep;
	Vektor2D mousePos;

	public VerhaltenSchwarm(Agent agent, int width, int height) {
		this.width = width;
		this.height = height;
		this.agent = agent;
		this.agents = MyObjektManager.getExemplar();
		this.mousePos = new Vektor2D();
		sep = 10;
		ali = 0.1;
		coh = 0.05;
	}

	public VerhaltenSchwarm(Agent agent, int width, int height, double sep, double ali, double coh) {
		this.width = width;
		this.height = height;
		this.sep = sep;
		this.ali = ali;
		this.coh = coh;
		this.agent = agent;
		this.agents = MyObjektManager.getExemplar();
		this.mousePos = new Vektor2D();
	}

	public Vektor2D separation() {
		Vektor2D steeringForce = new Vektor2D(0, 0);
		for (int i = 0; i < agents.getAgentSize(); i++) {
			if (agent.id == i)
				continue;
			MyBasisObjekt bObj = agents.getAgent(i);
			if (bObj instanceof Agent) {
				Agent bObjF = (Agent) bObj;
				if (LineareAlgebra.euklDistance(agent.pos, bObjF.pos) < (agent.separationDist + bObjF.separationDist)) {
					Vektor2D help = new Vektor2D();
					help = LineareAlgebra.sub(agent.pos, bObjF.pos);
					double length = help.length();
					help.normalize();
					help.div(length);
					steeringForce.add(help);
				}
			}
		}
		return steeringForce;
	}

	public Vektor2D alignment() {
		Vektor2D steeringForce = new Vektor2D(0, 0);
		int count = 0;
		for (int i = 0; i < agents.getAgentSize(); i++) {
			if (agent.id == i)
				continue;
			MyBasisObjekt bObj = agents.getAgent(i);
			if (bObj instanceof Agent) {
				Agent bObjF = (Agent) bObj;
				if (LineareAlgebra.euklDistance(agent.pos, bObjF.pos) < (agent.separationDist + bObjF.separationDist)) {
					steeringForce.add(bObjF.speed);
					count++;
				}
			}
		}
		if (count > 0) {
			steeringForce.mult(1.0 / count);
			steeringForce.sub(agent.speed);
		}
		return steeringForce;
	}

	public Vektor2D cohesion() {
		Vektor2D steeringForce = new Vektor2D(0, 0);
		int count = 0;
		for (int i = 0; i < agents.getAgentSize(); i++) {
			if (agent.id == i)
				continue;

			MyBasisObjekt bObj = agents.getAgent(i);

			if (bObj instanceof Agent) {
				MyBeweglichesObjekt bObjF = (MyBeweglichesObjekt) bObj;
				steeringForce.add(bObjF.pos);
				count++;
			}
		}
		if (count > 0) {
			steeringForce.mult(1. / count);
			steeringForce.sub(agent.pos);
		}
		return steeringForce;
	}

	public Vektor2D follow(Vektor2D target) {
		Vektor2D help = new Vektor2D(0, 0);
		double dist;
		double speed;
		if (target.x > 0) {
			help = LineareAlgebra.sub(target, agent.pos);
			dist = help.length();
			speed = agent.maxSpeed * (dist / 2);
			speed = Math.min(speed, agent.maxSpeed);
			help.mult(speed / dist);
			help.sub(agent.speed);
		}
		return help;
	}

	@Override
	public void update() {
		Vektor2D regel1, regel2, regel3;
		Vektor2D velocity = new Vektor2D();
		regel1 = separation().mult(this.sep);
		regel2 = alignment().mult(this.ali);
		regel3 = cohesion().mult(this.coh);

		if (Mouse.isButtonDown(0)) {
			mousePos.x = Mouse.getX();
			mousePos.y = height - Mouse.getY();
			velocity.add(agent.speed).add(regel1).add(regel3).add(follow(mousePos));
		} else
			velocity.add(agent.speed).add(regel1).add(regel2).add(regel3);
		agent.pos.add(velocity);
		if (agent.pos.y > height || agent.pos.y < 0)
			agent.speed.y *= -1;
		if (agent.pos.x > width || agent.pos.x < 0)
			agent.speed.x *= -1;

	}
}
