import java.util.*;
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 4 };
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
	
	public static void quickSort(int[] input) {
		if (input.length == 0 || input.length == 1) return;      
      	quickSortUtil(input, 0, input.length - 1);
	}

  	public static void quickSortUtil(int [] input, int start, int end) {
      	if (start >= end) return;
      
        int pivot = partition(input, start, end);
        quickSortUtil(input, start, pivot - 1);
      	quickSortUtil(input, pivot + 1, end);
    }  
  
	public static int partition(int[] input, int start, int end) {
      	int pivot = end;
      	int numSmallElems = 0;
		for (int i = start; i < end; i++) {
          	if (input[i] < input[pivot]) numSmallElems++;
        } 
		pivot = start + numSmallElems;
		swap(input, start + numSmallElems, end);
		int i = start;
      	int j = end;
      	while (i < pivot || j > pivot) {
          	if (input[i] < input[pivot]) {
              	i++; 
            } else if (input[j] >= input[pivot]) {
              	j--;
            } else {
                swap(input, i, j);
                i++;
                j--;
            }
        }
      	return pivot;
    }
  
  	public static void swap(int [] input, int i, int j) {
      	int temp = input[i];
      	input[i] = input[j];
      	input[j] = temp;
    }
}