package br.com.alura.forum.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {

	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String mensagem;
	@NotNull
	@NotEmpty
	private String titulo;

	public AtualizacaoTopicoForm() {
	}
	
	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Optional<Topico> topico = topicoRepository.findById(id);
		if(topico.isPresent()) {
			topico.get().setTitulo(this.titulo);
			topico.get().setMensagem(this.mensagem);	
			return topico.get();
		}
		return null;		
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

}
