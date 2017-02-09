package contests.hourrank16;

import java.util.Arrays;
import java.util.Scanner;

public class CandyPiles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] c = new long[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextLong();
		}
		if (c.length == 1) {
			System.out.println(c[0] * 2 + " " + 1);
		} else {
			Arrays.sort(c);
			long happy = c[0];
			int count = 1;
			for (int j = 1; j < c.length; j++) {
				if (c[j] == happy) {
					count++;
				}
			}
			long happyDouble = happy * 2;
			if (count > 1) {
				System.out.println(happy + " " + count);
			} else {
				System.out.println(happyDouble + " " + count);
			}
		}
	}
}
