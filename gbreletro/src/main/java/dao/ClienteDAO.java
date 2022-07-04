package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.InterfaceClienteDAO;
import model.Cliente;
import model.Produto;

public class ClienteDAO implements InterfaceClienteDAO {

	@Override
	public void salvar(Cliente cliente) {		
		try{            
	        	String sql="INSERT INTO cliente (nomeClie,endereco,cep,logEmail,senha) VALUES (?,?,?,?,?)";
	        	
	                PreparedStatement psm = new ConexaoDAO().getConn().prepareStatement(sql);
	                psm.setString(1,cliente.getNomeClie());
	                psm.setString(2,cliente.getEndereco());
	                psm.setString(3,cliente.getCep());
	                psm.setString(4,cliente.getLogEmail());
	                psm.setString(5,cliente.getSenha());
	               
	                psm.execute();
	               
	            }catch (Exception e) {
					System.out.println("Erro ao adicionar o produto no carrinho");
				} 
	}

	@Override
	public Cliente fazerLogin(String login, String senha) {
		
		String sql="";
        try{            
        	 sql="SELECT idClie,nomeClie, cep, logEmail, senha FROM cliente";
        	
                PreparedStatement psm = new ConexaoDAO().getConn().prepareStatement(sql);
//                psm.setString(1,login);               
                psm.execute();
                ResultSet result = psm.getResultSet();
                while (result.next()){
                	int id = result.getInt("idClie");
                    String nome = result.getString("nomeClie");                    
                    String cep = result.getString("cep");
                    String logEmail = result.getString("logEmail");
                    String senhaClie = result.getString("senha");
                    
                    System.out.println(logEmail+" "+login);
                    System.out.println(senhaClie+" "+senha);
                    
                   if(logEmail.equals(login) & senhaClie.equals(senha)) {
                	  return(new Cliente(nome," ", cep, logEmail,senhaClie));
                	}                   
                }   
                
            }catch (Exception e) {
				System.out.println("Erro ao buscar produto por id");
			}          
		return null;		
	}


}
