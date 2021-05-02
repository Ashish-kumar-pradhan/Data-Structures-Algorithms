package recursion;

public class FindingIndexArray {
	static int index(int arr[] , int size) {
		if (size==0) {
			return -1;
		}if(arr[size]==5) {
			return size;
		} smallindex = index(arr , size - 1);
		
	}
	public static void main(String[] args) {

	}


}
