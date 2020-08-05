/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   2020104 - <Norton Trevisan>                                   **/
/**                                                                 **/
/**   Primeiro Exercício-Programa                                   **/
/**                                                                 **/
/**   <Gustavo Ryan Nascimento Silva>         <11796785>            **/
/**                                                                 **/
/**   <15/04/2020>                                             	    **/
/*********************************************************************/

/*
	Caixa eletrônico das Ilhas Weblands, com estoque ilimitado de cédulas
	de B$50,00, B$10,00, B$5,00 e B$1,00.
*/
public class CaixaEletronico {
	// Número de cédulas de B$50,00 TESTANDO MERGE CONFLICT
	static int n50;
	
	// Número de cédulas de B$10,00
	static int n10;

	// Número de cédulas de B$5,00
	static int n5;
	
	// Número de cédulas de B$1,00
	static int n1;


	/*
		Determina a quantidade de cada nota necessária para totalizar
		um determinado valor de retirada, de modo a minimizar a quantidade
		de cédulas entregues.
		
		Abastece as variáveis globais n50,n10, n5 e n1 com seu respectivo
		número de cédulas.
		
		Parâmetro:
			valor - O valor a ser retirado
	*/
	static void fazRetirada(int valor) {
		/*Primeiro vamos zerar as variáveis para garantir que caso haja mais de um saque, os valores não se entrelacem e se confundam. */
		n1 = 0;
		n5 = 0;
		n10 = 0;
		n50 = 0;
		/*Segundo, vamos conferir se o valor é negativo, caso sim, o método já vai retornar o valor -1 para todas as variáveis.*/
        if (valor<0){
            n50 = -1;
            n10 = -1;
            n5 = -1;
            n1 = -1;
        }
    /*Começamos pelas notas maiores para sempre pegar a solução ótima com o menor uso de notas possível*/
        /*Em cada condicional IF(exceto o último) o valor inserido no parâmetro é dividido pelo valor da cédula,
          caso o resultado da divisão seja maior ou igual a 1, a condicional será executada, ou seja
          a variável nX(Sendo X o valor da cédula 50,10,5 ou 1) será abastecida pelo número de cédulas de X necessárias nessa operação,
          após isso subtraímos o valor total dessas cédulas do valor inicial(X*nX). Assim, a variável Valor se torna o restante da operação.
         */
        if((valor/50)>=1){
          n50= valor/50;
          valor = valor-(50*n50);
      }

        /*Aqui já garantimos, por meio da divisão que usamos o máximo possível de notas de 50*/

      if((valor/10)>=1){
          n10= valor/10;
          valor = valor-(10*n10);
      }

      /*Aqui já garantimos, por meio da divisão que usamos o máximo possível de notas de 10*/

      if((valor/5)>=1){
          n5= valor/5;
          valor = valor-(5*n5);
      }

        /*Aqui já garantimos, por meio da divisão que usamos o máximo possível de notas de 5*/

      /*Nesse IF em específico é necessário especificar para notas de 1, que o valor precisa ser maior que 0 e menor que 5,
      por isso a utilização do && que garante que as duas condições sejam satisfeitas.*/

      if((valor/1)<5&&(valor/1)>0){
          n1= valor/1;
          valor = valor-(5*n1);
      }

	/*
		Apenas para seus testes. ISSO SERA IGNORADO NA CORREÇÃO
	*/

    }

	public static void main(String[] args) {
		// escreva seu código (para testes) aqui

		// Exemplo de teste:3
		fazRetirada(28);
		System.out.println("Notas de 50: "+n50);
		System.out.println("Notas de 10: "+n10);
		System.out.println("Notas de 5:  "+n5);
		System.out.println("Notas de 1:  "+n1);
	}
}