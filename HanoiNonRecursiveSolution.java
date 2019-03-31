public class HanoiNonRecursiveSolution implements HanoiSolution {

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

    private void moveDisk(Peg from, Peg to) {
        System.out.println("Step " + cnt++ + " Move disk " + from.peek() + " from " + from.getCode() + " to " + to.getCode());
        to.push(from.pop());
    }

    /**
     * compare the top of peg1 and the top of peg 2 and put the smaller one onto the top of the peg with the bigger one
     */
    private void exchange(Peg peg1, Peg peg2) {
        if (!peg1.empty() && !peg2.empty()) {
            if (peg1.peek() > peg2.peek()) {
                moveDisk(peg2, peg1);
            } else {
                moveDisk(peg1, peg2);
            }
        } else if (peg1.empty() && !peg2.empty()) {
            moveDisk(peg2, peg1);
        } else if (!peg1.empty() && peg2.empty()) {
            moveDisk(peg1, peg2);
        }
    }

    /**
     * exchange S - I I - D S - I D - I repeatedly 3 ^ n - 1 times
     */
    @Override
    public void solve(int n) {
        if (n <= 0){
            throw new IllegalArgumentException("n must be > 0");
        }
        initialization(n);
        // total steps 3 ^ n - 1
        double total = Math.pow(3, n) - 1;
        for (int i = 0;;) {
            exchange(S, I);
            if (i++ >= total) break;
            exchange(I, D);
            if (i++ >= total) break;
            exchange(S, I);
            if (i++ >= total) break;
            exchange(D, I);
            if (i++ >= total) break;
        }
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