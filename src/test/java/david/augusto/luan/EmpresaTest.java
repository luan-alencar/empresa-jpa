package david.augusto.luan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import david.augusto.luan.entidades.Empresa;
import david.augusto.luan.entidades.Funcionario;
import david.augusto.luan.entidades.FuncionarioCLT;
import david.augusto.luan.entidades.FuncionarioHorista;
import david.augusto.luan.exceptions.CpfJaExisteException;
import david.augusto.luan.exceptions.CpfNaoExisteException;
import david.augusto.luan.exceptions.FuncionarioNaoExiste;

public class EmpresaTest {

	private Empresa empresa;

	@BeforeEach
	void setUp() throws Exception {
		empresa = new Empresa("Fábrica de Colchões");
		empresa.contratarFuncionario(new FuncionarioCLT("000.000.000-00", "Operario 1", 2000.0));
		empresa.contratarFuncionario(new FuncionarioCLT("111.111.111-11", "Operario 2", 2500.0));
		empresa.contratarFuncionario(new FuncionarioCLT("222.222.222-22", "Gerente", 5000.0));
		empresa.contratarFuncionario(new FuncionarioHorista("333.333.333-33", "Motorista", 18.75, 0));
		empresa.contratarFuncionario(new FuncionarioHorista("444.444.444-44", "Zelador", 15.0, 0));
	}

	@Test
	void testContratarComSucesso() throws CpfJaExisteException, FuncionarioNaoExiste {
		// Nesse caso, é para contratar o funcionário sem nenhum problema
		FuncionarioCLT diretor = new FuncionarioCLT("555.555.555-55", "Diretor", 8000.0);
		empresa.contratarFuncionario(diretor);
		assertTrue(empresa.getFuncionarios().contains(diretor));
	}

	@Test
	void testContratarCpfRepetido() throws CpfJaExisteException {
		// Aqui eu espero que ocorra uma exceção de CPF repetido
		Exception ex = assertThrows(CpfJaExisteException.class, () -> {
			Funcionario diretor = new FuncionarioCLT("000.000.000-00", "Diretor", 8000.0);
			empresa.contratarFuncionario(diretor);
		});
		assertNotNull(ex);
		assertEquals("Já existe um funcionário cadastrado com o CPF 000.000.000-00", ex.getMessage());
	}

	@Test
	void testGetFuncionarioQueExiste() throws CpfNaoExisteException {
		// Esse funcionário existe
		Funcionario f = empresa.buscarFuncionario("111.111.111-11");
		assertNotNull(f);
		assertEquals("Operario 2", f.getNome());
	}

	@Test
	void testGetFuncionarioQueNaoExiste() throws CpfNaoExisteException {
		// Tentando procurar um funcionário que não existe
		Exception ex = assertThrows(FuncionarioNaoExiste.class, () -> {
			empresa.buscarFuncionario("666.666.666-66");
		});
		assertNotNull(ex);
		assertEquals("Não foi encontrado um funcionário com o CPF 666.666.666-66", ex.getMessage());
	}

	@Test
	void testDemitirFuncionarioQueExiste() throws FuncionarioNaoExiste, CpfJaExisteException, CpfNaoExisteException {
		Funcionario f = empresa.buscarFuncionario("111.111.111-11");
		assertNotNull(f);
		// Confirma que o funcionário existe mesmo
		assertTrue(empresa.getFuncionarios().contains(f));
		// Demite o funcionário
		empresa.demitirFuncionario("111.111.111-11");
		// Confirma que o funcionário não consta mais na empresa
		assertFalse(empresa.getFuncionarios().contains(f));
	}

	@Test
	void testDemitirFuncionarioQueNaoExiste() throws FuncionarioNaoExiste {
		// Tentando demitir um funcionário que não existe
		Exception ex = assertThrows(FuncionarioNaoExiste.class, () -> {
			empresa.demitirFuncionario("666.666.666-66");
		});
		assertEquals("Não foi encontrado um funcionário com o CPF 666.666.666-66", ex.getMessage());
	}
}
