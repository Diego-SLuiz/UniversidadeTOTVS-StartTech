package rpg.personagem;

import rpg.enumeration.EspeciePersonagem;

public class Humano extends Personagem {
    public Humano(String nome) {
        super(nome, 10, 20, 0, 10, EspeciePersonagem.HUMANO);
    }

}
