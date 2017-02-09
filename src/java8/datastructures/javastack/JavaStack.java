package java8.datastructures.javastack;

import java.util.*;

public class JavaStack {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> s = new Stack<Character>();
		while (sc.hasNext()) {
			s = new Stack<Character>();
			String input = sc.next();
//			System.out.println(input);
			char[] array = input.toCharArray();
			for(int i = 0; i<array.length;i++){
				if(s.empty()){
					s.push(array[i]);
				}else{
					if(array[i] == ')' && s.peek() == '('){
						s.pop();
					} else if (array[i] == '}' && s.peek() == '{') {
						s.pop();
					} else if (array[i] == ']' && s.peek() == '[') {
						s.pop();
					} else if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
						s.push(array[i]);
					} else {
						break;
					}
				}
			}
			if(s.empty()){				
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}

	}
}
