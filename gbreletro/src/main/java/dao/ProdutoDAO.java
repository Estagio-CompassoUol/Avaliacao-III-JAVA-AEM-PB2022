package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.InterfaceProdutoDAO;
import model.Produto;

public class ProdutoDAO implements InterfaceProdutoDAO{
		
	@Override
	public Produto buscarProduto(int id) {
		String sql="";
		       
        try{            
        	 sql="SELECT idProd, nomeProd, descricao, valor FROM produtos WHERE idProd = ?";
        	
                PreparedStatement psm = new ConexaoDAO().getConn().prepareStatement(sql);
                psm.setInt(1,id);               
                psm.execute();
                ResultSet result = psm.getResultSet();
                while (result.next()){
                    int idEnco = result.getInt("IDPROD");
                    String nome = result.getString("NOMEPROD");
                    String descricao = result.getString("DESCRICAO");
                    double preco = result.getDouble("VALOR");                  
                   if(idEnco==id) {
                	   return new Produto(idEnco, nome, descricao, preco);
                   }                    
                }                
            }catch (Exception e) {
				System.out.println("Erro ao buscar produto por id");
			}           
		return null;
	}
		

	@Override
	public List<Produto> listarProduto() {
		String sql="";
		List<Produto> produtos = new ArrayList<>();
        try {        	
        	sql= "SELECT idProd, nomeProd, descricao, valor FROM produtos";
			PreparedStatement pst = new ConexaoDAO().getConn().prepareStatement(sql);
			pst.execute();

            ResultSet result = pst.getResultSet();
            
            while (result.next()){
                int id = result.getInt("IDPROD");
                String nome = result.getString("NOMEPROD");
                String descricao = result.getString("DESCRICAO");
                double preco = result.getDouble("VALOR");
              
               produtos.add(new Produto(id,nome,descricao,preco));                              
            }
            pst.close();
            return produtos;
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Produtos");
        }
        return produtos;
		
	}	
}
