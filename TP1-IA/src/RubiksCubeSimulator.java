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

public class RubiksCubeSimulator extends JFrame implements ActionListener {

	private final JPanel rightPanel;
	private final JPanel topPanel;
	private final JPanel centerPanel;
	private final JPanel bottomPanel;

	private static JButton upButton;
	private static JButton backButton;
	private static JButton leftButton;
	private static JButton frontButton;
	private static JButton rightButton;
	private static JButton downButton;

	private static JButton randomMoreButton;
	private static JButton randomLessButton;
	private static JLabel randomNumber;
	private static int randomNbr;
	private static JButton shuffleButton;
	private static JButton solveButton;

	private static JButton reUpButton;
	private static JButton reBackButton;
	private static JButton reLeftButton;
	private static JButton reFrontButton;
	private static JButton reRightButton;
	private static JButton reDownButton;

	private MosaicPanel cubeView;
	//private static JTextArea cubeView;

	private static Cube cube;

	public RubiksCubeSimulator(int width, int height) {
		topPanel = generateTopPanel();
		centerPanel = generateCenterPanel();
		bottomPanel = generateBottomPanel();
		rightPanel = generateRightPanel();

		this.setLayout(new BorderLayout());
		this.setSize(width, height);

		this.getContentPane().add(rightPanel, BorderLayout.EAST);
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		cube = new Cube();

		updateCubeView();
	}

	private void updateCubeView() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				switch(cube.upFace[i][j]) {
					case 'W': cubeView.setColor(i, j+3, Color.WHITE); break;
					case 'B': cubeView.setColor(i, j+3, Color.BLUE); break;
					case 'R': cubeView.setColor(i, j+3, Color.RED); break;
					case 'G': cubeView.setColor(i, j+3, Color.GREEN); break;
					case 'O': cubeView.setColor(i, j+3, Color.ORANGE); break;
					case 'Y': cubeView.setColor(i, j+3, Color.YELLOW);
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				switch(cube.frontFace[i][j]) {
					case 'W': cubeView.setColor(i+3, j+3, Color.WHITE); break;
					case 'B': cubeView.setColor(i+3, j+3, Color.BLUE); break;
					case 'R': cubeView.setColor(i+3, j+3, Color.RED); break;
					case 'G': cubeView.setColor(i+3, j+3, Color.GREEN); break;
					case 'O': cubeView.setColor(i+3, j+3, Color.ORANGE); break;
					case 'Y': cubeView.setColor(i+3, j+3, Color.YELLOW);
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				switch(cube.leftFace[i][j]) {
					case 'W': cubeView.setColor(i+3, j, Color.WHITE); break;
					case 'B': cubeView.setColor(i+3, j, Color.BLUE); break;
					case 'R': cubeView.setColor(i+3, j, Color.RED); break;
					case 'G': cubeView.setColor(i+3, j, Color.GREEN); break;
					case 'O': cubeView.setColor(i+3, j, Color.ORANGE); break;
					case 'Y': cubeView.setColor(i+3, j, Color.YELLOW);
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				switch(cube.rightFace[i][j]) {
					case 'W': cubeView.setColor(i+3, j+6, Color.WHITE); break;
					case 'B': cubeView.setColor(i+3, j+6, Color.BLUE); break;
					case 'R': cubeView.setColor(i+3, j+6, Color.RED); break;
					case 'G': cubeView.setColor(i+3, j+6, Color.GREEN); break;
					case 'O': cubeView.setColor(i+3, j+6, Color.ORANGE); break;
					case 'Y': cubeView.setColor(i+3, j+6, Color.YELLOW);
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				switch(cube.backFace[i][j]) {
					case 'W': cubeView.setColor(i+3, j+9, Color.WHITE); break;
					case 'B': cubeView.setColor(i+3, j+9, Color.BLUE); break;
					case 'R': cubeView.setColor(i+3, j+9, Color.RED); break;
					case 'G': cubeView.setColor(i+3, j+9, Color.GREEN); break;
					case 'O': cubeView.setColor(i+3, j+9, Color.ORANGE); break;
					case 'Y': cubeView.setColor(i+3, j+9, Color.YELLOW);
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				switch(cube.downFace[i][j]) {
					case 'W': cubeView.setColor(i+6, j+3, Color.WHITE); break;
					case 'B': cubeView.setColor(i+6, j+3, Color.BLUE); break;
					case 'R': cubeView.setColor(i+6, j+3, Color.RED); break;
					case 'G': cubeView.setColor(i+6, j+3, Color.GREEN); break;
					case 'O': cubeView.setColor(i+6, j+3, Color.ORANGE); break;
					case 'Y': cubeView.setColor(i+6, j+3, Color.YELLOW);
				}
			}
		}
		
		/*char[][] view = cube.getFlatCube();

		cubeView.setText("");
		for (int i = 0; i < 9; i++) {
			cubeView.append(new String(view[i]));
			if (i < 8) {
				cubeView.append("\n");
			}
		}*/
	}

	private JPanel generateRightPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(5,1));

		randomMoreButton = new JButton("more");
		randomLessButton = new JButton("less");
		randomNumber = new JLabel("0");
		randomNbr = 0;
		shuffleButton = new JButton("shuffle");
		solveButton = new JButton("solve");

		randomMoreButton.addActionListener(this);
		randomLessButton.addActionListener(this);
		shuffleButton.addActionListener(this);
		solveButton.addActionListener(this);

		jPanel.add(randomMoreButton);
		jPanel.add(randomLessButton);
		jPanel.add(randomNumber);
		jPanel.add(shuffleButton);
		jPanel.add(solveButton);

		return jPanel;
	}

	private JPanel generateTopPanel() {
		JPanel jPanel = new JPanel();

		upButton = new JButton("UP");
		backButton = new JButton("BACK");
		leftButton = new JButton("LEFT");
		frontButton = new JButton("FRONT");
		rightButton = new JButton("RIGHT");
		downButton = new JButton("DOWN");

		upButton.addActionListener(this);
		backButton.addActionListener(this);
		leftButton.addActionListener(this);
		frontButton.addActionListener(this);
		rightButton.addActionListener(this);
		downButton.addActionListener(this);

		jPanel.add(upButton);
		jPanel.add(backButton);
		jPanel.add(leftButton);
		jPanel.add(frontButton);
		jPanel.add(rightButton);
		jPanel.add(downButton);

		return jPanel;
	}

	private JPanel generateCenterPanel() {
		JPanel jPanel = new JPanel();

		//cubeView = new JTextArea();
		//cubeView.setEditable(false);
		
		cubeView = new MosaicPanel(9,12,20,20,Color.GRAY,2);  // for displaying the board
        cubeView.setAlwaysDrawGrouting(true);
        cubeView.setDefaultColor(Color.DARK_GRAY);
        cubeView.setGroutingColor(Color.BLACK);

		jPanel.add(cubeView);

		return jPanel;
	}

	private JPanel generateBottomPanel() {
		JPanel jPanel = new JPanel();

		reUpButton = new JButton("UPi");
		reBackButton = new JButton("BACKi");
		reLeftButton = new JButton("LEFTi");
		reFrontButton = new JButton("FRONTi");
		reRightButton = new JButton("RIGHTi");
		reDownButton = new JButton("DOWNi");

		reUpButton.addActionListener(this);
		reBackButton.addActionListener(this);
		reLeftButton.addActionListener(this);
		reFrontButton.addActionListener(this);
		reRightButton.addActionListener(this);
		reDownButton.addActionListener(this);

		jPanel.add(reUpButton);
		jPanel.add(reBackButton);
		jPanel.add(reLeftButton);
		jPanel.add(reFrontButton);
		jPanel.add(reRightButton);
		jPanel.add(reDownButton);

		return jPanel;
	}

	private static void generateMainWindow() {
		RubiksCubeSimulator simulator = new RubiksCubeSimulator(480, 300);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == upButton) {
			cube.turnUp();
		} else if (e.getSource() == backButton) {
			cube.turnBack();
		} else if (e.getSource() == leftButton) {
			cube.turnLeft();
		} else if (e.getSource() == frontButton) {
			cube.turnFront();
		} else if (e.getSource() == rightButton) {
			cube.turnRight();
		} else if (e.getSource() == downButton) {
			cube.turnDown();
		} else if (e.getSource() == reUpButton) {
			cube.returnUp();
		} else if (e.getSource() == reBackButton) {
			cube.returnBack();
		} else if (e.getSource() == reLeftButton) {
			cube.returnLeft();
		} else if (e.getSource() == reFrontButton) {
			cube.returnFront();
		} else if (e.getSource() == reRightButton) {
			cube.returnRight();
		} else if (e.getSource() == reDownButton) {
			cube.returnDown();
		} else if (e.getSource() == randomMoreButton) {
			randomNbr++; randomNumber.setText(""+randomNbr);
		} else if (e.getSource() == randomLessButton) {
			if(randomNbr > 0) randomNbr--; randomNumber.setText(""+randomNbr);
		} else if (e.getSource() == shuffleButton) {
			cube.shuffleCube(randomNbr);
		} else if (e.getSource() == solveButton) {
			Astar algorithme = new Astar((Cube)cube.clone());
			ArrayList<String> solution = algorithme.solve();
			System.out.println("Solution obtenue = " +solution);
			for(int i = 0; i < solution.size(); i++) {
				switch(solution.get(i)) {
					case "U": cube.turnUp(); break;
					case "L": cube.turnLeft(); break;
					case "F": cube.turnFront(); break;
					case "R": cube.turnRight(); break;
					case "D": cube.turnDown(); break;
					case "B": cube.turnBack(); break;
					case "U'": cube.returnUp(); break;
					case "L'": cube.returnLeft(); break;
					case "F'": cube.returnFront(); break;
					case "R'": cube.returnRight(); break;
					case "D'": cube.returnDown(); break;
					case "B'": cube.returnBack();
				}
			}
		}
		updateCubeView();
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				generateMainWindow();
			}
		});
	}

}
