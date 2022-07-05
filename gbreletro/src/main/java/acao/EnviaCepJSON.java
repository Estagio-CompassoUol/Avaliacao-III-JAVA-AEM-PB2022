package acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import interfaces.Acao;
import model.Frete;

public class EnviaCepJSON implements Acao {
	
	private List<Frete> listaFrete=new ArrayList<>();
	
	public EnviaCepJSON(List<Frete> listaFrete) {
		this.listaFrete.addAll(listaFrete);
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			Gson gson = new Gson();
			String json = gson.toJson(listaFrete);
			System.out.println(listaFrete.size());			
			response.setContentType("application/json");
			response.getWriter().print(json);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Não foi possivel obter o objeto JSON");;
		}
		return "forward:exibirFreteJson.jsp";
	}

}
