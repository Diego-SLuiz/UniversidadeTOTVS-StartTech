import java.util.Scanner;

public class NumerosImpares {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número maior que 0: ");
        Integer numeroLimite = entrada.nextInt();

        System.out.printf("Números ímpares até %d\n", numeroLimite);
        for (int i = 1; i < numeroLimite; i += 2) {
            System.out.println(i);
        }

    }
}