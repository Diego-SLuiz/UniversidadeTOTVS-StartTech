import java.util.Arrays;

public class MaioresPalavras {
    public static void main(String[] args) {
        System.out.printf("As palavras recebidas foram %s\n", Arrays.toString(args));
        String[] palavrasEmpatadas = new String[args.length];
        String maiorPalavra = args[0];
        Integer quantidadeEmpatadas = 0;

        for (String palavra: args) {
            maiorPalavra = palavra.length() > maiorPalavra.length() ? palavra : maiorPalavra;
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].length() == maiorPalavra.length()) {
                palavrasEmpatadas[i] = args[i];
                quantidadeEmpatadas++;
            }
        }

        System.out.printf("Existe(m) %d palavra(s) com %d letra(s): \n", quantidadeEmpatadas, maiorPalavra.length());

        for (String palavra: palavrasEmpatadas) {
            if (palavra != null) {
                System.out.println(palavra);
            }
        }
    }

}
