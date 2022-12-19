package rpg.entidade.personagem;

import rpg.item.armamento.Machado;

public class Orc extends Personagem {

    public Orc(String nome) {
        this.nome = nome;

        baseVida = 8;
        baseDano = 0;
        baseDefesa = 10;
        basePrecisao = 0;

        gerarArmamento();
        gerarEquipamento();
    }

    private void gerarArmamento() {
        Machado machado = new Machado();
        usarArmamento(machado);
    }

    private void gerarEquipamento() {

    }

}
