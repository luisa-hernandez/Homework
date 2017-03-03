package Homework2;

public class IsReversed {

	//TODO -- ignore whitespace, ignore capitalization
	public boolean areReversed(String sOne, String sTwo) {
		// are they the same length?
		char[] one = sOne.toCharArray();
		char[] two = sTwo.toCharArray();
		
		if (one.length != two.length) {
			return false;
		}

		// check every character
		for (int i = 0; i < one.length; i++) {
			char o = one[i];
			char t = two[one.length - i - 1];

			if (o != t) {
				// not a match!
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		
		String uno = "uno";
		String otro = "onu";
		
		String purple = "purple";
		String urp = "elprup";
		String purp2 = "purple";

		
		IsReversed ir = new IsReversed();
		
		System.out.println(ir.areReversed(uno, otro));
		System.out.println(ir.areReversed(uno, purple));
		System.out.println(ir.areReversed(purple, urp));
		System.out.println(ir.areReversed(purple, purp2));

	}

}
