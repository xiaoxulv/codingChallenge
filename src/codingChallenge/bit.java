package codingChallenge;

public class bit {
	// understanding is totally wrong! >o<	
//	public static int msb(int n) {
//		int temp = revBit(n);
//		return temp&1;
//	}
	public static int msb(int n) {
		int count = 0;
		while(n > 0){
			count++;
			n = n >>1; 
		}
		return count;
	}
	// mistake here! >o<	
//	public static int revBit(int n){
//		int res = 0;
//		int a = 0;
//		while(n > 0){
//		  a = n&1;
//		  res = res<<1;
//		  res = res|a;
//		  n = n>>1;
//		}
//		return res;
//	}
	public static int revBit(int n){
		int res = 0;
		for(int i = 0; i < 32; i++){
			int t = n&1;
			res =  res<<1;
			res |= t;
			n >>= 1;
		}
		return res;
	}
	// this is linear of input complexity,
	// O(logn)
	public static int setBit(int num) {
		int count = 0;
		while (num > 0) {
			count += num & 1;
			num = num >> 1;
		}
		return count;
	}
	// this is better than the previous one, 
	// only jump through set bits(aka 1), 
	// O(logk), k<n
	public static int setbit(int num) {
		int count = 0;
		while (num > 0) {
			num &= num - 1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(setBit(9));
		System.out.println(setbit(9));
		System.out.println(revBit(1));
		
		System.out.println(msb(1));
	}

}
