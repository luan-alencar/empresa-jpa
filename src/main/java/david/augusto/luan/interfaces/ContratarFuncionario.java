package david.augusto.luan.interfaces;

import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.exceptions.CpfJaExisteException;

public interface ContratarFuncionario {

	public void contratarFuncionario(Funcionario funcionario) throws CpfJaExisteException;
}
