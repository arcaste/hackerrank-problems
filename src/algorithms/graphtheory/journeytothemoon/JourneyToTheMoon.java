package algorithms.graphtheory.journeytothemoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class JourneyToTheMoon {

		int E;
		int V;
		LinkedList<Integer>[] adj;
		int[] edgeTo;
		boolean[] marked;
		int s;

		int[] cc;
		int count;

		public JourneyToTheMoon(int V) {
			this.V = V;
			adj = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<Integer>();
			}
			edgeTo = new int[V];
			marked = new boolean[V];
			cc = new int[V];
		}

		public void dfs(int v) {
			marked[v] = true;
			count++;

			for (Integer w : adj[v]) {
				if (!marked[w]) {
					dfs(w);
				}
			}
		}

		public void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}

		public static void main(String[] args) throws Exception {
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			String[] temp = bfr.readLine().split(" ");
			int N = Integer.parseInt(temp[0]);
			int I = Integer.parseInt(temp[1]);
			JourneyToTheMoon sObj = new JourneyToTheMoon(N);

			for (int i = 0; i < I; i++) {
				temp = bfr.readLine().split(" ");
				int a = Integer.parseInt(temp[0]);
				int b = Integer.parseInt(temp[1]);
				sObj.addEdge(a, b);
			}
			System.out.println(sObj.adj[1]);
			for (int i = 0; i < sObj.V; i++) {
				sObj.count = 0;
				if (!sObj.marked[i]) {
					sObj.dfs(i);
					sObj.cc[i] = sObj.count;
				}
			}

			long combinations = 0;

			for (int i = 0; i < sObj.V; i++) {
				for (int i1 = 0; i1 < sObj.V && i != i1; i1++)
					combinations += sObj.cc[i] * sObj.cc[i1];
			}

			System.out.println(combinations);

		}
}
