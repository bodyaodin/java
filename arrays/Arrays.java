import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Arrays {
	
	public static void main(String[] args) {
		
		Arrays obj = new Arrays();
		
		List<List<Integer>> groupedNums = new ArrayList<List<Integer>>();

		int[] array = new int[20];
		int sum = 10;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 9);
		}
		
		groupedNums = obj.getNumsFromArrayAndGroup(array, sum);
	    
		for(List<Integer> couple : groupedNums) {
			for(Integer num : couple) {
				System.out.print(num + " ");
	        	}
	        	System.out.println();
	    	}
	}
	
	List<List<Integer>> getNumsFromArrayAndGroup (int[] array, int sum) {
		List<List<Integer>> listOfCouples = new ArrayList<List<Integer>>();
		List<Integer> coupleOfNums;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if(i != j && array[i] + array[j] == sum) {
                    			coupleOfNums = new ArrayList<Integer>();
                    
                    			coupleOfNums.add(array[i]);
                    			coupleOfNums.add(array[j]);
                    
                    			List<Integer> reverseList = new ArrayList<Integer>(coupleOfNums);                    
                    			Collections.reverse(reverseList);
                    
                    			if(!listOfCouples.contains(coupleOfNums) && !listOfCouples.contains(reverseList)) {
                        			listOfCouples.add(coupleOfNums);
					} 
				}
			}
		}
		
		return listOfCouples;
	}
}
