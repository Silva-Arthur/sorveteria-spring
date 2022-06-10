package br.com.sorveteria.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "faturamento_diario")
@Entity
public class FaturamentoDiarioEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "faturamentodiarioid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long faturamentoDiarioId;
	
	@Column(name = "valorfaturado")
	private BigDecimal valorFaturado;
	
	@Column(name = "datafaturamento")
	private Date dataFaturamento;
	
	@Column(name = "datacriacao")
	private Date dataCriacao;
	
	@Column(name = "dataatualizacao")
	private Date dataAtualizacao;
	
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name = "usuarioid")
	private UsuarioEntity usuario;

	public Long getFaturamentoDiarioId() {
		return faturamentoDiarioId;
	}

	public void setFaturamentoDiarioId(Long faturamentoDiarioId) {
		this.faturamentoDiarioId = faturamentoDiarioId;
	}

	public BigDecimal getValorFaturado() {
		return valorFaturado;
	}

	public void setValorFaturado(BigDecimal valorFaturado) {
		this.valorFaturado = valorFaturado;
	}

	public Date getDataFaturamento() {
		return dataFaturamento;
	}

	public void setDataFaturamento(Date dataFaturamento) {
		this.dataFaturamento = dataFaturamento;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataFaturamento == null) ? 0 : dataFaturamento.hashCode());
		result = prime * result + ((faturamentoDiarioId == null) ? 0 : faturamentoDiarioId.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((valorFaturado == null) ? 0 : valorFaturado.hashCode());
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
		FaturamentoDiarioEntity other = (FaturamentoDiarioEntity) obj;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataFaturamento == null) {
			if (other.dataFaturamento != null)
				return false;
		} else if (!dataFaturamento.equals(other.dataFaturamento))
			return false;
		if (faturamentoDiarioId == null) {
			if (other.faturamentoDiarioId != null)
				return false;
		} else if (!faturamentoDiarioId.equals(other.faturamentoDiarioId))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valorFaturado == null) {
			if (other.valorFaturado != null)
				return false;
		} else if (!valorFaturado.equals(other.valorFaturado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FaturamentoDiarioEntity [faturamentoDiarioId=" + faturamentoDiarioId + ", valorFaturado="
				+ valorFaturado + ", dataFaturamento=" + dataFaturamento + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", observacao=" + observacao + "]";
	}

	
	
}
