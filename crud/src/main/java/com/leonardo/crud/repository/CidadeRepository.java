package com.leonardo.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.leonardo.crud.model.CidadeModel;

/**
 * Repositorio de telefone.
 * @author Leonardo Rodrigues
 */
public interface CidadeRepository extends CrudRepository<CidadeModel, Integer> {
	
	List<CidadeModel> findAll();
	
	CidadeModel findByCodigoCidade (int codigoCidade);
	
	List<CidadeModel> findBySituacaoCidade (String situacaoCidade);

	List<CidadeModel> findByDescricaoCidadeContainingIgnoreCase (String descricaoCidade);
	
	void delete(CidadeModel cliente);

	<TelMod extends CidadeModel> TelMod save(TelMod cliente); 
	
//	CidadeModel findByNumeroTelefone (String numeroTelefone);

}
