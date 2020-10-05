package autumn_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution6 {
	
	static int solution(String inputString) {
        int answer = 0;
        
        char[] sc = inputString.toCharArray();
        List<Character> list = new ArrayList<>();
        for(int i=0; i<inputString.length(); i++) {
        	char c = sc[i];
        	if(c == '(' || c == ')' || c == '{' || c == '}' || c == '['
        			|| c == ']' || c == '<' || c == '>')
        		list.add(c);
        }
        
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        Stack<Character> s3 = new Stack<>();
        Stack<Character> s4 = new Stack<>();
        for(int i=0; i<list.size(); i++) {
    		char c = list.get(i);
    		if(c == '(') {
    			s1.add('(');
    		} else if(c == '{') {
    			s2.add('{');
    		} else if(c == '[') {
    			s3.add('[');
    		} else if(c == '<') {
    			s4.add('<');
    		} else if(c == ')') {
    			if(s1.isEmpty()) return -1;
    			s1.pop();
    			answer++;
    		} else if(c == '}') {
    			if(s2.isEmpty()) return -1;
    			s2.pop();
    			answer++;
    		} else if(c == ']') {
    			if(s3.isEmpty()) return -1;
    			s3.pop();
    			answer++;
    		} else if(c == '>') {
    			if(s4.isEmpty()) return -1;
    			s4.pop();
    			answer++;
    		}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String s1 = "Hello, world!";
		String s2 = "line [plus]";
		String s3 = "if (Count of eggs is 4.) {Buy milk.}";
		String s4 = ">_<";
		
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}
}
