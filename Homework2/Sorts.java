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
	}

}
