package com.leonardo.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.crud.model.CidadeModel;
import com.leonardo.crud.model.ClienteModel;
import com.leonardo.crud.model.ResponseModel;
import com.leonardo.crud.repository.CidadeRepository;

/**
 * Serviço de telefones.
 * @author Leonardo Rodrigues
 */

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	/**
	 * Serviço de cadastro de cidade.
	 *  Retorna sucesso ou falha.
	 */
	public ResponseModel cadastrar( CidadeModel cidade) {
		ResponseModel resposta = new ResponseModel();
		try {
				cidade.setCodigoCidade(null);	
				cidade.setSituacaoCidade("A");
				repository.save(cidade);
				resposta.setMensagem("Cidade cadastrada com sucesso");
				resposta.setCodigo(1);
		} catch (Exception e) {
			resposta.setMensagem("Falha ao cadastrar: "+e.getMessage());
			resposta.setCodigo(99);
		}
		return resposta;
	}
	
	/**
	 * Serviço de atualização de cidade.
	 *  Retorna sucesso ou falha.
	 */
	public ResponseModel atualizar( CidadeModel cidade) {
		ResponseModel resposta = new ResponseModel();
		try {
				CidadeModel listCidade = repository.findByCodigoCidade(cidade.getCodigoCidade());
				if(listCidade != null) {
					cidade.setSituacaoCidade("A");
					repository.save(cidade);
					resposta.setMensagem("Cidade atualizada com sucesso");
					resposta.setCodigo(1);
				} else {
					resposta.setMensagem("Cidade não cadastrada! Realize o cadastro.");
					resposta.setCodigo(99);
				}
				
		} catch (Exception e) {
			resposta.setMensagem("Falha ao cadastrar: "+e.getMessage());
			resposta.setCodigo(99);
		}
		return resposta;
	}
	
	/**
	 * Serviço de remoção - remove a cidade atraves do codigo de registro.
	 *  Retorna sucesso ou falha.
	 */
	public ResponseModel remover(Integer codigoCidade) {		
		ResponseModel resposta = new ResponseModel();
		try {			
			CidadeModel cidade = repository.findByCodigoCidade(codigoCidade);
			if(cidade!=null) {
				cidade.setSituacaoCidade("I");
				this.repository.save(cidade);
				resposta.setMensagem("Cidade removida com sucesso");
				resposta.setCodigo(1);
			} else {
				resposta.setMensagem("Cidade não cadastrada!");
				resposta.setCodigo(99);
			}
			
		} catch (Exception e) {
			resposta.setMensagem("Falha ao remover: "+e.getMessage());
			resposta.setCodigo(99);
		}
		return resposta;
	}
	
	/**
	 * Serviço de busca - retorna uma lista com todos os registros de cidade.
	 *
	 */
	 public List<CidadeModel> findAll() throws Exception {
		    return repository.findAll();
		  }
	 
		/**
		 * Serviço de busca - retorna uma lista com todos os registros de cidade que estão ativos.
		 *
		 */
	 public List<CidadeModel> findBySituacao() throws Exception {
			    return repository.findBySituacaoCidade("A");
			  }
	 
		/**
		 * Serviço de busca - retorna uma lista de cidades de acordo com a descricao da cidade.
		 *
		 */
	 public List<CidadeModel> findByDescricaoCidade(String descricaoCidade) throws Exception {
			  return repository.findByDescricaoCidadeContainingIgnoreCase(descricaoCidade);
			}
	 
		/**
		 * Serviço de busca - retorna uma lista de cidades de acordo com a uf da cidade.
		 *
		 */

}
