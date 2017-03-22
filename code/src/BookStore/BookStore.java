package BookStore;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;

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

	
	
	
	public void addBook(Book b){
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
}
