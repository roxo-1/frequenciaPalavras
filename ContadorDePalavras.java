import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class ContadorDePalavras {
    public static void main(String[] args) {
        File arquivoParaLer = new File("arquivo.txt");
        String conteudoCompleto = leArquivo(arquivoParaLer);
        if (conteudoCompleto != null) {
            TreeMap<String, Integer> frequencia = contaPalavras(conteudoCompleto);

            System.out.println("--- Frequência de Palavras (Ordenado) ---");
            for (Map.Entry<String, Integer> entry : frequencia.entrySet()) {
                System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
            }
        }
    }

    public static String leArquivo(File file) {
        String nomeDoArquivo = "arquivo.txt";
        Path caminho = Paths.get(nomeDoArquivo);
        try {
            String conteudo = Files.readString(caminho);
            return conteudo;

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static TreeMap<String, Integer> contaPalavras(String conteudo) {
        TreeMap<String, Integer> frequencia = new TreeMap<>();
        String[] palavras = conteudo.toLowerCase().split("\\P{L}+");
        for (String palavra : palavras) {
            if (palavra.isEmpty()) {
                continue;
            }
            int contagem = frequencia.getOrDefault(palavra, 0);
            frequencia.put(palavra, contagem + 1);
        }
        return frequencia;
    }
}