/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   <2020104> - <Norton Trevisan>                                 **/
/**                                                                 **/
/**   Segundo Exercício-Programa                                    **/
/**                                                                 **/
/**   <Gustavo Ryan Nascimento Silva>         <11796785>            **/
/**                                                                 **/
/**   <28/04/2020>                                                  **/
/*********************************************************************/

/*
	Cálculo para raiz quadrada
*/
public class Raiz {
    /*
        Calcula a raiz quadrada de um valor, com uma determinada
        precisão. Retorna esse valor, ou -1 quando:

        * a < 0
        * epsilon <= 0
        * epsilon >= 1

        Parâmetro:
            a - valor cuja raiz quadrada será calculada
            epsilon - precisão do cálculo
    */
    static double raizQuadrada(double a, double epsilon) {
        /* O objetivo e calcular o valor mais proximo da raiz do numero a, primeiro estou declarando as variaveis
           que vou utilizar na formula fornecida no EP.

           "Xi" e usado aqui inicialmente como o caso base, o Xo, que e o unico que utiliza a formula A/2, mas no contexto
           da formula, ele representa o valor anterior ao Xi+1.
           "Xi1" representa Xi + 1.
         */

        double xi = a/2;

        double m = 1.0/2.0;

        double xi1 = 0;

        /*Aqui eu crio um contador i, apenas para o for. */
        int i = 0;



        /*Nessa parte estou garantindo que caso Epsilon seja menor ou igual a 0, ou maior ou igual a 1, o programa retorne -1. */
        if (epsilon<=0 || epsilon>=1) {
            return -1;
        } else if (a<0){
            return -1;
        } /* Aqui eu crio um for que garante que, iniciando com i = 1, ele conte i++, realizando a operação para calcular a raiz
         até que o valor de Xi+1 - Xi seja maior ou igual a Epsilon */
        else for(i = 1; ((xi1-xi)*-1) > epsilon; i++){
            /*Aqui eu atribuo o valor de Xi + 1 como o resultado da formula, utilizando Xi como o valor de X anterior a ele.*/
            xi1 = (m)*(xi+(a/xi));
            /*Aqui eu atribuo o resultado de Xi + 1 na linha anterior a Xi, pois eu preciso que, na proxima iteracao, o valor atual
            seja o valor anterior, ou seja, estou transformando o Xi + 1 atual no Xi da proxima iteracao.
             */
            xi = xi1;
            /*Aqui eu realizo o calculo com os valores atualizados*/
            xi1 = (m)*(xi+(a/xi));
        }
        /* Aqui retornamos apenas o valor final assumido por Xi1(Xi + 1) quando o for terminou de ser executado, ou seja
        quando a condição limite foi satisfeita
         */
        return xi1;
    }


    /*
        Apenas para seus testes. ISSO SERA IGNORADO NA CORREÇÃO
    */
    public static void main(String[] args) {
        // escreva seu código (para testes) aqui

        // Exemplo de teste:
        double valor = 63;
        double precisao = 0.001;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 63;
        precisao = 0.1;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 144;
        precisao = 0.01;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 3.14159;
        precisao = 0.01;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 0.14159;
        precisao = 0.01;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 0.003;
        precisao = 0.000001;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = -1;
        precisao = 0.001;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = -12;
        precisao = 0.001;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 100;
        precisao = 0.0000001;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 22;
        precisao = 0.03;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 64;
        precisao = 0.05;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 124.2;
        precisao = 0.005;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 1485;
        precisao = 0.001;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 2564.35;
        precisao = 0.001;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = -15.35;
        precisao = 0.01;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = Math.PI;
        precisao = 0.001;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 144;
        precisao = 1;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 144;
        precisao = 1.2;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 144;
        precisao = 0;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	valor = 144;
        precisao = -1.2;
        System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
    }
}