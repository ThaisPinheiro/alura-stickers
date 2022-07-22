package src;

public class Conteudo {

    private final String titulo;
    private final String urlImagem;
    private String classificacao;
    private String ranking;

    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    public Conteudo(String titulo, String urlImagem, String classificacao, String ranking) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.classificacao = classificacao;
        this.ranking = ranking;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public String getRanking() {
        return ranking;
    }
}
