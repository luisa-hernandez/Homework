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
	}

}
