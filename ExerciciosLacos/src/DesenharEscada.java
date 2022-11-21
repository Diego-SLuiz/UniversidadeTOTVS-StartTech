import java.util.Scanner;

public class DesenharEscada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número maior que 0: ");
        Integer numeroDegraus = entrada.nextInt();

        for (int i = 1; i <= numeroDegraus; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }
}
