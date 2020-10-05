package autumn_2020;

import java.util.Arrays;
import java.util.HashMap;

public class Solution4 {

	public static String[][] solution(String[][] snapshots, String[][] transactions) {
        boolean[] idCheck = new boolean[100000];
        
        HashMap<String, String> hm = new HashMap<>();
        for(int i=0; i<snapshots.length; i++) {
        	hm.put(snapshots[i][0], snapshots[i][1]);
        }
        
        for(int i=0; i<transactions.length; i++) {
        	int id = Integer.parseInt(transactions[i][0]);
        	String transaction = transactions[i][1];
        	String name = transactions[i][2];
        	int account = Integer.parseInt(transactions[i][3]);
        	
        	if(idCheck[id]) continue;
        	else {
        		idCheck[id] = true;
        		
        		if(hm.containsKey(name)) {
	        		int sum = Integer.parseInt(hm.get(name));
	        		if(transaction.equals("SAVE")) {
	        			sum += account;
	        		} else {
	        			sum -= account;
	        		}
	        		hm.put(name, sum + "");
        		} else {
        			if(transaction.equals("SAVE")) {
        				hm.put(name, account + "");
        			}
        		}
        	}
        }
        
        Object[] mk = hm.keySet().toArray();
        Arrays.sort(mk);
        
        String[][] answer = new String[hm.size()][2];
        for(int i=0; i<hm.size(); i++) {
        	String k = mk[i].toString();
        	answer[i][0] =k;
        	answer[i][1] = hm.get(k);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[][] snapshot = {
				{"ACCOUNT1", "100"}, 
				{"ACCOUNT2", "150"}
				};
		
		String[][] transactions = {
				{"1", "SAVE", "ACCOUNT2", "100"},
				{"2", "WITHDRAW", "ACCOUNT1", "50"}, 
				{"1", "SAVE", "ACCOUNT2", "100"}, 
				{"4", "SAVE", "ACCOUNT3", "500"}, 
				{"3", "WITHDRAW", "ACCOUNT2", "30"}
				};
		
		solution(snapshot, transactions);
	}
}
