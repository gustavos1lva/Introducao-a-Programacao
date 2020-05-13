import javax.xml.transform.OutputKeys;
import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args) {
        int W = 0;

        System.out.println("Programa para testar divisibilidade");

        System.out.println("Primeiro voce precisa inserir a lista de numeros que voce quer descobrir se e divisivel depois deve inserir o numero pelo qual eles serao divididos");

        System.out.println("Digite o tamanho da lista de numeros que voce quer testar");
        Scanner m = new Scanner(System.in);
        int[] n = new int[m.nextInt()];

        System.out.println("Insira, item a item, os numeros que voce quer testar, quando terminar digite 0 para finalizar." + "\n");
        Scanner qtd = new Scanner(System.in);
            for (int a = 0; a<n.length; a++){
                W = qtd.nextInt();
                n[a] = W;
            }

            System.out.println("Lista inserida:");
            for (int v = 0; v<n.length; v++){
                System.out.println(n[v]);
            }

            System.out.println("Insira o numero pelo qual a lista sera dividida");
            Scanner div1 = new Scanner(System.in);
            int div2 = div1.nextInt();

            for (int i = 0; i<n.length; i++){
                if (n[i]%div2==0){
                    System.out.println("O numero: " +n[i]+ " e divisivel por " +div2+ "\n");
                } else System.out.println("O numero: " +n[i]+ " nao e divisivel por " +div2+ "\n");
            }

        }

    }