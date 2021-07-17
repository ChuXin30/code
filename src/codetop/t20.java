package codetop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class t20 {
    public static boolean isValid(String s) {
        int n = s.length();
        Deque<Character> stack = new LinkedList<Character>();
        for(int i = 0 ; i < n ; i++ ){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')stack.push(c);
            else if(!stack.isEmpty()){
                if(c == ')' &&   stack.peek() != '(' )return false;
                if(c == ']' &&   stack.peek() != '[' )return false;
                if(c == '}' &&   stack.peek() != '{' )return false;
                stack.pop();
            }else{
                return false;
            }
        }
        if(stack.isEmpty())return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid( "()[]{}"));
        System.out.println(isValid( "(]"));

    }
}
