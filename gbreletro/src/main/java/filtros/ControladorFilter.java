package filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Acao;


@WebFilter("/do")
public class ControladorFilter implements Filter {
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("direct");
		
			String nomeDaClasse = "acao." + paramAcao;
			System.out.println(paramAcao);
			String nome = null;
			try {
				Class classe = Class.forName(nomeDaClasse);//carrega a classe com o nome 
				Acao acao = (Acao) classe.newInstance();
				nome = acao.executa(request,response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.out.println("Classe não encontrada");
				response.sendRedirect("Index.html");
			}
			String[] tipoEEndereco = nome.split(":");
			System.out.println(tipoEEndereco[0]);
			System.out.println(tipoEEndereco[1]);
			if(tipoEEndereco[0].equals("forward")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/" + tipoEEndereco[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(tipoEEndereco[1]);
			}
		}	

}
