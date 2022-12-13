public class PreencherTabuleiro {
    public static void main(String[] args) {
        if (args.length != 9) {
            System.out.printf("É necessário informar 9 símbolos, mas foram informados %d\n", args.length);
        }

        for (int i = 0; i < args.length; i++) {
            if (
                    !args[i].equalsIgnoreCase("o") &&
                    !args[i].equalsIgnoreCase("x") &&
                    !args[i].equalsIgnoreCase("_")
            ) {
                System.out.printf("Os únicos símbolos aceitos são \"x\", \"o\" e \"_\", mas foi informado %s\n", args[i]);
            }

            System.out.print(args[i]);
            System.out.print((i + 1) % 3 == 0 ? "\n" : " | ");
        }
    }

}
