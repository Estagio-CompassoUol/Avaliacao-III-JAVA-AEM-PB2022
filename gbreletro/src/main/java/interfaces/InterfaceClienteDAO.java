package interfaces;

import java.util.List;

import model.Cliente;

public interface InterfaceClienteDAO {
	public void salvar(Cliente cliente);
	public Cliente fazerLogin(String login, String senha);	

}
