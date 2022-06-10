package br.com.sorveteria.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

@Table(name = "pessoa") /*para caso a tabela tenha um nome diferente da classe*/
@Entity /*o atributo nome pode ser usado caso, quera-se dar um nome específico a essa entidade para trabalhar com hql*/
public class PessoaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pessoaid")
	Long pessoaId;
	
	private String nome;
	private String cpf;
    private String rg;
    private String email;
    private String telefone;
    private String celular;
    private String rua;
    private String cidade;
    private String estado;
    private String bairro;
    
    @Column(name = "estadocivil")
    private String estadoCivil;

    @Column(name = "datanascimento")
    private Date dataNascimento;
    
    private String escolaridade;
    private String obs;
    private String indicacao;
    
    @Column(name = "datacadastro")
    private Date dataCadastro;
    
    @Column(name = "usuarioid")
    private Long usuarioId;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@Override
	public String toString() {
		return "PessoaEntity [pessoaId=" + pessoaId + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", email="
				+ email + ", telefone=" + telefone + ", celular=" + celular + ", rua=" + rua + ", cidade=" + cidade
				+ ", estado=" + estado + ", bairro=" + bairro + ", estadoCivil=" + estadoCivil + ", dataNascimento="
				+ dataNascimento + ", escolaridade=" + escolaridade + ", obs=" + obs + ", indicacao=" + indicacao
				+ ", dataCadastro=" + dataCadastro + ", usuarioId=" + usuarioId + "]";
	}

	/**
	 * Realiza query dinamica por: nome, cpf, rg, escolaridade, indicação e bairro
	 * 
	 * */
	public Specification<PessoaEntity> toSpec() {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if (StringUtils.hasText(nome)) {
				Path<String> campoNome = root.<String>get("nome");
				Predicate predicadoNome = builder.like(campoNome, "%" + this.nome + "%");
				predicados.add(predicadoNome);
			}
			if (StringUtils.hasText(cpf)) {
				Path<String> campoCpf = root.get("cpf");
				Predicate predicadoCpf = builder.equal(campoCpf, this.cpf);
				predicados.add(predicadoCpf);
			}
			if (StringUtils.hasText(rg)) {
				Path<String> campoRg = root.get("rg");
				Predicate predicadoRg = builder.equal(campoRg, this.rg);
				predicados.add(predicadoRg);
			}
			if (StringUtils.hasText(escolaridade)) {
				Path<String> campoEscolaridade = root.get("escolaridade");
				Predicate predicadoEscolaridade = builder.equal(campoEscolaridade, this.escolaridade);
				predicados.add(predicadoEscolaridade);
			}
			if (StringUtils.hasText(indicacao)) {
				Path<String> campoIndicacao = root.<String>get("indicacao");
				Predicate predicadoIndicacao = builder.like(campoIndicacao, "%" + this.indicacao + "%");
				predicados.add(predicadoIndicacao);
			}
			if (StringUtils.hasText(bairro)) {
				Path<String> campoBairro = root.get("bairro");
				Predicate predicadoBairro = builder.equal(campoBairro, this.bairro);
				predicados.add(predicadoBairro);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
    
}
