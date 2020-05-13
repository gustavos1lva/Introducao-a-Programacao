public class Lista_2 {
    public static void main(String[] args) {

        /*

        //testando ex2
        ex2(3, 5);

        //testando ex3 em 2 casos
        ex3(1);

        ex3(11);

        //testando ex4
        ex4(1, 3, 10);
        ex4(0, 3, 10);
        ex4(3, 3, 10);

        //testando ex5
        ex5(1299, 0);
        ex5(1299, 1);
        ex5(1299, 2);

        //testando ex6
        ex6(10,2,9);
        ex6(10,25,19);
        ex6(39, 13, 54);

        //testando ex7
        ex7(0, 50);
        ex7(1,50);
        ex7(3,50);

        //testando ex8

        //testando ex9

        //testando ex10

        //testando ex11
        ex11(5,10);
        ex11(5,2);

        */

        //testando ex12
        ex12(5,3,4);
        ex12(3,5,4);
        ex12(4,3,5);
        ex12(5,5,5);

    }
    public static void ex2(int a, int b){
        int c = 0;
        if (0<a&&a<b) {c = 0;

            System.out.println("it worked!" + "\n");};
    }
    public static void ex3(int var){
        if(var<4 || var>10){
            System.out.println("fora" + "\n");
        }
    }
    public static void ex4(int pgto, double hr, double vlhr){
        /*Pagamento antecipado = 1
          Pagamento no prazo = 0
         */
        double noprazo = (hr * vlhr);
        double adiantado = (noprazo-(0.07*noprazo));

        System.out.println("Calculo da sua mensalidade");


        if (pgto==1) {
            System.out.println("Voce escolheu pagar antecipado.");
            System.out.println("O valor final e: "+adiantado);
        }

        if (pgto==0) {
            System.out.println("Pagamento dentro do prazo.");
            System.out.println("O valor final e " +noprazo);
        }

        if (pgto!=0 && pgto!=1){
            System.out.println("Voce digitou um tipo de pagamento invalido, favor digitar um valor valido: 0 ou 1." + "\n");
        } else System.out.println("Obrigado por escolher a Academia X" + "\n");
    }
    public static void ex5(double precoF, int opc){
        /*Pagamento a vista = 0
          Pagamento parcelado 2x = 1
          Pagamento parcelado 3x = 2
         */
        System.out.println("Calculo do preco do seu produto." + "\n");

        if (opc==0){
            System.out.println("Voce escolheu pagar a vista, o valor final e: " +precoF);
        }

        if (opc==1){
            double precoF2x = precoF + (0.10*precoF);
            System.out.println("Voce escolheu parcelar em 2 vezes, o valor final e: " +precoF2x);
        }

        if (opc==2){
            double precoF3x = precoF + (0.20*precoF);
            System.out.println("Voce escolheu parcelar em 3 vezes, o valor final e: " +precoF3x);
        }

        if (opc!=1 && opc!=2){
            System.out.println("Opcao de compra invalida." + "\n");
        } else System.out.println("Obrigado por comprar conosco, volte sempre." + "\n");
    }

    public static void ex6(int a, int b, int c) {
        if (a>b && a>c) {
            System.out.println("O maior inteiro da lista e: " + a + "\n");
        } else if (b>a && b>c) {
            System.out.println("O maior inteiro da lista e: "  + b + "\n");
        } else System.out.println("O maior inteiro da lista e: " + c + "\n");
    }

    public static void ex7(int tipo, double grau){
        //Celsius para Fahrenheit
        if (tipo==0){
            double tempC = ((grau - 32)*100)/180;
            System.out.println("A temperatura " +grau+ " Fahrenheit convertida para Celsius e: " +tempC+ "\n");
        } else if (tipo==1){
            double tempF = ((180*grau)/100) + 32;
            System.out.println("A temperatura " +grau+ " Celsius convertida para Fahrenheit e: " +tempF+ "\n");
        } else System.out.println("Tipo inválido." + "\n");
    }

    public static void ex8(int dia1, int mes1, int ano1, int dia2, int mes2, int ano2){
        if (ano1>ano2) {
            System.out.println("");
        }
    }

    public static void ex9(double pe, double jarda, double milha, double polegada){
    }

    public static void ex10(){

    }

    public static void ex11(int x, int y){
        double div = y%x;
        boolean resto = div==0;
        if (resto == true) {
            System.out.println(resto +"\n");
        } else System.out.println("Y nao e divisor de X, o resto e: " +div+ "\n");
    }

    public static void ex12(int z, int v, int n){
        System.out.println("E triangulo?? \n");
        boolean zh = z>v && z>n;
        boolean vh = v>z && v>n;
        boolean nh = n>z && n>v;
        if (zh == true){
            System.out.println("Z e a hipotenusa" + "\n");
            boolean quad = Math.pow(z,2) == Math.pow(v,2) + Math.pow(n,2);
            System.out.println(quad);
        } else if (vh == true){
            System.out.println("V e a hipotenusa" + "\n");
            boolean quad = Math.pow(v,2) == Math.pow(z,2) + Math.pow(n,2);
            System.out.println(quad);
        } else if (nh == true){
            System.out.println("N e a hipotenusa" + "\n");
            boolean quad = Math.pow(n,2) == Math.pow(z,2) + Math.pow(v,2);
            System.out.println(quad);
    } else System.out.println(zh);
}

}
