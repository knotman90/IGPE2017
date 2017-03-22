package Sorting;



public class BubbleSorter {


	public static void sort(IComparable[] elements){
		boolean go = true;
		while(go){
			go=false;
			for(int i=0 ; i< elements.length-1; i++){
				if((elements[i].compare(elements[i+1])))
				{
					IComparable t=elements[i];
					elements[i]=elements[i+1];
					elements[i+1]=t;
					go=true;
				}
			}
		}
	}

}
