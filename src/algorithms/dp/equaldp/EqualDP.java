package algorithms.dp.equaldp;

import java.util.Arrays;
import java.util.Scanner;

public class EqualDP {

	static long add(long a) {
		if (a == 1) {
			return 1;
		} else if (a >= 2 && a < 5) {
			return 2;
		} else {
			return 5;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			int count = 0;
			int num = s.nextInt();
			long[] co = new long[num];
			for (int j = 0; j < num; j++)
				co[j] = s.nextLong();
			Arrays.sort(co);
			while (co[0] != co[num - 1]) {
				long a = co[num - 1] - co[0];
				long b = add(a);
				for (int x = 0; x < num - 1; x++) {
					co[x] += b;
				}
				count++;
				Arrays.sort(co);
			}
			System.out.println(count);
		}
	}

}
