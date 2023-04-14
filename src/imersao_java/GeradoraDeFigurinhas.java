package imersao_java;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

		// Leitura da imagem
		// InputStream inputStream = new FileInputStream("entrada/filme.jpg");
		// InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
		BufferedImage imagemOrginal = ImageIO.read(inputStream);

		// Cria nova imagem em memoria com transperencia e com tamanho novo
		int largura = imagemOrginal.getWidth();
		int altura = imagemOrginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		// Copiar a imagem original para novo imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOrginal, 0, 0, null);

		// Configurar a fonta
		var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 64);
		graphics.setFont(fonte);
		
		// Escrever uma frase na nova imagem
		graphics.drawString("Filme muito bom", 88, novaAltura - 100);

		// Escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo+" figurinha.png"));
	}
}
