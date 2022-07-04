package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Acao;
import model.Carrinho;

public class CarrinhoDAO{		

		
	public void salvar(int id) {
        try{            
        	String sql="INSERT INTO carrinho (idProd) VALUES (?)";
        	
                PreparedStatement psm = new ConexaoDAO().getConn().prepareStatement(sql);
                psm.setInt(1,id);
               
                psm.execute();
               
            }catch (Exception e) {
				System.out.println("Erro ao adicionar o produto no carrinho");
			} 
	}
	
	public List<Carrinho> getListaCarrinho(){
		String sql="";
		List<Carrinho> carrinhos = new ArrayList<>();
        try { 
			Statement stmo = new ConexaoDAO().getConn().createStatement();
            stmo.executeQuery("SELECT idProd FROM carrinho");
            ResultSet result = stmo.getResultSet();			
            while (result.next()){
                int id = result.getInt("IDPROD");                              
               carrinhos.add(new Carrinho(id));                              
            }          		
            stmo.close();
            return carrinhos;            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Produtos");
        }
        return null;		
	}
	
	public void ApagarCarrinhos() {
	 try{  	
		String sql="TRUNCATE carrinho";
        PreparedStatement psm = new ConexaoDAO().getConn().prepareStatement(sql);
        psm.execute();
	 }catch (Exception e) {
		System.out.println("Erro ao adicionar o produto no carrinho");
	 } 
	}

	
}
