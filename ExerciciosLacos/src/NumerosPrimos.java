import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.printf("Digite um número maior que zero: ");
        Integer numeroLimite = Integer.parseInt(entrada.nextLine());

        if (numeroLimite < 1) {
            System.out.printf("O número precisa ser maior que zero, mas foi informado %d", numeroLimite);
            return;
        }

        System.out.printf("O número informado foi %d\n", numeroLimite);

        for (int i = 0; i < numeroLimite; i++) {
            Boolean primo = true;

            if (i == 0 || i == 1) {
                continue;
            }

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.printf("O número %d é primo!\n", i);
            }
         }
    }

}
