package mianshi.tensent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class test {


    ArrayList[] f(int[] num ){
        HashMap<Integer , Integer> hashMap = new HashMap<>();
        int n = num.length;
        for (int i = 0 ; i < n ; i++ ){
            hashMap.put( num[i] , hashMap.getOrDefault(num[i] , 0) +1 );
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for( int i = 1 ; i < n;  i++ ){
            if(!hashMap.containsKey(i)) arrayList.add(i);
        }

        return (ArrayList[]) arrayList.toArray();
    }

    public static void main(String[] args) {


    }

}
