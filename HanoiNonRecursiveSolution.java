public class HanoiRecursiveSolution implements Hanoi {
 
    public static void main(String[] args){
        Hanoi h = new Hanoi();
        h.move(3, 'A', 'B', 'C');
    }

    public void move(int n,char a,char b,char c){
        if(n == 1){
            System.out.println("Disk "+n+" From "+a+" To "+b);
            System.out.println("Disk "+n+" From "+b+" To "+c);
        }else{
            move(n - 1,a,b,c);
            System.out.println("Disk "+(n)+" From "+a+" To "+b);
            move(n - 1,c,b,a);
            System.out.println("Disk "+(n)+" From "+b+" To "+c);
            move(n - 1,a,b,c);
        }
    }
}