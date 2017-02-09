package contests.weekofcode28;
import java.util.*;

public class BoatTrips {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c = in.nextInt();
		int m = in.nextInt();
        int max = m*c;
        boolean set = false;
        int[] p = new int[n];
        for(int p_i=0; p_i < n; p_i++){
        	p[p_i] = in.nextInt();
            if(p[p_i]>max){
            	System.out.println("No");
            	set=true;
            	break;
            }
        }
        if(!set){
        	System.out.println("Yes");
        }
	}

}
