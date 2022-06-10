package br.com.sorveteria;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sorveteria.model.PessoaEntity;
import br.com.sorveteria.repository.PessoaRepository;

@SpringBootTest
public class PessoaEntityTests {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	static Long pessoaId = 4L;
	
	@Test
	void contextLoads() {
		System.out.println("teste - Pessoa");
	}

	@Test
	public void testeInserirPessoa() {
		PessoaEntity pessoa = new PessoaEntity();
		
		String codigoPessoa = String.valueOf(Math.random()*100);
				
		
		pessoa.setNome("Pessoa Teste código - " + codigoPessoa);
		pessoa.setEmail("pessoa."+codigoPessoa + "@arthursilva.tech");
		pessoa.setUsuarioId(5L);
		pessoa.setCidade("Mata de São João");
		pessoa.setCelular("71123456789");
		pessoa.setEstadoCivil("Solteiro");
		
		pessoa = pessoaRepository.save(pessoa);
		
		if (pessoa != null && pessoa.getPessoaId() != null)
			pessoaId = pessoa.getPessoaId();
		
		System.out.println("Pessoa inserida: " + pessoa);

	}

	public void testeEditarPessoa() {
		PessoaEntity pessoa = pessoaRepository.findById(pessoaId).get();
		
		pessoa.setBairro("Amado Bahia");
		pessoa.setRua("Rua F");
		
		pessoa = pessoaRepository.save(pessoa);
		
		System.out.println("Pessoa editada: " + pessoa);
	}
		
	@Test
	//@Transactional
	public void testeConsultaPessoa() {
		List<PessoaEntity> list = pessoaRepository.findAll();
		
		for (PessoaEntity pessoaEntity : list) {
			System.out.println(pessoaEntity);
		}
	}
	
	@Test
	public void testeConsultaPessoaById() {
		Optional<PessoaEntity> pessoa = pessoaRepository.findById(pessoaId);
		
		System.out.println(pessoa.get());
	}
	
	@Test
	public void testeConsultaPessoaByIdWithAgregations() {
		PessoaEntity pessoa = pessoaRepository.findByIdWithAgregations(pessoaId);
		
		System.out.println(pessoa);
		System.out.println(pessoa.getUsuarioId());
	}
	
	@Test
	public void testeConsultaPessoaByIdWithUsuario() {
		PessoaEntity pessoa = pessoaRepository.findByIdWithUsuario(pessoaId);
		
		System.out.println(pessoa);
		System.out.println(pessoa.getUsuarioId());
	}
}
