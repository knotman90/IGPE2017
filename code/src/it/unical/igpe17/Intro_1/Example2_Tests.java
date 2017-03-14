package it.unical.igpe17.Intro_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Example2_Tests {
	static final int SIZE = 10000; 
	@Test
	public void testBubbleSort(){
		int[] array = new int[SIZE];
		Example1.initArrayRandomly(array);
		Example2.mergesort(array);
		for(int i=0; i < array.length -1; i++){
			 assertTrue(array[i] <= array[i+1]); //(<=) is the invariant enforced by sorting
		}
	}
}
