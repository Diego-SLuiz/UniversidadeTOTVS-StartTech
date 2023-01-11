package rpg.armamento;

import rpg.enumeration.CategoriaArmamento;

public class Armamento {
    private final String nome;
    private final Integer precisaoBase;
    private final Integer ataqueBase;
    private final CategoriaArmamento categoriaArmamento;

    public Armamento(String nome, Integer precisaoBase, Integer ataqueBase, CategoriaArmamento categoriaArmamento) {
        this.nome = nome;
        this.precisaoBase = precisaoBase;
        this.ataqueBase = ataqueBase;
        this.categoriaArmamento = categoriaArmamento;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPrecisaoBase() {
        return precisaoBase;
    }

    public Integer getAtaqueBase() {
        return ataqueBase;
    }

    public CategoriaArmamento getCategoriaArmamento() {
        return categoriaArmamento;
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
