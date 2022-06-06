package com.leonardo.crud.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.crud.model.CidadeModel;
import com.leonardo.crud.model.ClienteModel;
import com.leonardo.crud.model.ResponseModel;
import com.leonardo.crud.repository.ClienteRepository;
import com.leonardo.crud.repository.ClienteRepositoryCustom;
import com.leonardo.crud.repository.CidadeRepository;

/**
 * Serviço de clientes.
 * @author Leonardo Rodrigues
 */

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository cliRepository;
	
	@Autowired
	private ClienteRepositoryCustom cliRepositoryCustom;
	
	
	
	/**
	 * Serviço de cadastro - verifica se o nome e cpf/cnpj do cliente informado não são nulos,
	 	Retorna com sucesso, 
	 * ou se as condições estiverem erradas com falha.
	 *  
	 */
	
	public ResponseModel cadastrar( ClienteModel cliente) {
		ResponseModel resposta = new ResponseModel();
		try {
			if(cliente.getNomeCliente()!=null){
				 if (cliente.getCpfCnpjCliente()!=null) {
					 
						cliente.setCodigoCliente(null);	
						cliente.setSituacaoCliente("A");	
						cliRepository.save(cliente);
						
						resposta.setMensagem("Cliente cadastrado com sucesso");
						resposta.setCodigo(1);
				 }
				 else {
						resposta.setMensagem("Insira o CPF ou CNPJ do cliente!"); 
						resposta.setCodigo(99);
					}
			} else {
				resposta.setMensagem("Insira o nome do cliente!"); 
				resposta.setCodigo(99);
			}
		} catch (Exception e) {
			resposta.setMensagem("Falha ao cadastrar: "+e.getMessage());
			resposta.setCodigo(99);
		}
		return resposta;
	}
	
	/**
	 * Serviço de remoção - remove o cliente atraves do codigo de registro,
	 *  Retorna sucesso ou falha.
	 */
	public ResponseModel remover(Integer codigoCliente) {		
		ResponseModel resposta = new ResponseModel();
		try {	
			ClienteModel cliente = cliRepository.findByCodigoCliente(codigoCliente);
			
			if(cliente != null) {
				cliente.setSituacaoCliente("I");
				this.cliRepository.save(cliente);
				resposta.setMensagem("Cliente removido com sucesso");
				resposta.setCodigo(1);
			
			} else {
				resposta.setMensagem("Cliente não cadastrado!");
				resposta.setCodigo(99);
			}
			
		} catch (Exception e) {
			resposta.setMensagem("Falha ao remover: "+e.getMessage());
			resposta.setCodigo(99);
		}
		return resposta;
	}
	/**
	 * Serviço de busca - retorna uma lista com todos os registros de cliente.
	 *
	 */
	 public List<ClienteModel> findAll() throws Exception {
		    return cliRepository.findAll();
		  }
	 
	/**
	 * Serviço de atualizar.
	 *
	 */
	 
	 public ResponseModel atualizar( ClienteModel cliente) {
			ResponseModel resposta = new ResponseModel();
			try {
				
				if(cliente.getNomeCliente()!=null){
					 if (cliente.getCpfCnpjCliente()!=null) {
						 ClienteModel listCliente = cliRepository.findByCodigoCliente(cliente.getCodigoCliente());	
							if(listCliente != null) {
								cliente.setSituacaoCliente("A");
								cliRepository.save(cliente);
								resposta.setMensagem("Cliente atualizado com sucesso");
								resposta.setCodigo(1);
							} else {
								resposta.setMensagem("Cliente não cadastrado! Realize o cadastro.");
								resposta.setCodigo(99);
							}
					 }
					 else {
							resposta.setMensagem("Insira o CPF ou CNPJ do cliente!"); 
							resposta.setCodigo(99);
						}
				} else {
					resposta.setMensagem("Insira o nome do cliente!"); 
					resposta.setCodigo(99);
				}

			} catch (Exception e) {
				resposta.setMensagem("Falha ao cadastrar: "+e.getMessage());
				resposta.setCodigo(99);
			}
			return resposta;
		}
	 
		/**
		 * Serviço de busca - retorna uma lista com todos os registros de clientes que estão ativos.
		 *
		 */
	 public List<ClienteModel> findBySituacao() throws Exception {
			    return cliRepository.findBySituacaoCliente("A");
			  }
		 
		 
	 /**
	  * Serviço de busca - retorna uma lista de clientes de acordo com cpf/cnpj.
	  *
			 */
	public List<ClienteModel> findByCpfCnpjCliente(String cpfCnpjCliente) throws Exception {
				    return cliRepository.findByCpfCnpjCliente(cpfCnpjCliente);
				  }
	
		/**
		 * Serviço de busca - retorna uma lista de clientes de acordo com o nome do cliente.
		 *
		 */
	 public List<ClienteModel> findByNomeCliente(String nomeCliente) throws Exception {
			  return cliRepository.findByNomeClienteContainingIgnoreCase(nomeCliente);
			}		
}
