package com.controle.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.controle.api.ennum.TipoCartao;
import com.sun.istack.NotNull;

@Entity
@Table(name = "cartao", schema = "public")
public class Cartao {

	@Id
	@Column(name = "numero_cartao")
	private Long numeroCartao;

	@NotNull
	private String nome;

	@NotNull
	private boolean status;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_cartao")
	private TipoCartao tipocartao;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public String getNome() {
		return nome;
	}

	public boolean isStatus() {
		return status;
	}

	public TipoCartao getTipocartao() {
		return tipocartao;
	}

	public User getUser() {
		return user;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setTipocartao(TipoCartao tipocartao) {
		this.tipocartao = tipocartao;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroCartao == null) ? 0 : numeroCartao.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		if (numeroCartao == null) {
			if (other.numeroCartao != null)
				return false;
		} else if (!numeroCartao.equals(other.numeroCartao))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cartao [numeroCartao=" + numeroCartao + ", nome=" + nome + ", status=" + status + ", tipocartao="
				+ tipocartao + ", user=" + user + "]";
	}

}
