package acm;

import java.util.HashMap;
import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String c = scanner.nextLine();
        HashMap<Character , Integer> hashMap = new HashMap<>();
        int length = str.length();
        for (int i = 0 ; i < length ; i++ ){
            char c1 = str.charAt(i);
            if(c1 >= 'A' && c1 <= 'Z')hashMap.put( (char)(c1-'A'+'a') , hashMap.getOrDefault((char)(c1-'A'+'a') , 0) +1 );
            else  hashMap.put( c1 , hashMap.getOrDefault(c1 , 0)+1);
        }

        if(c.charAt(0) >= 'A' && c.charAt(0) <= 'Z' && hashMap.containsKey((char)(c.charAt(0)-'A'+'a')))  System.out.println(hashMap.get((char)(c.charAt(0)-'A'+'a')));
        else if(hashMap.containsKey(c.charAt(0)) ) System.out.println(hashMap.get(c.charAt(0)));
        else System.out.println(0);

    }
}
