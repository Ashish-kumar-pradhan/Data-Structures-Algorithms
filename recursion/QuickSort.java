package recursion;

public class QuickSort {
	
	public static void quickSort( int arr[] , int si , int ei) {
		if (si >= ei) {
			return;
		}
		int pivotPos = partition(arr , si ,ei);
		
		quickSort(arr , si , pivotPos -1);
		quickSort(arr , pivotPos + 1 , ei );
		
	}
	
	public static int partition( int arr[] ,int si , int ei ) {
		int pivot = arr[si];
		int count = 0;
		for (int i = si+1 ; i <= ei ; i++) {
			if (pivot >= arr[i]) {
				count = count +1;
			}
		}
		
		arr[si] = arr[si + count];
		arr[si + count]= pivot;
		
		int i = si;
		int j = ei;
		while(i < pivot ) {
			if (arr[i]>pivot ) {
				while (j > pivot) {
					if (arr[j]<pivot) {
						break;
					}
					j--;
				}
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			i++;
			
		}
		
		
//		int[] temp1 = new int[si + count + 1];
//		int[] temp2 = new int[ei - (si+count)];
//		
//		for (int i = 0 ; i <= ei+1 ; i++) {
//			if (arr[i]<pivot) {
//				temp1[i]=arr[i];
//			}
//		}
//		
//		
		
		
		return si + count;
		
	}
	
	static void printArray(int a[]){
        int n = a.length;
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }

	public static void main(String[] args) {
		int array[] = {9 , 5 , 2 , 7 , 8 , 5 , 3 , 19 , 4};
		quickSort(array , 0 ,array.length -1);
		
		printArray(array);

	}

}
