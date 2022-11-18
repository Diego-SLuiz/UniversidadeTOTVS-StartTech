import java.util.Scanner;

public class PrecoProduto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        System.out.print("Digite o preço do produto: ");
        String nomeProdutoUm = entrada.nextLine();
        Double precoProdutoUm = entrada.nextDouble();
    }
}
