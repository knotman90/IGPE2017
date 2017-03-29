package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HelloCollections {



	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		List<Double> ll = new LinkedList<>();
		for(int i=0;i<20;i++){
			Double di = (double)i*0.5;
			al.add(i);
			ll.add(di*di*Math.exp( -Math.sin(20*di) ) );
		}

		System.out.println(al.toString());
		System.out.println(ll.toString());

		//min and max
		System.out.println("MAX=:"+Collections.max(ll));
		System.out.println("MIN=:"+Collections.min(ll));
		Collections.sort(ll);

		System.out.print("SORTED:");
		System.out.println(ll);

		//sublist and disjoint
		System.out.println(Collections.disjoint(ll, al));
		List<Double> llsub = ll.subList(0, ll.size()/2);

		//reverse
		Collections.reverse(llsub);
		System.out.println(Collections.disjoint(ll, llsub));

		//shuffle and sort
		Collections.shuffle(al);
		System.out.println(Collections.binarySearch(al, 10));
		Collections.sort(al);
		System.out.println(Collections.binarySearch(al, 10));


System.out.println("Rotation");
		for(int i=0;i<20;i++){
			Collections.rotate(al,i );
			System.out.println(al);
		}

	}

}
