package dsa.vector;

import java.lang.reflect.Array;

public class List<T> {

    private T[] elements;
    private int length;

    public List(int capacity){
        this.elements = (T[]) new Object[capacity]; //Effective Java Solution
        this.length = 0;
    }

//    public List(int capacity, Class<T> tipoClasse){
//        this.elements = (T[]) Array.newInstance(tipoClasse, capacity);
//        this.length = 0;
//    }

    public boolean add(T element) {
        this.increaseCapacity();
        if (this.length < this.elements.length){
            this.elements[this.length] = element;
            this.length++;
            return true;
        }
        return false;
    }

    public boolean add(int position, T element){

        if (!(position >= 0 && position < length)){
            throw new IllegalArgumentException("Invalid position");
        }

        this.increaseCapacity();

        //move all the elements
        for (int i=this.length-1; i>=position; i--){
            this.elements[i+1] = this.elements[i];
        }
        this.elements[position] = element;
        this.length++;

        return true;
    }

    private void increaseCapacity(){
        if (this.length == this.elements.length){
            T[] newElements = (T[]) new Object[this.elements.length * 2];
            System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
            this.elements = newElements;
        }
    }
    public T get(int position){
        return this.search(position);
    }

    public T search(int position){
        if (!(position >= 0 && position < length)){
            throw new IllegalArgumentException("Invalid position");
        }
        return this.elements[position];
    }

    public int search(T element){
        for (int i=0; i<this.length; i++){
            if (this.elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndex(T element){

        for (int i=this.length-1; i>=0; i--){
            if (this.elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public void remove(int position){
        if (!(position >= 0 && position < length)){
            throw new IllegalArgumentException("Invalid position");
        }
        for (int i=position; i<this.length-1; i++){
            this.elements[i] = this.elements[i+1];
        }
        this.length--;
    }

    public void remove(T element){
        int pos = this.search(element);
        if (pos > -1){
            this.remove(pos);
        }
    }

    public int length(){
        return this.length;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i=0; i<this.length-1; i++){
            s.append(this.elements[i]);
            s.append(", ");
        }

        if (this.length>0){
            s.append(this.elements[this.length-1]);
        }

        s.append("]");

        return s.toString();
    }

    public void clear(){
        //option 1
        this.elements = (T[]) new Object[this.elements.length];

        //option 2
       // this.length = 0;

        //option 3
      //  for (int i=0; i<this.length; i++){
       //     this.length[i] = null;
       // }
        //this.length = 0;
    }

    public boolean contains(T element){

		/*int pos = search(element);
		if (pos > -1){
			return true;
		}

		return false;*/

        return search(element) > -1; //>=0
    }


}
