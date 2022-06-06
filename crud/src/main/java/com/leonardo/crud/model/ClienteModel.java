package com.leonardo.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

/**
 * Classe que representa os Clientes na aplicação.
 * @author Leonardo Rodrigues
 */

@Entity
@NoArgsConstructor
@Table(name="cliente")
public class ClienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo_cliente")
	private Integer codigoCliente;
	
	@Column(name="nome_cliente")
	private String nomeCliente;
	
	@Column(name="endereco_cliente")
	private String enderecoCliente;
	
	@Column(name="bairro_cliente")
	private String bairroCliente; 
	
	@Column(name="codigo_cidade")
	private Integer codigoCidade;
	
	@Column(name="descricao_cidade")
	private String descricaoCidade;
	
	@Column(name="email_cliente")
	private String emailCliente;
	
	@Column(name="cpf_cnpj_cliente")
	private String cpfCnpjCliente;
	
	@Column(name="numero_cliente")
	private String numeroCliente;
	
	@Column(name="cep_cliente")
	private String cepCliente;
	
	@Column(name="telefone_cliente")
	private String telefoneCliente;
	
	@Column(name="situacao_cliente")
	private String situacaoCliente;

	


	public ClienteModel(Integer codigoCliente, String nomeCliente, String enderecoCliente, String bairroCliente,
			Integer codigoCidade, String descricaoCidade, String emailCliente, String cpfCnpjCliente,
			String numeroCliente, String cepCliente, String telefoneCliente, String situacaoCliente) {
		super();
		this.codigoCliente = codigoCliente;
		this.nomeCliente = nomeCliente;
		this.enderecoCliente = enderecoCliente;
		this.bairroCliente = bairroCliente;
		this.codigoCidade = codigoCidade;
		this.descricaoCidade = descricaoCidade;
		this.emailCliente = emailCliente;
		this.cpfCnpjCliente = cpfCnpjCliente;
		this.numeroCliente = numeroCliente;
		this.cepCliente = cepCliente;
		this.telefoneCliente = telefoneCliente;
		this.situacaoCliente = situacaoCliente;
	}
	
	



	public Integer getCodigoCliente() {
		return codigoCliente;
	}





	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}





	public String getNomeCliente() {
		return nomeCliente;
	}





	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}





	public String getEnderecoCliente() {
		return enderecoCliente;
	}





	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}





	public String getBairroCliente() {
		return bairroCliente;
	}





	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
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





	public String getEmailCliente() {
		return emailCliente;
	}





	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}





	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}





	public void setCpfCnpjCliente(String cpfCnpjCliente) {
		this.cpfCnpjCliente = cpfCnpjCliente;
	}





	public String getNumeroCliente() {
		return numeroCliente;
	}





	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}





	public String getCepCliente() {
		return cepCliente;
	}





	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}





	public String getTelefoneCliente() {
		return telefoneCliente;
	}





	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}





	public String getSituacaoCliente() {
		return situacaoCliente;
	}





	public void setSituacaoCliente(String situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}





	public ClienteModel() {
		
	}
}
