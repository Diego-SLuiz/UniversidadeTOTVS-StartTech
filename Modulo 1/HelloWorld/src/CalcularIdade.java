import java.util.Scanner;

public class CalcularIdade {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu ano de nascimento: ");
        Integer nascimento = entrada.nextInt();
        Integer idade = 2022 - nascimento;

        System.out.printf("O ano de nascimento informado é %d\n", nascimento);
        System.out.printf("A pessoa tem (ou vai completar) %d anos em 2022\n", idade);
    }

}
