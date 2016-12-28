package algorithms.implementation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c[] = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}
		in.close();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int count;
			if (map.get(c[i]) == null) {
				count = 1;
			} else {
				count = map.get(c[i]);
				count++;
			}
			map.put(c[i], count);
		}
		Iterator it = map.entrySet().iterator();
		int socksPair = 0;
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        socksPair += (int) pair.getValue()/2;
	        it.remove();
	    }
	    System.out.println(socksPair);
	}

}
