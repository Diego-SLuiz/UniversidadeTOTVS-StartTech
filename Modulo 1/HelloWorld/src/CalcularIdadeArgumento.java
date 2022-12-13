public class CalcularIdadeArgumento {
    public static void main(String[] args) {
        Integer anoNascimento = Integer.parseInt(args[0]);
        Integer anoAtual = Integer.parseInt(args[1]);

        System.out.printf("O ano de nascimento informado é %d\n", anoNascimento);
        System.out.printf("A pessoa tem (ou vai completar) %d anos em %d", anoAtual - anoNascimento, anoAtual);
    }

}
