package autumn_2020;

public class Solution4 {

	public static int solution(int[][] t1, int[][] t2) {
		int answer = -1;
		return answer;
	}
	 
	public static void main(String[] args) {
		int[][] t11 = {{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int[][] t12 = {{1,2},{-1,-1},{-1,-1}};
		
		int[][] t21 = {{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int[][] t22 = {{-1,1},{-1,-1}};
		System.out.println(solution(t11, t12));
		System.out.println(solution(t21, t22));
	}
}
