package acm;

import java.util.HashMap;
import java.util.Scanner;

public class test3 {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String string = scanner.nextLine();
			HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
			hMap.put('0',0);
			hMap.put('1',1);
			hMap.put('2',2);
			hMap.put('3',3);
			hMap.put('4',4);
			hMap.put('5',5);
			hMap.put('6',6);
			hMap.put('7',7);
			hMap.put('8',8);
			hMap.put('9',9);
			hMap.put('A',10);
			hMap.put('B',11);
			hMap.put('C',12);
			hMap.put('D',13);
			hMap.put('E',14);
			hMap.put('F',15);
			int ret = 0;
			for(int i = string.length()-1 ; i >= 2 ; i--) {
				char c = string.charAt(i);
				ret += Math.pow( 16 , string.length()-i-1)* hMap.get(c);
			}
			System.out.println(ret);
		}
	}
}
