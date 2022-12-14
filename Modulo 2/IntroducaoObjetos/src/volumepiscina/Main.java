package volumepiscina;

import utilidades.Leitor;

public class Main {
    public static void main(String[] args) {
        String mensagemPadrao = "Digite o(a) %s da piscina: ";
        String avisoPadrao = "Valor inválido";
        Integer largura = Leitor.lerInteiro(mensagemPadrao.formatted("largura"), avisoPadrao);
        Integer comprimento = Leitor.lerInteiro(mensagemPadrao.formatted("comprimento"), avisoPadrao);
        Integer profundidade = Leitor.lerInteiro(mensagemPadrao.formatted("profundidade"), avisoPadrao);
        Piscina piscina = new Piscina(largura, comprimento, profundidade);

        System.out.printf("O volume dessa piscina é: %s³\n", piscina.calcularVolume());
    }
}
