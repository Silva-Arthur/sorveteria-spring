package br.com.sorveteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
@SequenceGenerator(name = "seq_role", sequenceName = "seq_role", allocationSize = 1, initialValue = 1 )
public class RoleEntity implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
	@Column(name = "roleid")
	private Long roleId;
	
	private String nomeRole; /*Papel, exemplo ROLE_SECRETARIO ou ROLE_GERENTE*/

	/*Retorna o nome do papel, acesso ou autorizacao, exemplo ROLO_GERENTE */
	@Override
	public String getAuthority() {
		return this.nomeRole;
	}

	public Long getId() {
		return roleId;
	}

	public void setId(Long id) {
		this.roleId = id;
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	@Override
	public String toString() {
		return "Role [id=" + roleId + ", nomeRole=" + nomeRole + "]";
	}
	
	
	
}
