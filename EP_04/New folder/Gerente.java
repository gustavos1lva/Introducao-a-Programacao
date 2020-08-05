
public class Gerente extends Pessoa implements InterfaceGerente{
	private static final String tipo = "G";
	private Cliente[] clientes;
	private int numClientes;

	/* Construtor da Classe Gerente
	 * Este construtor invoca o construtor da classe Pessoa e inicializa os dois atributos 
	 * do objeto que esta sendo instanciado.
	 */
	Gerente(String nome, int cpf){
		super(nome, cpf);
		clientes = new Cliente[20];
		numClientes = 0;
	}

	
	/* Metodo que retorna o valor do atributo tipo do objeto atual */
	String retornaTipo() {
		return tipo;
	}
	
	/* Metodo para imprimir informacoes sobre os clientes gerenciados pelo gerente atual
	 */
	void imprimirClientes(){
		Cliente atual;
		System.out.println("\tNumero de clientes: " + numClientes);
		for (int c=0; c < numClientes; c++){
			atual = clientes[c];
			System.out.println("\t" + (c+1) + "\t" + atual.retornaTipo() + "\t" + atual.nome + "\t" + atual.cpf + "\t" + atual.getValorContaCorrente() + "\t" + atual.getValorDaDivida() + "\t" + atual.negativado());
		}
	}


	/* Metodo para adicionar um cliente no arranjo de clientes do gerente atual.
	 * Caso o numero de clientes seja igual a 20, nao deve adicionar e deve retornar false.
	 * Caso contrario, ha duas situacoes: 
	 *   1a: o cliente ja consta no arranjo de clientes (verifique isso usando o numero do cpf),
	 *       neste caso o cliente nao deve ser reinserido e o metodo deve retornar false; 
	 *   1a: o cliente passado como parametro nao consta no arranjo de clientes: o cliente 
	 *       deve ser adicionado na posicao numClientes, o atributo numClientes deve ser 
	 *       incrementado em 1 e o metodo deve retornar true. 
	 */
	public boolean adicionarCliente(Cliente cliente) {
		/*
		Aqui eu criei uma variavel pra usar de contador e saber o numero de clientes, um for para percorrer
		o array clientes e 4 IF, 1o para garantir que nao e nulo, ou seja, existe cliente naquela posicao
		o programa soma +1 a variavel numC, o 2o IF evita o exception e o 3o verifica se o cliente ja esta na base
		o 4o IF retorna false caso numC seja igual a 20, sendo todos os IF falsos o codigo no final adiciona o cliente
		ao array clientes[] e retorna true.
		 */
		int numC = 0;
		for (int i = 0; i<20; i++) {
			if (clientes[i] != null) {
				numC++;
			} if (clientes[i] != null) {
				if (clientes[i].cpf == cliente.cpf){
				return false;
				}
			}
		}
		if (numC == 20){
			return false;
		}

		clientes[numClientes] = cliente;
		this.numClientes++;
		return true;
	}

	
	/* Metodo para cobrar os emprestimos de todos os clientes do gerente atual.
	 * Para cada um dos clientes presentes no arranjo clientes, este metodo deve:
	 *   - nao fazer nada para o cliente, caso seu valorDaDivida seja igual a zero
	 *   - caso contrario, ha duas situacoes:
	 *     1a) se o valorContaCorrente do cliente for maior ou igual ao valorDaDivida, deve
	 *         fazer o cliente pagar a divida, isto e, o valorContaCorrente sera atualizado, 
	 *         descontando-se o valor da divida e o valorDaDivida sera zerado.
	 *     2a) se o valorContaCorrente do cliente for menor do que o valorDaDivida, 
	 *         deve fazer o cliente pagar parte da divida, isto e, o valorDaDivida 
	 *         sera atualizado, tendo seu valor diminuido pelo valorContaCorrente e 
	 *         o valorContaCorrente sera zerado.
	 */
	public void cobrarTodosEmprestimos() {
		/*
		Aqui eu fiz um for para percorrer o array clientes[], seguido de um IF para garantir que a posicao i
		do array nao seja nula e apos isso tres IF, o 1o para conferir se o valor da divida seja maior zero, ou
		seja, que a divida a ser cobrada existe e o 2o para garantir que ha saldo disponivel para pagar a divida
		inteira, o terceiro IF serve para o caso do cliente nao ter como pagar o valor inteiro da divida, tendo um
		saldo menor que a divida.
		 */
		for (int i = 0; i<20; i++){
			if (clientes[i] != null) {
				if (clientes[i].getValorDaDivida() > 0) {
					if (clientes[i].getValorContaCorrente() >= clientes[i].getValorDaDivida()) {
						int divida = clientes[i].getValorDaDivida();
						int saldo = clientes[i].getValorContaCorrente();
						int dif = saldo - divida;
						clientes[i].setValorDaDivida(0);
						clientes[i].setValorContaCorrente(dif);

					}
					if (clientes[i].getValorContaCorrente() < clientes[i].getValorDaDivida()) {
						int divida = clientes[i].getValorDaDivida();
						int saldo = clientes[i].getValorContaCorrente();
						int dif = divida - saldo;
						clientes[i].setValorDaDivida(dif);
						clientes[i].setValorContaCorrente(0);
					}
				}
			}
		}
	}



}
