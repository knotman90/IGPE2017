package it.unical.igpe17.Intro_1;

public class Example2 {

	public static void mergesort(int[] numbers){
		_mergesort(numbers,0,numbers.length-1);
	}

	private static int distance(final int s, final int e){
		return e-s+1;
	}

	
	/**
	 * Why not the plain old (s+e)/2?
	 * @param s
	 * @param e
	 * @return 
	 */
	private static int midpoint(final int s, final int e){
		
		return s+(e-s)/2;
		
	}

	private static void _mergesort(int[] numbers, final int s, final int e) {
		if(distance(s,e)<=1)
			return;
		int mid=midpoint(s,e);
		_mergesort(numbers,s,mid);
		_mergesort(numbers,mid+1,e);
		merge(numbers,s,mid,e);
	}


	private static  void merge(int[] numbers, final int s, final int mid, final int e){
		int[] sorted = new int[distance(s,e)];
		int i=s; int j=mid+1;
		int ins=0;
		while(i<=mid && j<=e)
			if(numbers[i] < numbers[j])
				sorted[ins++]=numbers[i++];
			else
				sorted[ins++]=numbers[j++];
		
		while(i<=mid)
			sorted[ins++]=numbers[i++];
		
		while(j<=e)
			sorted[ins++]=numbers[j++];
		
		for(int k=0;k<ins;k++)
			numbers[s+k] = sorted[k];
		
	}
}
