package model;

public class Cliente {
	private int idClie;
	private String nomeClie;
	private String endereco;
	private String cep;
	private String logEmail;
	private String senha;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String endereco, String cep, String logEmail, String senha) {
		this.nomeClie = nome;
		this.endereco = endereco;
		this.cep=cep;
		this.logEmail= logEmail;
		this.senha=senha;
	}

	public int getIdClie() {
		return idClie;
	}
	
	public String getNomeClie() {
		return nomeClie;
	}
	public void setNomeClie(String nomeClie) {
		this.nomeClie = nomeClie;
	}
	
	public String getLogEmail() {
		return logEmail;
	}
	public void setLogEmail(String logEmail) {
		this.logEmail = logEmail;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
