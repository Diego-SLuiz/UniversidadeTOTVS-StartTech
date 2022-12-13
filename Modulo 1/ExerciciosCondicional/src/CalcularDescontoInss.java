import java.util.Scanner;

public class CalcularINSS {
    private static final Scanner entrada = new Scanner(System.in);
    private static final Double[] listaAliquotas = {0.075, 0.09, 0.12, 0.14};
    private static final Double[] listaSalarios = {1212.0, 2427.35, 3641.03, 7087.22};

    public static void main(String[] args) {
        Double valorSalario = perguntarSalario();
        Double valorDesconto = calcularDesconto(valorSalario);

        System.out.printf("O salário bruto informado foi de %.2f\n", valorSalario);
        System.out.printf("O desconto do INSS é de %.2f\n", valorDesconto);
    }

    public static Double perguntarSalario() {
        Double valorSalarioInformado = 0.0;
        String textoSalarioInformado = "";
        Boolean valorInvalido = true;

        while (valorInvalido) {
            System.out.print("Digite o valor do salário: ");

            try {
                textoSalarioInformado = entrada.nextLine();
                valorSalarioInformado = Double.parseDouble(textoSalarioInformado.replace(",", "."));
                valorInvalido = false;
            } catch (NumberFormatException error) {
                System.out.printf("O valor informado é inválido: %s\n", textoSalarioInformado);
            }
        }

        return valorSalarioInformado;
    }

    public static Double calcularDesconto(Double valorSalario) {
        Double valorRestante = 0.0;
        Double valorDesconto = 0.0;
        Double valorAliquota = 0.0;

        if (valorSalario <= listaSalarios[0]) {
            valorDesconto = valorSalario * listaAliquotas[0];
            return valorDesconto;
        }

        for (int i = 0; i < listaSalarios.length; i++) {
            if (valorSalario > listaSalarios[i]) {
                if (valorDesconto == 0) {
                    valorDesconto += listaSalarios[i] * listaAliquotas[i];
                } else {
                    valorDesconto += (listaSalarios[i] - listaSalarios[i - 1]) * listaAliquotas[i];
                }

                if (i + 1 < listaSalarios.length) {
                    valorAliquota = listaAliquotas[i + 1];
                    valorRestante = valorSalario - listaSalarios[i];
                } else {
                    valorAliquota = 0.0;
                    valorRestante = 0.0;
                }
            }
        }

        return valorDesconto + valorRestante * valorAliquota;
    }

}
