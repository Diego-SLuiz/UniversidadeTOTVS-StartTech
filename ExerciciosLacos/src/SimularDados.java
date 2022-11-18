import java.util.Random;
import java.util.Scanner;

public class SimularDados {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        System.out.println("Digite um número maior que 0: ");
        Integer quantidadeDados = entrada.nextInt();
        Integer somaDados = 0;

        for (int i = 0; i < quantidadeDados; i++) {
            Integer numeroSorteado = aleatorio.nextInt(6) + 1;
            somaDados += numeroSorteado;
            System.out.printf("O número %d foi sorteado!\n", numeroSorteado);
        }

        System.out.printf("A soma dos números sorteados é %d\n", somaDados);
    }
}
