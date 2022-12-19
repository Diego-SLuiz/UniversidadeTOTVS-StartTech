package rpg.item.equipamento;

import rpg.enumeration.CategoriaEquipamento;

public class Equipamento {
    protected Integer defesa;
    protected CategoriaEquipamento categoriaEquipamento;

    @Override
    public String toString() {
        return "Equipamento{" +
                "defesa=" + defesa +
                ", tipoEquipamento=" + categoriaEquipamento +
                '}';
    }
}
