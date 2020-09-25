package summer_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	public static char[] swap(char[] p, int a, int b) {
		char tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
		return p;
	}
	
	public static char[] permutation(char[] p) {
		int I = -1, J = 0;
		for(int i=p.length-1; i>0; i--) {
			if(p[i-1] < p[i]) {
				I = i-1;
				break;
			}
		}
		if(I == -1)
			return new char[] {'1'};
		
		for(int j=p.length-1; j>=0; j--) {
			if(p[j] > p[I]) {
				J = j;
				break;
			}
		}
		
		swap(p, I, J);
		
		J = p.length - 1;
		
		while(I+1 < J) {
			swap(p, I+1, J);
			I++;
			J--;
		}
		
		return p;
	}
	
	public static String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        int osl = orders.length;
        int csl = course.length;
        for(int i=0; i<osl; i++) {
        	char[] ca = orders[i].toCharArray();
        	Arrays.sort(ca);
        	
        	for(int j=0; j<csl; j++) {
        		int n = ca.length;
        		int cou = course[j]; 
        		if(n >= cou) {
        			System.out.println("n : " + n + "   cou : " + cou);
        			char[] p = new char[n];
        			for(int k=0; k<cou; k++) {
        				p[k] = 0;
        			}
        			for(int k=cou; k<n; k++) {
        				p[k] = 1;
        			}
        			String s = "";
        			while(p[0] != '1') {
        				for(int k=0; k<n; k++) {
        					s += ca[k];
        				}
        				p = permutation(p);
        			}
        			map.put(s, map.getOrDefault(s, 0) + 1);
        		}
        	}
        	
        	
        }
        
        return new String[] {map.get("AC") + ""};
    }
	
	public static void main(String[] args) {
		String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course1 = {2,3,4};
		for(String s : solution(orders1, course1)) System.out.println(s);
//		
//		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//		int[] course2 = {2,3,5};
//		System.out.println(solution(orders2, course2));
//		
//		String[] orders3 = {"XYZ", "XWY", "WXA"};
//		int[] course3 = {2,3,4};
//		System.out.println(solution(orders3, course3));
	}
}
