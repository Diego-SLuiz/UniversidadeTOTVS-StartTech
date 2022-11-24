import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AgruparAlunos {
    public static void main(String[] args) {
        if (args.length % 3 != 0) {
            System.out.println("O número de alunos precisa ser múltiplo de 3!");
            return;
        }

        Random aleatorio = new Random();
        String[][] grupos = new String[args.length / 3][3];
        String[] nomesRecebidos = args.clone();

        for (int i = 0; i < grupos.length; i++) {
            for (int j = 0; j < grupos[i].length; j++) {
                String alunoSelecionado = null;
                Integer indiceAluno = 0;

                while (alunoSelecionado == null) {
                    indiceAluno = aleatorio.nextInt(args.length);
                    alunoSelecionado = args[indiceAluno];
                }

                args[indiceAluno] = null;
                grupos[i][j] = alunoSelecionado;
            }
        }

        System.out.printf("Os nomes recebidos foram %s\n", Arrays.toString(nomesRecebidos));

        for (int i = 0; i < grupos.length; i++) {
            System.out.printf("Grupo %d:\n", i + 1);
            System.out.printf("%s\n", Arrays.toString(grupos[i]));
        }
    }

}
