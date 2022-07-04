package model;

public class Compra {	
		private int idCliente;
		private int idProd;		
		private double valorProd;
		private String cepDes;
		private double valorFrete;
		private int prazoEntrega;
		
					
		public double getValorProd() {
			return valorProd;
		}
		
		public void setValorProd(double valorProd) {
			this.valorProd = valorProd;
		}
		
		public String getCepDes() {
			return cepDes;
		}
		
		public void setCepDes(String cepDes) {
			this.cepDes = cepDes;
		}
		
		public double getValorFrete() {
			return valorFrete;
		}
		
		public void setValorFrete(double valorFrete) {
			this.valorFrete = valorFrete;
		}
		
		public int getPrazoEntrega() {
			return prazoEntrega;
		}
		
		public void setPrazoEntrega(int prazoEntrega) {
			this.prazoEntrega = prazoEntrega;
		}

		public int getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		public int getIdProd() {
			return idProd;
		}

		public void setIdProd(int idProd) {
			this.idProd = idProd;
		}
}
