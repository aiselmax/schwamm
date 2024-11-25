package objekte;

import java.util.HashMap;

public class MyObjektManager {
	private HashMap<Integer, Agent> agents;

	// ****************************************************
	// ObjektManager als Singleton realisieren
	private static MyObjektManager exemplar = new MyObjektManager();

	private MyObjektManager() {
		agents = new HashMap<Integer, Agent>();
	}

	public static MyObjektManager getExemplar() {
		return exemplar;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clonen ist nicht erlaubt");
	}
	// ***************************************************

	public void registerAgent(Agent obj) {
		agents.put(new Integer(obj.id), obj);
	}

	public void removeAgent(Agent obj) {
		agents.remove(obj);
	}

	public Agent getAgent(int objID) {
		return agents.get(new Integer(objID));
	}

	public HashMap<Integer, Agent> getFlummiMap() {
		return agents;
	}

	public int getAgentSize() {
		return agents.size();
	}
}