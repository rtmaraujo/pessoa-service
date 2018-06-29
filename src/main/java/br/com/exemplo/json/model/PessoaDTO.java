package br.com.exemplo.json.model;

public class PessoaDTO {

	private Integer codigo;
	private String mensagem;

	public PessoaDTO() {
	}

	public PessoaDTO(Integer codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
