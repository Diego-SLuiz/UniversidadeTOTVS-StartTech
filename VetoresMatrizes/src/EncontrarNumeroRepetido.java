import java.util.Arrays;

public class EncontrarNumeroRepetido {
    public static void main(String[] args) {
        Integer[] numerosRepetidos = new Integer[args.length];
        Integer[] quantidadeVezesRepetidos = new Integer[args.length];

        System.out.printf("Os números de entrada foram %s\n", Arrays.toString(args));
        System.out.println("Os números repetidos foram: ");

        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                continue;
            }

            Integer numero = Integer.parseInt(args[i]);
            numerosRepetidos[i] = numero;
            quantidadeVezesRepetidos[i] = 0;

            for (int j = i + 1; j < args.length; j++) {
                if (args[j] == null) {
                    continue;
                }

                Integer outroNumero = Integer.parseInt(args[j]);

                if (numero == outroNumero ) {
                    quantidadeVezesRepetidos[i]++;
                    args[j] = null;
                }
            }
        }

        for (int i = 0; i < quantidadeVezesRepetidos.length; i++) {
            if (numerosRepetidos[i] != null && quantidadeVezesRepetidos[i] > 0) {
                System.out.printf("Número %d repetido %d vez(es)\n", numerosRepetidos[i], quantidadeVezesRepetidos[i]);
            }
        }
    }

}
