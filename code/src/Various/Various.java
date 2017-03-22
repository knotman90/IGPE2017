package Various;

import java.math.BigInteger;

public class Various {



	public static void main(String[] args) {
		int n=2;
		long s = System.currentTimeMillis();
		
		for(int i=0;i<500000 ; i++)
			if(i==400000)
				System.out.println(n+"^"+i + "\t"+ ipow(n, i));
		long e = System.currentTimeMillis();

		System.out.println((double)(e-s)/1000.0);
	}
	//	public static int ipow(final int n, final int k){
	//		if(k==0)
	//			return 1;
	//		int ans =n;
	//		for(int i=1; i<k ; i++){
	//			ans*=n;
	//		}
	//		return ans;
	//	}

	//	public static long ipow(final int n, final int k){
	//		if(k==0)
	//			return 1;
	//		if(k==1)
	//			return n;
	//		if((k&1)==1)
	//			return ipow(n,k-1)*n;
	//		
	//		return ipow(n,k/2)*ipow(n,k/2);
	//		
	//	}

	//	public static long ipow(final long n, final long k){
	//		if(k==0)
	//			return 1;
	//		long ans =n;
	//		for(int i=1; i<k ; i++){
	//			ans*=n;
	//		}
	//		return ans;
	//	}

//	public static BigInteger ipow(final long n, final long k){
//		if(k==0)
//			return BigInteger.ONE;
//		BigInteger bin = BigInteger.valueOf(n);
//		BigInteger bians = bin;
//		for(int i=1; i<k ; i++){
//			bians=bians.multiply(bin);
//		}
//		return bians;
//	}

	public static BigInteger ipow(final int n, final int k){
		if(k==0)
			return BigInteger.ONE;
		if(k==1)
			return BigInteger.valueOf(n);
		if((k&1)==1)
			return ipow(n,k-1).multiply(BigInteger.valueOf(n));

		BigInteger res = ipow(n,k/2); 
		return (res).multiply(res);

	}


}
