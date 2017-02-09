package contests.hourrank16;

import java.math.BigInteger;
import java.util.Scanner;

public class LuckyNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		boolean flag = false;
		for (int a0 = 0; a0 < q; a0++) {
			BigInteger n = new BigInteger(in.next());
			BigInteger tmp = n;
			flag = false;
			if (n.mod(BigInteger.valueOf(7)).compareTo(BigInteger.ZERO) == 0) {
				System.out.println("Yes");
			} else if (n.mod(BigInteger.valueOf(4)).compareTo(BigInteger.ZERO) == 0) {
				System.out.println("Yes");
			} else {
				tmp = tmp.subtract(BigInteger.valueOf(7));
				while (tmp.compareTo(BigInteger.ZERO) >= 0) {
					if (tmp.mod(BigInteger.valueOf(4)).compareTo(BigInteger.ZERO) == 0) {
						flag = true;
						System.out.println("Yes");
						break;
					}
					tmp = tmp.subtract(BigInteger.valueOf(7));
				}
				if (!flag) {
					System.out.println("No");
				}
			}
		}
	}
}
