package chapter1;

import cn.hutool.json.JSONUtil;

import java.util.Stack;

/**
 * @author lifei801984
 * @date 2021/12/13 15:42
 */
public class Q2_MyQueue {
    /**
     * 原始数据栈
     */
    private Stack<Integer> pushStack;
    /**
     * 辅助栈
     */
    private Stack<Integer> popStack;

    public Q2_MyQueue(Stack<Integer> pushStack, Stack<Integer> popStack) {
        this.pushStack = pushStack;
        this.popStack = popStack;
    }

    private void push2pop(){
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public void add(Integer data) {
        pushStack.push(data);
        push2pop();
    }

    public Integer poll() {
        push2pop();
        return popStack.pop();
    }

    public Integer peek() {
        push2pop();
        return popStack.peek();
    }

    public static void main(String[] args) {
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        Q2_MyQueue myStack = new Q2_MyQueue(pushStack, popStack);

        myStack.add(5);
        myStack.add(4);
        myStack.add(6);
        myStack.add(2);
        System.out.println(myStack.peek());
        System.out.println(JSONUtil.toJsonStr(myStack.pushStack));
        System.out.println(JSONUtil.toJsonStr(myStack.popStack));
        myStack.poll();
        System.out.println(JSONUtil.toJsonStr(myStack.pushStack));
        System.out.println(JSONUtil.toJsonStr(myStack.popStack));
        myStack.poll();
        System.out.println(JSONUtil.toJsonStr(myStack.pushStack));
        System.out.println(JSONUtil.toJsonStr(myStack.popStack));
        myStack.poll();
        System.out.println(JSONUtil.toJsonStr(myStack.pushStack));
        System.out.println(JSONUtil.toJsonStr(myStack.popStack));
    }
}
