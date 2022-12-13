package NotasAlunos;

import Utilidades.Leitor;

public class Aluno {
    private static final Integer numeroTotalNotas = 3;
    private static final Double notaMinimaPossivel = 0.0;
    private static final Double notaMaximaPossivel = 10.0;

    public String nome;
    public Double[] notas;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public void atualizarNotas() {
        notas = new Double[numeroTotalNotas];
        String mensagemPadrao = "Digite a %d° nota de %s: ";
        String avisoPadrao = "Valor inválido. Digite um valor entre %.2f e %.2f";

        for (int i = 0; i < numeroTotalNotas; i++) {
            String mensagem = mensagemPadrao.formatted(i + 1, nome);
            String aviso = avisoPadrao.formatted(notaMinimaPossivel, notaMaximaPossivel);
            notas[i] = Leitor.lerDecimal(notaMinimaPossivel, notaMaximaPossivel, mensagem, aviso);
        }
    }

    public Double calcularMedia() {
        if (notas == null) {
            return 0.0;
        }

        Double somaNotas = 0.0;

        for (Double nota : notas) {
            somaNotas += nota;
        }

        return somaNotas / numeroTotalNotas;
    }

}
