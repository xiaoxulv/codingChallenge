package codingChallenge;

public class countInversions {
	public static int mergesort(int[] n){
		int[] tmp = new int[n.length];
		return msort(n, tmp, 0, n.length-1);
	}
	public static int msort(int []n, int[] tmp, int left, int right){
		int res = 0;
		int mid = 0;
		if(left < right){
			mid = left + (right-left)/2;
			res = msort(n, tmp, left, mid);
			res += msort(n, tmp, mid+1, right);
			res += merge(n, tmp, left, mid+1, right);
		}
		return res;
	}
	public static int merge(int[] n, int[] tmp, int left, int mid, int right){
		int res = 0;
		int i = left, j = mid, k = left;
		while(i <= mid - 1 && j <= right){
			if(n[i] <= n[j])
				tmp[k++] = n[i++];
			else{
				tmp[k++] = n[j++];
				res += mid-i;
			}
		}
		while(i <= mid-1)
			tmp[k++] = n[i++];
		while(j <= right)
			tmp[k++] = n[j++];
		for(i = left; i <= right; i++)
			n[i] = tmp[i];
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 6, 4, 5, 3};
		System.out.println(mergesort(arr));
	}

}
