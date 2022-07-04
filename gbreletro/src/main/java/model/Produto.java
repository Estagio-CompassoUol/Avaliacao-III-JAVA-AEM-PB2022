package model;

public class Produto {
	private int idProd;
	private String nomeProd;
	private String descricao;
	private double valor;
	
	public Produto() {
		
	}
	
	public Produto(int id, String nome, String descricao, double valor) {
		this.idProd = id;
		this.nomeProd = nome;
		this.descricao = descricao;
		this.valor = valor;			
		
	}
	
	
	public int getIdProd() {
		return idProd;
	}
	
	public String getNomeProd() {
		return nomeProd;
	}
	
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
