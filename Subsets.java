/**
 * 
 */

/**
 * @author Dell
 *
 */
public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
		Integer[] setArray = {1,2,3};
		
		SubsetGenerator(setArray, new Integer[setArray.length],0);
		

	}
	
	public static void SubsetGenerator(Integer[] setArray, Integer[] subset,int i) {
		
		if(i == setArray.length)
			PrintSet(subset);
		else
		{
			subset[i] = null;
			SubsetGenerator(setArray, subset, i+1);
			subset[i] = setArray[i];
			SubsetGenerator(setArray, subset, i+1);
			
		}
				
	}
	
	public static void PrintSet(Integer[] setArray) {
		System.out.print("\n[");
		for(int i=0;i<setArray.length;i++) {
			if(setArray[i] != null)
				System.out.print(setArray[i]+ ",");
		}
		System.out.print("]");
	}

}
