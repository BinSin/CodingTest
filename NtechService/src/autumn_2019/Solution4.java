package autumn_2019;

public class Solution4 {
	
	static long factorial(int k) {
		return k != 1 ? k * factorial(k-1) : 1;
	}
	
    static  int solution(int n, int k) {
        int answer = 1;
    	int num = (n - k + 1); 
    	
    	if(num < 0)
    		return 0;
    	if(num == 1)
    		return (int)(factorial(k) % 10007);
    	
    	answer = num * num;
        answer *= factorial(k) % 10007;
        return answer;
    }
    
    public static void main(String[] args) {
    	System.out.println(solution(2, 2));
    	System.out.println(solution(3, 2));
    	System.out.println(solution(3, 3));
    	System.out.println(solution(3, 1));
    	
    }
}