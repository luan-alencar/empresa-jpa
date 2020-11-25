package david.augusto.luan.interfaces;

import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.exceptions.FuncionarioNaoExiste;

public interface BuscarFuncionario {
	
	public Funcionario buscarFuncionario(String cpf) throws FuncionarioNaoExiste;
}
