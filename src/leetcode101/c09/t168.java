package leetcode101.c09;

//168. Excel表列名称
//        给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//
//        例如：
//
//        A -> 1
//        B -> 2
//        C -> 3
//        ...
//        Z -> 26
//        AA -> 27
//        AB -> 28
//        ...

public class t168 {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            sb.append((char)(a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return sb.reverse().toString();
    }
}
