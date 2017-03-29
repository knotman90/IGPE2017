package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class ListTests {

	public static Integer size=10000;
	Random r = new Random(System.currentTimeMillis());
	
	//@Test
	public void insertRandomLinkedList(){
		List<Integer> ll = new LinkedList<Integer>();
		ll.add(0);
		for (int i = 0; i < size; i++) {
			ll.add(	r.nextInt(ll.size()),i 	);
		}
	}

	@Test
	public void insertTailLinkedList(){
		List<Integer> ll = new ArrayList<Integer>();
		ll.add(0);
		for (int i = 0; i < size; i++) {
			ll.add(	r.nextInt(ll.size()),i 	);
		}
	}

	@Test
	public void insertRandomArrayList(){

	}

	@Test
	public void insertTailArrayList(){

	}



}
