package com.leonardo.crud.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.leonardo.crud.model.ClienteModel;
import com.leonardo.crud.model.ResponseModel;
import com.leonardo.crud.model.CidadeModel;
import com.leonardo.crud.service.ClienteService;
import com.leonardo.crud.service.CidadeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTest {
	
//	@Autowired
//	private ClienteService cliService;
//	
//	@Autowired
//	private CidadeService telService;
//	
//	@Test
//	public void telefoneNaoNulo() {
//		ClienteModel cliente = new ClienteModel(null,"leonardo rodrigues","Kazuo Murakami","Centro",null,null);
//		ResponseModel resposta = cliService.cadastrar(cliente);
//		assertEquals("O Telefone não pode ser nulo! Selecione!", resposta.getMensagem());
//	}
//
//	@Test
//	public void telefoneJaCadastradoEmUmCliente() {
//		ClienteModel cliente = new ClienteModel(null,"joao pedro morais","Kazuo Murakami","Centro",2,"88888888888");
//		ResponseModel resposta = cliService.cadastrar(cliente);
//		assertEquals("Telefone relacionado a outro cliente!", resposta.getMensagem());
//
//	}		
//
//	@Test
//	public void telefoneNaoCadastrado() {
//		ClienteModel cliente = new ClienteModel(null,"Leonardo souza rodrigues 3","Kazuo Murakami","Centro",999,"23456789234");
//		ResponseModel resposta = cliService.cadastrar(cliente);
//		assertEquals("Telefone não encontrado!", resposta.getMensagem());
//
//	}
//	
//	@Test
//	public void clienteRemovidoComSucesso() {
//		ResponseModel resposta = cliService.remover(3);
//		assertEquals("Cliente removido com sucesso", resposta.getMensagem());
//	}
//	
//	@Test
//	public void cadastroCliente() {
//		ClienteModel cliente = new ClienteModel(null,"Leonardo souza rodrigues","Kazuo Murakami","Centro",3,"123456789876");
//		ResponseModel resposta = cliService.cadastrar(cliente);
//		assertEquals("Cliente cadastrado com sucesso", resposta.getMensagem());
//
//	}	
//	
//	@Test
//	public void cadastroTelefone() {
//		TelefoneModel telefone = new TelefoneModel(null,"123456789876",null,null,null);
//		ResponseModel resposta = telService.cadastrar(telefone);
//		assertEquals(1,resposta.getCodigo());
//	}
//	
//	@Test
//	public void telefoneRemovidoComSucesso() {
//		ResponseModel resposta = telService.remover(6);
//		assertEquals("Telefone removido com sucesso", resposta.getMensagem());
//	}
}
