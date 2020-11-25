package david.augusto.luan.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "funcionario")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "cpf", name = "cpf_uk"))
public abstract class Funcionario {

	@NotNull
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "nome")
	private String nome;
	@Column(name = "salario")
	private Double salario;

	public Funcionario(String cpf, String nome, Double salario) {
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
	}

}
