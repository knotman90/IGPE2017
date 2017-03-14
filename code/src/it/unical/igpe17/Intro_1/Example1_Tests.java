package it.unical.igpe17.Intro_1;

import static org.junit.Assert.*;

import org.junit.Test;


public class Example1_Tests {

	static final int SIZE = 10000; 
	@Test
	public void testBubbleSort(){
		int[] array = new int[SIZE];
		Example1.initArrayRandomly(array);
		Example1.bubbleSort(array);
		for(int i=0; i < array.length -1; i++){
			 assertTrue(array[i] <= array[i+1]); //(<=) is the invariant enforced by sorting
		}
	}
	
	
}
