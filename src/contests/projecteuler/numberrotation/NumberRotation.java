package contests.projecteuler.numberrotation;

import java.math.BigInteger;
import java.util.Scanner;

public class NumberRotation {
	private static final BigInteger TEN = BigInteger.valueOf(10);
	private static final BigInteger HUNDRED_THOUSAND = BigInteger.valueOf(100000);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		BigInteger total = BigInteger.ZERO;
		for (int pow = 0; pow < m; pow++) {
			for (BigInteger a = BigInteger.ONE; a.compareTo(TEN) < 0; a = a.add(BigInteger.ONE)) {
				for (BigInteger n = BigInteger.ONE; n.compareTo(TEN) < 0; n = n.add(BigInteger.ONE)) {
					final BigInteger denom = ((TEN.pow(pow)).subtract(n)).multiply(a);
					final BigInteger div = (TEN.multiply(n)).subtract(BigInteger.ONE);

					if (denom.mod(div).equals(BigInteger.ZERO)) {
						final BigInteger num = denom.divide(div);
						if (num.toString().length() == pow) {
							final BigInteger value = new BigInteger("" + num + a);
							if (value.toString().length() <= 100) {
								total = total.add(value);
							}
						}
					}
				}
			}
		}

		System.out.println(total.mod(HUNDRED_THOUSAND));
	}

}
