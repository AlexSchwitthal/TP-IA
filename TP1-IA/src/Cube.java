import java.util.concurrent.ThreadLocalRandom;


public class Cube implements Cloneable{

	public char[][] upFace;
	public char[][] backFace;
	public char[][] rightFace;
	public char[][] frontFace;
	public char[][] leftFace;
	public char[][] downFace;

	public Cube() {
		upFace = initializeFace('W');
		backFace = initializeFace('R');
		rightFace = initializeFace('G');
		frontFace = initializeFace('B');
		leftFace = initializeFace('Y');
		downFace = initializeFace('O');
	}

	private char[][] initializeFace(char color) {
		char[][] side = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				side[i][j] = color;
			}
		}
		return side;
	}

	public void turnUp() {
		upFace = rotateArrayClockwise(upFace);//rotation des couleurs sur la partie visible de la face

		for (int i = 0; i < 3; i++) {
			char tmp = frontFace[0][i];//decalage du haut des faces (qui bougent avec la face haute)
			frontFace[0][i] = rightFace[0][i];
			rightFace[0][i] = backFace[0][i];
			backFace[0][i] = leftFace[0][i];
			leftFace[0][i] = tmp;
		}
	}

	public void turnLeft() {
		leftFace = rotateArrayClockwise(leftFace);

		for (int i = 0; i < 3; i++) {
			char tmp = backFace[2 - i][2];
			backFace[2 - i][2] = downFace[i][0];
			downFace[i][0] = frontFace[i][0];
			frontFace[i][0] = upFace[i][0];
			upFace[i][0] = tmp;
		}
	}

	public void turnFront() {
		frontFace = rotateArrayClockwise(frontFace);

		for (int i = 0; i < 3; i++) {
			char tmp = leftFace[2 - i][2];
			leftFace[2-i][2] = downFace[0][2-i];
			downFace[0][2-i] = rightFace[i][0];
			rightFace[i][0] = upFace[2][i];
			upFace[2][i] = tmp;
		}
	}

	public void turnRight() {
		rightFace = rotateArrayClockwise(rightFace);

		for (int i = 0; i < 3; i++) {
			char tmp = frontFace[i][2];
			frontFace[i][2] = downFace[i][2];
			downFace[i][2] = backFace[2 - i][0];
			backFace[2-i][0] = upFace[i][2];
			upFace[i][2] = tmp;
		}

	}

	public void turnDown() {
		downFace = rotateArrayClockwise(downFace);

		for (int i = 0; i < 3; i++) {
			char tmp = leftFace[2][i];
			leftFace[2][i] = backFace[2][i];
			backFace[2][i] = rightFace[2][i];
			rightFace[2][i] = frontFace[2][i];
			frontFace[2][i] = tmp;
		}
	}

	public void turnBack() {
		backFace = rotateArrayClockwise(backFace);

		for (int i = 0; i < 3; i++) {
			char tmp = rightFace[i][2];
			rightFace[i][2] = downFace[2][2 - i];
			downFace[2][2-i] = leftFace[2-i][0];
			leftFace[2-i][0] = upFace[0][i];
			upFace[0][i] = tmp;
		}
	}

	public void returnUp() {
		upFace = rotateArrayUnClockwise(upFace);//rotation des couleurs sur la partie visible de la face

		for (int i = 0; i < 3; i++) {
			char tmp = frontFace[0][i];//decalage du haut des faces (qui bougent avec la face haute)
			frontFace[0][i] = leftFace[0][i];
			leftFace[0][i] = backFace[0][i];
			backFace[0][i] = rightFace[0][i];
			rightFace[0][i] = tmp;
		}
	}

	public void returnLeft() {
		leftFace = rotateArrayUnClockwise(leftFace);
		
		for (int i = 0; i < 3; i++) {
			char tmp = backFace[2 - i][2];
			backFace[2 - i][2] = upFace[i][0];
			upFace[i][0] = frontFace[i][0];
			frontFace[i][0] = downFace[i][0];
			downFace[i][0] = tmp;
		}
	}

	public void returnFront() {
		frontFace = rotateArrayUnClockwise(frontFace);

		for (int i = 0; i < 3; i++) {
			char tmp = leftFace[2 - i][2];
			leftFace[2-i][2] = upFace[2][i];
			upFace[2][i] = rightFace[i][0];
			rightFace[i][0] = downFace[0][2-i];
			downFace[0][2-i] = tmp;
		}
	}

	public void returnRight() {
		rightFace = rotateArrayUnClockwise(rightFace);
		
		for (int i = 0; i < 3; i++) {
			char tmp = frontFace[i][2];
			frontFace[i][2] = upFace[i][2];
			upFace[i][2] = backFace[2 - i][0];
			backFace[2-i][0] = downFace[i][2];
			downFace[i][2] = tmp;
		}
	}

	public void returnDown() {
		downFace = rotateArrayUnClockwise(downFace);

		for (int i = 0; i < 3; i++) {
			char tmp = leftFace[2][i];
			leftFace[2][i] = frontFace[2][i];
			frontFace[2][i] = rightFace[2][i];
			rightFace[2][i] = backFace[2][i];
			backFace[2][i] = tmp;
		}
	}

	public void returnBack() {
		backFace = rotateArrayUnClockwise(backFace);

		for (int i = 0; i < 3; i++) {
			char tmp = rightFace[i][2];
			rightFace[i][2] = upFace[0][i];
			upFace[0][i] = leftFace[2-i][0];
			leftFace[2-i][0] = downFace[2][2-i];
			downFace[2][2-i] = tmp;
		}
	}

	public void randomMove() {
		int random = ThreadLocalRandom.current().nextInt(0, 12);

		switch (random) {
		case 0:
			this.turnUp();
			break;
		case 1:
			this.turnLeft();
			break;
		case 2:
			this.turnFront();
			break;
		case 3:
			this.turnRight();
			break;
		case 4:
			this.turnDown();
			break;
		case 5:
			this.turnBack();
			break;
		case 6:
			this.returnUp();
			break;
		case 7:
			this.returnLeft();
			break;
		case 8:
			this.returnFront();
			break;
		case 9:
			this.returnRight();
			break;
		case 10:
			this.returnDown();
			break;
		case 11:
			this.returnBack();
			break;
		}
	}

	public void shuffleCube(int iter) {
		for (int i = 0; i < iter; i++) {
			this.randomMove();
		}
	}


	private static char[][] applyFace(char[][] source) {
		char[][] target = new char[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				target[i][j] = source[i][j];
			}
		}

		return target;
	}

	private static char[][] rotateArrayClockwise(char[][] array) {

		char[][] rotatedArray = new char[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				rotatedArray[j][2 - i] = array[i][j];
			}
		}
		return rotatedArray;
	}
	
	private static char[][] rotateArrayUnClockwise(char[][] array) {

		char[][] rotatedArray = new char[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				rotatedArray[2-j][i] = array[i][j];
			}
		}
		return rotatedArray;
	}

	public char[][] getFlatCube() {
		char[][] cube = new char[9][12];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 12; j++) {
				cube[i][j] = ' ';
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j + 3] = upFace[i][j];
				cube[i + 3][j] = leftFace[i][j];
				cube[i + 3][j + 3] = frontFace[i][j];
				cube[i + 3][j + 6] = rightFace[i][j];
				cube[i + 3][j + 9] = backFace[i][j];
				cube[i + 6][j + 3] = downFace[i][j];
			}
		}

		return cube;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < 3; i++) {
			s = s.concat(new String(this.upFace[i]));
		}
		for(int i = 0; i < 3; i++) {
			s = s.concat(new String(this.downFace[i]));
		}
		for(int i = 0; i < 3; i++) {
			s = s.concat(new String(this.rightFace[i]));
		}
		for(int i = 0; i < 3; i++) {
			s = s.concat(new String(this.leftFace[i]));
		}
		for(int i = 0; i < 3; i++) {
			s = s.concat(new String(this.frontFace[i]));
		}
		for(int i = 0; i < 3; i++) {
			s = s.concat(new String(this.backFace[i]));
		}
		return s;
	}

	public boolean isSolved() {
		if (!isFaceSolved(upFace)) {
			return false;
		}
		if (!isFaceSolved(leftFace)) {
			return false;
		}
		if (!isFaceSolved(frontFace)) {
			return false;
		}
		if (!isFaceSolved(rightFace)) {
			return false;
		}
		if (!isFaceSolved(backFace)) {
			return false;
		}
		if (!isFaceSolved(downFace)) {
			return false;
		}
		return true;
	}

	private static boolean isFaceSolved(char[][] face) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (face[i][j]!=face[1][1]) {
					return false;
				}
			}
		}

		return true;
	}

	public char[][] getUpFace() {
		return applyFace(upFace);
	}

	public char[][] getBackFace() {
		return applyFace(backFace);
	}

	public char[][] getRightFace() {
		return applyFace(rightFace);
	}

	public char[][] getFrontFace() {
		return applyFace(frontFace);
	}

	public char[][] getLeftFace() {
		return applyFace(leftFace);
	}

	public char[][] getDownFace() {
		return applyFace(downFace);
	}
	
	public Object clone(){
		Cube copy = new Cube();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				copy.upFace[i][j] = this.upFace[i][j];
				copy.backFace[i][j] = this.backFace[i][j];
				copy.rightFace[i][j] = this.rightFace[i][j];
				copy.frontFace[i][j] = this.frontFace[i][j];
				copy.leftFace[i][j] = this.leftFace[i][j];
				copy.downFace[i][j] = this.downFace[i][j];
			}
		}
		return copy;
	}

}
