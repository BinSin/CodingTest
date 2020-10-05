package autumn_2019;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	public static class Pair {
		int x, y;
		Pair(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static String[] solution(String[] board, int y, int x) {
		int height = board.length;
		int width = board[0].length();
		String[] answer = new String[height];
		
		for(int i=0; i<height; i++) {
			answer[i] = "";
		}
		
		char[][] boom = new char[height][width];
		for(int i=0; i<height; i++) {
			String now = board[i];
			for(int j=0; j<width; j++) {
				boom[i][j] = now.charAt(j);
			}
		}
		
		if(boom[y][x] == 'M') {
			boom[y][x] = 'X';
			
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					answer[i] += boom[i][j];
				}
			}
		}
		else {
			int[][] val = new int[height][width];
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					val[i][j] = -1;
				}
			}
			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(y, x));
			Pair[] nextLocation = 
				{
					new Pair(-1, -1), new Pair(-1, 0), new Pair(-1, 1),
					new Pair(0, -1),				 new Pair(0, 1),
					new Pair(1, -1), new Pair(1, 0), new Pair(1, 1)
				};
			
			val[y][x] = 0;
			while(!q.isEmpty()) {
				Pair first = q.poll();
				int nowX = first.x;
				int nowY = first.y;
				for(int k=0; k<nextLocation.length; k++) {
					Pair next = nextLocation[k];
					int nx = nowX + next.x;
					int ny = nowY + next.y;
					if(0 <= nx && nx < width && 0 <= ny && ny < height) {
						if(boom[ny][nx] == 'E' && val[ny][nx] == -1) {
							q.add(new Pair(ny, nx));
							val[ny][nx] = 0; 
						} else if(boom[ny][nx] == 'M'){
							val[nowY][nowX]++;
						}
					}
				}
			}
			
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					if(val[i][j] == 0)
						answer[i] += 'B';
					else if(val[i][j] > 0) {
						boolean check = false;
						for(int k=0; k<nextLocation.length; k++) {
							Pair next = nextLocation[k];
							int nx = j + next.x;
							int ny = i + next.y;
							if(0 <= nx && nx < width && 0 <= ny && ny < height) {
								if(val[ny][nx]  == 0) {
									check = true;
								}
							}
						}
						if(check) {
							answer[i] += val[i][j];
						} else {
							answer[i] += 'E';
						}
						
					}
					else {
						answer[i] += 'E';
					}
				}
			}
		}
		
		return answer;
	}
		
	public static void main(String[] args) {
		String[] board = {"EEEEE", "EEMEE", "EEEEE", "EEEEE"};
		String[] answer = solution(board, 2, 0);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		System.out.println("==============");
		
		String[] board2 = {"MME", "EEE", "EME"};
		String[] answer2 = solution(board2, 0, 0);
		for(int i=0; i<answer2.length; i++) {
			System.out.println(answer2[i]);
		}
		
	}
}
