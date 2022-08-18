package sort;

public class Quick {
	
	public static void quick(int[] array, int start, int end) {
		if (start >= end) return;
		int pivot = start;
		int left = start + 1;
		int right = end;
		
		while (left <= right) {
			while (left <= end && array[left] <= array[pivot]) left++;
			while (right > start && array[pivot] <= array[right]) right--;
			
			if (right <= left) {
				int temp = array[pivot];
				array[pivot] = array[right];
				array[right] = temp;
			} else {
				int temp = array[right];
				array[right] = array[left];
				array[left] = temp;
			}
		}
		
		quick(array, start, right - 1);
		quick(array, right + 1, end);
	}
	
	public static void main(String[] args) {
		int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		quick(array, 0, array.length - 1);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

}
