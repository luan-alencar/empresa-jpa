package david.augusto.luan.exceptions;

public class CpfNaoExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public CpfNaoExisteException(String cpf) {
		super("Não foi encontrado um funcionário com o CPF " + cpf);
	}
}
