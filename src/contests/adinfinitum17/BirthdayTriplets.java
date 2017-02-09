package contests.adinfinitum17;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class BirthdayTriplets {

public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
	
		BigDecimal m = BigDecimal.valueOf(1000000007);
		for (int i = 0; i < q; i++) {
			BigDecimal f1 = new BigDecimal(in.next());
			BigDecimal f2 = new BigDecimal(in.next());
			BigDecimal f3 = new BigDecimal(in.next());

			BigDecimal a = BigDecimal.ZERO;
			BigDecimal b = BigDecimal.ZERO;
			BigDecimal c = BigDecimal.ZERO;
			BigDecimal l = new BigDecimal(in.next());
			BigDecimal r = new BigDecimal(in.next());
			r = r.add(BigDecimal.ONE);
			BigDecimal sum = BigDecimal.ZERO;
			outerloop: for (BigDecimal b0 = BigDecimal.ONE; b0.compareTo(BigDecimal.valueOf(5001)) < 0; b0 = b0
					.add(BigDecimal.ONE)) {
				for (BigDecimal c0 = b0.add(BigDecimal.ONE); c0.compareTo(BigDecimal.valueOf(5002)) < 0; c0 = c0
						.add(BigDecimal.ONE)) {
					BigDecimal res = f1.subtract(b0.pow(2).add(c0.pow(2)));
                    if (res.doubleValue() > 0) {
					res = new BigDecimal(Math.sqrt(res.doubleValue()));
                    
					if (res.compareTo(BigDecimal.valueOf(5001)) <= 0 && res.doubleValue() % 1 == 0) {
								
						if ((res.pow(2).add(b0.pow(2).add(c0.pow(2))).compareTo(f1) == 0
								&& (res.pow(3).add(b0.pow(3).add(c0.pow(3))).compareTo(f2) == 0)
								&& (res.pow(4).add(b0.pow(4).add(c0.pow(4))).compareTo(f3) == 0))) {
							c = res;
							a = b0;
							b = c0;
							break outerloop;
						}
					}
                    }
				}
			}
			
			BigInteger suma = BigInteger.ZERO;
			BigInteger exp1 = BigInteger.ZERO;
			BigDecimal exp2 = BigDecimal.ZERO;
			double exp2d = 0;
			if (a.equals(BigDecimal.ONE)) {
				suma = r.toBigInteger().subtract(l.toBigInteger()).mod(m.toBigInteger());
			} else {
				exp1 = a.toBigInteger().modPow(r.toBigInteger(), m.toBigInteger())
						.subtract(a.toBigInteger().modPow(l.toBigInteger(), m.toBigInteger())).mod(m.toBigInteger());
				exp2d = (1.0 / (a.doubleValue() - 1.0));
				if (exp2d < 0) {
					exp2d += m.intValue();
				}
				exp2 = BigDecimal.valueOf(exp2d);
				suma = new BigDecimal(exp1).multiply(exp2).setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger();
			}
			exp1 = b.toBigInteger().modPow(r.toBigInteger(), m.toBigInteger())
					.subtract(b.toBigInteger().modPow(l.toBigInteger(), m.toBigInteger())).mod(m.toBigInteger());
			exp2d = (1.0 / (b.doubleValue() - 1.0));
			if (exp2d < 0) {
				exp2d += m.intValue();
			}
			exp2 = BigDecimal.valueOf(exp2d);
			BigInteger sumb = new BigDecimal(exp1).multiply(exp2).setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger();

			exp1 = c.toBigInteger().modPow(r.toBigInteger(), m.toBigInteger())
					.subtract(c.toBigInteger().modPow(l.toBigInteger(), m.toBigInteger())).mod(m.toBigInteger());
			exp2d = (1.0 / (c.doubleValue() - 1.0));
			if (exp2d < 0) {
				exp2d += m.intValue();
			}
			exp2 = BigDecimal.valueOf(exp2d);
			BigInteger sumc = new BigDecimal(exp1).multiply(exp2).setScale(0, BigDecimal.ROUND_HALF_UP).toBigInteger();
			System.out.println(suma.add(sumb).add(sumc).mod(m.toBigInteger()));
		}
    }
}
