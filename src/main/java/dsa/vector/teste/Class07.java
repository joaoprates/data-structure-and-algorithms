package dsa.vector.teste;

import dsa.vector.Vector;

public class Class07 {
    public static void main(String[] args) {

        Vector vector = new Vector(10);

        vector.add("b");
        vector.add("c");
        vector.add("d");

        System.out.println(vector);

        vector.add(1, "a");

        System.out.println(vector);
    }
}
