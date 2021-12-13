package chapter1;

import cn.hutool.json.JSONUtil;

import java.util.Stack;

/**
 * @author lifei801984
 * @date 2021/12/13 16:31
 */
public class Q3_ReverseStack {

    private Integer getAndRemoveLastElement(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            Integer last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(JSONUtil.toJsonStr(stack));
        Q3_ReverseStack reverseStack = new Q3_ReverseStack();
        reverseStack.reverse(stack);
        System.out.println(JSONUtil.toJsonStr(stack));
    }
}
