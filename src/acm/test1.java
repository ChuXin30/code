package acm;

import java.util.Scanner;

public class test1 {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			if(n == 0 )break;
			int count = 0;
			while(n >= 2 ) {
				count += n/3;
				if(n==2) {
					count++;
					break;
				}
				n = n/3 + n%3;
			}
			System.out.println(count);
		}
	}
}
