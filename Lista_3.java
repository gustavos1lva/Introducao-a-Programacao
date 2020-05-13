public class Lista_3 {
    public static void main(String[] args) {
        ex5();
        ex6();
    }

    public static void ex5() {
        int x = 0;
        int soma = 0;
        int aux = 0;
        int i = 0;
        do {
            if (x % 2 == 0) {
                soma += x;
                System.out.println(aux + "+" + x + "=" + soma);
                aux = soma;
                i++;
                System.out.println(i);
            }
            x++;
        } while (i != 11);
    }

    public static void ex6() {
        double x = 1;
        int i = 1;
        double cubo = 0;
        do {
            cubo = Math.pow(x,3);
            System.out.println(cubo);
            i++;
            x++;
        } while(i !=10);
    }
}
