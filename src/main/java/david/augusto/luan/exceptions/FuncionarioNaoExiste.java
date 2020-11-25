package david.augusto.luan.exceptions;

public class FuncionarioNaoExiste extends Exception {
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoExiste(String cpf) {
		super("Não foi encontrado um funcionário com o CPF " + cpf);
	}

}
