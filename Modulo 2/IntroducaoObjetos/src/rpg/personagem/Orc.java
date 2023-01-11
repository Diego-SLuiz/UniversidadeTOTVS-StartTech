package rpg.personagem;

import rpg.enumeration.EspeciePersonagem;

public class Orc extends Personagem {
    public Orc(String nome) {
        super(nome, 10, 20, 0, 10, EspeciePersonagem.ORC);
    }

}
