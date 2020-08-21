package com.controle.api.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriarEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse resposne;
	private Long codigo;
	
	public RecursoCriarEvent(Object source, HttpServletResponse resposne,Long codigo) {
		super(source);
		this.resposne = resposne;
		this.codigo = codigo;
	}

	public HttpServletResponse getResposne() {
		return resposne;
	}

	public Long getCodigo() {
		return codigo;
	}
	

}
