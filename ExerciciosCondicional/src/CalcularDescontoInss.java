public class CalcularDescontoInss {
    public static void main(String[] args) {
        //Double[] listaAliquotas = {0.075, 0.09, 0.12, 0.14};
        //Double[] listaSalarios = {1212.0, 2427.35, 3641.03, 7087.22};
        Double valorSalario = Double.parseDouble(args[0]);
        Double valorRestante = valorSalario;
        Double valorDesconto = 0.0;

        if (valorSalario >= 1212) {
            valorRestante -= 1212;
            valorDesconto += valorRestante * 0.075;
        }

        if (valorSalario >= 2427.35) {
            valorRestante -= 2427.35;
            valorDesconto += valorRestante * 0.09;
        }

        if (valorSalario >= 3641.03) {
            valorRestante -= 3641.03;
            valorDesconto += valorRestante * 0.12;
        }

        if (valorSalario >= 7087.22) {
            valorRestante -= 7087.22;
            valorDesconto += valorRestante * 0.14;
        }



        
        System.out.println(valorDesconto);
    }
}
