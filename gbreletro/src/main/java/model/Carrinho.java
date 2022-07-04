package model;

public class Carrinho {
	
	private int id;
	private int idProd;
	
	public Carrinho(int idProd) {
		this.idProd=idProd; 
	}
	
	public int getId() {
		return id;
	}
			
	public int getIdProd() {
		return idProd;
	}
		
}
