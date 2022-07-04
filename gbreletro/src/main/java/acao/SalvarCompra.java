package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompraDAO;
import interfaces.Acao;
import model.Frete;

public class SalvarCompra implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
	
		
		CompraDAO compraDAO = new CompraDAO();
		compraDAO.salvar(null);
	
		return null;
	}

}
