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
public class CidadeRepositoryCustom {
	  @PersistenceContext
	  private EntityManager entityManager;

	  public List<ClienteModel> findByCustom(String descricaoCidade, String ufCidade) throws Exception {

	    List<ClienteModel> ltResult = null;

	    try {

	      CriteriaBuilder cb = entityManager.getCriteriaBuilder();

	      CriteriaQuery<ClienteModel> query = cb.createQuery(ClienteModel.class);

	      Root<ClienteModel> root = query.from(ClienteModel.class);

	      List<Predicate> predicates = new ArrayList<>();

	      if (ufCidade != null) {
	        Predicate ufCidadeEqual = cb.equal(root.get("ufCidade"), ufCidade);
	        predicates.add(ufCidadeEqual);
	      }

	      if (descricaoCidade != null) {
	        StringBuilder descricaoCidadeStr = new StringBuilder();
	        descricaoCidadeStr.append("%").append(descricaoCidade.replace(" ", "%")).append("%");

	        Predicate predicate = cb.like(root.get("descricaoCidade"), descricaoCidadeStr.toString().toUpperCase());
	        predicates.add(predicate);
	      }

	      query.where(predicates.toArray(new Predicate[predicates.size()]))
	          .orderBy(cb.desc(root.get("codigoCidade")));

	      ltResult = entityManager.createQuery(query).setMaxResults(500).getResultList();

	    } catch (Exception e) {
	    	System.out.println("findByCustom: " + e.toString());
	    }

	    return ltResult;
	  }
}
