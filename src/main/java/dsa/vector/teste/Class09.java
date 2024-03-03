package dsa.vector.teste;

import dsa.vector.Vector;

public class Class09 {
    public static void main(String[] args) {

        Vector vector = new Vector(10);

        vector.add("a");
        vector.add("b");
        vector.add("c");
        vector.add("d");
        vector.add("f");


        System.out.println(vector);

        vector.remove(vector.search("b"));

        System.out.println(vector);
    }
}
