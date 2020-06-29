package D202006;

import java.util.Stack;

/**
 * @Author UGcris
 * @date 2020/6/30
 **/
public class CQueue {
    Stack<Integer> temp;
    Stack<Integer> stack;

    public CQueue() {
        this.temp = new Stack<>();
        this.stack = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (stack.empty()) {
            return -1;
        }
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        int ans = temp.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return ans;
    }
}
