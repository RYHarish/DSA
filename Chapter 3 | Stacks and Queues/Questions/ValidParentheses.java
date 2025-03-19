package Questions;

import java.util.Stack;

public class ValidParentheses {
    public static boolean balancedBrackets(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '('|| c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    char top = stack.peek();
                    if((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}') ){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("{({[[()]]})}"));
    }
}


