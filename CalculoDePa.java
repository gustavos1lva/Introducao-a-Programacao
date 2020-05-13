import java.util.Scanner;

public class CalculoDePa {
    public static void main(String[] args) {
        System.out.println("Digite o a1, a razao e o ultimo valor da pa");
    Scanner s = new Scanner(System.in);
    ex7(s.nextInt(), s.nextDouble(), s.nextInt());
    }


    public static void ex7(int aONE, double RAZAO, int aN) {
        int n1 = (int) Math.ceil((aN - aONE + 1) / (RAZAO));
        System.out.println(n1);
        int pa = aONE;
        int N = 0;
        System.out.println("a1 = " + aONE);
        for (N = 1; N!= n1; N++){
            pa += RAZAO;
            System.out.println(pa);
        }
    }
}
