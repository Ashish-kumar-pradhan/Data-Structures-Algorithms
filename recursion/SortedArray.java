package recursion;

public class SortedArray {
	
	public static boolean is_sorted(int arr[]) { // this method is wrong
		if (arr.length <= 1) {
			return true;
		} 
		
		int smallArray[] = new int[arr.length - 1];
		for (int i = 1; i < arr.length ; i++) {
			smallArray[i-1] = arr[i];
		}
		boolean is_smaller_sorted = is_sorted(smallArray);
		if (is_smaller_sorted) {				
			return false;
		}
		if(arr[0]<=arr[1]) {
			return true;
				
		} else {
			return false;
		}
		
	}
	
	public static boolean is_sorted_2(int arr[]) {
		if (arr.length <= 1) {
			return true;
		} 
		if (arr[0] > arr[1]) {
			return false;		
		}
		int smallArray[] = new int[arr.length - 1];
		for (int i = 1; i < arr.length ; i++) {
			smallArray[i-1] = arr[i];
		}
		
		boolean is_smaller_sorted = is_sorted_2(smallArray);
		return is_smaller_sorted;				
	}
	
	private static boolean is_sorted_3(int arr[] , int startIndex) {
		if (startIndex >= arr.length-1) {
			return true;
		}
		if(arr[startIndex] > arr[startIndex + 1]) {
			return false;
		}
		boolean is_smaller_sorted = is_sorted_3(arr , startIndex + 1);
		return is_smaller_sorted;	
		
		
	}
	
	public static boolean is_sorted_3(int arr[]) {
		return is_sorted_3(arr , 0);
	}
	
	public static void main(String[] args) {
		int array[] = {1 ,2 , 3 , 7 , 6 , 8};
		System.out.println(is_sorted(array));
		System.out.println(is_sorted_2(array));
		System.out.println(is_sorted_3(array , 0));
		System.out.println(is_sorted_3(array));





	}

}
