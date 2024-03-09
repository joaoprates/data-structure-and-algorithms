package dsa.vector;

public class Vector {

	private Object[] elements; 
	private int length;

	public Vector(int capacity){
		this.elements = new Object[capacity];
		this.length = 0;
	}
	
	public boolean add(Object element) {
		this.increaseCapacity();
		if (this.length < this.elements.length){
			this.elements[this.length] = element;
			this.length++;
			return true;
		} 
		return false;
	}

	public boolean add(int position, Object element){
		
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
			Object[] newElements = new Object[this.elements.length * 2];
            System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
			this.elements = newElements;
		}
	}
	
	public Object search(int position){
		if (!(position >= 0 && position < length)){
			throw new IllegalArgumentException("Invalid position");
		} 
		return this.elements[position];
	}
	
	public int search(Object element){
		for (int i=0; i<this.length; i++){
			if (this.elements[i].equals(element)){
				return i;
			}
		}
		return -1;
	}

	public void remove(Object element){
		int position = search(element); // Find the position of the element
		if (position != -1) {
			for (int i = position; i < this.length - 1; i++) {
				this.elements[i] = this.elements[i + 1];
			}
			this.length--;
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
	
}
