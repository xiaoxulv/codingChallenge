package codingChallenge;

public class bit {
	public static int msb(int n) {
		int temp = revBit(n);
		return temp&1;
	}

	public static int revBit(int n){
		int res = 0;
		int a = 0;
		while(n > 0){
		  a = n&1;
		  res = res<<1;
		  res = res|a;
		  n = n>>1;
		}
		return res;
	}

	public static int setBit(int num) {
		int count = 0;
		while (num > 0) {
			count += num & 1;
			num = num >> 1;
		}
		return count;
	}

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
		System.out.println(revBit(10));
		System.out.println(msb(50));
	}

}
