package codingChallenge;

import java.math.BigInteger;
import java.util.Arrays;

public class FairWarning {

//	public static BigInteger gcd(BigInteger a, BigInteger b){
//		while(a.compareTo(b) != 0){
//			if(a.compareTo(b) == 1 || a.compareTo(b) == 0)
//				a = a.subtract(b);
//			else
//				b = b.subtract(a);
//		}
//		return a;
//	}
	public static BigInteger gcd(BigInteger[] a, int count){
		BigInteger res = a[0];
		for(int i = 0; i < count; i++){
			res = a[i].gcd(res);
			//System.out.println("~~~");
		}
		//System.out.println("gcd " + res);
		return res;
	}

	public static BigInteger warn(BigInteger[] num){
		Arrays.sort(num);
		BigInteger[] delta = new BigInteger[10000];
		int index = 0;
		for(int i = 0; i < num.length-1; i++){
			for(int j = i+1; j < num.length; j++){
				delta[index] = num[j].subtract(num[i]);
				index++;
			}
		}
		//System.out.println("index " + index);
		BigInteger t = gcd(delta, index);
	
		int count = 0;
		BigInteger tmp = num[0];
		while(tmp.compareTo(BigInteger.ZERO) == 1){
			tmp = tmp.subtract(t);
			count++;
		}
		//System.out.println(count);
		BigInteger c = BigInteger.valueOf(Integer.valueOf(count));
		return c.multiply(t).subtract(num[0]);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long a = 800000000000000000001l;
		//System.out.prBigIntegerln(Long.MAX_VALUE);
//		BigInteger b1 = new BigInteger("800000000000000000001");
//		System.out.println(b1);
		
		BigInteger[] n =  new BigInteger[3];
		n[0]= new BigInteger("260000");
		n[1]= new BigInteger("110000");
		n[2]= new BigInteger("60000");
		//System.out.println(n[0].subtract(n[1]));
		//System.out.println(gcd(n[0],n[1]));
		System.out.println(warn(n));
		
		BigInteger[] m =  new BigInteger[2];
		m[0]= new BigInteger("800000000000000000001");
		m[1]= new BigInteger("900000000000000000001");
		//System.out.println(gcd(m[0],m[1]));
		System.out.println(warn(m));
	}

}
