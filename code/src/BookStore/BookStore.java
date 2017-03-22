package BookStore;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;

import Sorting.BubbleSorter;

public class BookStore {

	private Book[] library;

	/*number of book inserted*/
	private int size;
	/* Maximum capacity of the bookstore*/
	private int capacity;

	public BookStore(int _capacity) {
		capacity = _capacity;
		assert(capacity>0);

		library= new Book[capacity];
		size=0;
	}

	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "BookStore [library=" + Arrays.toString(library) + ", size="
				+ size + ", capacity=" + capacity +" elements= " ;
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		for (int i = 0; i < library.length; i++) {
			sb.append(library[i].toString() + " ");
			
		}
		return sb.toString();
	}




	public void addBook(Book b){
		if(size >= capacity)
			throw new IllegalArgumentException("Exceeded capacity");
		library[size] = b;
		size++;

		//short version
		//library[size++] = b;
	}

	public void removeBook(Book b){

	}

	public void removeBook(int b){

	}

	public void searchForBook(Book b){

	}
	
	public void sort(){
		BubbleSorter.sort(library);
	}
}
