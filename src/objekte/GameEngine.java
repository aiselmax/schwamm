package objekte;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUseProgram;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.lwjgl.opengl.Display;


public class GameEngine extends MyBasisFenster {
	private MyObjektManager agents;
	private double sep, ali, coh;

	public GameEngine() {
		super("Schwarmverhalten", 1024, 768);
		agents = MyObjektManager.getExemplar();
		createAgents(200);
		this.sep = 10;
		this.ali = 0.1;
		this.coh = 0.05;
	}
	
	public GameEngine(int width, int height, int agentCount, double sep, double ali, double coh) {
		super("Schwarmverhalten", width, height);
		agents = MyObjektManager.getExemplar();
		createAgents(agentCount);
		this.sep = sep;
		this.ali = ali;
		this.coh = coh;
		
	}

	private void createAgents(int anz) {
		Random rand = ThreadLocalRandom.current();
		for (int i = 0; i < anz; i++) {
			Agent agent = new Agent(
					rand.nextInt(this.getWidth()), 					// pos.x
					rand.nextInt(this.getHeight()), 				// pos.y
					(rand.nextDouble() + 2), 						// xSpeed
					(rand.nextDouble() + 2), 						// ySpeed
					rand.nextInt(10) + 1); 							// radius

			agents.registerAgent(agent);
		}
	}

	@Override
	public void renderLoop() {

		String fragShader = "" + "void main() { " + "gl_FragColor = vec4(1, 1, 0, 1);" + "}";

		int shaderObjectF = glCreateShader(GL_FRAGMENT_SHADER);
		glShaderSource(shaderObjectF, fragShader);
		glCompileShader(shaderObjectF);

		int programObject = glCreateProgram();
		glAttachShader(programObject, shaderObjectF);
		glLinkProgram(programObject);
		glUseProgram(programObject);

		while (!Display.isCloseRequested()) {
			glClearColor(0.1f, 0.2f, 0.3f, 1);
			glClear(GL_COLOR_BUFFER_BIT);
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			glOrtho(0, this.getWidth(), this.getHeight(), 0, 0, 1);
			glMatrixMode(GL_MODELVIEW);
			glDisable(GL_DEPTH_TEST);

			for (int i = 1; i <= agents.getAgentSize(); i++) {
				Agent aktAgent = agents.getAgent(i);
				aktAgent.setVerhalten(new VerhaltenSchwarm(aktAgent, this.getWidth(), this.getHeight(), this.sep, this.ali, this.coh));
				aktAgent.render();
				aktAgent.update();
			}
			Display.update();
		}
	}

	public static void main(String[] args) {
		new GameEngine().start();
	}
}
