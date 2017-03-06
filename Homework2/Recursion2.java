package Homework2;

import java.util.ArrayList;

public class Recursion2 {

	public int countZeroes(int n) {

		// base case
		if (n == 1) {
			return 0;
		} else if (n == 0) {
			return 1;
		}

		int zeroCount = 0;
		// if even, last digit in binary representation is 0
		// i.e. 8 == 1000, 4 == 100, 2 == 10, 0 == 0
		if (n % 2 == 0) {
			zeroCount++;
		}

		// recursion
		return zeroCount + countZeroes(n / 2);
	}

	public static void main(String[] args) {

		Recursion2 rc = new Recursion2();
		for (int i = 0; i < 11; i++) {
			System.out.println(i + ": " + rc.countZeroes(i));
		}

	}

}
