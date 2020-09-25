package summer_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution3 {
	
	public static int[] solution(String[] info, String[] query) {
		int num = info.length;
		List<Integer> lanList = new ArrayList<>();
		List<Integer> supList = new ArrayList<>();
		List<Integer> carList = new ArrayList<>();
		List<Integer> foodList = new ArrayList<>();
		List<Integer> scoreList = new ArrayList<>();
		/*
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(info[i]);
			supMap.put(st.nextToken(), i);
			carMap.put(st.nextToken(), i);
			foodMap.put(st.nextToken(), i);
			scoreMap.put(Integer.parseInt(st.nextToken()), i);
		}
		*/
		int ql = query.length;
		int[] answer = new int[ql];
		for(int i=0; i<ql; i++) {
			StringTokenizer st = new StringTokenizer(query[i]);
			String lan = st.nextToken(); st.nextToken();
			String sup = st.nextToken(); st.nextToken();
			String car = st.nextToken(); st.nextToken();
			String food = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			int ans = 0;
			
			answer[i] = ans;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		for(int i : solution(info, query)) System.out.println(i);
	}
}
