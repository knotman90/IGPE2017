package Sorting;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Random;

import it.unical.igpe17.Intro_1.Example1;
import it.unical.igpe17.Intro_1.Example2;

import org.junit.Test;

import Various.RandomString;

public class BubbleSorterTest {



	@Test
	public void testBubbleSort(){

		Random r = new Random(System.currentTimeMillis());
		IComparable[] persons = new Person[100];
		for (int i = 0; i < persons.length; i++) {
			int l = 1+r.nextInt(20);
			persons[i] = new Person(); 
			((Person)persons[i]).setAge( 1+ r.nextInt(100));
			
			((Person)persons[i]).setName(RandomString.randomAlphanumericString(l));
		}
		
		for (int i = 0; i < persons.length; i++) {
			System.out.print(persons[i].toString() + " ");
			
		}
		System.out.println();
		
		BubbleSorter.sort(persons);
		

		for (int i = 0; i < persons.length; i++) {
			System.out.print(persons[i].toString()+ " ");
		}
		System.out.println();




	}

	public static void main(String[] args) {
		BubbleSorterTest bst = new BubbleSorterTest();
		bst.testBubbleSort();

	}

}
