import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Astar {
	public State racine;
	public HashMap<String,State> extended;
	public TreeSet<State> frontier;
	public HashMap<String,State> frontierSet;
	
	
	public Astar(Cube etatInitial) {
		this.racine = new State(etatInitial,0,null,-1);
		this.frontier = new TreeSet<State>();
		this.frontier.add(this.racine);
		this.frontierSet = new HashMap<String,State>();
		this.frontierSet.put(this.racine.toString(), this.racine);
		this.extended = new HashMap<String, State>();
	}
	
	public ArrayList<String> solve(){
		State current = frontier.first();
		this.frontier.remove(current);
		this.frontierSet.remove(current.toString());
		while(!current.etat.isSolved()) {
			System.out.println("taille frontier = " + this.frontier.size());
			ArrayList<State> listSucc = current.expand();
			this.extended.put(current.toString(), current);
			for(int i = 0; i < listSucc.size(); i++) {
				State node = listSucc.get(i);
				String s = node.toString();
				//System.out.println(s);
				if(!this.extended.containsKey(s)) {
					State etatFrontier = this.frontierSet.get(s);
					if(etatFrontier == null) {
						this.frontier.add(node);
						this.frontierSet.put(s, node);
					}
					else {
						if(etatFrontier.nbrActions > node.nbrActions) {
							this.frontier.remove(etatFrontier);
							this.frontierSet.remove(etatFrontier.toString());
							this.frontier.add(node);
							this.frontierSet.put(s, node);						
						}
						else {
							current.cut(node);
						}
					}
				}
				else {
					current.cut(node);
				}
				
			}
			current = this.frontier.first();
			this.frontier.remove(current);
			this.frontierSet.remove(current.toString(), current);
		}
		ArrayList<String> actions = new ArrayList<String>();
		while(current.pere != null) {
			switch(current.actionPere)  {
				case 0: actions.add(0,"U"); break;
				case 1: actions.add(0,"L"); break;
				case 2: actions.add(0,"F"); break;
				case 3: actions.add(0,"R"); break;
				case 4: actions.add(0,"D"); break;
				case 5: actions.add(0,"B"); break;
				case 6: actions.add(0,"U'"); break;
				case 7: actions.add(0,"L'"); break;
				case 8: actions.add(0,"F'"); break;
				case 9: actions.add(0,"R'"); break;
				case 10: actions.add(0,"D'"); break;
				case 11: actions.add(0,"B'");
			}
			current = current.pere;
		}
		return actions; //new ArrayList<String>();
	}
}