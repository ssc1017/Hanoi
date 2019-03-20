public class HanoiRecursiveSolution {

    public static final int INIT_N = 4;

    /**
     * move disks from s to d through i
     * @param n disk number
     * @param s source peg
     * @param i intermediate peg
     * @param d destination peg
     */
    public void move(int n, char s, char i, char d){
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }
        if (n == 1) {
            System.out.println("Disk " + n + " From " + s + " To " + i);
            System.out.println("Disk " + n + " From " + i + " To " + d);
        } else {
            move(n - 1, s, i, d);
            System.out.println("Disk " + n + " From " + s + " To " + i);
            move(n - 1, d, i, s);
            System.out.println("Disk " + n + " From " + i + " To " + d);
            move(n - 1, s, i, d);
        }
    }

    public static void main(String[] args){
        HanoiRecursiveSolution hanoi = new HanoiRecursiveSolution();
        hanoi.move(INIT_N, 'S', 'I', 'D');
    }

}