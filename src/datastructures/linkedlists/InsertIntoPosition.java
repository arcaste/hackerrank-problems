package datastructures.linkedlists;

import java.util.ArrayList;

public class InsertIntoPosition {

	public static Node InsertNth(Node head, int data, int position) {
		Node n = new Node();
		if (head == null) {
			n.data = data;
			n.next = null;
			return n;
		} else {
			if (position == 0) {
				n.data = data;
				n.next = head;
				return n;
			}
			Node curr = head;
			Node nex = head.next;
			for (int i = 0; i < position - 1; i++) {
				curr = nex;
				nex = curr.next;
			}
			n.data = data;
			n.next = nex;
			curr.next = n;
			return head;
		}
	}

	public static Node Delete(Node head, int position) {
		if (position == 0) {
			head = head.next;
			return head;
		}
		Node curr = head;
		Node nex = head.next;
		for (int i = 0; i < position - 1; i++) {
			curr = nex;
			nex = curr.next;
		}
		curr.next = nex.next;
		return head;
	}
	
	public static void ReversePrint(Node head){
		ArrayList<Integer> a = new ArrayList<Integer>();
		if(head == null){
			return;
		} else {
			while(head != null){
				a.add(head.data);
				head = head.next;
			}
			for(int i = a.size()-1; i >= 0; i--){
				System.out.println(a.get(i));
			}
			
		}
	}

	public static Node Reverse(Node head){
		if(head == null){
			return head;
		} else {
			Node prev = null;
			Node current = head;
			Node next = null;
			while(current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			return prev;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node();
		Node n1 = new Node();
		Node n2 = new Node();
		head.data = 1;
		n1.data = 2;
		n2.data = 3;
		head.next = n1;
		n1.next = n2;
		n2.next = null;
		head = Reverse(head);
		printiaml(head);

	}

	private static void printiaml(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

}
