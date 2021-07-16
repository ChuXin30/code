package test;

import java.util.ArrayList;

public class t2 {


    public static ArrayList<Integer> f(int[] nums){
        int n = nums.length;
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++ ){
//            int p = nums[i];
//            System.out.println("i="+i+"p="+p);
            boolean flag = false;
            while( i != (nums[i]-1) ){
                System.out.println("i="+i+"  num[i]-1 = "+(nums[i]-1));
                if(nums[i] == nums[nums[i] - 1]){
                    array.add(nums[i]);
//                    swap( nums , i , nums[i] -1 );
                    flag = true;
//                    break;
                }
                if(flag){

                }else {
                    swap( nums , i , nums[i] -1 );
                }
                for(int x:nums) System.out.print(x+" ");
                System.out.println();
            }
            for(int x:nums) System.out.print(x+" ");
            System.out.println();
        }
//        for (int i = 0 ; i < array.size() ; i++ ) System.out.println(array.indexOf(i));

        return array;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] arr = {4,3,2,7,8,2,3,1};
        ArrayList<Integer> array = f(arr);

        for (int i = 0 ; i < array.size() ; i++ ) System.out.println(array.indexOf(i));
//        System.out.println(f(arr).toString());


    }
}


//import java.util.ArrayList;
//        import java.util.Scanner;
//public class Main {
//    public static ArrayList<Integer> f(int[] nums){
//        int n = nums.length;
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        for(int i = 0 ; i < n ; i++ ){
////            int p = nums[i];
////            System.out.println("i="+i+"p="+p);
//            while( i != nums[i]-1 ){
//                System.out.println("i="+i);
//                if(nums[i] == nums[nums[i] - 1]){
//                    array.add(nums[i]);
//                }
//                swap( nums , i , nums[i] -1 );
//            }
//        }
//        for (int i = 0 ; i < array.size() ; i++ ) System.out.println(array.indexOf(i));
//
//        return array;
//    }
//
//    public static void main(String[] args) {
//        //Scanner in = new Scanner(System.in);
//        //int a = in.nextInt();
//        //System.out.println(a);
//        int[] arr = {4,3,2,7,8,2,3,1};
//        ArrayList<Integer> array = f(arr);
//
//        System.out.println(array.toString());
//
//
//    }
//}