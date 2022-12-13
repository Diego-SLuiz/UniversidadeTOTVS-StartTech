import java.util.Scanner;

public class ConverterMoeda {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Double cotacaoDolar = 5.17;
        Double cotacaoEuro = 5.17;
        Double cotacaoLibra = 5.86;
        Double cotacaoPesoArgentino = 0.032;
        Double cotacaoCoroaTcheca = 0.21;

        System.out.print("Digite um valor em R$: ");
        Double valorReal = entrada.nextDouble();

        System.out.printf("O valor recebido é de %.2f\n", valorReal);
        System.out.println("Isso equivale a: ");
        System.out.printf("%.2f dólares\n",  valorReal / cotacaoDolar);
        System.out.printf("%.2f euros\n", valorReal / cotacaoEuro);
        System.out.printf("%.3f libras\n", valorReal / cotacaoLibra);
        System.out.printf("%.3f peso argentino\n", valorReal / cotacaoPesoArgentino);
        System.out.printf("%.3f coroa tcheca\n", valorReal / cotacaoCoroaTcheca);
    }

}
