package com.controle.api.repository.cartao;

import java.util.List;

import com.controle.api.entities.Cartao;
import com.controle.api.repository.filter.CartaoFilter;

public interface CartaoRepositoryQuery {
	
	public List<Cartao> filtrar(CartaoFilter cartaoFilter);

}
