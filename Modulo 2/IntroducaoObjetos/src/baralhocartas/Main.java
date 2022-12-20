package baralhocartas;

import baralhocartas.enumeration.Cor;
public class Main {
    public static void main(String[] args) {
        Baralho baralho = new Baralho(Cor.PRETO);
        baralho.embaralhar();

        System.out.println("Baralho pronto!");
        for (Carta carta : baralho.sacar(52)) {
            System.out.printf("A carta sacada é: \n%s\n", carta);
        }
    }

}
