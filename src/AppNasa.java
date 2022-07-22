package src;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class AppNasa {

	public static void main(String[] args) throws Exception {

		// Fazer uma conexão http e buscar os tops 10 do filme		
		String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
		
		var http = new ClienteHttp();
		String json = http.buscarDados(url);

		// Exibir e manipular esses dados na aplicação
		System.out.println();
		System.out.println("\uD83D\uDE80 \uD83C\uDF0E \u001B[44m\u001B[1m Sejam bem vindos ao nosso top3 Nasa!\u001b[0m \uD83D\uDE80 \uD83E\uDE90");
		System.out.println();

        ExtratorConteudo extrator = new ExtratorDeConteudoNasa();
        List<Conteudo> conteudos = extrator.extrairConteudos(json);

		var gerador = new GeradorStickers();

		for(int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeFigurinha = "saidaNasa/" + conteudo.getTitulo() + ".png";

            gerador.criar(inputStream, nomeFigurinha, i+1);

            System.out.println("\uD83C\uDF16 \u001B[35m\u001B[1m" + conteudo.getTitulo() + "\u001b[0m");
			System.out.println("Imagem(url): \u001B[34m\u001B[1m" + conteudo.getUrlImagem() + "\u001b[0m");
            System.out.println();
		}
	}
}
