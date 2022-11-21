import java.util.Arrays;

public class EncontrarMenorMaior {
    public static void main(String[] args) {
        Integer maiorNumero = Integer.parseInt(args[0]);
        Integer menorNumero = Integer.parseInt(args[0]);

        for (String argumento: args) {
            Integer numero = Integer.parseInt(argumento);
            maiorNumero = numero > maiorNumero ? numero : maiorNumero;
            menorNumero = numero < menorNumero ? numero : menorNumero;
        }

        System.out.printf("Os números de entrada foram %s\n", Arrays.toString(args));
        System.out.printf("O maior número é %d e o menor número é %d", maiorNumero, menorNumero);
    }

}
