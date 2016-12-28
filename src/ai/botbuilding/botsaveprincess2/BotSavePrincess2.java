package ai.botbuilding.botsaveprincess2;

import java.util.Scanner;

public class BotSavePrincess2 {
	static void nextMove(int N, int r, int c, char[][] board) throws Exception {
		int rP = -1, cP = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 'p') {
					rP = i;
					cP = j;
				}
			}
		}
		if (rP < 0 || cP < 0) {
			throw new Exception("Princess not found");
		}

		if (rP - r < 0) {
			System.out.println("UP");
		} else if (rP - r > 0) {
			System.out.println("DOWN");
		} else if (rP - r == 0 && cP - c < 0) {
			System.out.println("LEFT");
		} else if (rP - r == 0 && cP - c > 0) {
			System.out.println("RIGHT");
		}

	}

	static void printInput(int n, char[][] board) {
		System.out.println(n);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.print('\n');
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n < 3 || n > 100 || n % 2 == 0) {
			System.out.println("Enter an odd number, 3 <= N < 100");
			System.exit(0);
		}
		int r = sc.nextInt();
		int c = sc.nextInt();
		if (r >= n || c >= n) {
			System.out.println("Bot positions are out of bounds");
			System.exit(0);
		}
		char[][] board = new char[n][n];
		String in;
		for (int i = 0; i < n; i++) {
			in = sc.next();
			char[] array = in.toCharArray();
			for (int j = 0; j < array.length; j++) {
				board[i][j] = array[j];
			}
		}
		sc.close();
		if (board[r][c] != 'm') {
			throw new Exception("Bot positions doesn't match");
		}
		printInput(n, board);
		nextMove(n, r, c, board);
	}
}
