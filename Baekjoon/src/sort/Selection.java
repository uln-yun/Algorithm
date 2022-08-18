package sort;

import java.io.*;
import java.util.*;

public class Selection {

	public static void main(String[] args) {
		int n = 10;
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		for (int i = 0; i < n; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
