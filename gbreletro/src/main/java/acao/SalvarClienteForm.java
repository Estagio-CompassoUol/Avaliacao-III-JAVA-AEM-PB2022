package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import interfaces.Acao;
import model.Cliente;

public class SalvarClienteForm  implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Cadastrando novo Cliente");
		
		String nomeCliente = request.getParameter("nome");
		String paramEmail = request.getParameter("email");
		String paramSenha = request.getParameter("senha");
		String paramEndereco = request.getParameter("endereco");
		String paramCep = request.getParameter("cep");
				
				
		Cliente cliente = new Cliente();
		
		cliente.setNomeClie(nomeCliente);
		cliente.setLogEmail(paramEmail);
		cliente.setSenha(paramSenha);
		cliente.setEndereco(paramEndereco);
		cliente.setCep(paramCep);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		request.setAttribute("cliente", cliente.getNomeClie());
		
		return "redirect:do?direct=formCadastroCliente.jsp";
	
//	}

		
//		return "forward:formCadastroCliente.html";
	}
}
