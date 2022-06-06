package com.leonardo.crud.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import com.leonardo.crud.model.ClienteModel;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Transactional
public class ClienteRepositoryCustom {
	  @PersistenceContext
	  private EntityManager entityManager;

	  public List<ClienteModel> findByCustom(String nomeCliente, String cpfCnpjCliente, String telefoneCliente, String descricaoCidade) throws Exception {

	    List<ClienteModel> ltResult = null;

	    try {

	      CriteriaBuilder cb = entityManager.getCriteriaBuilder();

	      CriteriaQuery<ClienteModel> query = cb.createQuery(ClienteModel.class);

	      Root<ClienteModel> root = query.from(ClienteModel.class);

	      List<Predicate> predicates = new ArrayList<>();

	      if (nomeCliente != null) {
	        StringBuilder cliStr = new StringBuilder();
	        cliStr.append("%").append(nomeCliente.replace(" ", "%")).append("%");

	        Predicate predicate = cb.like(root.get("nomeCliente"), cliStr.toString());
	        predicates.add(predicate);
	      }

	      if (cpfCnpjCliente != null) {
	        Predicate cpfCnpjClienteEqual = cb.equal(root.get("cpfCnpjCliente"), cpfCnpjCliente);
	        predicates.add(cpfCnpjClienteEqual);
	      }

	      if (descricaoCidade != null) {
	        StringBuilder descricaoCidadeStr = new StringBuilder();
	        descricaoCidadeStr.append("%").append(descricaoCidade.replace(" ", "%")).append("%");

	        Predicate predicate = cb.like(root.get("descricaoCidade"), descricaoCidadeStr.toString().toUpperCase());
	        predicates.add(predicate);
	      }

	      if (telefoneCliente != null) {
	        Predicate telefoneClienteEqual = cb.equal(root.get("telefoneCliente"), telefoneCliente);
	        predicates.add(telefoneClienteEqual);
	      }


	      query.where(predicates.toArray(new Predicate[predicates.size()]))
	          .orderBy(cb.desc(root.get("codigoCliente")));

	      ltResult = entityManager.createQuery(query).setMaxResults(500).getResultList();

	    } catch (Exception e) {
	    	System.out.println("findByCustom: " + e.toString());
	    }

	    return ltResult;
	  }
}
