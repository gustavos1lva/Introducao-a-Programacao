import java.util.Scanner;

public class OperacoesComComplexos {
    public static void main(String[] args) {
        System.out.println("Codigos para operacoes: soma para soma, mult para multiplicacao, div para divisao, sub para subtracao e conj para conjugado");
        System.out.println("Que tipo de operacao voce realizara?");
        Scanner ops = new Scanner(System.in);
        String opr = ops.nextLine();

        String so = "soma";
        String m = "mult";
        String d = "div";
        String s = "sub";
        String cj = "conj";


        System.out.println("Operacao selecionada: " + opr);

        if (opr.equals(so)){
            somaa();
        } else if (opr.equals(m)) {
            mult();
        } else if (opr.equals(d)){
            div();
        } else if (opr.equals(s)) {
            sub();
        } else if (opr.equals(cj)) {
            System.out.println("Voce quer saber o conjugado de 1 ou 2 numeros?");
            Scanner cc = new Scanner(System.in);
            conj(cc.nextInt());
        } else System.out.println("Valor inserido invalido, tente novamente.");
        }

        public static int somaa(){

            String[] N = num();
            String[] NI = num1();

            /* soma da parte real */
            int a = Integer.valueOf(N[0]);
            int j = Integer.valueOf(NI[0]);
            int soma = a + j;
            String res1 = String.valueOf(soma);

            /* soma do numero da parte imaginaria */
            int l = Integer.valueOf(N[1]);
            int r = Integer.valueOf(NI[1]);
            int sum = l + r;
            String res = String.valueOf(sum);

            /* resultado final */
            System.out.println("O resultado da soma e: " + res1 + " + " + res + N[2]);
        return 0;}

        public static String[] num(){
            /* Primeiro numero */
            String[] N = new String[3];
            System.out.println("Insira abaixo a parte real, depois o número que multiplica i e depois i");
            Scanner c = new Scanner(System.in);

            for (int i = 0; i < 1; i++) {

                N[0] = String.valueOf(Integer.valueOf(c.nextLine()));
                N[1] = String.valueOf(Integer.valueOf(c.nextLine()));
                N[2] = c.nextLine();
                System.out.println(N[0]);
                System.out.println(N[1]);
                System.out.println(N[2]);
            }
            String num1 = N[0] + "+" + N[1] + N[2];
            System.out.println("O numero 1 e " + num1);

        return N;
    }

        public static String[] num1(){

                /* Segundo numero */

            String[] NI = new String[3];

            System.out.println("Insira abaixo a parte real, depois o número que multiplica i e depois i");
            Scanner b = new Scanner(System.in);

            for (int s = 0; s < 1; s++) {

                NI[0] = String.valueOf(Integer.parseInt(b.nextLine()));
                NI[1] = String.valueOf(Integer.parseInt(b.nextLine()));
                NI[2] = b.nextLine();
                System.out.println(NI[0]);
                System.out.println(NI[1]);
                System.out.println(NI[2]);
            }
            String num2 = NI[0] + "+" + NI[1] + NI[2];
            System.out.println("O numero 2 e " + num2);

        return NI;}

        public static String mult() {
            String[] N = num();
            String[] NI = num1();

            // 1 + 2i * 2 + 1i
            // 2 + 1i + 4i - 2

            //distributiva
            int a = Integer.valueOf(N[0]);
            int b = Integer.valueOf(N[1]);
            int a1 = Integer.valueOf(NI[0]);
            int b1 = Integer.valueOf(NI[1]);
            int mtr = (a * a1) + (b * (b1 * (-1)));
            int mti = (a * b1) + (b * a1);
            String rREAL = String.valueOf(mtr);
            String rIMG = String.valueOf(mti);

            System.out.println("O resultado da multiplicacao e " + mtr + "+" + mti+"i");

        return rREAL;
    }
        public static String conj(int n){
            String[] N = num();

        /*para se obter o conjugado de um numero complexo inverte-se o sinal da parte imaginaria*/

            int a = Integer.valueOf(N[0]);
            int b = Integer.valueOf(N[1]);
            int con = b * (-1);
            String rCC = String.valueOf(con);
            if (n==2) {
                String[] NI = num1();
                int aa = Integer.valueOf(NI[0]);
                int bb = Integer.valueOf(NI[1]);
                int conn = bb * (-1);
                String rC = String.valueOf(conn);
                String rr = NI[0];
                String ri = rC + NI[2];
                System.out.println("O conjugado do complexo 2 e: " + NI[0] + conn+NI[2]);
            }

            System.out.println("O conjugado do complexo 1 e: " + N[0] + con+N[2]);

 return rCC;
            }
        public static String[] conjdv(){
                String[] NI = num1();

                int aa = Integer.valueOf(NI[0]);
                int bb = Integer.valueOf(NI[1]);
                int conn = bb * (-1);
                String rC = String.valueOf(conn);
                String rr = NI[0];
                String ri = rC + NI[2];
                System.out.println("O conjugado do complexo e: " + NI[0] + conn+NI[2]);
                String jj = NI[0];
                String gg = NI[1];
                String ii = NI[2];

            String[] ab = new String[]{ri,rC,jj,gg,ii};
            return  ab;
    }

        public static String div(){
            System.out.println("Insira o dividendo");
            String[] N = num();

            System.out.println("Insira o divisor");
            String[] ab = conjdv();
            /* pra realizar a divisao vamos precisar multiplicar */
            //parte do dividendo
            int a = Integer.valueOf(N[0]);
            int b = Integer.valueOf(N[1]);
            int a1 = Integer.valueOf(ab[2]);
            int b1 = Integer.valueOf(ab[1]);
            int mtr = (a * a1) + ((b * b1) * (-1));
            int mti = (a * b1) + (b * a1);
            String rREAL = String.valueOf(mtr);
            String rIMG = String.valueOf(mti);
            System.out.println("O resultado da multiplicacao e " + mtr + "+" + mti+"i");

            //parte do divisor

            int ac = Integer.valueOf(ab[2]);
            int bc = Integer.valueOf(ab[3]);
            int mtc = (ac * a1) + ((bc * b1) * (-1));
            int mtcc = (ac * b1) + (bc * a1);
            System.out.println("O resultado da multiplicacao e " + mtc + "+" + mtcc+"i");

            // System.out.println("O divisor e: " + ab[1] + "+" + ab[2]);

            System.out.println("O resultado da divisao e: " + mtr + "+" + mti+"i" + "/" + mtc + "+" + mtcc+"i");
            return "i";
    }
        public static String sub(){
            String[] N = num();
            String[] NI = num1();

            /* sub da parte real */
            int a = Integer.valueOf(N[0]);
            int j = Integer.valueOf(NI[0]);
            int sub = a - j;
            String res1 = String.valueOf(sub);

            /* soma do numero da parte imaginaria */
            int l = Integer.valueOf(N[1]);
            int r = Integer.valueOf(NI[1]);
            int subb = l - r;
            String res = String.valueOf(subb);

            /* resultado final */
            System.out.println("O resultado da subtracao e: " + res1 + " + " + res + N[2]);
            return res;
        }
}


