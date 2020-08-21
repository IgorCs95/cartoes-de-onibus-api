package com.controle.api.entities;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.controle.api.ennum.TipoCartao;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cartao_.class)
public abstract class Cartao_ {

	public static volatile SingularAttribute<Cartao, Long> numeroCartao;
	public static volatile SingularAttribute<Cartao, String> nome;
	public static volatile SingularAttribute<Cartao, Boolean> status;
	public static volatile SingularAttribute<Cartao, TipoCartao> tipocartao;
	public static volatile SingularAttribute<Cartao, User> user;

}