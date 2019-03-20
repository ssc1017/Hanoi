public class HanoiRecursiveSolution implements HanoiSolution {

    public static final int INIT_N = 4;

    private void moveDisk(int n, char from, char to) {
        System.out.println("Move disk " + n + " from " + from + " to " + to);
    }

    /**
     * move disks from s to d through i
     * @param n disk number
     * @param s source
     * @param i intermediate
     * @param d destination
     */
    public void move(int n, char s, char i, char d){
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
        move(INIT_N, 'S', 'I', 'D');
    }

    @Override
    public void examine() {
        
    }

    public static void main(String[] args){
        HanoiRecursiveSolution hanoi = new HanoiRecursiveSolution();
        hanoi.solve(INIT_N);
    }

}