package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import interfaces.Acao;
import model.Produto;

public class ListaProdutos implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("listando empresas");
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<Produto> lista = produtoDAO.listarProduto();
		
		request.setAttribute("produtos", lista);
		
		return "forward:listaProdutos.jsp";
	}

}
