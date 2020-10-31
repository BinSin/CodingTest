package autumn_2020;
import java.util.*;

// failed
class Solution3 {
  private static void solution(int numOfOrder, String[] orderArr) {
		for(int i=0; i<numOfOrder; i++) {
			Stack<String> s = new Stack<>();
			String str = orderArr[i];
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) >= '1' && str.charAt(j) <= '9') {
					s.push(sb.toString());
					sb = new StringBuilder();
					sb.append(str.charAt(j));
				} else if(str.charAt(j) == '(' || str.charAt(j) == ')') {
					s.push(sb.toString());
					sb = new StringBuilder();
					continue;
				} else {
					sb.append(str.charAt(j));
				}
			}
			while(!s.isEmpty()) {
				sb = new StringBuilder();
				String st = s.pop();
				char e = s.pop().charAt(0);
				if(e >= '1' && e <= '9') {
					int n = e - '0';
					for(int j=0; j<n; j++) {
						sb.insert(0, st);
					}
				}
			}
			System.out.println(sb.toString());
		}
  }

  private static class InputData {
    int numOfOrder;
    String[] orderArr;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.orderArr = new String[inputData.numOfOrder];
      for (int i = 0; i < inputData.numOfOrder; i++) {
        inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfOrder, inputData.orderArr);
  }
}