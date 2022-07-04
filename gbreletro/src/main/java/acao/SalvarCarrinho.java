package acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarrinhoDAO;
import dao.CompraDAO;
import interfaces.Acao;
import model.Carrinho;
import model.Cliente;
import model.Compra;
import model.Frete;
import model.Produto;

public class SalvarCarrinho implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		List<Produto> produtos=new ArrayList<>(); 
		int idProd = 0;
		double valorProd = 0;
		System.out.println("Salvando no Carrinho de Compras");		

		String CEP=request.getParameter("cep");
		String valorFreteSalv = request.getParameter("valor");
		String prazoFre= request.getParameter("prazo");
		String usuario=request.getParameter("usuario");
				
		
		System.out.println(CEP+" " +valorFreteSalv +" " + prazoFre +" " + usuario);
		
		IrParaCarrinho irParaCarrinho=new IrParaCarrinho();		
		List<Produto> produtos2=irParaCarrinho.getProdutos();		
		for (Produto produto : produtos2) {
			idProd=produto.getIdProd();
			valorProd=produto.getValor();
			produtos.add(produto);
		}
		
		for (Produto produto : produtos) {
			System.out.println(produto.getNomeProd());
		}
			
		Compra compra = new Compra();
		compra.setIdProd(idProd);
//		compra.setIdCliente(idUsuario);
		compra.setValorProd(valorProd);
		compra.setCepDes(CEP);

		compra.setValorFrete(Double.parseDouble(valorFreteSalv.replace(',','.')));
		compra.setPrazoEntrega(Integer.parseInt(prazoFre));
				
		CompraDAO compraDAO = new CompraDAO();
		compraDAO.salvar(compra);
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
		carrinhoDAO.ApagarCarrinhos();
		
		
		request.setAttribute("compras", compra);
		
		return "redirect:do?direct=compraCadastrada.jsp";
	
	}
}
