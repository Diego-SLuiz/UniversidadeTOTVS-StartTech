import java.util.Scanner;

public class CalcularEspacoCinema {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a quantidade total de fileiras: ");
        Integer fileiras = entrada.nextInt();

        System.out.println("Digite a quantidade de cadeiras por fileira: ");
        Integer cadeiras = entrada.nextInt();

        System.out.println("Digite a porcentagem de cadeiras reservadas: ");
        Integer porcentagemReservada = entrada.nextInt();

        Integer totalLugares = fileiras * cadeiras;
        System.out.printf("A sala de cinema tem %d fileiras e %d cadeiras em cada\n", fileiras, cadeiras);
        System.out.printf("A capacidade dessa sala é de %d pessoas\n", totalLugares);
        System.out.printf("A quantidade de cadeiras reservadas é %d\n", porcentagemReservada / 100 * totalLugares);
    }

}
