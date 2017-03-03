package Homework2;

public class Recursion1 {

	public int Recursion1(int[] arr) {
		// base case
		if (arr.length == 1) {
			return arr[0];
		}

		// recursion
		int[] Array1;
		int[] Array2;

		if (arr.length % 2 == 0) {
			// even length array
			// split even array into 2
			Array1 = new int[arr.length / 2];
			Array2 = new int[arr.length / 2];

			// loop
			int current = 0;
			int current2 = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i + 1 < arr.length / 2) {
					Array1[current] = arr[i];
					current++;
				} else {
					Array2[current2] = arr[i];
					current2++;
				}
			}

			int max1 = Recursion1(Array1);
			int max2 = Recursion1(Array2);
			if (max1 >= max2) {
				return max1;
			} else {
				return max2;
			}
		} else {
			// odd length array
			// split even array into 2
			Array1 = new int[arr.length / 2];
			Array2 = new int[(arr.length / 2) + 1];

			// loop
			int current = 0;
			int current2 = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i + 1 <= arr.length / 2) {
					Array1[current] = arr[i];
					current++;
				} else {
					Array2[current2] = arr[i];
					current2++;
				}
			}

			int max1 = Recursion1(Array1);
			int max2 = Recursion1(Array2);
			if (max1 >= max2) {
				return max1;
			} else {
				return max2;
			}

		}

	}

	public static void main(String[] args) {

		int[] Array1 = new int[6];
		Array1[0] = 2;
		Array1[1] = 4;
		Array1[2] = 8;
		Array1[3] = 5;
		Array1[4] = 6;
		Array1[5] = 9; 

		int[] Array2 = new int[7];
		Array2[0] = -1;
		Array2[1] = 5;
		Array2[2] = 9;
		Array2[3] = -5;
		Array2[4] = -4;
		Array2[5] = 10;
		Array2[6] = 6;

		Recursion1 rc = new Recursion1();
		System.out.println(rc.Recursion1(Array1));
		System.out.println(rc.Recursion1(Array2));
	}

}
