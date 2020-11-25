package david.augusto.luan.exceptions;

public class CpfJaExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public CpfJaExisteException(String cpf) {
		super("Operação não realizada, funcionário de CPF: " + cpf + "já existe");
	}
}
