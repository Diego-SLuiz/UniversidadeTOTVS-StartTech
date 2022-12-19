package rpg.item.armamento;

import rpg.enumeration.CategoriaArmamento;

public class Armamento {
    private Integer dano;
    private Integer precisao;
    private CategoriaArmamento categoriaArmamento;

    @Override
    public String toString() {
        return "Armamento{" +
                "dano=" + dano +
                ", precisao=" + precisao +
                ", tipoArmamento=" + categoriaArmamento +
                '}';
    }
}
