package autumn_2019;

public class Solution3 {
    static  boolean solution(String input) {
        int[] check = new int[3]; // (, {, [
        
        for(int i=0; i<input.length(); i++) {
        	char now = input.charAt(i);
        	switch(now) {
        	case '(':
        		if(check[0] > 0) return false;
        		else check[0]++;
        		break;
        	case ')':
        		if(check[0] <= 0) return false;
        		else check[0]--;
        		break;
        	case '{': 
        		if(check[1] > 0 || check[0] > 0) return false;
        		else check[1]++;
        		break;
        	case '}':
        		if(check[1] <= 0 || check[0] > 0) return false;
        		else check[1]--;
        		break;
        	case '[': 
        		if(check[2] > 0 || check[1] > 0 || check[0] > 0) return false;
        		else check[2]++;
        		break;
        	case ']':
        		if(check[2] <= 0 || check[1] > 0 || check[0] > 0) return false;
        		else check[2]--;
        		break;
        	}
        }
        
        for(int i=0; i<3; i++) {
    		if(check[i] > 0) return false;
    	}
        
        return true;
    }
    
    public static void main(String[] args) {
    	System.out.println(solution("3+[(5+1)-1]"));
    	System.out.println(solution("3+([5+1]))"));
    	System.out.println(solution("3+{(5+1}"));
    	System.out.println(solution("3+[{(5+1)-1}+3]"));
    	System.out.println(solution("3+([5+1])"));
    	System.out.println(solution("[{(})]"));
    	
    }
}