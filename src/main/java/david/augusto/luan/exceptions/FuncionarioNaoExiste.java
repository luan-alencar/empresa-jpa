package david.augusto.luan.exceptions;

public class FuncionarioNaoExiste extends Exception {
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoExiste() {
		super("Operação não realizada, funcionario não cadastrado no banco de dados");
	}

}
