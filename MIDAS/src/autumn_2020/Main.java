package autumn_2020;

public class Main {

	public static String solution1(String[] strs) {
		int minLen = 1000;
		for(String s : strs) {
			minLen = Math.min(minLen, s.length());
		}
		
		int index = 0;
		for(int i=0; i<minLen; i++) {
			boolean check = false;
			char std = strs[0].charAt(i);
			for(int j=0; j<strs.length; j++) {
				if(std != strs[j].charAt(i)) {
					check = true;
					index = i;
					break;
				}
			}
			if(check) break;
		}
		
		if(index == 0) {
			for(int i=0; i<strs.length-1; i++) {
				String a = strs[i].substring(0, minLen);
				String b = strs[i+1].substring(0, minLen);
				if(!a.equals(b)) {
					return "";
				}
			}
			return strs[0].substring(0, minLen);
		} else {
			return strs[0].substring(0, index);
		}
	}
	
	public static void main(String[] args) {
		String[] strs1 = {"aaaa", "aaa", "aaa"};
		String[] strs2 = {"abcaefg", "abcdefg", "abcdhfg"};
		String[] strs3 = {"a", "b", "c"};
		System.out.println(solution1(strs1));
		System.out.println(solution1(strs2));
		System.out.println(solution1(strs3));
	}
}
