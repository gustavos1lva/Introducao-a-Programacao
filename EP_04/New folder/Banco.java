/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   <2020104> - <Norton Trevisan>                                 **/
/**                                                                 **/
/**   Quarto Exercício-Programa                                     **/
/**                                                                 **/
/**   <Gustavo Ryan Nascimento Silva>         <11796785>            **/
/**                                                                 **/
/**   <30/06/2020>                                                  **/
/*********************************************************************/

public class Banco {
	private Gerente[] gerentes;
	private int numGerentes;
	
	/* Construtor da Classe Banco
	 * Inicializa os dois atributos do objeto que esta sendo instanciado.
	 */
	Banco(){
		gerentes = new Gerente[10];
		numGerentes = 0;
	}
	

	/* Metodo para Imprimir informacoes gerais sobre o banco atual
	 */
	void imprimir(){
		System.out.println("#########################################################################");
		System.out.println("Imprimindo informacoes do banco.");
		System.out.println("Ha " + numGerentes + " gerente(s) neste banco.");
		Gerente ger;
		for (int g=0; g < numGerentes; g++){
			ger = gerentes[g];
			System.out.println("Gerente: " + ger.nome + "\tCPF: " + ger.cpf);
			ger.imprimirClientes();
		}
		System.out.println("#########################################################################");
	}
	
	
	
	/* Metodo para adicionar um gerente no arranjo de gerentes do banco.
	 * Caso o numero de gerentes seja igual a 10, nao deve adicionar e deve retornar false.
	 * Caso contrario, ha duas situacoes: 
	 *   1a: o gerente ja consta no arranjo de gerentes (verifique isso usando o numero do cpf),
	 *       neste caso o gerente nao deve ser reinserido e o metodo deve retornar false; 
	 *   2a: o gerente passado como parametro nao consta no arranjo de gerentes: o gerente 
	 *       deve ser adicionado na posicao numGerentes, o atributo numGerentes deve ser 
	 *       incrementado em 1 e o metodo deve retornar true. 
	 */
	boolean adicionarGerente(Gerente gerente){
		/*
		Aqui eu tenho um for para percorrer o array gerentes[] e criei uma variavel para armazenar uma contagem
		do numero de gerentes, o 1o IF garante que gerentes[i] nao seja nulo, evitando nullpointer exception,
		apos isso o 2o IF verifica se o numero de gerentes esta no limite e o 3o IF e outro para evitar o exception
		o 4o IF e para verificar se esse gerente ja esta adicionado no array gerentes[].

		Caso todos os IF sejam falsos, ou seja, o gerente nao esta no array e o numero de gerentes e menor que 10,
		o codigo final adiciona esse gerente no array gerentes[], soma 1 ao numero de gerentes e retorna true.
		 */
		int numG = 0;
		for (int i = 0; i<10; i++) {
			if (gerentes[i] != null) {
				numG++;
			}
			if (numG == 10) {
				return false;
			}
			if (gerentes[i] != null) {

			if (gerentes[i].cpf == gerente.cpf) {
				return false;
			}
		}
		}

		gerentes[numGerentes] = gerente;
		numGerentes++;
		
		return true;
	}
	
}
