package LeetCodeJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem0022 {
    public static void main(String[] args) {
        print(generateParenthesis(3));
        print(generateParenthesis(1));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        int[] parenthesesRemainingCount1 = new int[]{n-1, n-1};
        int[] parenthesesRemainingCount2 = new int[]{n-1, n-1};
        Stack<String> stack = new Stack<>();
        stack.push("(");
        Stack<String> stack2 = new Stack<>();
        stack2.addAll(stack);
        backtrack(results, parenthesesRemainingCount1, "", "(", stack);
        backtrack(results, parenthesesRemainingCount2, "", ")", stack2);
        return results;
    }

    public static void backtrack(List<String> results, int[] parenthesesRemainingCount, String currentResult, String parentheses, Stack<String> stack) {
        // base case if n = 1
        if (parenthesesRemainingCount[0] == 0 && parenthesesRemainingCount[1] == 0 && parentheses == ")") {
            results.add("()");
            return;
        }
        currentResult += parentheses;
        Stack<String> copyStack = new Stack<>();
        copyStack.addAll(stack);
        String previousParentheses = "";
        if (copyStack.size() > 0) {
            previousParentheses = copyStack.peek();
        }
        if (previousParentheses == "(" && parentheses == ")") {
            copyStack.pop();
        } else {
            copyStack.push(parentheses);
        }
        if (parentheses == "(") {
            parenthesesRemainingCount[0]--;
        } else {
            parenthesesRemainingCount[1]--;
        }

        if (parenthesesRemainingCount[0] == 0 && parenthesesRemainingCount[1] == 0) {
            if (copyStack.size() == 1 && copyStack.peek() == "(") {
                results.add("("+currentResult+")");
                return;
            }
        }

        if (parenthesesRemainingCount[0] > 0) {
            backtrack(results, parenthesesRemainingCount, currentResult, "(", copyStack);
            parenthesesRemainingCount[0]++;
        }
        if (parenthesesRemainingCount[1] > 0) {
            backtrack(results, parenthesesRemainingCount, currentResult, ")", copyStack);
            parenthesesRemainingCount[1]++;
        }
    }

    public static void print(List<String> results) {
        System.out.printf("[%s]\n", String.join(",", results));
    }
}
