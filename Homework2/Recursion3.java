package Homework2;

import java.util.ArrayList;

public class Recursion3 {

	public boolean isPalindrome(String str) {

		str = str.toLowerCase();

		//check length (base case)
		int length = str.length();
		if (length < 2) {
			return true;
		}

		int begin = 0;
		int end = str.length() - 1;

		// strip punctuation/whitespace at beginning
		while (str.charAt(begin) < 'a' || str.charAt(begin) > 'z') {
			begin++;
			length--;
			// hit base-case
			if (begin <= end - 2) {
				return true;
			}
		}

		// strip punctuation/whitespace at end
		while (str.charAt(end) < 'a' || str.charAt(end) > 'z') {
			end--;
			length--;
			// hit base-case
			if (begin <= end - 2) {
				return true;
			}
		}

		// base case
		if (str.length() < 2) {
			return true;
		}

		// check first and last string && middle
		String substring = str.substring(begin + 1, end);
		if (str.charAt(begin) == str.charAt(end) && isPalindrome(substring)) {
			// check the middle
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		ArrayList<String> strs = new ArrayList<String>();
		strs.add("A but tuba.");
		strs.add("A car, a man, a maraca.");
		strs.add("Aibohphobia (fear of palindromes)");

		strs.add("Ummmmm that aren't");
		strs.add("Just any word");
		strs.add("Mirror");

		Recursion3 rc = new Recursion3();

		for (String str : strs) {
			System.out.println(str);
			System.out.println(rc.isPalindrome(str));
		}

	}

}
