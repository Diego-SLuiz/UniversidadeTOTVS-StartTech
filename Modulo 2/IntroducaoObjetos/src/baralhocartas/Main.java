package baralhocartas;

import baralhocartas.enumeration.Cor;
public class Main {
    public static void main(String[] args) {
        Baralho baralho = new Baralho(Cor.PRETO);
        baralho.embaralhar();

        System.out.println("Baralho pronto!");
        System.out.printf("A carta sacada é: \n%s\n", baralho.sacar(1)[0]);
    }

}
