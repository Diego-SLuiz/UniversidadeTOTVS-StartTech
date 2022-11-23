import java.util.Scanner;
m=
public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.printf("Digite um número maior que zero: ");
        Integer numeroLimite = Integer.parseInt(entrada.nextLine());

        if (numeroLimite < 1) {
            System.out.printf("O número precisa ser maior que zero, mas foi informado %d", numeroLimite);
            return;
        }

        for (int i = 0; i < numeroLimite; i++) {

        }
    }
}
