import java.util.Scanner;

public class PrecoProduto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String[] produtoNomes = new String[3];
        Double[] produtoPrecos = new Double[3];
        String nomeProdutoMaisCaro = "";
        Double precoProdutoMaisCaro = 0.0;

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome de um produto: ");
            produtoNomes[i] = entrada.nextLine();

            System.out.printf("Digite o preço do produto \"%s\": ", produtoNomes[i]);
            produtoPrecos[i] = Double.parseDouble(entrada.nextLine().replace(",", "."));

            System.out.printf("Foi informado o produto %s que custa R$ %.2f\n", produtoNomes[i], produtoPrecos[i]);

            if (produtoPrecos[i] > precoProdutoMaisCaro) {
                nomeProdutoMaisCaro = produtoNomes[i];
                precoProdutoMaisCaro = produtoPrecos[i];
            }
        }

        System.out.printf("O produto mais caro é \"%s\"", nomeProdutoMaisCaro);
    }

}
