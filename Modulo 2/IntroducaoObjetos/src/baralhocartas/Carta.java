package baralhocartas;

import baralhocartas.enumeration.Cor;
import baralhocartas.enumeration.Naipe;

public class Carta {
    public String nome;
    public Integer valor;
    public Cor cor;
    public Naipe naipe;

    public Carta(String nome, Integer valor, Naipe naipe, Cor cor) {
        this.nome = nome;
        this.valor = valor;
        this.cor = cor;
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return String.format("Carta - Nome: %s Valor: %d Naipe: %s Cor: %s", nome, valor, naipe, cor);
    }
}
