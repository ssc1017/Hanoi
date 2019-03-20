import java.lang.Integer;
import java.util.Stack;

public class Peg {
    
    private Stack<Integer> stack;

    private char code;

    public Peg(char code) {
        stack = new Stack<>();
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public void push(Integer i) {
        stack.push(i);
    }

    public Integer pop() {
        return stack.pop();
    }

    public Integer peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }

    public void printAll() {
        for (Integer i : stack) {
            System.out.println(i);
        }
    }

}