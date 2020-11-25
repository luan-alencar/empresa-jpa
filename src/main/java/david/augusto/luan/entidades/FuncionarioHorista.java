package david.augusto.luan.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario_horista")
@NoArgsConstructor
public class FuncionarioHorista extends Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Column(name = "valor_hora")
	private Double valorHora;

	@Getter
	@Setter
	@Column(name = "horas_trabalhadas")
	private Integer horasTrabalhadasNoMes;

	public FuncionarioHorista(String cpf, String nome, Double salario, Integer horasTrabalhadasNoMes) {
		super(cpf, nome, salario);
		this.valorHora = salario;
		this.horasTrabalhadasNoMes = horasTrabalhadasNoMes;
	}

	public Double getSalario() {
		return this.valorHora * horasTrabalhadasNoMes;
	}

}
