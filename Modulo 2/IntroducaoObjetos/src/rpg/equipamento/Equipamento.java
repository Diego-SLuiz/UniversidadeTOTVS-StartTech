package rpg.equipamento;

import rpg.enumeration.CategoriaEquipamento;

public class Equipamento {
    private final String nome;
    private final Integer defesaBase;
    private final CategoriaEquipamento categoriaEquipamento;

    public Equipamento(String nome, Integer defesaBase, CategoriaEquipamento categoriaEquipamento) {
        this.nome = nome;
        this.defesaBase = defesaBase;
        this.categoriaEquipamento = categoriaEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDefesaBase() {
        return defesaBase;
    }

    public CategoriaEquipamento getCategoriaEquipamento() {
        return categoriaEquipamento;
    }

    public String toString() {
        return String.format("""
                %s:
                    Defesa -> %d
                    Categoria -> %s
                """, nome, defesaBase, categoriaEquipamento);
    }

}
