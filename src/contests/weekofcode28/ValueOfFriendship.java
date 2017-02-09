package contests.weekofcode28;

import java.math.BigInteger;
import java.util.*;

class Group implements Comparable<Group> {
	Set<Integer> list = new HashSet<Integer>();

	public Group() {
	}

	public void add(int i) {
		list.add(i);
	}

	public boolean contains(int i) {
		if (list.contains(i)) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return list.toString();
	}

	// @Override
	// public int compare(Group arg0, Group arg1) {
	// return arg0.list.size() < arg1.list.size() ? -1 : arg0.list.size() ==
	// arg1.list.size() ? 0 : 1;
	// }

	@Override
	public int compareTo(Group arg0) {
		return list.size() < arg0.list.size() ? 1 : list.size() == arg0.list.size() ? 0 : -1;
	}

	public int size() {
		return list.size();
	}
}

class Groups {
	int groupsCount = 1;
	// List<Group> groups = new LinkedList<Group>();
//	Set<Group> groups = new HashSet<Group>();
	int[] list;

	public Groups(int n) {
		groupsCount =1;
		list = new int [n];
		for (int i = 0; i < list.length; i++) {
			list[i] = -1;
		}
	}

	public void add(int x, int y) {
		// if (groups.isEmpty()) {
		// Group a = new Group();
		// a.add(x);
		// a.add(y);
		// groups.add(a);
		// } else {
		int xg = -1;
		int yg = -1;
		boolean merge = false;
//		for (Group group : groups) {
			if (list[x]!=-1) {
				xg=list[x];
			}
			if (list[y]!=-1) {
				yg=list[y];
			}
			if (xg != -1 && yg != -1) {
				merge = true;
//				break;
			}
//		}
		if (merge) {
			if (xg!=yg) {
				merge(xg, yg);
			}
		} else {
			if (xg != -1) {
				list[y]=xg;
			} else if (yg != -1) {
				list[x]= yg;
			} else {
				list[x]=groupsCount;
				list[y]=groupsCount;
				groupsCount++;
//				Group a = new Group();
//				a.add(x);
//				a.add(y);
//				groups.add(a);
			}
		}
		// }
	}

	private void merge(int xg, int yg) {
		for(int i = 0; i<list.length;i++){
			if(list[i]==yg){
				list[i]= xg;
			}
		}
//		groups.remove(yg);
	}

	public void printAll() {
//		for (Group group : groups) {
//			System.out.println(group.toString());
//		}
	}

}

public class ValueOfFriendship {
	// public static final BigInteger ONE = BigInteger.ONE;
	// public static final BigInteger TWO = BigInteger.valueOf(2);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
//			int[] array0 = new int[m];
//			int[] array1 = new int[m];
//			Random r = new Random();
//			for (int i = 0; i < m; i++) {
//				array0[i] = r.nextInt(n-1);
//				array1[i] = r.nextInt(n-1);
//			}
			Groups groups = new Groups(n);
			for (int a1 = 0; a1 < m; a1++) {
				 int x = in.nextInt();
				 int y = in.nextInt();
//				int x = array0[a1];
//				int y = array1[a1];
				groups.add(x, y);
			}
			// groups.printAll();
			long count = 0;
			// BigInteger m = BigInteger.valueOf(m0);
			ArrayList<BigInteger> partialSums = new ArrayList<BigInteger>();
			Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
			for(int i=0;i<groups.list.length;i++){
				if(map.containsKey(groups.list[i])){
					int a = map.get(groups.list[i]);
					a++;
					map.replace(groups.list[i], a);
				} else {
					map.put(groups.list[i], 1);
				}
			}
//			Collections.sort(groups.groups);
			long variabile = map.get(groups.list[0]);
			for (int i = 0; i < groups.list.length; i++) {
				long k = map.get(groups.list[i]);
				// BigInteger k = BigInteger.valueOf(ki);
				long res0;
				if (i == 0) {
					res0 = k * (k - 1) * (m - (k - 2));
				} else {
//					for (int i0 = 0; i0 <= i; i0++) {
						variabile += map.get(groups.list[i]);
//					}
					res0 = k * (k - 1) * (m - (variabile - (2 + i)));
				}
//				res0 += summPartials(k);
				res0 += k*(k-2);
				count += res0;
			}
			System.out.println(count);
			// for (BigInteger bigInteger : partialSums) {
			// System.out.print(bigInteger.toString()+" ");
			// }
			// System.out.print("\n");
		}
	}

//	private static long summPartials(long k) {
////		long res = 0;
////		for (int i = 1; i <= k - 2; i++) {
////			res += (k - i) * (k - (i + 1));
////		}
////		return res;
//	}

}
