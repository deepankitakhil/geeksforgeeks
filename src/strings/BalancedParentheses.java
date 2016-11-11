package strings;

import java.util.Stack;

/**
 * Created by Deepankit on 10/16/2016.
 */
public class BalancedParentheses {
    public static void main(String[] args) {
        BalancedParentheses balancedParentheses = new BalancedParentheses();
        System.out.println(balancedParentheses.isBalancedParethesis("([][][])()()()[][][[[[{(((())))}]]]]()()"));
    }

    private boolean isBalancedParethesis(String input) {
        Stack<Character> stack = new Stack();
        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) == '{' || input.charAt(index) == '[' || input.charAt(index) == '(')
                stack.push(input.charAt(index));

            else if (!stack.isEmpty() && input.charAt(index) == '}' && stack.peek() == '{')
                stack.pop();
            else if (!stack.isEmpty() && input.charAt(index) == ']' && stack.peek() == '[')
                stack.pop();
            else if (!stack.isEmpty() && input.charAt(index) == ')' && stack.peek() == '(')
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();

    }
}
