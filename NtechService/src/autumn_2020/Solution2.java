package autumn_2020;

public class Solution2 {

	public static int solution(int N) {
        if(N < 3) return N;
        int[] dp = new int[N+1];
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        for(int i=3; i<N+1; i++) {
        	dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[N];
    }
	
	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
	}
}
