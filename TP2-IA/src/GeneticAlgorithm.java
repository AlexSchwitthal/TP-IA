import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GeneticAlgorithm {
	public Population population;
	public int populationSize;
	public PentominosBoard board;

	public GeneticAlgorithm(PentominosBoard game, int k) {
		this.population = new Population(game);
		for (int i = 0; i < 2 * k; i++) {
			PentominosBoard copy = game.copy();
			while (copy.nbrPlaced < 12) {
				copy.putPiece((int) (63 * Math.random()), (int) (8 * Math.random()), (int) (8 * Math.random()));
			}
			this.population.add(copy);
		}
		this.populationSize = 2 * k;
		this.board = game;
	}

	public ArrayList<Couple> selection() {
		RandomSelector r = new RandomSelector();
		ArrayList<Couple> c = new ArrayList<Couple>();

		for (int i = 0; i < this.population.population.size(); i++) {
			r.add(8 * 8 - this.population.get(i).nbrFreePlaces());
		}
		for (int i = 0; i < this.population.population.size(); i += 2) {
			PentominosBoard mother = null;
			PentominosBoard father = null;
			do {
				mother = this.population.get(r.randomChoice());
				father = this.population.get(r.randomChoice());
			} while (mother == father);

			c.add(new Couple(mother, father));
		}
		return c;
	}

	public Population crossover(ArrayList<Couple> parents) {
		
		Population p = new Population(this.population.originalBoard);
//		for (Couple c : parents) {
//			
//			// child
//			for (int i = 0; i < 2; i++) {
//				PentominosBoard child = new PentominosBoard();
//				
//				// 1 to 12 pieces
//				for (int j = 0; j < 12; i++) {
//					
//					//mother
//					if (Math.random() < 0.5) {
//						child.board.set(j, c.mother.board.get(j));
//						child.positions.set(j, c.mother.positions.get(j));
//					}
//					
//					//father
//					else {
//						child.board.set(j, c.father.board.get(j));
//						child.positions.set(j, c.father.positions.get(j));
//					}
//				}
//				p.add(child);
//			}
//		}
		
		for(int i = 0; i < parents.size(); i++) {
			PentominosBoard parent1 = parents.get(i).father;
			PentominosBoard parent2 = parents.get(i).mother;
			PentominosBoard child1 = parent1.copy();
			PentominosBoard child2 = parent2.copy();
			
			for(int j = 1; j < 13; j++) {
				if(Math.random() < 0.5) {
					int pp = parent2.orientation(this.populationSize);
					ArrayList<Integer> pos = parent2.positions.get(pp);
					child1.putPiece(pp, pos.get(pp), pos.get(pp));
				}
			}
			
		}
		return p;
	}

	public PentominosBoard solve(double mutationRate, double elitistRate) {
		/*
		while(nbFreePlaces > 4) {
			parent <- selection()
			children <- crossover(parents)
			for(j = 0; j < children.size(), j++) {
				if(math.random() < mutationRate) {
					do mutation
				}
			}
		}
		*/
		this.board.putPiece(5, 3, 2);
		return null;

	}
}
