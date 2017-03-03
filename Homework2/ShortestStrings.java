package Homework2;

public class ShortestStrings {

	public String[] getShortest(String[] strs) {
		/**
		 * returns shortest strings of every three
		 */

		String[] shortestStrings = new String[strs.length / 3];

		// loop on strings
		// el primer paso is in spanish but this isn't
		int shortesStringsIndex = 0;
		for (int i = 0; i < strs.length; i += 3) {
			// save shortest string in new array
			String one = strs[i];
			String two = strs[i + 1];
			String three = strs[i + 2];

			int shorty = i;
			if (one.length() > two.length() || one.length() > three.length()) {
				if (two.length() > three.length()) {
					shorty = i + 2;
				} else {
					shorty = i + 1;
				}
			}
			shortestStrings[shortesStringsIndex] = strs[shorty];
			shortesStringsIndex += 1;
		}

		// return array
		return shortestStrings;
	}

	public static void main(String[] args) {

		// el primer paso is in spanish but this is english boy yeah
		String[] strs = new String[12];
		strs[0] = "el";
		strs[1] = "primer";
		strs[2] = "paso";
		strs[3] = "is";
		strs[4] = "in";
		strs[5] = "spanish";
		strs[6] = "but";
		strs[7] = "this";
		strs[8] = "is";
		strs[9] = "english";
		strs[10] = "boy";
		strs[11] = "yeah";

		ShortestStrings ss = new ShortestStrings();
		String[] shorties = ss.getShortest(strs);

		// el is is boy
		for (int i = 0; i < shorties.length; i++) {
			System.out.println(shorties[i]);
			;
		}

	}

}
