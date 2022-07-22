package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa  implements ExtratorConteudo {
 
    public List<Conteudo> extrairConteudos(String json) {
        
        // Extrair só os dados que interessam 
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();

        //popular a lista de conteudos
        for(Map<String, String> atributos: listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            //System.out.println(listaDeConteudos.get(0));
            
            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
