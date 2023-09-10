package org.mudit.stack;

import java.util.Stack;

/**
 * Write a method to recursively check whether an equation has a balanced number
 * of left and right parentheses and brackets - (including (,),[,],{,}).
 * <p>
 * Examples:
 * <br>
 * isBalanced("() [] ()") ==> true
 * <br>
 * isBalanced("([)]") ==> false
 */
public class BalancedParentheses {

    public static void main(String[] args) {
        System.out.println(isBalanced("[] () {{( )}}"));

    }

    public static boolean isBalanced(String input) {
        if (input.length() == 1) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for (char c : input.toCharArray()) {
            if (st.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            }
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
                continue;
            }
            if (c == ')' && st.peek() == '(') {
                st.pop();
            }
            if (c == ']' && st.peek() == '[') {
                st.pop();
            }
            if (c == '}' && st.peek() == '{') {
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
