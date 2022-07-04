package acao;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;

import interfaces.Acao;
import model.Frete;


public class CalculoFrete implements Acao{
	List<Frete> listaFrete=new ArrayList<>();
	
	public List<Frete> getListaFrete() {
		return listaFrete;
	}
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String cepDest= request.getParameter("cep");
			System.out.println(cepDest);
			String frete = getFrete(cepDest);	
			System.out.println(frete);
			String[] freteDiv=frete.split(" ");			
			String valorString = freteDiv[0];			
			String prazoString = freteDiv[1];
			
			listaFrete.add(new Frete(cepDest, valorString,prazoString)); 			
									
			request.setAttribute("frete", listaFrete);
		} catch (Exception e) {
			System.out.println("Erro ao calcular o frete");
		}		
		return "forward:exibirFrete.jsp";
	}
	
	
	public String getFrete(String cepDest) throws Exception {
		   
		String linkCorreios = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?nCdEmpresa=08082650&sDsSenha=564321&sCepOrigem=33202817&sCepDestino="+cepDest+"&nVlPeso=1&nCdFormato=1&nVlComprimento=20&nVlAltura=20&nVlLargura=20&sCdMaoPropria=n&nVlValorDeclarado=0&sCdAvisoRecebimento=n&nCdServico=04510&nVlDiametro=0&StrRetorno=xml&nIndicaCalculo=3";
		URL url = new URL(linkCorreios);    
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		Scanner sc = new Scanner(conn.getInputStream());
		int i= 0;
		String dados = "";
//<Servicos><cServico><Codigo>04510</Codigo><Valor>35,40</Valor><PrazoEntrega>7</PrazoEntrega><ValorSemAdicionais>35,40</ValorSemAdicionais><ValorMaoPropria>0,00</ValorMaoPropria><ValorAvisoRecebimento>0,00</ValorAvisoRecebimento><ValorValorDeclarado>0,00</ValorValorDeclarado><EntregaDomiciliar>S</EntregaDomiciliar><EntregaSabado>N</EntregaSabado><obsFim></obsFim><Erro>0</Erro><MsgErro></MsgErro></cServico></Servicos>/br		
		while (sc.hasNextLine()) {					
			dados+=sc.next()+",";									 
		}		
		sc.close();
		
		dados=getDados(dados);
		System.out.println(dados);
		return dados; 
	}
	
	public String getDados(String frete) {
				
		String[] separVal = frete.split("Valor");
		String valorSep = separVal[1];			    
		String[] dadoValor = valorSep.split("<");			
		String[] dadoValor2 = dadoValor[0].split(">");				
		String valorFrete=dadoValor2[1];
			
		String[] separPraz = frete.split("PrazoEntrega");
		String prazo = separPraz[1];					    
		String[] dadoPrazo = prazo.split("<");		
		String[] dadoPrazo2 = dadoPrazo[0].split(">");		
		String prazoEntrega = dadoPrazo2[1];
		
		return valorFrete+" "+prazoEntrega;
	}
}
