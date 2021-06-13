package leetcode101.c03;

public class t680 {

    public boolean validPalindrome1(String s , int l , int r){
        while (l <= r){
            if(s.charAt(l) != s.charAt(r))return false;
            else{
                l++;
                r--;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while ( l <= r ){
            if(s.charAt(l) == s.charAt(r)){
                l++;r--;
            }else {
                return validPalindrome1(s , l+1 , r) || validPalindrome1(s , l , r-1);
            }
        }
        return true;
    }

    public void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }
}
