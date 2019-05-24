import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class ArrayToList {
	
	public static void main(String[] args) {
		
		List<List<Integer>> groupedNums;

		int[] array = new int[20];
		int sum = 10;
		
		Random random = new Random();
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		
		groupedNums = ArrayToList.getNumsFromArrayAndGroup(array, sum);
	    
		for(List<Integer> couple : groupedNums) {
			for(Integer num : couple) {
				System.out.print(num + " ");
	        	}
	        	System.out.println();
	    	}
	}
	
	static List<List<Integer>> getNumsFromArrayAndGroup (int[] array, int sum) {
		List<List<Integer>> listOfCouples = new ArrayList<List<Integer>>();
		List<Integer> coupleOfNums;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] + array[j] == sum) {
                    			coupleOfNums = Arrays.asList(array[i], array[j]);
                                        
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
