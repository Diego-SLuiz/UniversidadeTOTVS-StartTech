package rpg;

import rpg.enumeration.CategoriaArmamento;

public class Armamento {
    public final String nome;
    public final Integer precisaoBase;
    public final Integer ataqueBase;
    public final CategoriaArmamento categoriaArmamento;

    public Armamento(String nome, Integer precisaoBase, Integer ataqueBase, CategoriaArmamento categoriaArmamento) {
        this.nome = nome;
        this.precisaoBase = precisaoBase;
        this.ataqueBase = ataqueBase;
        this.categoriaArmamento = categoriaArmamento;
    }

    public String toString() {
        return String.format("""
                %s:
                    Precisao -> %d
                    Ataque - %d
                    Categoria -> %s
                """, nome, precisaoBase, ataqueBase, categoriaArmamento);
    }

}
