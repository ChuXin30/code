package leetcode101.leetcode;

public class t231 {
    public static boolean isPowerOfTwo(int n) {
        if(n == 0)return false;
        if(n == 1)return true;
        while (n != 1){
            if(n %2 != 0)return  false;
            n = n/2;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2) );
    }
}
