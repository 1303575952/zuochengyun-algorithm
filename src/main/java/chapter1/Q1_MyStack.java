package chapter1;

import cn.hutool.json.JSONUtil;

import java.util.Stack;

/**
 * @author lifei801984
 * @date 2021/12/13 14:48
 */

/**
 * 除了下述方法，还有另一种方法：保证dataStack和minStack大小保持一致，pop的时候从minStack直接取数即可，不需要两栈栈顶元素对比
 */
public class Q1_MyStack {
    /**
     * 无特殊处理的栈
     */
    private Stack<Integer> dataStack;
    /**
     * 存放最小数据的栈
     */
    private Stack<Integer> minStack;

    public Q1_MyStack(Stack<Integer> dataStack, Stack<Integer> minStack) {
        this.dataStack = dataStack;
        this.minStack = minStack;
    }

    public void push(Integer data) {
        //如果要放入的数据小于等于minStack栈顶数据则放入
        if (minStack.isEmpty() || minStack.peek() >= data) {
            dataStack.push(data);
            minStack.push(data);
            return;
        }
        dataStack.push(data);
    }

    public Integer pop() {
        if (dataStack.isEmpty()) {
            return null;
        }
        if (dataStack.peek() > minStack.peek()) {
            return dataStack.pop();
        }
        if (dataStack.peek().equals(minStack.peek())) {
            minStack.pop();
            return dataStack.pop();
        }
        //其他情况不可能存在
        return null;
    }

    public Integer getMin() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        Q1_MyStack myStack = new Q1_MyStack(dataStack, minStack);

        myStack.push(5);
        myStack.push(4);
        myStack.push(6);
        myStack.push(2);
        System.out.println(myStack.getMin());
        System.out.println(JSONUtil.toJsonStr(myStack.dataStack));
        System.out.println(JSONUtil.toJsonStr(myStack.minStack));
        myStack.pop();
        System.out.println(JSONUtil.toJsonStr(myStack.dataStack));
        System.out.println(JSONUtil.toJsonStr(myStack.minStack));
        myStack.pop();
        System.out.println(JSONUtil.toJsonStr(myStack.dataStack));
        System.out.println(JSONUtil.toJsonStr(myStack.minStack));
    }
}
