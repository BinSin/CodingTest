package autumn_2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main3 {
	
	public static class Pair{
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs(int[][] b, int i, int j, int R, int C) {
		if(b[i][j] == 0) return 0;
		Pair[] next1 = {new Pair(0, 1), new Pair(0, -1)};
		Pair[] next2 = {new Pair(1, 0), new Pair(-1, 0)};
		int sum = 0;
		// 가로
		Queue<Pair> q1 = new LinkedList<>();
		Pair s1 = new Pair(i, j);
		q1.add(s1);
		boolean[][] check1 = new boolean[R][C];
		check1[i][j] = true;
		int number1 = b[i][j];
		
		List<Pair> list1 = new ArrayList<>();
		list1.add(s1);
		while(!q1.isEmpty()) {
			Pair p = q1.remove();
			for(Pair n : next1) {
				int nx = p.x;
				int ny = p.y + n.y;
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(check1[nx][ny] || number1 != b[nx][ny]) continue;
				check1[nx][ny] = true;
				list1.add(new Pair(nx, ny));
			}
		}
		// 세로
		Queue<Pair> q2 = new LinkedList<>();
		Pair s2 = new Pair(i, j);
		q2.add(s2);
		boolean[][] check2 = new boolean[R][C];
		check2[i][j] = true;
		int number2 = b[i][j];
		List<Pair> list2 = new ArrayList<>();
		list2.add(s2);
		while(!q2.isEmpty()) {
			Pair p = q2.remove();
			for(Pair n : next2) {
				int nx = p.x + n.x;
				int ny = p.y;
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(check2[nx][ny] || number2 != b[nx][ny]) continue;
				check2[nx][ny] = true;
				list2.add(new Pair(nx, ny));
			}
		}
		int ls1 = list1.size();
		int ls2 = list2.size();
		if(ls1 >= 3 && ls2 >= 3) {
			for(Pair p : list1) {
				b[p.x][p.y] = 0; 
			}
			for(Pair p : list2) {
				b[p.x][p.y] = 0;
			}
			sum += ls1 + ls2 - 1;
		} else if(ls1 >= 3 && ls2 < 3) {
			for(Pair p : list1) {
				b[p.x][p.y] = 0;
			}
			sum += ls1;
		} else if(ls1 < 3 && ls2 >= 3) {
			for(Pair p : list2) {
				b[p.x][p.y] = 0;
			}
			sum += ls2;
		} else {
			return 0;
		}
		return sum;
	}
	
	public static int solution(int[][] board) {
		int R = board.length;
		int C = board[0].length;
		int answer = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				int[][] b = new int[R][C];
				for(int k=0; k<R; k++) {
					b[k] = board[k].clone();
				}
				b[i][j] = 0;
				int sum = 0;
				
				while(true) {
					// 내리기
					for(int c=0; c<C; c++) {
						for(int r=R-1; r>0; r--) {
							if(b[r][c] == 0) {
								b[r][c] = b[r-1][c];
								b[r-1][c] = 0;
							}
						}
					}
					boolean check = false;
					for(int c=0; c<R; c++) {
						for(int d=0; d<C; d++) {
							int s = bfs(b, c, d, R, C);
							if(s > 0) check = true;
							sum += s;
						}
					}
					if(!check) break;
				}
				answer = Math.max(answer, sum);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] board = {{1,1,3,3}, {4,1,3,4}, {1,2,1,1}, {2,1,3,2}};
		System.out.println(solution(board));
	}
}
