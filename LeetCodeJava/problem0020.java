package LeetCodeJava;

import java.util.*;

public class problem0020 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));      // should return true
        System.out.println(isValid("[}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> parenthesesStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if (parenthesesStack.empty()) {
                parenthesesStack.push(s.charAt(i));
                continue;
            }

            Character currentTopParentheses = parenthesesStack.peek();
            if (currentTopParentheses == '(') {
                if (s.charAt(i) == ')') {
                    parenthesesStack.pop();
                } else {
                    parenthesesStack.push(s.charAt(i));
                }
            } else if (currentTopParentheses == '{') {
                if (s.charAt(i) == '}') {
                    parenthesesStack.pop();
                } else {
                    parenthesesStack.push(s.charAt(i));
                }
            } else if (currentTopParentheses == '[') {
                if (s.charAt(i) == ']') {
                    parenthesesStack.pop();
                } else {
                    parenthesesStack.push(s.charAt(i));
                }
            }
        }

        return parenthesesStack.empty();
    }
}
