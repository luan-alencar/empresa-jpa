package david.augusto.luan.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionario_horista")
@AllArgsConstructor
public class FuncionarioHorista extends Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "valor_hora")
	private Double valorHora;

	@Setter
	@Column(name = "horas_trabalhadas")
	private int horasTrabalhadasNoMes;

	public Double getSalario() {
		return this.valorHora * horasTrabalhadasNoMes;
	}
}
