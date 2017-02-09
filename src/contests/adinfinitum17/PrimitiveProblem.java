package contests.adinfinitum17;

import java.math.*;
import java.util.*;

public class PrimitiveProblem {
	static BigInteger TWO = new BigInteger("2");
	public static int exp(int a1, int b1, int m1) {
		BigInteger r = new BigInteger("1");
		BigInteger a = BigInteger.valueOf(a1);
		BigInteger b = BigInteger.valueOf(b1);
		BigInteger m = BigInteger.valueOf(m1);
		while (true) {
			BigInteger tmp = b.mod(TWO);
			if (tmp.equals(BigInteger.ONE)) {
				r = r.multiply(a);
				r = r.mod(m);
			}
			b = b.divide(TWO);
			if (b.equals(BigInteger.ZERO)) {
				break;
			}
			a = a.multiply(a);
			a = a.mod(m);
		}
		return r.intValue();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet();
		double count = p-1;
		int n = p-1;
        for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                		set.add(i);
                        n /= i;
                }
        }
        for (Integer x : set) {
			count=count*(1-(1/(double)x));
		}
		list.addAll(set);
		boolean found = true;

		for(int j=1; j < p;j++){
			for(int i : list){
				if(exp(j,(p-1)/i,p) == 1){
					found = false;
					break;
				}
			}
			if(found){				
				System.out.println(j + " " + (int)count);
				break;
			} else {
				found = true;
			}
		}
		
	}

}
