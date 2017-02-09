package java8.introduction.output;

import java.util.Scanner;

public class OutputFormatting {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================");
		for (int i = 0; i < 3; i++) {
			String s1 = sc.next();
			char[] a1 = s1.toCharArray();
			int i1 = sc.nextInt();
			char[] a2 = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
			if (a1.length > 10) {
				throw new Exception("Input string too long");
			}
			System.arraycopy(a1, 0, a2, 0, a1.length);
			System.out.print(a2);
			if(i1 < 10){
				System.out.print("00"+i1);
			}else if(i1<100){
				System.out.print("0"+i1);				
			} else {				
				System.out.print(i1);
			}
			System.out.print("\n");

		}
		System.out.println("================================");
		sc.close();

	}
}
