package com.leonardo.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa as Cidades na aplicação.
 * @author Leonardo Rodrigues
 */

@Entity
@Table(name="cidade")
public class CidadeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_cidade")
	private Integer codigoCidade;
	
	@Column(name="descricao_cidade")
	private String descricaoCidade;
	
	@Column(name="uf_cidade")
	private String ufCidade;

	@Column(name="situacao_cidade")
	private String situacaoCidade;

	public CidadeModel(Integer codigoCidade, String descricaoCidade, String ufCidade, String situacaoCidade) {
		super();
		this.codigoCidade = codigoCidade;
		this.descricaoCidade = descricaoCidade;
		this.ufCidade = ufCidade;
		this.situacaoCidade = situacaoCidade;
	}

	public Integer getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	public String getDescricaoCidade() {
		return descricaoCidade;
	}

	public void setDescricaoCidade(String descricaoCidade) {
		this.descricaoCidade = descricaoCidade;
	}

	public String getUfCidade() {
		return ufCidade;
	}

	public void setUfCidade(String ufCidade) {
		this.ufCidade = ufCidade;
	}

	public String getSituacaoCidade() {
		return situacaoCidade;
	}

	public void setSituacaoCidade(String situacaoCidade) {
		this.situacaoCidade = situacaoCidade;
	}

	public CidadeModel() {
		
	}
	
	
	
}
