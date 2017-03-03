package Homework_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create some strings
		ArrayList<String> strings = new ArrayList<String>();

		String str = "abcd";
		for (int x = 0; x < 5; x++) {
			strings.add(new String(str));
			str = new StringBuilder(str).reverse().toString();
		}
		
		try {
			FileOutputStream fileOut = new FileOutputStream("/Users/LuisaHernandez/Documents/jstrings");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(strings);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		ArrayList<String> istrings;
		try {
	         FileInputStream fileIn = new FileInputStream("/Users/LuisaHernandez/Documents/jstrings");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         istrings = (ArrayList<String>) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c) {
	         c.printStackTrace();
	         return;
	      }

		// print objects
		for(String istr: istrings){
			System.out.println(istr);
		}
	}

}
