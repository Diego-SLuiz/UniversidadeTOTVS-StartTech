import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortearNumero {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        Scanner entrada = new Scanner(System.in);
        Integer[] numeros = {
                aleatorio.nextInt(1, 7),
                aleatorio.nextInt(1, 7),
                aleatorio.nextInt(1, 7)
        };

        Integer quantidadeAcertos = 0;
        Boolean acertou = false;

        System.out.print("Digite um número entre 1 e 6: ");
        Integer numeroDigitado = entrada.nextInt();

        if (numeroDigitado < 1 || numeroDigitado > 6) {
            System.out.printf("O número precisa estar entre 1 e 6. Número digitado: %d\n", numeroDigitado);
            return;
        }

        System.out.printf("Numeros sorteados: %s\n", Arrays.toString(numeros));

        for (Integer numero: numeros) {
            if (numero.equals(numeroDigitado)) {
                quantidadeAcertos++;
                acertou = true;
            }
        }

        if (acertou) {
            System.out.printf("Parabéns, você acertou %d vezes!", quantidadeAcertos);
            return;
        }

        System.out.println("Você não acertou...");
    }
}
