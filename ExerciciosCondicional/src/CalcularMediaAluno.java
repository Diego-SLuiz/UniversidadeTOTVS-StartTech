public class CalcularMediaAluno {
    public static void main(String[] args) {
        Double [] notas = {
                Double.parseDouble(args[0]),
                Double.parseDouble(args[1]),
                Double.parseDouble(args[2]),
                Double.parseDouble(args[3])
        };

        Double media = (notas[0] + notas[1] + notas[2] + notas[3]) / 4;

        System.out.printf("As notas do aluno são %.1f, %.1f, %.1f, %.1f\n", notas[0], notas[1], notas[2], notas[3]);
        System.out.printf("A média do aluno é %.1f e foi %s\n", media, media > 5 ? "aprovado" : "reprovado");
    }
}
