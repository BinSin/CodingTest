package autumn_2019;

public class Solution {
    static public int solution(int a, int b, int budget) {
        int answer = 0;
        
        int i = budget / a;
        for(int j=i; j>=0; j--) {
            if((budget - (a * j)) % b == 0) answer++;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	System.out.println(solution(3000, 5000, 23000));
    }
}