package contests.weekofcode28;

import java.util.*;

public class ChoosingWhiteBalls {

	public static float createTree(int n, int k, char[] list, int sub) {
		if (k <= 0) {
			return 0;
		}
		Set<char[]> queue = new HashSet<char[]>();
		int[] a=new int[n];
		int[] b=new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (list[i] == 'W' && a[i]!=1) {
				a[i]=1;
				if(k-1>0){
					if(b[i]!=1){
						b[i]=1;
						insertIntoQueue(queue, list, i, n - 1);						
					}
				}
				count++;
			} else if(list[n - 1 - i] == 'W' && a[i] != 1) {
				a[i] = 1;
				if(k-1>0){
					if(b[n - 1 - i]!=1){						
						b[n - 1 - i]=1;
						insertIntoQueue(queue, list, n - 1 - i, n - 1);
					}
				}
				count++;
			} else {
				if(k-1>0){
					if(b[i]!=1 && list[i]=='B'){
						b[i]=1;
						insertIntoQueue(queue, list, i, n - 1);	
					}
					if(b[n - 1 - i]!=1&& list[n-1-i]=='B'){						
						b[n - 1 - i]=1;
						insertIntoQueue(queue, list, n - 1 - i, n - 1);
					}
				}
			}
		}
		float tot = (1/(float)sub)*((float) count / (float) n);
		Iterator<char[]> it = queue.iterator();
		int l = queue.size();
		while (it.hasNext()) {
			tot += createTree(n - 1, k - 1, it.next(), l);
			it.remove();
		}
		return tot;
	}

	private static void insertIntoQueue(Set<char[]> queue, char[] list, int i, int n) {
		char[] tmp = new char[n];
		int i1 = 0;
		for (int i0 = 0; i0 < list.length; i0++) {
			if (i0 != i) {
				tmp[i1] = list[i0];
				i1++;
			}
		}
			
		queue.add(tmp);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String balls = in.next();
		
		List<Character> list = new LinkedList<Character>();
		for (char c : balls.toCharArray()) {
			list.add(c);
		}
		System.out.println(createTree(n, k, balls.toCharArray(), 1));
	}

}
