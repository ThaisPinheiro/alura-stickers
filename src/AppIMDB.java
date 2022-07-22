package src;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class AppIMDB {
    public static void main(String[] args) throws Exception {
	
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
		
		var http = new ClienteHttp();
        var gerador = new GeradorStickers();
		String json = http.buscarDados(url);
        
		System.out.println();
		System.out.println("\u001B[44m\u001B[1mSejam bem vindos ao nosso top10 Filmes!\u001b[0m \uD83C\uDF7F \uD83C\uDFA5");
		System.out.println();

        ExtratorConteudo extrator = new ExtratorDeConteudosIMDB();
        List<Conteudo> conteudos = extrator.extrairConteudos(json);

		for(int cont = 0; cont < 10; cont++) {

            Conteudo conteudo = conteudos.get(cont);
            
            String emoji = "";
            
            int nota = (int) Float.parseFloat(conteudo.getClassificacao());

			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeFigurinha = "saidaIMDB/" + conteudo.getTitulo() + ".png";

            System.out.println("Título: \u001B[35m\u001B[1m" + conteudo.getTitulo() + "\u001b[0m");
			System.out.println("\u001B[46m\u001B[1mClassificação: \u001b[0m " + conteudo.getClassificacao());

			gerador.criar(inputStream, nomeFigurinha, (int) Integer.parseInt(conteudo.getRanking()));

            if (nota > 6 ){
				for(int i = 0; i < nota; i++){
					emoji = emoji + "\u001B[31m\u2764 \uFE0F\u001b[0m";
				}
			} else {
				for(int i = 0; i < nota; i++){
					emoji = emoji + "\u1F49x";
				}
			}

            System.out.println(emoji);
            System.out.println("Poster(url): \u001B[34m\u001B[1m" + conteudo.getUrlImagem() + "\u001b[0m");
            System.out.println();

		}
	}
}
