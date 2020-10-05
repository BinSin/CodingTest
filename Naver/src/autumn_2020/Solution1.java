package autumn_2020;

public class Solution1 {

	public static String solution(int n, int[] p, int[] c) {
		double answer = 0;
		int s = 0;
		int price = 100;
		int i;
		for(i=0; i<n; i++) {
			s += p[i];
			System.out.println("answer : " + answer);
			if(s >= c[i]) {
				answer += (c[i] * price);
				s -= c[i];
				price = 100;
			} else {
				if(price == 25) {
					i++;
					break;
				}
				price /= 2;
			}
		}
		System.out.println(i);
		return String.format("%.2f", answer/i);
	}
	
	public static void main(String[] args) {
		int n1 = 6;
		int[] p1 = {5,4,7,2,0,6};
		int[] c1 = {4,6,4,9,2,3};
		int n2 = 7;
		int[] p2 = {6,2,1,0,2,4,3};
		int[] c2 = {3,6,6,2,3,7,6};
		int n3 = 7;
		int[] p3 = {1,2,4,0,2,4,3};
		int[] c3 = {1,2,4,100,100,100,100};
		System.out.println(solution(n1, p1, c1));
		System.out.println(solution(n2, p2, c2));
		System.out.println(solution(n3, p3, c3));
	}
}
