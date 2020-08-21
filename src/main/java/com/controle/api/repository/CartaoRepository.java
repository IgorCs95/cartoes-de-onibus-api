package com.controle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle.api.entities.Cartao;
import com.controle.api.repository.cartao.CartaoRepositoryQuery;

public interface CartaoRepository  extends JpaRepository<Cartao,Long>,CartaoRepositoryQuery{

}
