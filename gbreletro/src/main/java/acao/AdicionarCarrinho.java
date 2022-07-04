package acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarrinhoDAO;
import interfaces.Acao;


public class AdicionarCarrinho implements Acao {
		
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Adicionando no Carrinho de Compras");
		
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);	
		
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
		carrinhoDAO.salvar(id);
	
		
		return "redirect:do?direct=ListaProdutos";
	}

}
