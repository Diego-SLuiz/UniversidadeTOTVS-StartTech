package rpg;

import rpg.enumeration.CategoriaEquipamento;

public class Equipamento {
    public final String nome;
    public final Integer defesaBase;
    public final CategoriaEquipamento categoriaEquipamento;

    public Equipamento(String nome, Integer defesaBase, CategoriaEquipamento categoriaEquipamento) {
        this.nome = nome;
        this.defesaBase = defesaBase;
        this.categoriaEquipamento = categoriaEquipamento;
    }

    public String toString() {
        return String.format("""
                %s:
                    Defesa -> %d
                    Categoria -> %s
                """, nome, defesaBase, categoriaEquipamento);
    }

}
