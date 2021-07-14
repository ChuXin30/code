package mianshi;

public class shein_1 {

     static String changespaceto20(String str) {
        // write code here
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        for(int i = 0 ; i < length ; i++ ){
            char c = str.charAt(i);
            if(c == ' ')sb.append("%20");
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(changespaceto20("a  b    c"));

    }
}
