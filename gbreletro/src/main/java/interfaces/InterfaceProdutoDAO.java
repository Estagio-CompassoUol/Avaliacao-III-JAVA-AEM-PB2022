package interfaces;

import java.util.List;

import model.Produto;

public interface InterfaceProdutoDAO {	
	public Produto buscarProduto(int id);
	public List<Produto> listarProduto();

}
