import java.util.Stack;
import java.lang.Integer;

public class HanoiNonRecursiveSolution implements HanoiSolution {

    private Peg S = new Peg('S');

    private Peg I = new Peg('I');
    
    private Peg D = new Peg('D');

    public static final int INIT_N = 4;

    public void moveDisk(Peg from, Peg to) {
        System.out.println("Move disk " + from.peek() + " from " + from.getCode() + " to " + to.getCode());
        to.push(from.pop());
    }

    public void exchange(Peg stack1, Peg stack2) {
        if (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek() > stack2.peek()) {
                moveDisk(stack2, stack1);
            } else {
                moveDisk(stack1, stack2);
            }
        } else if (stack1.empty() && !stack2.empty()) {
            moveDisk(stack2, stack1);
        } else if (!stack1.empty() && stack2.empty()) {
            moveDisk(stack1, stack2);
        }
    }

    @Override
    public void solve(int n) {
        if (n <= 0){
            throw new IllegalArgumentException("n must be > 0");
        }

        // initialization all disks
        for (int i = n; i > 0; i--) {
            S.push(i);
        }

        for (int i = 0; i < Math.pow(3, n) - 1;) { //循环3^n - 1
            exchange(S, I);
            i++;
            if (i >= Math.pow(3, n)) break;
            exchange(I, D);
            i++;
            if (i >= Math.pow(3, n)) break;
            exchange(S, I);
            i++;
            if (i >= Math.pow(3, n)) break;
            exchange(D, I);
            i++;
            if (i >= Math.pow(3, n)) break;
        }
    }

    @Override
    public void examine() {
        D.printAll();
    }

    /**
     * keep exchanging S - I I - D S - I D - I until complete 
     */
    public static void main(String[] args) {
        HanoiNonRecursiveSolution hanoi = new HanoiNonRecursiveSolution();
        hanoi.solve(INIT_N);
        hanoi.examine();
    }
}