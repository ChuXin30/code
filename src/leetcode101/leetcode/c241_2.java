package leetcode101.leetcode;

public class c241_2 {


    public int minSwaps(String s) {
        int num_0 = 0;
        int num_1 = 0;
        for(int i = 0 ; i < s.length() ; i++ ){
            if(s.charAt(i) == '0')num_0++;
            else num_1++;
        }
        if( (num_0-num_1)<=-2 || (num_0-num_1)>=2 )return -1;
        int count = 0;
        char[] str = new char[s.length()];

        for(int i = 0 ; i < s.length() ; i++){
            str[i] = s.charAt(i);
        }

        int dp[][] = new int[2][str.length];
        int n = str.length;
        for(int i = 1 ; i < n ; i++ ){

        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
