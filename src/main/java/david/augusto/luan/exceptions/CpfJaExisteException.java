package david.augusto.luan.exceptions;

public class CpfJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public CpfJaExisteException(String cpf) {
		super("Já existe um funcionário cadastrado com o CPF " + cpf);
	}
}
