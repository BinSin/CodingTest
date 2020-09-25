package autumn_2020;

public class Solution2 {

	public static int solution(int []A, int S) {
		int answer = 0;
		int len = A.length;
		int sum = 0, s = 0, e = 0;
		while(s <= e && e < len) {
			if(sum < S) {
			 	sum += A[e++];
			} else {
				sum -= A[s++];
			}
			if(sum == S) answer++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,1,1,1}, 3));
		System.out.println(solution(new int[] {1,1,1,1}, 1));
		System.out.println(solution(new int[] {1,3,5,7}, 0));
	}
}
