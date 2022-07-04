package dao;

import java.sql.PreparedStatement;

import interfaces.InterfaceCompraDAO;
import model.Compra;

public class CompraDAO implements InterfaceCompraDAO {

	@Override
	public void salvar(Compra compra) {
		try{            
        	String sql="INSERT INTO compra (idProd,valorProd,valorFrete,prazoEntrega,idCliente,cepDes) VALUES (?,?,?,?,?,?)";
        	
                PreparedStatement psm = new ConexaoDAO().getConn().prepareStatement(sql);
                psm.setInt(1,compra.getIdProd());
                psm.setDouble(2,compra.getValorProd());
                psm.setDouble(3,compra.getValorFrete());
                psm.setInt(4,compra.getPrazoEntrega());
                psm.setInt(5,compra.getIdCliente());
                psm.setString(6, compra.getCepDes());             
                            
            }catch (Exception e) {
				System.out.println("Erro ao adicionar o produto no carrinho");
			} 
		
	}

}
