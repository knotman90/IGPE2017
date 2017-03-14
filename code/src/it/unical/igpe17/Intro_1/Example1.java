package it.unical.igpe17.Intro_1;

import java.util.Arrays;
import java.util.Random;



public class Example1{
	
	
	public static void initArrayRandomly(int[] array){
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < array.length; i++) 
			array[i] = r.nextInt(array.length*10);
	}
	
	public static void example1(){
		final int N = 100000;
		int[] array = new int[N];
		initArrayRandomly(array);
		//System.out.println(Arrays.toString(array));
		bubbleSort(array);
		//System.out.println(Arrays.toString(array));


	}
	public static  void bubbleSort(int[] numbers){
		boolean go = true;
		while(go){
			go=false;
			for(int i=0 ; i< numbers.length-1; i++){
				if(numbers[i] > numbers[i+1])
				{
					int t=numbers[i];
					numbers[i]=numbers[i+1];
					numbers[i+1]=t;
					go=true;
				}
			}
		}
	}
	
	

	public static void main(String[] args) {
		Example1.example1();
	}

}
