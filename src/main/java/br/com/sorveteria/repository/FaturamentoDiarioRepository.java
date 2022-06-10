package br.com.sorveteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.sorveteria.model.FaturamentoDiarioEntity;

@Repository
public interface FaturamentoDiarioRepository extends JpaRepository<FaturamentoDiarioEntity, Long>, JpaSpecificationExecutor<FaturamentoDiarioEntity>{

}
