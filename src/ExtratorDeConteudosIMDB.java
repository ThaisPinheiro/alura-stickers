package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudosIMDB implements ExtratorConteudo {
    
    public List<Conteudo> extrairConteudos(String json) {
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();

        for(Map<String, String> atributos: listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String classificacao = atributos.get("imDbRating");
            String ranking = atributos.get("rank");

            Conteudo conteudo = new Conteudo(titulo, urlImagem, classificacao, ranking);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
