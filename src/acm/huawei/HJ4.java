package acm.huawei;

import java.util.Scanner;


public class HJ4 {
	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String string = sc.nextLine();
			int n = string.length();
			int i = 0;
			for( i = 0 ; i < n; i++ ) {
				System.out.print(string.charAt(i));
				if((i+1)%8 == 0 )System.out.println();
			}
			if(n%8 != 0) {
				for(int j = n ; j < ((n/8)+1)*(8) ; j++) {
					System.out.print(0);
				}
				System.out.println();
			}
			//System.out.print(string.substring(i, n));
//			for(int j = n ; j < (n/8) ; j++) {
//				System.out.print(0);
//			}
//			System.out.println();
//			System.out.println("n="+n+"\ti="+i);

		}
	}
}
