package com.controle.api.repository.cartao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.controle.api.entities.Cartao;
import com.controle.api.entities.Cartao_;
import com.controle.api.repository.filter.CartaoFilter;

public class CartaoRepositoryImpl implements CartaoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cartao> filtrar(CartaoFilter lancamentoFilter) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cartao> criteria = builder.createQuery(Cartao.class);
		Root<Cartao> root = criteria.from(Cartao.class);

		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Cartao> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(CartaoFilter cartaoFilter, CriteriaBuilder builder, Root<Cartao> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (cartaoFilter.getNumeroCartao() != null) {
			predicates.add(builder.equal(root.get(Cartao_.numeroCartao), cartaoFilter.getNumeroCartao()));
		}

		if (cartaoFilter.getUser_id() != null) {

			predicates.add(builder.equal(root.get(Cartao_.user), cartaoFilter.getUser_id()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}
