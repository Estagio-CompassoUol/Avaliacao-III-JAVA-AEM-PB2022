package servlet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.google.gson.Gson;


@WebServlet("/previsao")
public class BuscaPrevisao extends HttpServlet{
		
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String xmlCidade=req.getParameter("acao");
		System.out.println(xmlCidade);

		String cidadeLowCase = xmlCidade.toLowerCase();
		String[] divCidade = cidadeLowCase.split(" ");
		String cidade="";
		for (int i = 0; i < divCidade.length; i++) {
			
			System.out.println(cidade);
			if(i==(divCidade.length-1)) {				
				cidade += divCidade[i];
			}else {
				cidade += divCidade[i]+"%20";
			}
			System.out.println(cidade);
		}		
		System.out.println(cidade);
		
		String codCidade = getRetornaCodCidade(cidade);
		System.out.println(codCidade);
		 

		String retorno;
		try {
			retorno = getPrevisaoXML(codCidade);
			System.out.println(retorno);			
//			Gson gson = new Gson();
//			String json = gson.toJson(retorno); 	
			JSONObject paisesJson = XML.toJSONObject(retorno);
			resp.setContentType("application/json");
			resp.getWriter().print(paisesJson);			
		} catch (Exception e) {
			
			System.out.println("Não foi possivel obter o objeto JSON");;
		}
	}
	
@SuppressWarnings("resource")
public String getRetornaCodCidade(String cidade) {
	try {
		System.out.println(cidade);
		String linkInpeCod = "http://servicos.cptec.inpe.br/XML/listaCidades?city="+cidade;
		URL url = new URL(linkInpeCod);    
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		Scanner sc = new Scanner(conn.getInputStream(), "ISO-8859-1" );
				
		String retornoxmlCid = "";
		while (sc.hasNextLine()) {			
			retornoxmlCid = sc.nextLine();
			System.out.println(retornoxmlCid);		
			return retornoxmlCid;
				
		}	
		sc.close();
		
	} catch (Exception e) {
		System.out.println("Cidade não localizada");
	}
	return null;
}

	
	public String getPrevisaoXML(String codLocalidade) throws Exception {

		System.out.println(codLocalidade);
		String[] codigoSep = codLocalidade.split("<id>");
		String codSep = codigoSep[1];
		System.out.println(codSep);
		
		String[] dadoCodig = codSep.split(">");			
		String codigoCid=dadoCodig[0];
		System.out.println(codigoCid);
		
		String[] dadoCodig2 = dadoCodig[0].split("<");	
		String codigoCid2=dadoCodig2[0];
		System.out.println(codigoCid2);

		String linkPrevisaoXML = "http://servicos.cptec.inpe.br/XML/cidade/"+codigoCid2+"/previsao.xml";
		URL url = new URL(linkPrevisaoXML);    
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		Scanner sc = new Scanner(conn.getInputStream());
	    String dados = "";
		
		while (sc.hasNextLine()) {					
			dados+=sc.next();									 
		}		
		sc.close();
		
		
		return dados;
	}

	
}