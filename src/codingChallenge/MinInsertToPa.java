package codingChallenge;

public class MinInsertToPa {
	public static int MinInsert(String s){
		int len = s.length();
		int[][] dp = new int[len][len];
		for(int i = 0; i < len; i++)
			dp[i] = new int[len];
		
		for(int i = 1; i < len; i++){
			for(int l = 0, r = i; r < len; l++, r++){
				if(s.charAt(l) == s.charAt(r))
					dp[l][r] = dp[l+1][r-1];
				else
					dp[l][r] = 1 + Math.min(dp[l][r-1], dp[l+1][r]);
			}
		}
		return dp[0][len-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MinInsert("abcb"));
	}

}
