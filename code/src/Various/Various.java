package Various;

import java.math.BigInteger;

public class Various {


	public static void ipowTest(){
		System.out.println("IPOW: \n");
		int n=2;
		long s = System.currentTimeMillis();
		
		for(int i=0;i<100 ; i++)
			System.out.println(n+"^" + i +"\t"+ ipow(n,i));

		
		long e = System.currentTimeMillis();
		System.out.println((double)(e-s)/1000.0);

	}

	public static void lpowTest(){
		System.out.println("IPOW: \n");
		int n=2;
		long s = System.currentTimeMillis();
		
		for(int i=0;i<100 ; i++)
			System.out.println(n+"^" + i +"\t"+ lpow(n,i));

		
		long e = System.currentTimeMillis();
		System.out.println((double)(e-s)/1000.0);

	}
	
	public static void bipowRTest(){
		System.out.println("BIPOWR: \n");
		int n=2;
		long s = System.currentTimeMillis();
		BigInteger ans = BigInteger.ZERO;
		for(int i=0;i<7000 ; i++)
			ans=ans.add(bipowR(n, i));

		System.out.println(n+"^" + "\t"+ ans);
		long e = System.currentTimeMillis();
		System.out.println((double)(e-s)/1000.0);

	}


	public static void bipowTest(){
		System.out.println("BIPOW: \n");
		int n=2;
		long s = System.currentTimeMillis();
		BigInteger ans = BigInteger.ZERO;
		for(int i=0;i<7000 ; i++){
			//System.out.println(i+" "+bipow(n, i));
			ans=ans.add(bipow(n, i));
		}

		System.out.println(n+"^" + "\t"+ ans);
		long e = System.currentTimeMillis();
		System.out.println((double)(e-s)/1000.0);

	}


	public static int ipow(final int n, final int k){
		if(k==0)
			return 1;
		int ans =n;
		for(int i=1; i<k ; i++){
			ans*=n;
		}
		return ans;
	}



	public static long lpow(final int n, int  k){

		if(k==0)
			return 1;
		long ans =n;
		for(int i=1; i<k ; i++){
			ans*=n;
		}
		return ans;
	}

	public static BigInteger bipow(final long n, final long k){
		if(k==0)
			return BigInteger.ONE;
		BigInteger bin = BigInteger.valueOf(n);
		BigInteger bians = bin;
		for(int i=1; i<k ; i++){
			bians=bians.multiply(bin);
		}
		return bians;
	}

	public static BigInteger bipowR(final int n, final int k){
		if(k==0)
			return BigInteger.ONE;
		if(k==1)
			return BigInteger.valueOf(n);
		if((k&1)==1)
			return bipowR(n,k-1).multiply(BigInteger.valueOf(n));

		BigInteger res = bipowR(n,k/2); 
		return (res).multiply(res);

	}

	
	/**
	 * MAIN
	 */
	public static void main(String[] args) {
		ipowTest();
		//lpowTest();
		//bipowTest();
		//bipowRTest();
	}
}
