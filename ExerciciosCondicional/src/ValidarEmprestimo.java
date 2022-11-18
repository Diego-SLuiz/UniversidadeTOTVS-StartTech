public class ValidarEmprestimo {
    public static void main(String[] args) {
        Integer idade = Integer.parseInt(args[0]);
        Double valorSalario = Double.parseDouble(args[1]);
        Double valorEmprestimo = Double.parseDouble(args[2]);
        Integer quantidadeParcelas = Integer.parseInt(args[3]);

        StringBuilder mensagemRejeitado = new StringBuilder();
        Boolean rejeitado = false;

        if (idade < 18 || idade > 65) {
            mensagemRejeitado.append(String.format("- idade precisa ser entre 18 e 65 anos. Idade informada: %d\n", idade));
            rejeitado = true;
        }

        if (quantidadeParcelas < 3 || quantidadeParcelas > 24) {
            mensagemRejeitado.append(String.format("- quantidade de parcelas precisa estar entre 3 e 24. Quantidade informada: %d\n", quantidadeParcelas));
            rejeitado = true;
        }

        if (valorEmprestimo / quantidadeParcelas > 0.3 * valorSalario) {
            mensagemRejeitado.append(String.format("- parcela compromete mais de 30 porcento do salário. Salário: %.1f", valorSalario));
            rejeitado = true;
        }

        if (rejeitado) {
            System.out.println("O emprestimo foi rejeitado: ");
            System.out.println(mensagemRejeitado);
        }
    }
}
