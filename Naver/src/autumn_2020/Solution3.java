package autumn_2020;

public class Solution3 {

	public static long solution(int k) {
		long answer = 0;
		long[][] dp = new long[26][10];
		if(k < 2) return 0;
		dp[1] = new long[] {6,2,5,5,4,5,6,3,7,6};
		for(int i=0; i<=k; i++) {
			for(int j=0; j<=k; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] += 6;
				}
				if(i == 1 || j == 1) {
					dp[i][j] += 2;
				}
				if(i == 2 || j == 2) {
					dp[i][j] += 5;
				}
				if(i == 3 || j == 3) {
					dp[i][j] += 5;
				}
				if(i == 4 || j == 4) {
					dp[i][j] += 4;
				}
				if(i == 5 || j == 5) {
					dp[i][j] += 5;
				}
				if(i == 6 || j == 6) {
					dp[i][j] += 6;
				}
				if(i == 7 || j == 7) {
					dp[i][j] += 3;
				}
				if(i == 8 || j == 8) {
					dp[i][j] += 7;
				}
				if(i == 9 || j == 9) {
					dp[i][j] += 6;
				}
			}
		}
		for(int i=1; i<=k; i++) {
			for(int j=1; j<=k; j++) {
				if(i+j == k) answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(11));
		System.out.println(solution(1));
	}
}
