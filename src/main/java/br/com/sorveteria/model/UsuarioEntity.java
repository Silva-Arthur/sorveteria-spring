package br.com.sorveteria.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "usuario")
@Entity
public class UsuarioEntity implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuarioid")
	Long usuarioId;
	
	private String nome;
    private String rg;
    private String email;
    private String telefone;
    private String celular;
    private String rua;
    private String cidade;
    private String estado;
    private String bairro;
    
    private String usuario;    

    private String senha;
    
    private String cpf;
    private String token;
    
    /*Os papeis ou acessos*/
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint(
			columnNames = {"usuarioid", "roleid"}, name = "unique_role_user"),
	
	joinColumns = @JoinColumn(name = "usuarioid", referencedColumnName = "usuarioid", table = "usuario", unique = false,
	foreignKey = @ForeignKey(name = "fk_usuario_usuarios_role", value = ConstraintMode.CONSTRAINT)),
	
	inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleid", table = "role", unique = false, updatable = false),
	foreignKey = @ForeignKey(name = "fk_role_usuarios_role", value = ConstraintMode.CONSTRAINT))
	private List<RoleEntity> roles;
    
    @Column(name = "datanascimento")
    private Date dataNascimento;
    
    @Column(name = "datacadastro")
    private Date dataCadastro;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoaid")
    private PessoaEntity pessoa;
    
    
    public PessoaEntity getPessoa() {
		return pessoa;
	}
    
    public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((usuarioId == null) ? 0 : usuarioId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (usuarioId == null) {
			if (other.usuarioId != null)
				return false;
		} else if (!usuarioId.equals(other.usuarioId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [usuarioId=" + usuarioId + ", nome=" + nome + ", rg=" + rg + ", email=" + email
				+ ", telefone=" + telefone + ", celular=" + celular + ", rua=" + rua + ", cidade=" + cidade
				+ ", estado=" + estado + ", bairro=" + bairro + ", usuario=" + usuario + ", senha=" + senha + ", cpf="
				+ cpf + ", dataNascimento=" + dataNascimento + ", dataCadastro=" + dataCadastro + "]";
	}
	
	public Specification<UsuarioEntity> toSpec() {
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if (StringUtils.hasText(this.usuario)) {
				Path<String> campoUsuario = root.<String>get("usuario");
				Predicate predicadoUsuario = builder.like(campoUsuario, "%" + this.usuario + "%");
				predicados.add(predicadoUsuario);
			}
			if (StringUtils.hasText(this.cpf)) {
				Path<String> campoCpf = root.<String>get("cpf");
				Predicate predicadoCpf = builder.equal(campoCpf, this.cpf);
				predicados.add(predicadoCpf);
			}
			if (StringUtils.hasText(this.nome)) {
				Join<UsuarioEntity, PessoaEntity> campoPessoa = root.join("pessoa");
				Path<String> campoNomePessoa = campoPessoa.<String>get("nome");
				Predicate predicadoNomePessoa = builder.like(campoNomePessoa, "%" + this.nome + "%");
				predicados.add(predicadoNomePessoa);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}

	/*São os acessos do usuario ROLE_ADMIN, ROLE_VISITANTE*/
	@Override
	@JsonIgnore
	public Collection<RoleEntity> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
