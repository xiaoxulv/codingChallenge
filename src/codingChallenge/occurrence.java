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
				right = mid - 1;
			if(a[mid] <= target)
				left = mid + 1;
			if(a[right] == target)
				return right;
		}
		return -1;
	}
	// in a same function, using a boolean to distinguish
	public static int bs(int []n, int target, boolean searchFirst){
		int len = n.length;
		int left = 0, right = len - 1;
		int res = -1;
		while(left <= right){
			int mid = left + (right - left)/2;
			if(n[mid] == target){
				res = mid;
				if(searchFirst)
					right = mid -1;
				else 
					left = mid + 1;
			}
			if(n[mid] > target)
				right = mid - 1;
			if(n[mid] < target)
				left = mid + 1;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={1,2,3,3,3,3,4,4,4,5};
		System.out.println(occur(a,3));
		
		int first = bs(a, 3, true);
		int last = bs(a, 3, false);
		System.out.println(last-first+1);
	}

}
