import java.util.Arrays;

public class EncontrarNumeroRepetido {
    public static void main(String[] args) {
        String[] numerosRepetido = new String[args.length];
        Integer[] quantidadesRepetido = new Integer[args.length];

        System.out.printf("Os números de entrada foram %s\n", Arrays.toString(args));
        System.out.println("Os números repetidos foram: ");

        for (String numero: args) {
            for (String outroNumero: args) {
                if (numero.equals(outroNumero)) {
                    for (int i = 0; i < numerosRepetido.length; i++) {
                        if (numero == numerosRepetido[i]) {
                            quantidadesRepetido[i] = 4;
                        } else {
                            numerosRepetido[i] = numero;
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.toString(numerosRepetido));
        System.out.println(Arrays.toString(quantidadesRepetido));
    }

}
