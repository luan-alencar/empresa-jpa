package david.augusto.luan.interfaces;

import david.augusto.luan.exceptions.FuncionarioNaoExiste;

public interface DemitirFuncionario {

	public void demitirFuncionario(String cpf) throws FuncionarioNaoExiste;
}
