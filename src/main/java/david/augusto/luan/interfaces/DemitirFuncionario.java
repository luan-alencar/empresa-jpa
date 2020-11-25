package david.augusto.luan.interfaces;

import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.exceptions.FuncionarioNaoExiste;

public interface DemitirFuncionario {

	public void demitirFuncionario(Funcionario funcionario) throws FuncionarioNaoExiste;
}
