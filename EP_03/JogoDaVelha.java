/*********************************************************************/
/**   ACH2001 - Introdu��o � Programa��o                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   <2020104> - <Norton Trevisan>                                 **/
/**                                                                 **/
/**   Terceiro Exerc�cio-Programa                                   **/
/**                                                                 **/
/**   <Gustavo Ryan Nascimento Silva>         <11796785>            **/
/**                                                                 **/
/**   <23/05/2020>                                                  **/
/*********************************************************************/

/*
	Jogo da Velha - programa para verificar o status de um jogo.
	
	Lista de Status calculado:
	0 - Jogo n�o iniciado: o tabuleiro est� 'vazio', isto � sem pe�as X e O;
    1 - Jogo encerrado1: o primeiro jogador (que usa as pe�as X) � o ganhador;
    2 - Jogo encerrado2: o segundo jogador (que usa as pe�as O) � o ganhador;
    3 - Jogo encerrado3: empate - todas as casas do tabuleiro est�o preenchidas com X e O, mas nenhum dos jogadores ganhou;
    4 - Jogo j� iniciado e em andamento: nenhuma das alternativas anteriores.	
*/

public class JogoDaVelha {
    static final char pecaX = 'X';
    static final char pecaY = 'O';
    static final char espacoVazio = ' ';

    /*
        Determina o status de uma partida de Jogo da Valha

        Entrada:
            tabuleiro - matriz 3x3 de caracteres representando uma partida valida de Jogo da Velha

        Sa�da:
            um inteiro contendo o status da partida (valores v�lidos de zero a quatro)
    */
    static int verificaStatus(char[][] tabuleiro) {
        int status = -1;

        /* Primeiro, eu crio um for para percorrer a matriz que forma o jogo da velha, criando os iteradores i e j, sendo linha e coluna respectivamente.
         */
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {

                /* Um if para garantir que os índices i e j(linha e coluna) nunca passem dos tamanhos da matriz, evitando o erro "out of bounds"
                 */
                if (j - 1 >= 0 && j + 1 < 3) {

                    /*  Um IF para verificar se um dos jogadores ganhou o jogo de forma horizontal, ou seja, completando 3 casas iguais na mesma linha.
                        Caso algum deles seja verdadeiro, tem outro IF para desobrir qual jogador obteve a vitoria e a variavel 'status' e abastecida com o codigo
                        correspondente.
                     */
                    if (tabuleiro[i][j] == tabuleiro[i][j + 1] && tabuleiro[i][j] == tabuleiro[i][j - 1]) {
                        if (tabuleiro[i][j] == pecaX) {
                            status = 1;
                        } else if (tabuleiro[i][j] == pecaY) {
                            status = 2;
                        }
                    }
                }

                /* O IF abaixo verifica vitorias verticais, ou seja, se um jogador obteve ganhou o jogo preenchendo 3 casas
                   na mesma coluna, e como no IF anterior, existe outro para verificar qual jogador obteve a vitoria e abastecer
                   a variavel 'status' com o codigo correspondente.
                 */
                if (j - 1 >= 0 && j + 1 < 3) {
                    if (tabuleiro[j][i] == tabuleiro[j + 1][i] && tabuleiro[j][i] == tabuleiro[j - 1][i]) {
                        if (tabuleiro[j][i] == pecaX) {
                            status = 1;
                        } else if (tabuleiro[j][i] == pecaY) {
                            status = 2;
                        }
                    }
                }

                /* Os dois IF's abaixo verificam vitorias em ambas as diagonais da matriz e, como no IF anterior, existe
                   outro dentro para verificar qual jogador obteve a vitoria e abastecer a variavel 'status' com o codigo
                   correspondente.
                 */
                if (i == j) {
                    if (tabuleiro[i][j] == tabuleiro[1][1] && tabuleiro[i][j] == tabuleiro[2][2]) {
                        if (tabuleiro[i][j] == pecaX) {
                            status = 1;
                        } else if (tabuleiro[i][j] == pecaY) {
                            status = 2;
                        }
                    }
                }

                if (i == j){
                    if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0]){
                        if (tabuleiro[0][2] == pecaX){
                            status = 1;
                        } else if (tabuleiro[0][2] == pecaY){
                            status = 2;
                        }
                    }
                }
            }
        }

        /* O laço for abaixo percorre a matriz e dentro dele existem 5 IF's para verificar os outros possíveis desfechos
           para o jogo.

           Abaixo foram criados dois contadores para verificar os casos 0 e 3
         */
        int contador = 0;
        int contador2 = 0;

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                /* Esse IF abaixo verifica se a linha e coluna atual da matriz esta vazia e caso esteja, soma +1 ao contador.
                   o objetivo e que, caso o jogo ainda nao tenha sido iniciado, o contador ao final da condicional sera 9, pois
                   tento percorrido toda a matriz, nao encontrou nenhum caracter preenchendo-a.
                 */
                if (tabuleiro[i][j] == ' ') {
                    contador++;
                } if (contador == 9) {
                    status = 0;
                }

                /* O IF abaixo verifica se toda a matriz esta preenchida e caso esteja e, mesmo preenchida nao atende
                   a nenhuma condicao de vitoria, sabemos que houve um empate.
                 */
                if (tabuleiro[i][j] != ' '){
                    contador2++;
                } if (contador2 == 9) {
                    status = 3;
                }

                /* O IF abaixo verifica que o jogo esta em andamento porem sem nenhuma conclusao ainda, visto que, como
                   todas as outras possibilidades ja estao cobertas no codigo acima, aqui so e necessario verificar se
                   a variavel 'status' e diferente de 1, 2 e 3, sendo vitoria de X, vitoria de O ou empate, respectivamente.
                   A variavel status nao sendo nenhum desses 3, sabe-se entao que o jogo esta em andamento.
                 */
                if (status != 1 && status != 2 && status != 0 && status != 3) {
                    status = 4;
                }
            }
        }


        return status;
    }

    /*
        Apenas para seus testes. ISSO SER� IGNORADO NA CORRE��O
    */
    public static void main(String[] args) {
        // escreva seu c�digo (para testes) aqui

        char[][] tab0 = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		char[][] tab1 = {{'X','O','O'},{'O','O','X'},{'X','X','X'}};
		char[][] tab2 = {{' ','X',' '},{'O','X','O'},{' ','X','O'}};
		char[][] tab3 = {{'O','O','X'},{'X','X','X'},{'O','X','O'}};
		char[][] tab4 = {{'O',' ',' '},{'X','O','X'},{'X','X','O'}};
		char[][] tab5 = {{' ','X','O'},{'X','O','X'},{'O','X','O'}};
        char[][] tab6 = {{'X',' ','X'},{'X','X','O'},{'O','O','O'}};
        char[][] tab7 = {{'O','X','O'},{'X','O','X'},{'X','O','X'}};
        char[][] tab8 = {{'O','X','X'},{'X','O','O'},{'O','X','X'}};
        char[][] tab9 = {{' ',' ',' '},{'X','O','X'},{' ',' ',' '}};
        

		System.out.println("Status calculado: " + verificaStatus(tab0));
		System.out.println("Status esperado para o tabuleiro1: 0\n");

		System.out.println("Status calculado: " + verificaStatus(tab1));
		System.out.println("Status esperado para o tabuleiro2: 1\n");

		System.out.println("Status calculado: " + verificaStatus(tab2));
		System.out.println("Status esperado para o tabuleiro3: 1\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab3));
		System.out.println("Status esperado para o tabuleiro4: 1\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab4));
		System.out.println("Status esperado para o tabuleiro5: 2\n");
		
		System.out.println("Status calculado: " + verificaStatus(tab5));
        System.out.println("Status esperado para o tabuleiro6: 2\n");
     
        System.out.println("Status calculado: " + verificaStatus(tab6));
        System.out.println("Status esperado para o tabuleiro7: 2\n");
        
        System.out.println("Status calculado: " + verificaStatus(tab7));
        System.out.println("Status esperado para o tabuleiro8: 3\n");
        
        System.out.println("Status calculado: " + verificaStatus(tab8));
        System.out.println("Status esperado para o tabuleiro9: 3\n");
    
        System.out.println("Status calculado: " + verificaStatus(tab9));
        System.out.println("Status esperado para o tabuleiro10: 4\n");

    }
}