package autumn_2020;

import java.util.Stack;

public class Solution3 {

	public static int solution(int[] histogram) {
		int answer = 0;
		int l = histogram.length;
		Stack<Integer> s = new Stack();
		for(int i=0; i<l; i++) {
			while(!s.isEmpty() && histogram[s.peek()] > histogram[i]) {
				int w = i-1;
				int h = histogram[s.pop()];
				if(!s.isEmpty()) {
					w = i - s.peek() - 1;
				}
				answer = Math.max(answer, w*h);
			}
			s.push(i);
		}
		while(!s.isEmpty()) {
			int w = l-1;
            int h = histogram[s.pop()];
            if(!s.isEmpty()) {
                w = l - s.peek() - 1;
            }
            answer = Math.max(answer, w*h);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] histogram1 = {2,2,2,3};
		int[] histogram2 = {6,5,7,3,4,2};
		System.out.println(solution(histogram1));
		System.out.println(solution(histogram2));
	}
}
