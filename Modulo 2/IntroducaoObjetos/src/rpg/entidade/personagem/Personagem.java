package rpg.entidade.personagem;

import rpg.item.armamento.Armamento;
import rpg.item.equipamento.Equipamento;

public class Personagem {
    protected Integer baseVida;
    protected Integer baseDano;
    protected Integer baseDefesa;
    protected Integer basePrecisao;
    protected String nome;
    protected Armamento armamento;
    protected Equipamento equipamento;

    public void usarArmamento(Armamento armamento) {
        this.armamento = armamento;
    }

    public void usarEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

}
