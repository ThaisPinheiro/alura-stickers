package src;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class GeradorStickers {
    
    public void criar(InputStream inputStream, String nomeFigurinha, int posicao) throws Exception{
        //leitura
        // InputStream inputStream = new FileInputStream(new File("entrada/topMovies_1.jpg"));
        
        // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria uma nova imagem em memoria com transparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem eem memória
        Graphics2D graphics  = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //config fonte
        var fonte = new Font("Garamond", Font.BOLD, 64);
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem 
        graphics.drawString("TOP " + posicao, 200, novaAltura - 100);
             
        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/", nomeFigurinha));
    }
}
