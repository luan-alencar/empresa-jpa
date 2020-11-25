package david.augusto.luan.entidades;

import java.util.ArrayList;
import java.util.List;

import david.augusto.luan.exceptions.CpfJaExisteException;
import david.augusto.luan.exceptions.CpfNaoExisteException;
import david.augusto.luan.exceptions.FuncionarioNaoExiste;
import david.augusto.luan.interfaces.BuscarFuncionario;
import david.augusto.luan.interfaces.CalcularSalario;
import david.augusto.luan.interfaces.ContratarFuncionario;
import david.augusto.luan.interfaces.DemitirFuncionario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Empresa implements ContratarFuncionario, DemitirFuncionario, CalcularSalario, BuscarFuncionario {

	private String nome;
	private List<Funcionario> funcionarios;

	public Empresa(String nome) {
		this.nome = nome;
		this.funcionarios = new ArrayList<Funcionario>();
	}

	@Override
	public void contratarFuncionario(Funcionario funcionario) throws CpfJaExisteException {
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(funcionario.getCpf())) {
				throw new CpfJaExisteException(funcionario.getCpf());
			}
		}
		funcionarios.add(funcionario);
	}

	@Override
	public void demitirFuncionario(String cpf) throws FuncionarioNaoExiste {
		Funcionario fun = null;
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(cpf)) {
				fun = f;
			}
			throw new FuncionarioNaoExiste();
		}
		funcionarios.remove(fun);
	}

	@Override
	public Funcionario buscarFuncionario(String cpf) throws CpfNaoExisteException {
		Funcionario funcionario = null;
		for (Funcionario f : funcionarios) {
			if (f.getCpf().equals(cpf)) {
				funcionario = f;
			}
			throw new CpfNaoExisteException(cpf);
		}
		return funcionario;
	}

	@Override
	public Double calcularSalario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		return null;
	}

}
