package br.com.sorveteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sorveteria.model.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>, JpaSpecificationExecutor<UsuarioEntity>{
	
	List<UsuarioEntity> findByUsuario(String usuario);
	
	@Transactional
	@Modifying
	@Query("update UsuarioEntity set token = ?1 where usuario = ?2 ")
	void atualizaTokenUser(String token, String login);
	
	@Query("select u from UsuarioEntity u where u.usuario = ?1")
	UsuarioEntity findUserByLogin(String login);
	
	@Query( nativeQuery = true, value =
			  "select * from usuario as u "
			+ "inner join pessoa as p on p.pessoa_id = u.pessoaid "
			+ "where p.pessoaid = ?1")
	UsuarioEntity findUserByPessoaQueryNative(Long pessoaId);
	
	@Query("from UsuarioEntity u left join u.pessoa p where p.pessoaId = ?1")
	UsuarioEntity findUsuarioByPessoa(Long pessoaId);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "insert into usuarios_role(usuarioid, roleid) values (?1, (select roleid from role where nome_role = 'ROLE_USER'));")
	void insereAcessoRolePadrao(Long id);
	
	
}
