
public class Cliente extends Pessoa implements InterfaceCliente{
	static final int dividaMaxima = 30000;
	static final String tipo = "C";
	private int valorContaCorrente;
	private int valorDaDivida;
	
	/* Construtor da Classe Cliente
	 * Este construtor invoca o construtor da classe Pessoa e inicializa os dois atributos 
	 * do objeto que esta sendo instanciado.
	 */
	Cliente(String nome, int cpf, int valorInicial){
		super(nome, cpf);
		valorContaCorrente = valorInicial;
		valorDaDivida = 0;
	}
	
	/* Metodo que retorna o valor do atributo tipo do objeto atual */
	String retornaTipo() {
		return tipo;
	}	
	
	
	protected int getValorContaCorrente() { return valorContaCorrente; }
	
	protected int getValorDaDivida() { return valorDaDivida; }
	
	protected void setValorContaCorrente(int valor) {
		valorContaCorrente = valor;
	}
	
	protected void setValorDaDivida(int valor) {
		valorDaDivida = valor;
	}


	/* Metodo para o cliente atual obter um emprestimo de acordo com o valor passado por parametro
	 *   Caso o valor do parametro seja menor ou igual a zero, o metodo deve retornar false
	 *   Caso contrario ha duas situacoes:
	 *     1a) se o valor do parametro mais o valor do atributo valorDaDivida for maior do
	 *         que o valor da constante dividaMaxima, o metodo deve retornar false 
	 *     2a) caso contrario, o atributo valorDaDivida deve ser incrementado em valor, o atributo
	 *         valorContaCorrente deve ser incrementado em valor e o metodo deve retornar true
	 */
	public boolean obterEmprestimo(int valor) {
		/*
		Apenas um IF para garantir que o valor nao seja negativo e que seja menor que a divida maxima.
		 */
		if	(valor > 0 && (valor + valorDaDivida) <= dividaMaxima){
			valorDaDivida += valor;
			valorContaCorrente += valor;
			return true;
		}
		return false;
	}
	

	/* Metodo para o cliente atual pagar parte de sua divida de acordo com o valor passado por parametro
	 *   Caso o valor do parametro seja menor ou igual a zero, o metodo deve retornar false
	 *   Caso contrario ha duas situacoes:
	 *     1a) se o valor do parametro for maior do que o valorDaDivida ou for maior do que 
	 *         valorContaCorrente, o metodo deve retornar false 
	 *     2a) caso contrario, o atributo valorDaDivida deve ser decrementado em valor, o atributo
	 *         valorContaCorrente deve ser decrementado em valor e o metodo deve retornar true
	 */
	public boolean pagarEmprestimo(int valor) {
		/* Aqui eu fiz dois IF para verificar se todas as situacoes para pagar empréstimo foram satisfeitas,
		 * ou seja, que nao haveria "pagamento negativo" e que o valor a ser pago esta disponivel em conta*/
		if (valor <= 0){
			return false;
		}
		if(valor > valorDaDivida || valor > valorContaCorrente){
			return false;
		}
		valorDaDivida -= valor;
		valorContaCorrente -= valor;
		return true;
	}
	
	
	/* Metodo que retorna true caso valorContaCorrente seja menor do que valorDaDivida.
	 * Caso contrario, retorna false.
	 */
	public boolean negativado() {
		/* Aqui e apenas um IF para ver se o cliente esta negativado no banco, ou seja, se deve mais do que tem.
		 */
		if (valorContaCorrente < valorDaDivida){
			return true;
		} else return false;
	}
	

	/* Metodo para o cliente atual realizar um saque do valor passado por parametro
	 *   Caso o valor do parametro seja menor ou igual a zero, o metodo deve retornar false
	 *   Caso contrario ha duas situacoes:
	 *     1a) se o valor do parametro for maior do que o valor do atributo valorContaCorrente, o 
	 *         metodo deve retornar false
	 *     2a) caso contrario, o atributo valorContaCorrente deve ser decrementado em valor e o
	 *         metodo deve retornar true
	 */
	public boolean realizarSaque(int valor) {
	/*
		Aqui sao 2 IF so para garantir que nao sejam feitos saques com valores negativos e que o valor a ser
		sacada e menor que o disponivel em conta.
		 */
		if (valor <= 0){
			return false;
		} else	if (valor > valorContaCorrente){
			return false;
		}
		valorContaCorrente -= valor;
		return true;
	}
}
