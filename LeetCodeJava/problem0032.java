package LeetCodeJava;

import java.util.Stack;

public class problem0032 {
    public static void main(String[] args) {
        // System.out.println(longestValidParentheses("(()"));
        // System.out.println(longestValidParentheses(")()())"));
        // System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()(()"));
        // System.out.println(longestValidParentheses("(()"));
        // System.out.println(longestValidParentheses("())"));
        // System.out.println(longestValidParentheses(")()())"));
    }

    // still not complete solution
    public static int longestValidParentheses(String s) {
        int longestValidCount = 0;
        Stack<Character> parenthesesStack = new Stack<>();
        boolean isValidCounting = false;
        int currentValidCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if (parenthesesStack.isEmpty()) {
                parenthesesStack.push(s.charAt(i));
                // isValidCounting = false;
            } else {
                Character topCharacter = parenthesesStack.peek();
                if (topCharacter == '(' && s.charAt(i) == ')') {
                    parenthesesStack.pop();
                    currentValidCount++;
                    isValidCounting = true;
                } else {
                    parenthesesStack.push(s.charAt(i));
                    if (s.charAt(i) != '(') {
                        isValidCounting = false;   
                    }
                }
            }

            if (!isValidCounting && currentValidCount > 0) {
                if (longestValidCount < currentValidCount * 2) {
                    longestValidCount = currentValidCount * 2;
                }
                currentValidCount = 0;
            }
        }

        if (isValidCounting) {
            if (longestValidCount < currentValidCount * 2) {
                longestValidCount = currentValidCount * 2;
            }
        }

        return longestValidCount;
    }

    // this solution only check "()()" not "(())"
    public static int longestValidParentheses1(String s) {
        int validCount = 0;
        boolean isLeftParentheses = false;
        for(int i = 0; i < s.length(); i++) {
            if (isLeftParentheses && s.charAt(i) == ')') {
                validCount += 2;
                isLeftParentheses = false;
                continue;
            }
            if (s.charAt(i) == '(') {
                isLeftParentheses = true;
            }
        }
        return validCount;
    }
}