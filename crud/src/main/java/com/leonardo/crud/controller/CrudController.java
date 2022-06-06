package com.leonardo.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.crud.model.ClienteModel;
import com.leonardo.crud.model.ResponseModel;
import com.leonardo.crud.model.CidadeModel;
import com.leonardo.crud.service.ClienteService;
import com.leonardo.crud.service.CidadeService;

/**
 * Controller gerenciador de clientes.
 * @author Leonardo Rodrigues
 */

@RestController
@RequestMapping("/api")
public class CrudController {
		
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CidadeService cidadeService;
	
	//clientes
	@RequestMapping(value="/cliente/listarTodos", method=RequestMethod.GET)
	public @ResponseBody List<ClienteModel> listar() throws Exception {
		return clienteService.findAll();
	}
	
	@RequestMapping(value="/cliente/listarAtivos", method=RequestMethod.GET)
	public @ResponseBody List<ClienteModel> listarClientesAtivos() throws Exception {
		return clienteService.findBySituacao();
	}
		
	@RequestMapping(value="/cliente/cadastrar", method=RequestMethod.POST)
	public @ResponseBody ResponseModel cadastrar(@RequestBody ClienteModel cliente) throws Exception {
		return clienteService.cadastrar(cliente);
	}
	
	@RequestMapping(value="/cliente/atualizar", method=RequestMethod.POST)
	public @ResponseBody ResponseModel atualizar(@RequestBody ClienteModel cliente) throws Exception {
		return clienteService.atualizar(cliente);
	}
	
	@RequestMapping(value="/cliente/remover/{codigoCliente}", method=RequestMethod.GET)
	public @ResponseBody ResponseModel remover(@PathVariable Integer codigoCliente) {
		return clienteService.remover(codigoCliente);
	}
	
	@RequestMapping(value="/cliente/listarNomeCliente", method=RequestMethod.GET)
	public @ResponseBody List<ClienteModel> listarNomeCliente( @RequestParam("nomeCliente") final String nomeCliente) throws Exception {
		return clienteService.findByNomeCliente(nomeCliente);
	}	

	//cidades
	@RequestMapping(value="/cidade/listarTodos", method=RequestMethod.GET)
	public @ResponseBody List<CidadeModel> listarCidade() throws Exception {
		return cidadeService.findAll();
	}
	
	@RequestMapping(value="/cidade/listarAtivas", method=RequestMethod.GET)
	public @ResponseBody List<CidadeModel> listarCidadesAtivas() throws Exception {
		return cidadeService.findBySituacao();
	}
	
	
	@RequestMapping(value="/cidade/cadastrar", method=RequestMethod.POST)
	public @ResponseBody ResponseModel cadastrarCidade(@RequestBody CidadeModel cidade) throws Exception {
		return cidadeService.cadastrar(cidade);
	}
	
	@RequestMapping(value="/cidade/atualizar", method=RequestMethod.POST)
	public @ResponseBody ResponseModel atualizarCidade(@RequestBody CidadeModel cidade) throws Exception {
		return cidadeService.atualizar(cidade);
	}
	
	@RequestMapping(value="/cidade/remover/{codigoCidade}", method=RequestMethod.GET)
	public @ResponseBody ResponseModel removerCidade(@PathVariable Integer codigoCidade) {
		return cidadeService.remover(codigoCidade);
	}
	
	@RequestMapping(value="/cidade/listarDescricaoCidade", method=RequestMethod.GET)
	public @ResponseBody List<CidadeModel> listarDescricaoCidade( @RequestParam("descricaoCidade") final String descricaoCidade) throws Exception {
		return cidadeService.findByDescricaoCidade(descricaoCidade);
	}	
	

	//PARTE 02 - API INTEGRAÇÃO
	@RequestMapping(value="/cliente/listarCpfCnpj", method=RequestMethod.GET)
	public @ResponseBody List<ClienteModel> listarCpfCnpj(@RequestParam("cpfCnpjCliente") final String cpfCnpjCliente) throws Exception {
		return clienteService.findByCpfCnpjCliente(cpfCnpjCliente);
	}
}
