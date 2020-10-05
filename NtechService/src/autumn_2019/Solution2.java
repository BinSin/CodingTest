package autumn_2019;

public class Solution2 {
    static  public int solution(long n) {
    	int answer = 0;
        String s = n + "";
    	boolean[] check = new boolean[10];
    	for(int i=0; i<s.length(); i++) {
    		check[s.charAt(i) - '0'] = true;
    	}

    	for(int i=1; i<10; i++) {
    		if(check[i] && n % i == 0) answer++;
    	}
         return answer;
    }
    
    public static void main(String[] args) {
    	System.out.println(solution(2322));
    	System.out.println(solution(1234));
    }
}