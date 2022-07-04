package previsaodotempo;

import java.util.Scanner;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/cidade")
public class Principal {
	public static void main(String[] args) {
		BuscaPrevisao buscaPrevisao = new BuscaPrevisao();
		
		System.out.println("Digite o nome da cidade");
		Scanner ler= new Scanner(System.in);
		String cidade = ler.nextLine();
		
		System.out.println(buscaPrevisao.getRetornaCodCidade(cidade)); 
		
		
	}
}
