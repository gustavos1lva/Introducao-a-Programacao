public class ClienteEspecial extends Cliente{
	static final int dividaMaxima = 50000;
	static final String tipo = "CE";
	
	/* Construtor da Classe ClienteEspecial
	 * Este construtor invoca o construtor da classe Cliente.
	 */
	ClienteEspecial(String nome, int cpf, int valor){
		super(nome, cpf, valor);
	}
	
	/* Metodo que retorna o valor do atributo tipo do objeto atual */
	String retornaTipo() {
		return tipo;
	}

	public boolean obterEmprestimo(int valor) {
		/*
		Esse metodo apenas substitui o metodo obterEmprestimo da classe Cliente para o caso do cliente ser do
		tipo CE(Cliente Especial), nesse caso a divida maxima dele e maior.
		 */
		int valorContaCorrente = getValorContaCorrente();
		int valorDaDivida = getValorDaDivida();
		if	(valor <= 0){
			return false;
		} else if (valorDaDivida + valor >= dividaMaxima){
			return false;
		}
		setValorContaCorrente(valorContaCorrente + valor);
		setValorDaDivida(valorDaDivida + valor);

		return true;
	}
	
}
