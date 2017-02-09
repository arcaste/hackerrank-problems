package contests.weekofcode28;

import java.util.*;

public class LuckyNumber {
	static long count = 0;
	static int value;
	
	public static void powerset(char[] list) {
		  List<List<String>> ps = new ArrayList<List<String>>();
		  ps.add(new ArrayList<String>());
		  for (char item : list) {
		    List<List<String>> newPs = new ArrayList<List<String>>();
		 
		    for (List<String> subset : ps) {
		      newPs.add(subset);
		      List<String> newSubset = new ArrayList<String>(subset);
		      newSubset.add(String.valueOf(item));
		      if(newSubset.size()>0){
		    	  int in = newSubset.size();
		    	  if(in>=3){				
						value = Integer.valueOf(newSubset.get(in-3)+newSubset.get(in-2)+newSubset.get(in-1));
					} else if(in>1){			
						value = Integer.valueOf(newSubset.get(in-2)+newSubset.get(in-1));
					} else {							
						value = Integer.valueOf(newSubset.get(in-1));
					}
					if (value % 8 == 0) {
						count++;
					}
		      }
		      newPs.add(newSubset);
		    }
		    ps = newPs;
		  }
		}
	
	public static void main(String[] args) {
		 count = 0;
		 Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			String st = in.next();
        powerset(st.toCharArray());
		 System.out.println(count);
	}
}
