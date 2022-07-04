package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdutoDAO;
import interfaces.Acao;
import model.Produto;


public class MostraProduto  implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando dados da empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();		
		Produto produto = produtoDAO.buscarProduto(id);
		request.setAttribute("produto", produto);
		
		return "forward:carrinhoCompra.jsp";
	}
}
