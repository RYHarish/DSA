package Questions;

import java.util.Stack;

public class NextGreaterElement {
    
    public static int[] NextGreaterElementinArray(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length -1; i >= 0; i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if(stack.empty()){
                result[i] = -1;
            }
            else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {5,6,7,2,5,6};
        int[] results = NextGreaterElementinArray(arr);
        for (int result: results){
            System.out.println(result);
        }
    }
}
