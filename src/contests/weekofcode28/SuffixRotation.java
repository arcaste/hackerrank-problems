package contests.weekofcode28;

import java.util.*;

public class SuffixRotation {
	public static long Gcount = Long.MAX_VALUE;
	public static char[] array;
	public static Map<Character, Integer> map;
	private static int recursion = 0;

	public static void rotateLeft(char[] arr, int start, int a) {
		if (arr == null || arr.length == 0 || a < 0) {
			throw new IllegalArgumentException("error!");
		}
		reverse(arr, start, start + a - 1);
		reverse(arr, start + a, arr.length - 1);
		reverse(arr, start, arr.length - 1);

	}

	public static void rotateRight(char[] arr, int start, int a) {
		if (arr == null || arr.length == 0 || a < 0) {
			throw new IllegalArgumentException("error!");
		}
		a = arr.length - a;

		reverse(arr, a, arr.length - 1);
		reverse(arr, start, a - 1);
		reverse(arr, start, arr.length - 1);

	}

	public static void reverse(char[] arr, int left, int right) {
		if (arr == null || arr.length == 1)
			return;

		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

	static void printArray(char arr[]) {
		int i;
		for (i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			Gcount = Long.MAX_VALUE;
			recursion = 1000;
			String s = in.next();
			array = s.toCharArray();
			Arrays.sort(array);
			map = new LinkedHashMap<Character, Integer>();
			for (int i = 0; i < array.length; i++) {
				int val = 1;
				if (map.containsKey(array[i])) {
					val = map.get(array[i]);
					val++;
					map.replace(array[i], val);
				} else {
					map.put(array[i], val);
				}
			}
			solveProblem(s.toCharArray(), 0, 0, 1, array[0], 0);
			System.out.println(String.valueOf(Gcount));
		}
	}

	private static void solveProblem(char[] s, int _i0, int _i1, int _i2, char s1, long _count) {
		long count = _count;
		for (int i0 = _i0; i0 < s.length; i0++) {
			char smallest = s[i0];
			if (!isSmallest(smallest, i0)) {
				int n = i0;
				for (int i1 = i0 + 1; i1 < s.length; i1++) {
					if (s[i1] < smallest) {
						smallest = s[i1];
						n = i1;
						if (isSmallest(s[i1], i0)) {
							if (s[i1] == s1) {
								if (_i2 == 1) {
									break;
								} else {
									_i2--;
								}
							} else {
								for (int i2 = 2; i2 <= ((int) map.get(s[i1])); i2++) {
									recursion++;
									if (recursion < 1000) {
										solveProblem(s, _i0, _i1, i2, s[i1], count);
									}
								}
								break;
							}
						}
					}
				}
				count++;
				if (count >= Gcount) {
					break;
				}
				int l = n - i0;
				int r = s.length - i0 - l;
				if (r < l) {
					rotateRight(s, i0, r);
				} else {
					rotateLeft(s, i0, l);
				}
			}
		}
		if (count < Gcount) {
			Gcount = count;
		}
	}

	private static boolean isSmallest(char smallest, int i0) {
		if (smallest == array[i0]) {
			return true;
		}
		return false;
	}
}
