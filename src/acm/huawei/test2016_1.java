package acm.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class test2016_1 {
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String string = scanner.nextLine();
			HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
			for(int i = 0 ;  i < string.length() ; i++) {
				char c = string.charAt(i);
				hMap.put(c, 1);
//				if(hMap.containsKey(c)) {
//					hMap.put(c, hMap.get(c)+1);
//				}else {
//					hMap.put(c, 1);
//				}
			}
			for(int i = 0 ; i < string.length() ; i++) {
				char c = string.charAt(i);
				if(hMap.get(c) == 1) {
					System.out.print(c);
					hMap.put(c, 0);
				}
			}

			System.out.println();
		}
	}
}
