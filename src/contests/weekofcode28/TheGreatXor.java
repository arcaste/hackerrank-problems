package contests.weekofcode28;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class TheGreatXor {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
        	BigInteger a1 = BigInteger.valueOf(in.nextLong());
            char[] chars = new char[a1.toString(2).length()];
            Arrays.fill(chars, '1');
            System.out.println(new BigInteger(a1.xor(new BigInteger(new String(chars),2)).toString(2),2).longValue());
        }
    }

}
