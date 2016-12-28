package ai.botbuilding.botsaveprincess;

import java.util.Scanner;

public class BotSavePrincess {

	private static void printInput(int n, char[][] board) {
		System.out.println(n);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.print('\n');
		}
	}

	private static void solution(int n, char[][] board) throws Exception {
		printInput(n, board);
		int p;
		if (board[0][0] == 'p') {
			p = 0;
		} else if (board[0][n - 1] == 'p') {
			p = 1;
		} else if (board[n - 1][0] == 'p') {
			p = 2;
		} else if (board[n - 1][n - 1] == 'p') {
			p = 3;
		} else {
			throw new Exception("Princess not found");
		}
		switch (p) {
		case 0:
			printOutput(n, new String[] { "UP", "LEFT" });
			break;
		case 1:
			printOutput(n, new String[] { "UP", "RIGHT" });
			break;
		case 2:
			printOutput(n, new String[] { "DOWN", "LEFT" });
			break;
		case 3:
			printOutput(n, new String[] { "DOWN", "RIGHT" });
			break;
		default:
			throw new Exception("Cannot print path");
		}

	}

	private static void printOutput(int n, String[] path) {
		int i;
		for (i = 0; i < n / 2; i++) {
			System.out.println(path[0]);
		}
		for (i = 0; i < n / 2; i++) {
			System.out.println(path[1]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n < 3 || n > 100 || n % 2 == 0) {
			System.out.println("Enter an odd number, 3 <= N < 100");
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
		solution(n, board);
	}
}
