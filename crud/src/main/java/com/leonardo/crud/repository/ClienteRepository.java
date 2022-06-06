package com.leonardo.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.leonardo.crud.model.ClienteModel;
/**
 * Repositorio de cliente.
 * @author Leonardo Rodrigues
 */
public interface ClienteRepository extends CrudRepository<ClienteModel, Integer> {
	
	List<ClienteModel> findAll();
	
	ClienteModel findByCodigoCliente (Integer codigoCliente);
	
	List<ClienteModel> findBySituacaoCliente (String  situacaoCliente);
	
	void delete(ClienteModel cliente);
	
	List<ClienteModel> findByCpfCnpjCliente (String cpfCnpjCliente);
	
	List<ClienteModel> findByNomeClienteContainingIgnoreCase (String nomeCliente);

	<CliMod extends ClienteModel> CliMod save(CliMod cliente); 

}
