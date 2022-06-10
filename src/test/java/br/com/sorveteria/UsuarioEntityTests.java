package br.com.sorveteria;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.sorveteria.model.PessoaEntity;
import br.com.sorveteria.model.RoleEntity;
import br.com.sorveteria.model.UsuarioEntity;
import br.com.sorveteria.repository.PessoaRepository;
import br.com.sorveteria.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioEntityTests {
	
	static Long usuarioId = 5L;
	static Long pessoaId = 4L;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Test
	void contextLoads() {
		System.out.println("teste - Usuarios");
		
	}
	
	@Test
	public void teste01InserirUsuario() {
		UsuarioEntity usuario = new UsuarioEntity();
		PessoaEntity pessoa = new PessoaEntity();
		
		String codigoUsuario = String.valueOf(Math.random() * 100);
		
		pessoa.setNome("Pessoa do usuario codigo - " + codigoUsuario);
		pessoa.setEmail("pessoa."+codigoUsuario + "@arthursilva.tech");
		pessoa.setUsuarioId(5L);
		pessoa.setCidade("Mata de São João");
		pessoa.setCelular("71123456789");
		pessoa.setEstadoCivil("Solteiro");
		
		pessoa = pessoaRepository.save(pessoa);
		
		usuario.setPessoa(pessoa);
		usuario.setUsuario("usuario." + codigoUsuario );
		usuario.setSenha(new BCryptPasswordEncoder().encode("123456"));		

		usuario = usuarioRepository.save(usuario);
		
		
		if (usuario != null && usuario.getUsuarioId() != null) {
			this.usuarioId = usuario.getUsuarioId(); 
			this.pessoaId = usuario.getPessoa().getPessoaId();
			
			System.out.println("Pessoa do usuario " + this.pessoaId);
		}
		usuarioRepository.insereAcessoRolePadrao(usuarioId);

		System.out.println(usuario);
	}
	
	@Test
	public void teste02EditarUsuario() {
		UsuarioEntity usuario = new UsuarioEntity();
		
		RoleEntity role = new RoleEntity();
	}
	
	@Test
	public void testeConsultarUsuarioComParametrosVariaveis() {
		
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setNome("Luiza");
		
		List<UsuarioEntity> listaUsuario = usuarioRepository.findAll(usuario.toSpec());
		
		for (UsuarioEntity usuarioEntity : listaUsuario) {
			System.out.println("=================================");
			System.out.println(usuarioEntity.toString());
			System.out.println(usuarioEntity.getPessoa().toString());
			System.out.println("=================================");
		}
	}

	@Test
	public void teste03ConsultaUsuario() {
		List<UsuarioEntity> list = usuarioRepository.findAll();
		
		for (UsuarioEntity usuarioEntity : list) {
			System.out.println(usuarioEntity);
		}
	}
	
	@Test
	public void teste04ConsultaUsuarioByPessoa() {
		
		try {
			UsuarioEntity usuario = usuarioRepository.findUsuarioByPessoa(pessoaId);
			System.out.println(usuario);
			
			if (usuario.getPessoa() != null)
				System.out.println(usuario.getPessoa());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void teste05ConsultaUsuarioByPessoaQueryNative() {
		UsuarioEntity usuario = usuarioRepository.findUserByPessoaQueryNative(pessoaId);
		
		System.out.println(usuario);
		try {
			System.out.println("PessoaId do usuario: " + usuario.getPessoa());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void teste06ConsultaUsuarioAndRole(){
		Optional<UsuarioEntity> usuario;
		
		usuario = usuarioRepository.findById(usuarioId);
		
		try {
			//Lendo lista de roles
			for (RoleEntity role : usuario.get().getAuthorities()) {
				System.out.println(role);
			}
		} catch (Exception ex) {
			System.out.println("ERRO - USUARIO SEM AUTHORITIES");
		}
	}
	
}
