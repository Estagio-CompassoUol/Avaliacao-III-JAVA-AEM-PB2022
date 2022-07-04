package acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarrinhoDAO;
import dao.ProdutoDAO;
import interfaces.Acao;
import model.Carrinho;
import model.Produto;

public class IrParaCarrinho implements Acao {
	List<Produto>produtos= new ArrayList<>();
	
	public List<Produto> getProdutos() {
		return produtos;
	}
		
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		   
		
		
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
		List<Carrinho> listaCarrinhos = carrinhoDAO.getListaCarrinho();		
		produtos.addAll(getProdutosCarrinho(listaCarrinhos));
	
		request.setAttribute("produtos", produtos);
		return "forward:carrinhoCompra.jsp";
	}
	
	public List<Produto> getProdutosCarrinho(List<Carrinho> listaCarrinhos2){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto>produtoBusc= new ArrayList<>();
		for (int i = 0; i < listaCarrinhos2.size(); i++) {
			Produto produtosEnc=produtoDAO.buscarProduto(listaCarrinhos2.get(i).getIdProd());
			if(produtosEnc!=null) {
			int idEnco = produtosEnc.getIdProd();
			String nome=produtosEnc.getNomeProd();
			String desc=produtosEnc.getDescricao();
			double valor = produtosEnc.getValor();
				
			produtoBusc.add(new Produto(idEnco,nome, desc,valor));
			}
			
		}
		return produtoBusc;		
	}

}
