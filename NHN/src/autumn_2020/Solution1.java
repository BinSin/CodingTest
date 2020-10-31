package autumn_2020;

import java.util.Scanner;

class Solution1 {
	
	private static boolean check(int numOfQuickPlayers, char[] namesOfQuickPlayers, char target) {
		for(int i=0; i<numOfQuickPlayers; i++) {
			if(namesOfQuickPlayers[i] == target) return true;
		}
		return false;
	}
	
  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
		char[] ansPlayers = new char[numOfAllPlayers-1];
		for(int i=0; i<numOfAllPlayers-1; i++) ansPlayers[i] = (char)('B' + i);
		int[] ansNumbers = new int[numOfAllPlayers];
		int[] quickPlayers = new int[numOfAllPlayers];
		char tag = 'A';
		int position = 0;
		ansNumbers[0]++; // A는 술래이므로 1부터 시작
		for(int i=0; i<numOfQuickPlayers; i++) quickPlayers[namesOfQuickPlayers[i] - 'A']++;
		for(int i=0; i<numOfGames; i++) {
			position = (position + numOfMovesPerGame[i]) % (numOfAllPlayers-1);
			if(position < 0) position += numOfAllPlayers - 1;
			char target = ansPlayers[position];
			if(!check(numOfQuickPlayers, namesOfQuickPlayers, target)) { // 달리기 빠른 사람이면 술래가 안된다
				ansPlayers[position] = tag;
				ansNumbers[target - 'A']++;
				tag = target;
			} else {
				ansNumbers[tag - 'A']++; // 못잡으면 다시 술래
			}
		}
		for(int i=0; i<numOfAllPlayers-1; i++) {
			System.out.println(ansPlayers[i] + " " + ansNumbers[ansPlayers[i]-'A']);
		}
		System.out.println(tag + " " + ansNumbers[tag-'A']);
  }

  private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
      for(int i = 0; i < inputData.numOfGames ; i++){
        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  }
}