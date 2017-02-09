package java8.datastructures.javapqueue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student {
	private int token;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getCgpa() < o2.getCgpa()) {
			return 1;
		} else if (o1.getCgpa() > o2.getCgpa()) {
			return -1;
		} else {
			if (!o1.getFname().equals(o2.getFname())) {
				return o1.getFname().compareTo(o2.getFname());
			} else {
				if (o1.getToken() < o2.getToken()) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}

}

public class JavaPQueue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StudentComparator comparator = new StudentComparator();
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		PriorityQueue<Student> q = new PriorityQueue<Student>(n, comparator);
		while (n > 0) {
			String event = in.next();
			if (event.equals("ENTER")) {
				String name = in.next();
				double cf = in.nextDouble();
				int id = in.nextInt();
				in.nextLine();
				Student s = new Student(id, name, cf);
				q.add(s);
			} else {
				q.poll();
			}

			n--;

		}

		if (q.isEmpty()) {
			System.out.println("EMPTY");
		} else {
//			for (Student s : q) {
//				System.out.println(s.getFname());
//			}
			while (!q.isEmpty()) {
				System.out.println(q.poll().getFname());
			}
		}
		in.close();
	}
}
