package it.unical.igpe17.Intro_1;

import java.io.Console;
import java.util.Scanner;

public class HelloWorld {

	//input reader
	final Scanner s = new Scanner(System.in);

	//read from stdin
	public void fancyCalculator(){
		System.out.println("JAVA first calulator");
		while(true){
			//operands
			int l,r;
			System.out.println("Type the 1 operand");
			l=s.nextInt();
			System.out.println("Type the 2 operand");
			r=s.nextInt();
			//output the sum of the two number
			final int ans = l+r;
			System.out.print("-> ");
			System.out.println(ans);
		}

	}

	public static void main(String[] args) {
		HelloWorld calculator = new HelloWorld();
		calculator.fancyCalculator();
	}
}
