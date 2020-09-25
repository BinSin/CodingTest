package autumn_2020;

public class Solution1 {

	static final int  max = 365;
	public static int solution(int[][] flowers) {
        int answer = 0;
        boolean[] check = new boolean[max+1];
        for(int i=0; i<flowers.length; i++) {
        	for(int j=flowers[i][0]; j<flowers[i][1]; j++) {
        		check[j] = true;
        	}
        }
        for(int i=0; i<=max; i++) {
        	if(check[i]) answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] flowers1 = {{2,5},{3,7},{10,11}};
		int[][] flowers2 = {{3,4},{4,5},{5,6},{8,10}};
		
		System.out.println(solution(flowers1));
		System.out.println(solution(flowers2));
	}
}
