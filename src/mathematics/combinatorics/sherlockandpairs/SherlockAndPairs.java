package mathematics.combinatorics.sherlockandpairs;

import java.util.Scanner;

public class SherlockAndPairs {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int x = 0; x < t; x++) {
			int n = s.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = s.nextInt();
			}
			int count = 0;
			for (int i = 0; i < a.length - 1; i++) {
				for (int j = i + 1; j < a.length; j++) {
					if (a[i] == a[j]) {
						count++;
					}
				}
			}
			System.out.println(count * 2);
		}
	}

}
