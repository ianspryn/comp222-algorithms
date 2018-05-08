
public class TicTacToeBoard {
	private Symbol[][] board;	
	
	public TicTacToeBoard(int[] intBoard) {
		board = new Symbol[3][3];
		
		int counter = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (intBoard[counter] == 1) {
					board[i][j] = Symbol.BLANK;
				} else if (intBoard[counter] == 2) {
					board[i][j] = Symbol.O;
				} else {
					board[i][j] = Symbol.X;
				}
				counter++;
			}
		}
	}



	@Override
//	public int hashCode() {
//		String s = "";
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if (board[i][j] == (Symbol.BLANK)) {
//					s += "1";
//				} else if (board[i][j] == (Symbol.O)) {
//					s += "2";
//				} else {
//					s+= "3";
//				}
//			}
//		}
//		
//		int hash = 7;
//		for (char c: s.toCharArray()) {
//			hash = hash * 31 + c;
//		}
//		return hash;
//	}
	
	public int hashCode() {
		int[] numbers = new int[9];
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == (Symbol.BLANK)) {
					numbers[counter] = 0;
				} else if (board[i][j] == (Symbol.O)) {
					numbers[counter] = 1;
				} else {
					numbers[counter] = 2;
				}
			}
		}
		
		int hash = 7;
		for (int i = 0; i < 9; i++) {
			hash = hash + numbers[i] * (int)Math.pow(3, i+1);	
		}
		return hash;
	}
}
