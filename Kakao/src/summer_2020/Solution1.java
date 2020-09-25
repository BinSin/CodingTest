package summer_2020;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

	public static void delete(StringBuffer sb, List<Integer> rl) {
		for(int i=0; i<rl.size(); i++) {
        	sb.deleteCharAt(rl.get(i)-i);
        }
	}
	
	public static String solution(String new_id) {
		StringBuffer sb = new StringBuffer(new_id.toLowerCase()); // 1?���?
		
		List<Integer> rl = new LinkedList<>();
        for(int i=0; i<sb.length(); i++) {
        	char c = sb.charAt(i);
        	if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
        		continue;
        	} else {
        		if(c != '-' && c != '_' && c != '.') rl.add(i);
        	}
        }
        delete(sb, rl);
        
        rl = new LinkedList<>();
        int count = 0;
        for(int i=0; i<sb.length(); i++) {
        	char c = sb.charAt(i);
        	if(c == '.') {
        		count++;
        		if(count > 1) rl.add(i);
        	} else {
        		count = 0;
        	}
        }
        delete(sb, rl);
        
        if(sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.toString().equals("")) {
        	sb.append('a');
        } else {
        	if(sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        }
        
        if(sb.length() >= 16) sb.delete(15, sb.length());
        
        if(sb.toString().equals("")) {
        	sb.append('a');
        } else {
        	if(sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        }
        
        if(sb.length() <= 2) {
        	char c = sb.charAt(sb.length()-1);
        	while(sb.length() < 3) {
        		sb.append(c);
        	}
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
	}
}
