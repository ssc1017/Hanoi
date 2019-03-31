public class HanoiRecursiveSolution implements HanoiSolution {

    private int cnt;

    private Peg S;

    private Peg I;
    
    private Peg D;

    private void initialization(int n) {
        cnt = 1;
        S = new Peg('S');
        I = new Peg('I');
        D = new Peg('D');
        for (int i = n; i > 0; i--) {
            S.push(i);
        }
    }

    private void moveDisk(int n, Peg from, Peg to) {
        System.out.println("Step " + cnt++ + " Move disk " + from.peek() + " from " + from.getCode() + " to " + to.getCode());
        to.push(from.pop());
    }

    /**
     * move disks from s to d through i
     * @param n disk number
     * @param s source
     * @param i intermediate
     * @param d destination
     */
    private void move(int n, Peg s, Peg i, Peg d) {
        if (n == 1) {
            moveDisk(n, s, i);
            moveDisk(n, i, d);
        } else {
            move(n - 1, s, i, d);
            moveDisk(n, s, i);
            move(n - 1, d, i, s);
            moveDisk(n, i, d);
            move(n - 1, s, i, d);
        }
    }

    @Override
    public void solve(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }
        initialization(n);
        move(n, S, I, D);
    }

    @Override
    public void show() {
        System.out.println("\nThe result is:");
        while (!S.empty() || !I.empty() || !D.empty()) {
            if (!S.empty()) {
                System.out.print(S.pop());
            } else System.out.print("\t");
            if (!I.empty()) {
                System.out.print(I.pop());
            } else System.out.print("\t");
            if (!D.empty()) {
                System.out.print(D.pop() + "\n");
            } else System.out.print("\n");
        }
        System.out.println(S.getCode() + "\t" + I.getCode() + "\t" + D.getCode());
    }

}