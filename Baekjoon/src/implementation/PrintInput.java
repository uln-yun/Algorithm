package implementation;

import java.util.Scanner;

public class PrintInput {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}
}
