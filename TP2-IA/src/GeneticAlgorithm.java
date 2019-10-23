import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GeneticAlgorithm {
	public Population population;
	public int populationSize;
	public PentominosBoard board;
	
	public GeneticAlgorithm(PentominosBoard game, int k) {
		this.population = new Population(game);
		for(int i = 0; i < 2 * k; i++) {
			PentominosBoard copy = game.copy();
			while(copy.nbrPlaced < 12) {
				copy.putPiece((int)(63 * Math.random()), (int)(8 * Math.random()), (int)(8 * Math.random()));
			}
			this.population.add(copy);
		}
		this.populationSize = 2 * k;
		this.board = game;
	}
	
	public ArrayList<Couple> selection(){
		RandomSelector r = new RandomSelector();
		ArrayList<Couple> c = new ArrayList<Couple>();
		
		for(int i = 0; i < this.population.population.size(); i++) {
			r.add(8 *8 - this.population.get(i).nbrFreePlaces());
		}
		for(int i = 0; i < this.population.population.size() / 2; i++) {
			PentominosBoard mother = null;
			PentominosBoard father = null;
			while(mother == father) {
				mother = this.population.get(r.randomChoice());
				father = this.population.get(r.randomChoice());
			}
			
			c.add(new Couple(mother, father));
		}
		return c;
	}
	
	public Population crossover(ArrayList<Couple> parents){
		Population p = new Population(this.population.originalBoard);
		Random r = new Random();
		
		for(Couple c : parents) {
			for(int i = 0; i < 2; i++) {
				PentominosBoard son = new PentominosBoard();
				for(int j = 0; j < 12; i++) {
					int randomNumber = r.nextInt(100);
					if(randomNumber >= 50) {
						//son.putPiece(p, row, col);
					}
					else {
						
					}
				}
			}
			PentominosBoard son1 = new PentominosBoard();
			PentominosBoard son2 = new PentominosBoard();

		}
		return null;
	}
	
	
	
	public PentominosBoard solve(double mutationRate, double elitistRate) {
		this.board.putPiece(5, 3, 2);
		return null;
		
	}
}
