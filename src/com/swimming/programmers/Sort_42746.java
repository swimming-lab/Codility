import java.util.*;

class Sort_42746 {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
    	for(int i=0; i<numbers.length; i++) {
    		list.add(numbers[i]);
    	}
    	
    	Collections.sort(list, (a, b)-> {
    			String as = String.valueOf(a);
    			String bs = String.valueOf(b);
    			                
    			// 여기서 -는 내림차순을 위한거다.
    			return -Integer.compare(Integer.valueOf(as+bs), Integer.valueOf(bs+as));
    		}
    	);
    	//System.out.println(list);
    	
    	StringBuffer sf = new StringBuffer();
    	
    	for (Integer i : list) {
    		sf.append(i);
    	}
        
    	//System.out.println("answer = " + sf);
    	return sf.toString();
    }
  
    public static void main(String[] args) {
        final Sort_42746 solution = new Sort_42746();
        String result = solution.solution(
                new int[]{6, 10, 2});

        System.out.println(result);
    }
}
