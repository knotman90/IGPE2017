package BookStore;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import Various.RandomString;

public class MainBookStore {

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random(System.currentTimeMillis());
		System.out.println("How many books?");
		int cap = s.nextInt();
		BookStore bs = new BookStore(cap);
		
		for (int i = 0; i < cap; i++) {
			Book b = new Book();
			b.setNpages(r.nextInt(1000));
			
			b.setYear(new Date(System.currentTimeMillis() - r.nextInt(1000000)));
			b.setISBN(RandomString.randomAlphanumericString(13));
			b.setAuthor(RandomString.randomAlphanumericString(50));
			bs.addBook(b);
		}
		
		
		System.out.println(bs.toString());
		System.out.println();
		bs.sort();
		System.out.println(bs.toString());
		System.out.println();
	}
}
