import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.IntVar;

public class Hidato extends JFrame implements ActionListener, CaretListener{
	private final JPanel rightPanel;
	private final JPanel centerPanel;
	
	private static JButton solveButton;
	private static JComboBox petList;
	
	private MosaicPanel hidatoView;
	
	public int grid[][], gridInit[][];
	
	public Hidato(int width, int height) {
		BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    try{
	    	lecteurAvecBuffer = new BufferedReader(new FileReader("hidatoEasy66.txt"));
	    	ligne = lecteurAvecBuffer.readLine();
	    	String elements[] = ligne.split(" ");
	    	this.grid = new int[new Integer(elements[0]).intValue()][new Integer(elements[1]).intValue()];
	    	this.gridInit = new int[new Integer(elements[0]).intValue()][new Integer(elements[1]).intValue()];
	    	int line = 0;
	    	while((ligne = lecteurAvecBuffer.readLine()) != null) {
		    	elements = ligne.split(" ");
		    	for(int i = 0; i < elements.length; i++) {
		    		this.grid[line][i] = new Integer(elements[i]).intValue();
		    		this.gridInit[line][i] = new Integer(elements[i]).intValue();
		    	}
		    	line++;
		    }
		    lecteurAvecBuffer.close();
	    	}
	    catch(IOException exc){
	    	System.out.println(exc.getMessage());
	    	}
	    centerPanel = generateCenterPanel(this.grid.length,this.grid[0].length);
		rightPanel = generateRightPanel();

		this.setLayout(new BorderLayout());
		this.setSize(width, height);

		this.getContentPane().add(rightPanel, BorderLayout.EAST);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private JPanel generateRightPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(2,1));

		solveButton = new JButton("solve");

		solveButton.addActionListener(this);

		jPanel.add(solveButton);
		
		String[] petStrings = { "easy", "medium", "hard", "very hard" };
		petList = new JComboBox(petStrings);
		petList.setSelectedIndex(0);
		petList.addActionListener(this);
		
		jPanel.add(petList);

		return jPanel;
	}


	private JPanel generateCenterPanel(int rows, int columns) {
		JPanel jPanel = new JPanel();

		hidatoView = new MosaicPanel(rows,columns,50,50,Color.GRAY,2,this);  // for displaying the board
        hidatoView.setAlwaysDrawGrouting(true);
        hidatoView.setDefaultColor(Color.WHITE);
        hidatoView.setGroutingColor(Color.BLACK);

		jPanel.add(hidatoView);

		return jPanel;
	}
	
	public void solve() {
		Model model = new Model();
		IntVar[][] row = new IntVar[6][6];
		IntVar[] all = new IntVar[36];
		
		
		int index = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if(grid[i][j] != 0) {
					row[i][j] = model.intVar("contrainte de domaine", grid[i][j]);
					all[index] = model.intVar("contrainte de domaine", grid[i][j]);
				}
				else {
					row[i][j] = model.intVar("contrainte de domaine", 1, 36);
					all[index] = model.intVar("contrainte de domaine", 1, 36);
				}

				index++;
			}
			System.out.println("");
		}
		
		model.allDifferent(all).post();
		
		
		index = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				model.arithm(row[i][j], "=", all[index]).post();
				index++;

				if(grid[i][j] == 0) {
					
					Constraint[] plus = new Constraint[8];
					Constraint[] minus = new Constraint[8];
	 
					if(i != 0) {
						plus[0] = model.arithm(row[i][j], "-",row[i-1][j],"=",1);
						minus[0] = model.arithm(row[i][j], "-",row[i-1][j],"=",-1);
					}
					else {
						plus[0] = model.arithm(row[i][j], "=", 99);
						minus[0] = model.arithm(row[i][j], "=", 99);
					}
					
					if(i != 5) {
						plus[1] = model.arithm(row[i][j], "-",row[i+1][j],"=",1);
						minus[1] = model.arithm(row[i][j], "-",row[i+1][j],"=",-1);
					}
					else {
						plus[1] = model.arithm(row[i][j], "=", 99);
						minus[1] = model.arithm(row[i][j], "=", 99);
					}
					
					if(j != 0) {
						plus[2] = model.arithm(row[i][j], "-",row[i][j-1],"=",1);
						minus[2] = model.arithm(row[i][j], "-",row[i][j-1],"=",-1);
					}
					else {
						plus[2] = model.arithm(row[i][j], "=", 99);
						minus[2] = model.arithm(row[i][j], "=", 99);
					}
					
					if(j != 5) {
						plus[3] = model.arithm(row[i][j], "-",row[i][j+1],"=",1);
						minus[3] = model.arithm(row[i][j], "-",row[i][j+1],"=",-1);
					}
					else {
						plus[3] = model.arithm(row[i][j], "=", 99);
						minus[3] = model.arithm(row[i][j], "=", 99);
					}
					
					if(j != 0 && i != 0) {
						plus[4] = model.arithm(row[i][j], "-",row[i-1][j-1],"=",1);
						minus[4] = model.arithm(row[i][j], "-",row[i-1][j-1],"=",-1);
					}
					else {
						plus[4] = model.arithm(row[i][j], "=", 99);
						minus[4] = model.arithm(row[i][j], "=", 99);
					}
					
					if(j != 5 && i != 5) {
						plus[5] = model.arithm(row[i][j], "-",row[i+1][j+1],"=",1);
						minus[5] = model.arithm(row[i][j], "-",row[i+1][j+1],"=",-1);
					}
					else {
						plus[5] = model.arithm(row[i][j], "=", 99);
						minus[5] = model.arithm(row[i][j], "=", 99);
					}
					
					if(i != 0 && j != 5) {
						plus[6] = model.arithm(row[i][j], "-",row[i-1][j+1],"=",1);
						minus[6] = model.arithm(row[i][j], "-",row[i-1][j+1],"=",-1);
					}
					else {
						plus[6] = model.arithm(row[i][j], "=", 99);
						minus[6] = model.arithm(row[i][j], "=", 99);
					}
				
					if(i != 5 && j != 0) {
						plus[7] = model.arithm(row[i][j], "-",row[i+1][j-1],"=",1);
						minus[7] = model.arithm(row[i][j], "-",row[i+1][j-1],"=",-1);
					}
					else {
						plus[7] = model.arithm(row[i][j], "=", 99);
						minus[7] = model.arithm(row[i][j], "=", 99);
					}
					model.or(plus).post();
					model.or(minus).post();
				}		
			}
		}
		
		//solve
		System.out.println(model.getSolver().solve());

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				this.grid[i][j] = row[i][j].getValue();
				System.out.print(row[i][j].getValue() + " ");
			}
			System.out.println("");
		}
	}
	
	public boolean isSolved() {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				boolean foundedPlus = grid[i][j] == grid.length * grid[0].length, foundedMinus = grid[i][j] == 1;
				for(int k = i > 1? i - 1: 0; (!foundedPlus || !foundedMinus) && k < (i + 2 < grid.length? i + 2: grid.length); k++){
					for(int l = j > 1? j - 1: 0; (!foundedPlus || !foundedMinus) && l < (j + 2 < grid[i].length? j + 2: grid[i].length); l++) {
						if(grid[i][j] - grid[k][l] == 1)
							foundedMinus = true;
						else
							if(grid[i][j] - grid[k][l] == -1)
								foundedPlus = true;
					}
				}
				if(!foundedPlus || !foundedMinus)
					return false;
			}
		}
		return true;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[i].length; j++) {
				s += " " + this.grid[i][j];
			}
			s += "\n";
		}
		return s;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == solveButton) {
			this.solve();
			if(this.isSolved()) {
				this.hidatoView.disableTextField();
			}
		} else {
			if(e.getSource() == this.petList) {
				String lvl = "";
				switch(((JComboBox)e.getSource()).getSelectedIndex()){
						case 0: lvl = "hidatoEasy66.txt";break;
						case 1: lvl = "hidatoMedium66.txt";break;
						case 2: lvl = "hidatoHard66.txt";break;
						case 3: lvl = "hidatoVeryHard66.txt";break;
				}
				BufferedReader lecteurAvecBuffer = null;
			    String ligne;
			    try{
			    	lecteurAvecBuffer = new BufferedReader(new FileReader(lvl));
			    	ligne = lecteurAvecBuffer.readLine();
			    	String elements[] = ligne.split(" ");
			    	this.grid = new int[new Integer(elements[0]).intValue()][new Integer(elements[1]).intValue()];
			    	this.gridInit = new int[new Integer(elements[0]).intValue()][new Integer(elements[1]).intValue()];
			    	int line = 0;
			    	while((ligne = lecteurAvecBuffer.readLine()) != null) {
				    	elements = ligne.split(" ");
				    	for(int i = 0; i < elements.length; i++) {
				    		this.grid[line][i] = new Integer(elements[i]).intValue();
				    		this.gridInit[line][i] = new Integer(elements[i]).intValue();
				    	}
				    	line++;
				    }
				    lecteurAvecBuffer.close();
			    	}
			    catch(IOException exc){
			    	System.out.println(exc.getMessage());
			    	}
			    this.hidatoView.clearTextField();
			}else {
				String name = ((JTextField)e.getSource()).getName();
				String elements[] = name.split(" ");
				int row = new Integer(elements[0]).intValue(), col = new Integer(elements[1]).intValue();
				if(((JTextField)e.getSource()).getText().compareTo("") != 0) {
					this.grid[row][col] = new Integer(((JTextField)e.getSource()).getText()).intValue();
					System.out.println(this.toString());
					if(this.isSolved()) {
						this.hidatoView.disableTextField();
					}
				}
			}
		}
		updateSudokuView();
	}
	
	public void caretUpdate(CaretEvent e) {
		String name = ((JTextField)e.getSource()).getName();
		String elements[] = name.split(" ");
		int row = new Integer(elements[0]).intValue(), col = new Integer(elements[1]).intValue();
		if(((JTextField)e.getSource()).getText().compareTo("") != 0) {
				this.grid[row][col] = Integer.parseInt(((JTextField)e.getSource()).getText());
			System.out.println(this.toString());
		}
	}
	
	private void updateSudokuView() {
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[i].length; j++) {
				if(this.grid[i][j] == 0)
					hidatoView.setString(i, j, "");
				else
					hidatoView.setString(i, j, "" + this.grid[i][j]);
			}
		}
	}
	
	private static void generateMainWindow() {
		Hidato simulator = new Hidato(600, 500);
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				generateMainWindow();
				}
		});
	}
}
