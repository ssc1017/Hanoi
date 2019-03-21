public class HanoiProblem {

    public static final int INIT_N = 8;
    public static void main(String[] args) {
        HanoiSolution hanoiSolution = new HanoiNonRecursiveSolution();
        hanoiSolution.solve(INIT_N);
        hanoiSolution.show();
    }

}