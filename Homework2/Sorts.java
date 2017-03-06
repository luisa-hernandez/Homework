package Homework2;

public class Sorts {

	public int[] bubblesort(int[] ints) {
		/**
		 * returns a sorted integer array
		 */

		boolean sorted = true;
		do {
			sorted = true;
			for (int i = 0; i < ints.length - 1; i++) {
				if (ints[i] > ints[i + 1]) {
					int temp = ints[i];
					ints[i] = ints[i + 1];
					ints[i + 1] = temp;
					sorted = false;
				}
			}
		} while (!sorted);

		return ints;
	}

	public int[] recursiveBubble(int[] ints) {

		// base case
		if (ints.length == 1) {
			return ints;
		}

		// one pass of normal bubble sort
		for (int i = 0; i < ints.length - 1; i++) {
			if (ints[i] > ints[i + 1]) {
				int temp = ints[i];
				ints[i] = ints[i + 1];
				ints[i + 1] = temp;
			}
		}

		// create subarray
		int[] subArray = new int[ints.length - 1];
		for (int i = 0; i <= subArray.length - 1; i++) {
			subArray[i] = ints[i];
		}

		// recursion on 1st - 2nd to last element
		subArray = recursiveBubble(subArray);

		// put elements of sub array into array
		for (int i = 0; i <= subArray.length - 1; i++) {
			ints[i] = subArray[i];
		}

		// one last pass of normal bubble sort
		for (int i = 0; i < ints.length - 1; i++) {
			if (ints[i] > ints[i + 1]) {
				int temp = ints[i];
				ints[i] = ints[i + 1];
				ints[i + 1] = temp;
			}
		}

		return ints;
	}

	public void printArray(int[] ints) {
		for (int i = 0; i < ints.length; i++) {
			System.out.print(new Integer(ints[i]) + " ");
		}
		System.out.println("");
	}

	public int[] quickSort(int[] ints) {

		// base case
		if (ints.length < 1) {
			return ints;
		}

		// pick a pivot
		int pivot = ints[0];

		// divide integers into two sub lists
		int smallerCount = 0;
		int largerCount = 0;
		for (int i = 0; i < ints.length; i++) {
			// count smaller elements
			if (ints[i] < pivot) {
				smallerCount++;
			}
			// count larger/equal elements
			if (ints[i] >= pivot) {
				smallerCount++;
			}
		}

		// create subarrays
		int[] left = new int[smallerCount];
		int[] right = new int[largerCount];
		int leftIndex = 0;
		int rightIndex = 0;

		for (int i = 1; i < ints.length; i++) {
			// put smaller elements in left subArray
			if (ints[i] < pivot) {
				left[leftIndex] = ints[i];
				leftIndex++;
			}
			// put larger/equal elements in right subArray
			if (ints[i] >= pivot) {
				right[rightIndex] = ints[i];
				rightIndex++;
			}
		}

		// call quickSort on each sub list
		left = quickSort(left);
		right = quickSort(right);

		// combine results
		// left
		for (int i = 0; i < left.length; i++) {
			ints[i] = left[i];
		}

		// pivot
		ints[left.length] = pivot;

		// right
		for (int i = 0; i < right.length; i++) {
			ints[i + left.length + 1] = right[i];
		}

		return ints;
	}

	public int[] insertionSort(int[] ints) {
		return ints;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[10];
		numbers[0] = 4;
		numbers[1] = 77;
		numbers[2] = 98;
		numbers[3] = 30;
		numbers[4] = 20;
		numbers[5] = 50;
		numbers[6] = 77;
		numbers[7] = 22;
		numbers[8] = 49;
		numbers[9] = 2;

		Sorts bs = new Sorts();

		System.out.println("Original");
		bs.printArray(numbers);
		System.out.println();

		System.out.println("Bubble Sort");
		int[] bsNumbers = bs.bubblesort(numbers);
		bs.printArray(bsNumbers);
		System.out.println();

		System.out.println("Recursive Bubble Sort");
		int[] recursiveBsNumbers = bs.recursiveBubble(numbers);
		bs.printArray(recursiveBsNumbers);
		System.out.println();

		System.out.println("Quick Sort");
		int[] quickSortNumbers = bs.recursiveBubble(numbers);
		bs.printArray(quickSortNumbers);
		System.out.println();

	}

}
