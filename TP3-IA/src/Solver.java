import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

public class Solver {
	
	Model model = new Model();
	
	IntVar v0 = model.intVar("v0", 42);
}
