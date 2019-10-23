import java.util.ArrayList;

public class State implements Comparable{
	
	public Cube etat;
	public ArrayList<State> succ;
	public int nbrActions;
	public State pere;
	int actionPere;
	public int identifiant;
	public float valH;
	public static int id = 0;
	public static Heuristic h = new HeuristicCube();
	
	public State(Cube cube, int iter, State father, int action) {
		this.etat = cube;
		nbrActions = iter;
		succ = new ArrayList<State>();
		this.pere = father;
		this.actionPere = action;
		this.identifiant = id++;
		this.valH = State.h.value(cube);
	}
	
	public ArrayList<State> expand() {
		if(this.succ.size()!=0)
			return this.succ;
		ArrayList<State> succ = new ArrayList<State>();
		for(int i = 0; i < 12; i++) {
			Cube tmp = (Cube)etat.clone();
			switch(i) {
				case 0: tmp.turnUp(); break;
				case 1: tmp.turnLeft(); break;
				case 2: tmp.turnFront(); break;
				case 3: tmp.turnRight(); break;
				case 4: tmp.turnDown(); break;
				case 5: tmp.turnBack(); break;
				case 6: tmp.returnUp(); break;
				case 7: tmp.returnLeft(); break;
				case 8: tmp.returnFront(); break;
				case 9: tmp.returnRight(); break;
				case 10: tmp.returnDown(); break;
				case 11: tmp.returnBack();
			}
			succ.add(new State(tmp,this.nbrActions+1,this,i));
		}
		return succ;
	}
	
	public void cut(State aCouper) {
		this.succ.remove(aCouper);
	}
	
	public int compareTo(Object s) {
		float value = this.nbrActions+this.valH-((State)s).nbrActions-((State)s).valH;
		if(value > 0.0001 || value < -0.0001)
			return value > 0? 1 : -1;
		return this.identifiant - ((State)s).identifiant;
	}
	
	public String toString() {
		return this.etat.toString();
	}
	
	public static void changeHeuristic(Heuristic fonction) {
		State.h = fonction;
	}
}
