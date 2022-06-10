package br.com.sorveteria.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sorveteria.model.PessoaEntity;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long>, JpaSpecificationExecutor<PessoaEntity>{

	/**
	 * Query baseada em hql para carregar as agregações
	 * */
	@Query(value = "select p from PessoaEntity p where p.pessoaId = :pessoaId")
	public PessoaEntity findByIdWithUsuario(@Param("pessoaId") Long id);

	/**
	 * Query baseada no {@link EntityGraph} para carregar as agregações
	 * */
	/*@EntityGraph(attributePaths = {"usuario"})
	@Query(value = "select p from PessoaEntity p where p.pessoaId = :pessoaId")
	public PessoaEntity findByIdWithAgregations(@Param("pessoaId") Long id);*/
	@Query(value = "select p from PessoaEntity p where p.pessoaId = :pessoaId")
	public PessoaEntity findByIdWithAgregations(@Param("pessoaId") Long id);
	
	@Query(value = "select p.pessoaId from PessoaEntity p where p.cpf = :cpf")
	public Long findPessoaPorCpf(@Param("cpf") String cpf);
	
	@Query(value = "select p.pessoaId from PessoaEntity p where p.rg = :rg")
	public Long findPessoaPorRg(@Param("rg") String rg);
}
