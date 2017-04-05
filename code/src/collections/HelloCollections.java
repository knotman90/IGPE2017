package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import Various.RandomString;

public class HelloCollections {


public static List<Integer> replicate (List<Integer> l, int a, int b){
	while(b-- >=0){
		l.add(a);
	}
	return l;
}
	public static void testStreams(){
		List<Integer> al = new ArrayList<>();

		for(int i=0;i<20;i++)
			al.add(i);

//		Long ng5 = al.stream()
//				.filter(element -> element>=5)
//				.collect(Collectors.counting());

		al= al.stream()
				.filter(element -> element>=5)
				.map(element -> element*7)
				.map(e -> e> 70 ? e%70 : e )
				.collect(Collectors.toList());

		
		System.out.println(al);
		Queue<Integer> queue = new PriorityQueue(al);
		al.clear();
		  while (!queue.isEmpty())
		      al.add(queue.remove());

		  System.out.println(al);
		    
		
		
		Integer sumal = al.stream()
		.reduce(0, (a,b)->a+b);
		
		
		System.out.println(sumal);
		System.out.println(al);

	}
	
	
	public static void main(String[] args) {
		IntStream.range(1, 100)
	    .filter(s -> {
	    	if(s>5){
	        System.out.println(s+ " is good");
	        return true;
	    	}
	    	else
	    		System.out.println(s+ " isn't good");
	        return false;
	    })
	    .map(e -> {return e*e;})
	    .anyMatch(e -> {
	    	System.out.println("match"+e);
	    	return e>36;
	    });
	}
	public static void test1() {
		IntStream.range(1, 10)
	    .filter(s -> {
	    	if(s>5){
	        System.out.println(s+ " is good");
	        return true;
	    	}
	    	else
	    		System.out.println(s+ " isn't good");
	        return false;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
	}
	public static void testLists() {
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

		Collection<Integer> collection = new TreeSet<Integer>();
		//do work on the collection
		for (Integer collection_element: collection) {
			System.out.println(collection_element);
		}

		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			if(integer > 5)
				iterator.remove();

		}

	}

	public static void printDuplicates(){
		List<String> args = new ArrayList<String>();


		for(int i=0;i<1000;i++)
			args.add(RandomString.randomAlphanumericString(3));
		Set<String> s  = new TreeSet<>();
		for (int i = 0; i < args.size(); i++) {
			if(!s.add(args.get(i)))
				System.out.println(args.get(i)+" = duplicata");
		}
		System.out.println("DISTINTE: "+ s.toString());

		//sort and search for duplicate words
	}


}
