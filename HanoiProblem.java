public class HanoiProblem {

    public static final int INIT_N = 2;

    public static void main(String[] args) {
        HanoiSolution hanoiSolution = new HanoiNonRecursiveSolution();  // either HanoiNonRecursiveSolution or HanoiRecursiveSolution
        hanoiSolution.solve(INIT_N);
        hanoiSolution.show();
    }

}