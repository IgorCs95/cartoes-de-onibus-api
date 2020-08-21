package com.controle.api.ennum;

public enum TipoCartao{

	COMUM("comun"), ESTUDANTE("estudande"), TRABALHADOR("trabalhador");

	private String descricao;

	TipoCartao(String descricao) {
	        this.descricao = descricao;
	    }

	public String getDescricao() {
		return descricao;
	}

}
