package dsa.vector.teste;

import java.util.ArrayList;

public class Class12 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("C");

        System.out.println(arrayList);

        arrayList.add(1,"B");

        System.out.println(arrayList);

        boolean exist = arrayList.contains("A");
        if(exist){
            System.out.println("Element is in the array");
        } else{
            System.out.println("No element in the array");
        }

        int pos = arrayList.indexOf("B");
        if(pos >-1){
            System.out.println("Element is in the position " + pos);
        } else{
            System.out.println("No element in the array " + pos);
        }
        System.out.println(arrayList.get(2));

        arrayList.removeFirst();
        arrayList.remove("B");

        System.out.println(arrayList);

        System.out.println(arrayList.size());
    }
}
