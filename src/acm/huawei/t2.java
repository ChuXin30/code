package acm.huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class t2 {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
//			String string = scanner.nextLine();
			
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int x = scanner.nextInt();
			
			
			LinkedList<String> lStrings = new LinkedList<String>();
			LinkedList<String> nStrings = new LinkedList<String>();
			
//			System.out.println("m="+m+"\tn="+n+"\tx="+x);
			for(int i = 0 ; i < m ; i++) {
				String string = scanner.nextLine();
//				System.out.println(string);

				lStrings.add(string) ;
			}
			for(int i = 0 ; i < n ; i++) {
				String string = scanner.nextLine();
//				System.out.println(string);

				nStrings.add(string) ;
			}
			System.out.println(false);
		}
}
