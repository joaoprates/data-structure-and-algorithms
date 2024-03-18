package dsa.vector.teste;

import dsa.vector.Vector;

public class Class10 {
    public static void main(String[] args) {

        Vector vector = new Vector(10);

        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();

        Contact c4 = new Contact();

        vector.add(c1);
        vector.add(c2);
        vector.add(c3);

        int elementPosition = vector.search(c4);
        if (elementPosition > -1){
            System.out.println("This element is in the vector");
        } else {
            System.out.println("This element is not in the vector");
        }
    }
}
