package acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDAO;
import interfaces.Acao;
import model.Cliente;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Cliente> retCliente = new ArrayList<>();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando " + login);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = clienteDAO.fazerLogin(login,senha);
		retCliente.add(cliente);
		System.out.println(retCliente.size());
			
		if(cliente != null) {
			System.out.println("Usuario existe");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", retCliente);
			return "redirect:do?direct=ListaProdutos";
		} else {
			return "redirect:do?direct=LoginForm";
		}
	}
}
