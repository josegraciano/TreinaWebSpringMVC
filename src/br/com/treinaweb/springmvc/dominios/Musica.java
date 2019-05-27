package br.com.treinaweb.springmvc.dominios;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "mus_musicas")
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mus_id")
	private Long id;

	@NotNull(message = "O nome é obrigatório")
	@NotEmpty(message = "O nome é obrigatório")
	@Size(min = 3, max = 10, message = "O nome da música deve conter entre 3 e 10 caracteres")
	@Column(name = "mus_nome", length = 10, nullable = false)
	private String nome;

	@NotNull(message = "A data é obrigatória")
	@Column(name = "mus_data_criacao", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCriacao;

	//EAGER traz todas as dependências (Join) num único select
	//LAZY traz as dependências sob demanda
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "alb_id")
	private Album album;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}
