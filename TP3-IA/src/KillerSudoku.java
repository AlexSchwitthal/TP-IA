import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KillerSudoku extends JFrame implements ActionListener, CaretListener{
	private final JPanel rightPanel;
	private final JPanel centerPanel;
	
	private static JButton solveButton;
	private static JComboBox petList;
	
	private MosaicPanel sudokuView;
	
	public int grid[][] = new int [9][9];
	public ArrayList<Cage> cages;
	
	public KillerSudoku(int width, int height){
		centerPanel = generateCenterPanel();
		rightPanel = generateRightPanel();

		this.setLayout(new BorderLayout());
		this.setSize(width, height);

		this.getContentPane().add(rightPanel, BorderLayout.EAST);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.cages = new ArrayList<Cage>();
		BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    try{
	    	lecteurAvecBuffer = new BufferedReader(new FileReader("src/easyKS.txt"));
	    	while((ligne = lecteurAvecBuffer.readLine()) != null) {
		    	String elements[] = ligne.split(" ");
		    	ArrayList<Pair> cells = new ArrayList<Pair>();
		    	for(int i = 1; i < elements.length; i = i + 2) {
		    		cells.add(new Pair(new Integer(elements[i]).intValue(), new Integer(elements[i + 1]).intValue()));
		    	}
		    	this.cages.add(new Cage(new Integer(elements[0]).intValue(), cells));
		    }
		    lecteurAvecBuffer.close();
	    	}
	    catch(IOException exc){
	    	System.out.println(exc.getMessage());
	    	}
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


	private JPanel generateCenterPanel() {
		JPanel jPanel = new JPanel();

		sudokuView = new MosaicPanel(9,9,50,50,Color.GRAY,2,this);  // for displaying the board
        sudokuView.setAlwaysDrawGrouting(true);
        sudokuView.setDefaultColor(Color.WHITE);
        sudokuView.setGroutingColor(Color.BLACK);

		jPanel.add(sudokuView);

		return jPanel;
	}
	
	public void solve() {
		Model model = new Model("Choco solver");
		IntVar[][] row = new IntVar[9][9];
		IntVar[][] col = new IntVar[9][9];
		IntVar[][] block = new IntVar[9][9];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; i < 9; i++) {
				IntVar a = model.intVar("domaine", 1, 9);
				row[i][j] = a;
				col[j][i] = a;
				block[i/3 * 3 + j/3][i%3 * 3 + j%3] = a;
			}
		}
		
		for(Cage c: this.cages) {
			int sum = 0;
			for(Pair p: c.cells) {
				
			}
		}
		model.getSolver();
	}
	
	public boolean isSolved() {
		ArrayList<TreeSet<Integer>> row = new ArrayList<TreeSet<Integer>>();
		ArrayList<TreeSet<Integer>> col = new ArrayList<TreeSet<Integer>>();
		ArrayList<TreeSet<Integer>> nonet = new ArrayList<TreeSet<Integer>>();
		for(int i = 0; i < 9; i++) {
			row.add(new TreeSet<Integer>());
			col.add(new TreeSet<Integer>());
			nonet.add(new TreeSet<Integer>());
		}
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(row.get(i).contains(new Integer(this.grid[i][j])))
					return false;
				if(col.get(j).contains(new Integer(this.grid[i][j])))
					return false;
				if(nonet.get(i / 3 * 3 + j / 3).contains(new Integer(this.grid[i][j])))
					return false;
				row.get(i).add(new Integer(this.grid[i][j]));
				col.get(j).add(new Integer(this.grid[i][j]));
				nonet.get(i / 3 * 3 + j / 3).add(new Integer(this.grid[i][j]));
			}
		}
		for(int i = 0; i < this.cages.size(); i++) {
			int sum = 0;
			TreeSet<Integer> allDiff = new TreeSet<Integer>();
			for(int j = 0; j < this.cages.get(i).cells.size(); j ++) {
				sum += this.grid[this.cages.get(i).cells.get(j).abs - 1][this.cages.get(i).cells.get(j).ord - 1];
				if(allDiff.contains(new Integer(this.grid[this.cages.get(i).cells.get(j).abs - 1][this.cages.get(i).cells.get(j).ord - 1])))
					return false;
				allDiff.add(new Integer(this.grid[this.cages.get(i).cells.get(j).abs - 1][this.cages.get(i).cells.get(j).ord - 1]));
			}
			if(sum != this.cages.get(i).sum)
				return false;
		}
		return true;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				s += " " + this.grid[i][j];
			}
			s += "\n";
		}
		for(int i = 0; i < this.cages.size(); i++) {
			s+= this.cages.get(i).toString() + "\n";
		}
		return s;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == solveButton) {
			this.solve();
			if(this.isSolved()) {
				this.sudokuView.disableTextField();
			}
		} else {
			if(e.getSource() == this.petList) {
				String lvl = "";
				switch(((JComboBox)e.getSource()).getSelectedIndex()){
						case 0: lvl = "src/easyKS.txt";break;
						case 1: lvl = "src/mediumKS.txt";break;
						case 2: lvl = "src/hardKS.txt";break;
						case 3: lvl = "src/veryHardKS.txt";break;
				}
				this.cages = new ArrayList<Cage>();
				BufferedReader lecteurAvecBuffer = null;
			    String ligne;
			    try{
			    	lecteurAvecBuffer = new BufferedReader(new FileReader(lvl));
			    	while((ligne = lecteurAvecBuffer.readLine()) != null) {
				    	String elements[] = ligne.split(" ");
				    	ArrayList<Pair> cells = new ArrayList<Pair>();
				    	for(int i = 1; i < elements.length; i = i + 2) {
				    		cells.add(new Pair(new Integer(elements[i]).intValue(), new Integer(elements[i + 1]).intValue()));
				    	}
				    	this.cages.add(new Cage(new Integer(elements[0]).intValue(), cells));
				    }
				    lecteurAvecBuffer.close();
			    	}
			    catch(IOException exc){
			    	System.out.println(exc.getMessage());
			    	}
			    this.sudokuView.clearTextField();
			}
			else {
				String name = ((JTextField)e.getSource()).getName();
				String elements[] = name.split(" ");
				int row = new Integer(elements[0]).intValue(), col = new Integer(elements[1]).intValue();
				if(((JTextField)e.getSource()).getText().compareTo("") != 0) {
					this.grid[row][col] = new Integer(((JTextField)e.getSource()).getText()).intValue();
					System.out.println(this.toString());
					if(this.isSolved()) {
						this.sudokuView.disableTextField();
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
			this.grid[row][col] = new Integer(((JTextField)e.getSource()).getText()).intValue();
			System.out.println(this.toString());
		}
	}
	
	private void updateSudokuView() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(this.grid[i][j] == 0)
					sudokuView.setChar(i, j, '\0');
				else
					sudokuView.setChar(i, j, (char)('0' + this.grid[i][j]));
			}
		}
	}
	
	private static void generateMainWindow() {
		KillerSudoku simulator = new KillerSudoku(600, 500);
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				generateMainWindow();
			}
		});
	}
}
