package autumn_2020;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution3 {

	static int solution(String road, int n) {
        int answer = -1;
        
        char[] cr = road.toCharArray();
        List<Integer> list = new LinkedList<>();
        if(cr[0] == '0') list.add(-1);
        else list.add(1);
        
        for(int i=1; i<road.length(); i++) {
        	int last = list.size() - 1;
        	if(list.get(last) > 0) {
        		if(cr[i] == '0') {
        			list.add(-1);
        		} else {
        			list.set(last, list.get(last)+1);
        		}
        	} else {
        		if(cr[i] == '0') {
        			list.set(last, list.get(last)-1);
        		} else {
        			list.add(1);
        		}
        	}
        }
        list.remove(list.size()-1);
        
        Queue<Integer> q = new LinkedList<>();
        
        return answer;
    }
	
	public static void main(String[] args) {
		String s1 = "111011110011111011111100011111";
		String s2 = "001100";
		
		System.out.println(solution(s1, 3));
		//System.out.println(solution(s2, 5));
	}
}
