package previsaodotempo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BuscaPrevisao {
		
	public String getRetornaCodCidade(String cidade) {
		try {
			String linkInpeCod = "http://servicos.cptec.inpe.br/XML/listaCidades?city="+cidade;
			URL url = new URL(linkInpeCod);    
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			Scanner sc = new Scanner(conn.getInputStream());
			
			String dados = "";
			
			while (sc.hasNextLine()) {
				String leitura = sc.next();
				if(leitura.contains("id")) {
					return leitura;	
				}													 
			}		
			sc.close();
			
		} catch (Exception e) {
			System.out.println("Cidade não localizada");
		}
		
		return null;
	}
	
	
	public String getPrevisaoXML(String codLocalidade) throws Exception {
//		String[] separVal = codLocalidade.split("Valor");
//		String valorSep = separVal[1];			    
		String[] dadoCodig = codLocalidade.split("<");			
		String[] dadoCodig2 = dadoCodig[0].split(">");				
		String codigoCid=dadoCodig2[1];
		
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
