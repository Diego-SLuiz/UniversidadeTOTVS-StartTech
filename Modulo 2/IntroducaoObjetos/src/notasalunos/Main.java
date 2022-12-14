package notasalunos;

import utilidades.Leitor;

public class Main {
    public static void main(String[] args) {
        Integer quantidadeAlunos = 3;
        Aluno[] listaAlunos = new Aluno[quantidadeAlunos];
        String mensagemPadrao = "\nDigite o nome do %d° aluno: ";

        for (int i = 0; i < quantidadeAlunos; i++) {
            String mensagem = mensagemPadrao.formatted(i + 1);
            String nomeAluno = Leitor.lerTexto(mensagem);
            listaAlunos[i] = new Aluno(nomeAluno);
            listaAlunos[i].atualizarNotas();
        }

        for (Aluno aluno : listaAlunos) {
            System.out.printf("\nA média do aluno %s é %.2f\n", aluno.nome, aluno.calcularMedia());
        }
    }
}
