import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

public class LeitorDeArquivo {

    public static String leArquivo(File file) {
        // 1. Especifique o caminho (path) para o seu arquivo
        String nomeDoArquivo = "arquivo.txt";
        Path caminho = Paths.get(nomeDoArquivo);

        try {
            // 2. Leia todo o conteúdo do arquivo para uma String
            String conteudo = Files.readString(caminho);
            
            // 3. Imprima o conteúdo
            System.out.println("Conteúdo do arquivo:");
            System.out.println(conteudo);
            return conteudo;

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}