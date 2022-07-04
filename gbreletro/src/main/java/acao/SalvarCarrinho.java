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
		List<Compra> compras = new ArrayList<>();
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
		int idProd = 0;
		double valorProd = 0;
		System.out.println("Salvando no Carrinho de Compras");		

				
		String CEP=request.getParameter("cep");
		String valorFreteSalv = request.getParameter("valor");
		String prazoFre= request.getParameter("prazo");				
		
		System.out.println(CEP+" " +valorFreteSalv +" " + prazoFre);		
		List<Carrinho> listaCarrinhos = carrinhoDAO.getListaCarrinho();		
		IrParaCarrinho irParaCarrinho=new IrParaCarrinho();		
		List<Produto> produtos2=irParaCarrinho.getProdutosCarrinho(listaCarrinhos);
		System.out.println( produtos2.size());
		for (Produto produto : produtos2) {
			
			Compra compra = new Compra();
			compra.setIdProd(produto.getIdProd());
			compra.setIdCliente(1);
			compra.setValorProd(produto.getValor());
			compra.setCepDes(CEP);
			compra.setValorFrete(Double.parseDouble(valorFreteSalv.replace(',','.')));
			compra.setPrazoEntrega(Integer.parseInt(prazoFre));
						
			compras.add(compra);
			
			CompraDAO compraDAO = new CompraDAO();
			compraDAO.salvar(compra);
		}
		
		for (Produto produto : produtos) {
			System.out.println(produto.getNomeProd());
		}
		
		carrinhoDAO.ApagarCarrinhos();		
		
		request.setAttribute("compras", compras);
		
		return "forward:compraCadastrada.jsp";
	
	}
}
