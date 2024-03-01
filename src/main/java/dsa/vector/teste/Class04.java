package dsa.vector.teste;

import dsa.vector.Vector;

public class Class04 {

	public static void main(String[] args) {
		
		Vector vector = new Vector(10);

		vector.add("element 1");
		vector.add("element 2");
		vector.add("element 3");

		System.out.println(vector.length());
		
		System.out.println(vector.toString());
	}

}
