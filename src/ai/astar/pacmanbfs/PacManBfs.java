package ai.astar.pacmanbfs;


import java.util.*;

public class PacManBfs {
	static class Node {
		int x;
		int y;
		char val;
		Node parent;
		public Node(int y, int x, char val, Node parent) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
			this.parent = parent;
		}

		public boolean equals(Node n0) {
			if (this.x == n0.x && this.y == n0.y && this.val == n0.val) {
				return true;
			} else {
				return false;
			}
		}
		public String toString(){
			return "X "+x+" Y: "+y+" V: "+val;
		}
	}

	Queue<Node> q = new LinkedList<Node>();
	ArrayList<String> p1 = new ArrayList<String>();
	LinkedList<String> p2 = new LinkedList<String>();
	int px;
	int py;
	int fx;
	int fy;
	int R;
	int C;
	char[][] m;
	boolean[][] v;
	Node finalNode;

	public void solve() {
		q.add(new Node(py, px, m[py][px],null));
		v[py][px] = true;
		while (!q.isEmpty()) {
			Node top = q.poll();
			p1.add(top.y +" "+top.x);
			if (top.val == '.') {
				finalNode = top;
				break;
			} else {
				expandNG(top);
			}
		}
	}
	public void print(){
		System.out.println(p1.size());
		for (String s : p1) {
			System.out.println(s);
		}
		Node node = finalNode;
		int count = 0;
		while(node != null){
			p2.addFirst((node.y+ " "+node.x));
			node = node.parent;
			if(node!=null)
				count++;
		}
		System.out.println(count);
		for (String s : p2) {
			System.out.println(s);
		}
	}
	
	private void expandNG(Node pos) {
		if (pos.y > 0) {
			if (m[pos.y - 1][pos.x] != '%' && !v[pos.y - 1][pos.x]) {
				q.add(new Node(pos.y - 1, pos.x, m[pos.y - 1][pos.x],pos));
				v[pos.y - 1][pos.x] = true;
			}
		}
		if (pos.x > 0) {
			if (m[pos.y][pos.x - 1] != '%' && !v[pos.y][pos.x - 1]) {
				q.add(new Node(pos.y, pos.x - 1, m[pos.y][pos.x - 1],pos));
				v[pos.y][pos.x - 1] = true;
			}
		}
		if (pos.x < (C - 1)) {
			if (m[pos.y][pos.x + 1] != '%' && !v[pos.y][pos.x + 1]) {
				q.add(new Node(pos.y, pos.x + 1, m[pos.y][pos.x + 1],pos));
				v[pos.y][pos.x + 1] = true;
			}
		}
		if (pos.y < (R - 1)) {
			if (m[pos.y + 1][pos.x] != '%' && !v[pos.y + 1][pos.x]) {
				q.add(new Node(pos.y + 1, pos.x, m[pos.y + 1][pos.x],pos));
				v[pos.y + 1][pos.x] = true;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PacManBfs pac = new PacManBfs();
		pac.py = sc.nextInt();
		pac.px = sc.nextInt();
		pac.fy = sc.nextInt();
		pac.fx = sc.nextInt();
		pac.R = sc.nextInt();
		pac.C = sc.nextInt();
		pac.m = new char[pac.R][pac.C];
		pac.v = new boolean[pac.R][pac.C];
		for (int i0 = 0; i0 < pac.R; i0++) {
			String line = sc.next();
			char[] array = line.toCharArray();
			for (int i1 = 0; i1 < pac.C; i1++) {
				pac.m[i0][i1] = array[i1];
				pac.v[i0][i1] = false;
			}
		}
		sc.close();
		pac.solve();
		pac.print();
	}

}

