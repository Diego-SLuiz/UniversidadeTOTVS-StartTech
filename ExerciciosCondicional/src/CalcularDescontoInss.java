public class CalcularDescontoInss {
    public static void main(String[] args) {
        //Double[] listaAliquotas = {0.075, 0.09, 0.12, 0.14};
        //Double[] listaSalarios = {1212.0, 2427.35, 3641.03, 7087.22};

        Double valorSalario = Double.parseDouble(args[0]);
        Double valorRestante = 0.0;
        Double valorDesconto = 0.0;
        Double valorAliquota = 0.0;

        if (valorSalario < 1212) {
            valorDesconto += valorSalario * 0.075;
            valorRestante = 0.0;
            valorAliquota = 0.0;
        }

        if (valorSalario >= 1212) {
            valorDesconto += 1212 * 0.075;
            valorRestante = valorSalario - 1212;
            valorAliquota = 0.09;
        }

        if (valorSalario >= 2427.35) {
            valorDesconto += (2427.35 - 1212) * 0.09;
            valorRestante = valorSalario - 2427.35;
            valorAliquota = 0.12;
        }

        if (valorSalario >= 3641.03) {
            valorDesconto += (3641.03 - 2427.35) * 0.12;
            valorRestante = valorSalario - 3641.03;
            valorAliquota = 0.14;
        }

        if (valorSalario >= 7087.22) {
            valorDesconto += (7087.22 - 3641.03) * 0.14;
            valorRestante = 0.0;
            valorAliquota = 0.0;
        }

        valorDesconto += valorRestante * valorAliquota;
        System.out.printf("O salário bruto informado foi de %.2f\n", valorSalario);
        System.out.printf("O desconto do INSS é de %.2f\n", valorDesconto);
    }

}
