public class ValidarEmprestimo {
    public static void main(String[] args) {
        Integer idade = Integer.parseInt(args[0]);
        Double valorSalario = Double.parseDouble(args[1]);
        Double valorEmprestimo = Double.parseDouble(args[2]);
        Integer quantidadeParcelas = Integer.parseInt(args[3]);

        StringBuilder mensagemRejeitado = new StringBuilder();
        Boolean rejeitado = false;

        Double valorParcela = valorEmprestimo / quantidadeParcelas;
        Double porcentagemSalario = valorParcela / valorSalario * 100;

        if (idade < 18 || idade > 65) {
            mensagemRejeitado.append(String.format("- idade precisa ser entre 18 e 65 anos. Idade informada: %d\n", idade));
            rejeitado = true;
        }

        if (quantidadeParcelas < 3 || quantidadeParcelas > 24) {
            mensagemRejeitado.append(String.format("- quantidade de parcelas precisa estar entre 3 e 24. Quantidade informada: %d\n", quantidadeParcelas));
            rejeitado = true;
        }

        if (porcentagemSalario > 30) {
            mensagemRejeitado.append(String.format("- parcela compromete %.0f porcento do salário. Salário: %.1f, parcela: %.1f", porcentagemSalario, valorSalario, valorParcela));
            rejeitado = true;
        }

        System.out.printf("A pessoa que está solicitando o emprestimo tem %d anos e tem o salario de %.1fR$\n", idade, valorSalario);
        System.out.printf("O emprestimo solicitado é de %.1fR$, para ser pago em %d parcelas\n", valorEmprestimo, quantidadeParcelas);

        if (rejeitado) {
            System.out.println("O emprestimo foi rejeitado: ");
            System.out.println(mensagemRejeitado);
            return;
        }

        System.out.println("O emprestimo foi aprovado!");
    }
}
