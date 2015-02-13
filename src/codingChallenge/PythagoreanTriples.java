package codingChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PythagoreanTriples {
	// O(n) in space not best here
	// compare to two sum problem
	public static List<List<Integer>> findPyTri(int num[]){
		List<Integer> in = new ArrayList<Integer>();
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		int[] temp = new int [num.length];
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for(int i = 0; i < num.length; i++){
			temp[i] = num[i]*num[i];
			m.put(temp[i], i);
		}
		for(int i = 0; i < num.length; i++)
			for(int j = i+1; j < num.length; j++)
				if(m.containsKey(temp[i]+temp[j])){
					in.add(num[i]);
					in.add(num[j]);
					in.add(num[m.get(temp[i] + temp[j])]);
					out.add(new ArrayList<Integer>(in));
					in.clear();
				}
		
		return out;
	}
	public static int[] find1000(){
		int max = 1000;
		int []res = new int[3];
		for(int i = 3; i < max; i++)
			for(int j = i+1; j < max-i; j++){
				int k = max-i-j;
				if(i*i + j*j == k*k){
					res[0] = i;
					res[1] = j;
					res[2] = k;
				}
			}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n[] = {3,4,8,5,12,13,7,10,6,24,25};
		System.out.println(findPyTri(n));
		int res[] = find1000();
		System.out.println(res[0]);
		System.out.println(res[1]);
		System.out.println(res[2]);
	}

}
