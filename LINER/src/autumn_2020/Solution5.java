package autumn_2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution5 {
	
	public static String[] solution(String[][] dataSource, String[] tags) {
       
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<dataSource.length; i++) {
        	String name = dataSource[i][0];
        	
        	for(int j=0; j<dataSource[i].length; j++) {
        		String tag = dataSource[i][j];
        		for(int k=0; k<tags.length; k++) {
        			if(tag.equals(tags[k]))
        				hm.put(name, hm.getOrDefault(name, 0) + 1);
        		}
        	}
        }
        
        List<String> keySetList = new ArrayList<>(hm.keySet());
        
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            	int v1 = hm.get(o1);
            	int v2 = hm.get(o2);
            	
            	if(v1 < v2) return 1;
            	else if(v1 > v2) return -1;
            	else {
            		return o1.compareTo(o2);
            	}
            }
        });
        
        int size = keySetList.size();
        if(size > 10) size = 10;
        String[] answer = new String[size];
        
        for(int i=0; i<size; i++) {
        	answer[i] = keySetList.get(i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[][] dataSource = {
		                         {"doc1", "t1", "t2", "t3"},
		                         {"doc2", "t0", "t2", "t3"},
		                         {"doc3", "t1", "t6", "t7"},
		                         {"doc4", "t1", "t2", "t4"},
		                         {"doc5", "t6", "t100", "t8"}
		};
		
		String[] tags = {"t1", "t2", "t3"};
		
		solution(dataSource, tags);
	}
}
