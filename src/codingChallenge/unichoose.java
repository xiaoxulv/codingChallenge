package codingChallenge;

import java.util.Random;

public class unichoose {
	public static int[] Uni(int []n, int k){
		int []res = new int[k];
		boolean []flag = new boolean[n.length];
		Random r = new Random();
		int i = 0;
		while(i < k){
			int rand = r.nextInt(n.length);
			if(!flag[rand]){
				res[i] = n[rand];
				flag[rand] = true;
				i++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = {1,2,3,4,5,6,7,8,9,10};
		int a[] = Uni(n,5);
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}

}
