package david.augusto.luan.entidades;

import java.util.ArrayList;
import java.util.List;

import david.augusto.luan.ContratarFuncionario;
import david.augusto.luan.exceptions.CpfJaExisteException;
import david.augusto.luan.exceptions.FuncionarioNaoExiste;
import david.augusto.luan.interfaces.DemitirFuncionario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Empresa implements ContratarFuncionario, DemitirFuncionario {

	private String nome;
	private List<Funcionario> funcionarios;

	public Empresa(String nome, List<Funcionario> funcionarios) {
		this.nome = nome;
		this.funcionarios = new ArrayList<Funcionario>();
	}

	@Override
	public void contratarFuncionario(Funcionario funcionario) throws CpfJaExisteException {
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(funcionario.getCpf())) {
				throw new CpfJaExisteException();
			}
		}
		funcionarios.add(funcionario);
	}

	@Override
	public void demitirFuncionario(Funcionario funcionario) throws FuncionarioNaoExiste {
		Funcionario fun = null;
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(funcionario.getCpf())) {
				fun = f;
			}
			throw new FuncionarioNaoExiste();
		}
		funcionarios.remove(fun);
	}

}
