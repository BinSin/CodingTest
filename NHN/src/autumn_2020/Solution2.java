package autumn_2020;

import java.util.Scanner;

class Solution2 {
  private static void solution(int day, int width, int[][] blocks) {
    int ans = 0;
		int[] building = new int[width+1];
		for(int i=0; i<day; i++) {
			int pos = 0;
			for(int j=0; j<width; j++) {
				building[j] += blocks[i][j];
			}
			for(int j=0; j<width; j++) {
				if(building[j] > building[j+1]) {
					int minHeight = Math.min(building[pos], building[j]);
					for(int k=pos+1; k<j; k++) {
						ans += minHeight - building[k];
						building[k] = minHeight;
					}
					pos = j;
					j++;
				}
			}
		}
		System.out.print(ans);
  }
  
  private static class InputData {
    int day;
    int width;
    int[][] blocks;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      
      inputData.blocks = new int[inputData.day][inputData.width];
      for (int i = 0; i < inputData.day; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.width; j++) {
          inputData.blocks[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.day, inputData.width, inputData.blocks);
  }
}