import java.util.HashSet;

public class Collision_TicTacToe {

	public static void main(String[] args) {

		//int M = 8009;
		int M = Integer.MAX_VALUE;
		
		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		TicTacToeBoard tic;
		
		int[] newBoard = new int[9];
		for (int i = 1; i < 4; i++ ) {
			newBoard[0] = i;
			for (int j = 1; j < 4; j++ ) {
				newBoard[1] = j;
				for (int k = 1; k < 4; k++ ) {
					newBoard[2] = k;
					for (int l = 1; l < 4; l++ ) {
						newBoard[3] = l;
						for (int m = 1; m < 4; m++ ) {
							newBoard[4] = m;
							for (int n = 1; n < 4; n++ ) {
								newBoard[5] = n;
								for (int o = 1; o < 4; o++ ) {
									newBoard[6] = o;
									for (int p = 1; p < 4; p++ ) {
										newBoard[7] = p;
										for (int q = 1; q < 4; q++ ) {
											newBoard[8] = q;
											tic = new TicTacToeBoard(newBoard);
											int hash = (tic.hashCode() % M + M) % M;
											if(set.contains(hash))
												count++;
											else
												set.add(hash);
										}
									}	
								}	
							}	
						}	
					}	
				}	
			}
		}
		System.out.println(count);
	}
}