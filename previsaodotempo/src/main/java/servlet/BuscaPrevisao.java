package servlet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/previsao")
public class BuscaPrevisao extends HttpServlet{
		
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String xmlCidade=req.getParameter("acao");
		System.out.println(xmlCidade);

		String retorno = getRetornaCodCidade(xmlCidade);
	
		System.out.println(retorno);
	
	
	
	}
	
	
public String getRetornaCodCidade(String cidade) {
	try {
		String linkInpeCod = "http://servicos.cptec.inpe.br/XML/listaCidades?city="+cidade;
		URL url = new URL(linkInpeCod);    
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		Scanner sc = new Scanner(conn.getInputStream());
		
		String retorno = "";
		
		while (sc.hasNextLine()) {
			String leitura = sc.next();
			if(leitura.contains("id")) {
				retorno = getPrevisaoXML(leitura);
					
			}													 
		}	
		
		sc.close();
		return retorno;
		
		
	} catch (Exception e) {
		System.out.println("Cidade nÃ£o localizada");
	}
	
	return null;
}

	
	public String getPrevisaoXML(String codLocalidade) throws Exception {
//		String[] separVal = codLocalidade.split("Valor");
//		String valorSep = separVal[1];			    
		String[] dadoCodig = codLocalidade.split("<");			
		String[] dadoCodig2 = dadoCodig[1].split(">");				
		String codigoCid=dadoCodig2[0];
		
		System.out.println(codigoCid);
		String linkPrevisaoXML = "http://servicos.cptec.inpe.br/XML/cidade/"+codigoCid+"/previsao.xml";
		URL url = new URL(linkPrevisaoXML);    
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		Scanner sc = new Scanner(conn.getInputStream());
		int i= 0;
		String dados = "";
//		
		while (sc.hasNextLine()) {					
			dados+=sc.next();									 
		}		
		sc.close();
				
		System.out.println(dados);
		return dados; 
	}

}