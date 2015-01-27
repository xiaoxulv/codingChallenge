package codingChallenge;

public class occurrence {
	public static int occur(int []a, int target){
		int f = bsFirst(a, target, 0, a.length-1);
		if(f == -1)
			return -1;
		int l = bsLast(a, target, 0, a.length-1);
		return l-f+1;
	}
	public static int bsFirst(int []a, int target, int left, int right){
		while(left <= right){
			int mid = left + (right - left)/2;
			if(a[mid] < target)
				left = mid + 1;
			if(a[mid] >= target)
				right = mid - 1;
			if(a[left] == target)
				return left;	
		}
		return -1;
	}
	public static int bsLast(int []a, int target, int left, int right){
		while(left <= right){
			int mid = left + (right - left)/2;
			if(a[mid] > target)
				mid = mid - 1;
			if(a[mid] <= target)
				left = mid + 1;
			if(a[right] == target)
				return right;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={3,3,3,3,3};
		System.out.println(occur(a,3));
	}

}
